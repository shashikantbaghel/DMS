package com.dms.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.dms.dao.PatientDaoImpl;
import com.dms.model.Patient;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Appointment implements ActionListener {
	
	JFrame apponitmentFrame;
	JLabel headingLabel,treatmentLabel,fromdateLabel,todateLabel;
	UtilDateModel utilmodel,utilmodel1;
	JDatePanelImpl datePanel,datePanel1;
	JDatePickerImpl datePicker,datePicker1;	
	DefaultTableModel model;
	JTable jtable;
	JScrollPane jScrollPane;
	JButton backButton,todayButton,seachButton,exportButton;
	
	public Appointment() {
	apponitmentFrame=new JFrame("Apponitment");
	apponitmentFrame.setPreferredSize(new Dimension(1366, 768));
	
		utilmodel = new UtilDateModel();
		utilmodel.setSelected(true);
		datePanel = new JDatePanelImpl(utilmodel);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		utilmodel1 = new UtilDateModel();
		utilmodel1.setSelected(true);
		datePanel1 = new JDatePanelImpl(utilmodel1);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		
	String column[]={"APPOINTMENT DATE","PATIENT NAME","MOBILE","STATUS"};    
	model = new DefaultTableModel();
	model.setColumnIdentifiers(column);
	jtable=new JTable();
	
	jtable.setModel(model);
	jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	jtable.setFillsViewportHeight(true);
	jScrollPane=new JScrollPane(jtable);
	jScrollPane.setBounds(100,300,800,200);
	jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	apponitmentFrame.add(jScrollPane);
	
	
	
	headingLabel=new JLabel("Apponitment");
	headingLabel.setFont(new Font("Aerial", Font.PLAIN, 50));
		
	fromdateLabel=new JLabel("FROM");
	todateLabel=new JLabel("TO");
	treatmentLabel=new JLabel("Treatment details");
	
	backButton=new JButton("Back");
	todayButton=new JButton("Today Appointment");
	seachButton=new JButton("Search");
	exportButton=new JButton("Export");
	backButton.addActionListener(this);
	todayButton.addActionListener(this);
	seachButton.addActionListener(this);
	exportButton.addActionListener(this);
	
	headingLabel.setBounds(50, -25, 400, 100);
	fromdateLabel.setBounds(320,100,50,30);
	todateLabel.setBounds(620,100,50,30);
	treatmentLabel.setBounds(100,100,150,30);
	backButton.setBounds(100,570,100,30);
	todayButton.setBounds(100,100,150,30);
	datePicker.setBounds(400,100,150,30);
	datePicker1.setBounds(700,100,150,30);
	seachButton.setBounds(700,150,150,30);
	exportButton.setBounds(910,300,100,30);
	
	apponitmentFrame.add(headingLabel);
	apponitmentFrame.add(treatmentLabel);
	apponitmentFrame.add(fromdateLabel);
	apponitmentFrame.add(todateLabel);
	
	apponitmentFrame.add(backButton);
	apponitmentFrame.add(todayButton);
	apponitmentFrame.add(datePicker);
	apponitmentFrame.add(datePicker1);
	apponitmentFrame.add(seachButton);
	apponitmentFrame.add(exportButton);
	
	apponitmentFrame.setLayout(null);
	apponitmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	apponitmentFrame.pack();
	apponitmentFrame.setLocationRelativeTo(null);
	apponitmentFrame.setVisible(true);

	}
	
	public static void exportTable(JTable table,File file) throws IOException {
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        for(int i=0; i < model.getColumnCount(); i++) {
    out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
    for(int j=0; j < model.getColumnCount(); j++) {
        out.write(model.getValueAt(i,j).toString()+"\t");
        }
        out.write("\n");
    }

    out.close();
    System.out.println("write out to: " + file);
   }
	
	public static void main(String[] args) {
		new Appointment();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		((DefaultTableModel)jtable.getModel()).setRowCount(0);
		
		 if(e.getSource()==exportButton)
		{

			try {
				exportTable(jtable, new File("D:\\tabledata.xls"));
				JOptionPane.showMessageDialog(null,"excel file saved successfully");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		 else if(e.getSource()==backButton)
			{
				apponitmentFrame.dispose();
				new Home();
			}
		 else if(e.getSource()==todayButton)
		 {
			 //select all patient having appointment today
			 if(new PatientDaoImpl().getTodayAppointmentPatient() != null)
			 {
				 List<Patient> list=new PatientDaoImpl().getTodayAppointmentPatient();
				 
				 Iterator<Patient> iterator=list.iterator();
					while(iterator.hasNext())
					{
						Patient patient=(Patient)iterator.next();
						Date appointmentDate=patient.getApponitmentdate();
						String patientName=patient.getName();
						String mobile=patient.getMobile();
						String status=patient.getStatus();
						
						
						model.addRow(new Object[]{appointmentDate, patientName, mobile, status});
					}
			
			 }
		 }
		
	}

}
