package com.dms.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.dms.dao.PatientDaoImpl;
import com.dms.dao.TreatmentMasterDaoImpl;
import com.dms.model.TreatmentMasterModel;
import com.dms.view.*;

public class PatientHistory implements ActionListener {

	
	JFrame patientHistoryFrame;
	JLabel headingLabel,patientNameLabel,patientdetailsLabel,addressLabel,mobileNoLabel,AgeLabel,GenderLabel,treatmentLabel;
	JLabel patientNameLabelValue,patientdetailsLabelValue,addressLabelValue,mobileNoLabelValue,AgeLabelValue,GenderLabelValue;
	JComboBox patientNameBox;
	DefaultTableModel model;
	JTable jtable;
	JScrollPane jScrollPane;
	JButton backButton,exportButton;
	public PatientHistory() {
	
		patientHistoryFrame=new JFrame("Patient History");
		patientHistoryFrame.setPreferredSize(new Dimension(1366,768));
		  
		String column[]={"TREATMENT DATE","TREATMENT","AMOUNT PAID","BALANCE"};    
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		jtable=new JTable();
		
		jtable.setModel(model);
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jtable.setFillsViewportHeight(true);
		jScrollPane=new JScrollPane(jtable);
		jScrollPane.setBounds(100,350,800,200);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		patientHistoryFrame.add(jScrollPane);
		
		
		
		headingLabel=new JLabel("Patient History");
		headingLabel.setFont(new Font("Aerial", Font.PLAIN, 50));
			
		patientNameBox=new JComboBox();
		
		
		patientNameBox.addActionListener(this);

	       List<String> l=new PatientDaoImpl().getPatientNames();
			
			for(String i:l) {
				patientNameBox.addItem(i);
			}
		
		
			
		patientNameLabel=new JLabel("Patient Name:");
		addressLabel=new JLabel("Address");
		mobileNoLabel=new JLabel("Mobile No");
		AgeLabel=new JLabel("Age");
		GenderLabel=new JLabel("Gender");
		treatmentLabel=new JLabel("Treatment details");
		
		addressLabelValue=new JLabel();
		mobileNoLabelValue=new JLabel();
		AgeLabelValue=new JLabel();
		GenderLabelValue=new JLabel();
		
		backButton=new JButton("Back");
		exportButton=new JButton("Export");
		
		backButton.addActionListener(this);
		exportButton.addActionListener(this);
		
		headingLabel.setBounds(50, -25, 400, 100);
		
		patientNameLabel.setBounds(100,100,150,30);
		addressLabel.setBounds(120,200,150,30);
		mobileNoLabel.setBounds(120,250,150,30);
		AgeLabel.setBounds(500,250,50,30);
		GenderLabel.setBounds(600,250,50,30);
		treatmentLabel.setBounds(100,300,150,30);
		
		addressLabelValue.setBounds(280,200,150,30);
		mobileNoLabelValue.setBounds(280,250,150,30);
		AgeLabelValue.setBounds(550,250,50,30);
		GenderLabelValue.setBounds(650,250,50,30);
		
		patientNameBox.setBounds(260,100,200,30);
		
		backButton.setBounds(100,570,100,30);
		exportButton.setBounds(910,350,100,30);
		
		
		patientHistoryFrame.add(headingLabel);
		
		patientHistoryFrame.add(patientNameLabel);
		patientHistoryFrame.add(addressLabel);
		patientHistoryFrame.add(mobileNoLabel);
		patientHistoryFrame.add(AgeLabel);
		patientHistoryFrame.add(GenderLabel);
		patientHistoryFrame.add(treatmentLabel);
		
		patientHistoryFrame.add(addressLabelValue);
		patientHistoryFrame.add(mobileNoLabelValue);
		patientHistoryFrame.add(AgeLabelValue);
		patientHistoryFrame.add(GenderLabelValue);
		
		patientHistoryFrame.add(patientNameBox);
		
		patientHistoryFrame.add(backButton);
		patientHistoryFrame.add(exportButton);
		
		patientHistoryFrame.setLayout(null);
		patientHistoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		patientHistoryFrame.pack();
		patientHistoryFrame.setLocationRelativeTo(null);
		patientHistoryFrame.setVisible(true);
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
      new PatientHistory();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(patientNameBox.hasFocus())
		{
			if(!"select".equalsIgnoreCase(patientNameBox.getSelectedItem().toString()))
			{
			((DefaultTableModel)jtable.getModel()).setRowCount(0);
			
			addressLabelValue.setText(new PatientDaoImpl().getPatientbyName(patientNameBox.getSelectedItem().toString()).getAddress());
			mobileNoLabelValue.setText(new PatientDaoImpl().getPatientbyName(patientNameBox.getSelectedItem().toString()).getMobile());
			AgeLabelValue.setText(Integer.toString(new PatientDaoImpl().getPatientbyName(patientNameBox.getSelectedItem().toString()).getAge()));
			GenderLabelValue.setText(new PatientDaoImpl().getPatientbyName(patientNameBox.getSelectedItem().toString()).getSex());
			
			List list=new TreatmentMasterDaoImpl().getTreatmentMasterModelByPatientName(patientNameBox.getSelectedItem().toString());
			Iterator<TreatmentMasterModel> iterator=list.iterator();
			while(iterator.hasNext())
			{
				TreatmentMasterModel masterModel=(TreatmentMasterModel)iterator.next();
				String treatmentDate=masterModel.getTreatmentDate().toString();
				String treatmentname=masterModel.getTreatmentName();
				String amountpaid=Integer.toString(masterModel.getTotalpaidamount());
				String balanceamount=Integer.toString(masterModel.getBalanceamount());
				
				
				model.addRow(new Object[]{treatmentDate, treatmentname, amountpaid, balanceamount});
			}
		
			
		   }
			else if("select".equalsIgnoreCase(patientNameBox.getSelectedItem().toString()))
			{
				((DefaultTableModel)jtable.getModel()).setRowCount(0);
				addressLabelValue.setText("");
				mobileNoLabelValue.setText("");
				AgeLabelValue.setText("");
				GenderLabelValue.setText("");
			}
			
		}
		else if(e.getSource()==backButton)
		{
			patientHistoryFrame.dispose();
			new Record();
		}
		else if(e.getSource()==exportButton)
		{

			try {
				exportTable(jtable, new File("D:\\tabledata.xls"));
				JOptionPane.showMessageDialog(null,"excel file saved successfully");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
