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

import com.dms.dao.TreatmentDaoimpl;
import com.dms.dao.TreatmentMasterDaoImpl;
import com.dms.model.TreatmentMasterModel;

public class TreatmentHistory implements ActionListener {
	
	JFrame treatmentHistoryFrame;
	JLabel headingLabel,treatmentNameLabel,treatmentLabel;
	JComboBox treatmentNameBox;
	DefaultTableModel model;
	JTable jtable;
	JScrollPane jScrollPane;
	JButton backButton,exportButton;
	public TreatmentHistory() {
	
		
		treatmentHistoryFrame=new JFrame("Treatment History");
		treatmentHistoryFrame.setPreferredSize(new Dimension(1366,768));
		  
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
		
		treatmentHistoryFrame.add(jScrollPane);
		
		
		
		headingLabel=new JLabel("Treatment History");
		headingLabel.setFont(new Font("Aerial", Font.PLAIN, 50));
			
		treatmentNameBox=new JComboBox();
		
		
		treatmentNameBox.addActionListener(this);

	       List<String> l=new TreatmentDaoimpl().getTreatmentNames();
			
			for(String i:l) {
				treatmentNameBox.addItem(i);
			}
		
		
			
		treatmentNameLabel=new JLabel("Treatment Name:");
		treatmentLabel=new JLabel("Treatment details");
		backButton=new JButton("Back");
		exportButton=new JButton("Export");
		
		backButton.addActionListener(this);
		exportButton.addActionListener(this);

		
		headingLabel.setBounds(50, -25, 400, 100);
		treatmentNameLabel.setBounds(100,100,150,30);	
		treatmentLabel.setBounds(100,300,150,30);
		treatmentNameBox.setBounds(260,100,200,30);
		backButton.setBounds(100,570,100,30);
		exportButton.setBounds(910,350,100,30);

		
		
		treatmentHistoryFrame.add(headingLabel);
		treatmentHistoryFrame.add(treatmentNameLabel);
		treatmentHistoryFrame.add(treatmentLabel);
		treatmentHistoryFrame.add(treatmentNameBox);
		treatmentHistoryFrame.add(backButton);
		treatmentHistoryFrame.add(exportButton);
		
		treatmentHistoryFrame.setLayout(null);
		treatmentHistoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		treatmentHistoryFrame.pack();
		treatmentHistoryFrame.setLocationRelativeTo(null);
		treatmentHistoryFrame.setVisible(true);

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
		new TreatmentHistory();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(treatmentNameBox.hasFocus())
		{
			if(!"select".equalsIgnoreCase(treatmentNameBox.getSelectedItem().toString()))
			{
			((DefaultTableModel)jtable.getModel()).setRowCount(0);
			
			
			
			List list=new TreatmentMasterDaoImpl().getTreatmentMasterModelByTreatmentName(treatmentNameBox.getSelectedItem().toString());
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
			else if("select".equalsIgnoreCase(treatmentNameBox.getSelectedItem().toString()))
			{
				((DefaultTableModel)jtable.getModel()).setRowCount(0);
				
			}
			else
			{
				((DefaultTableModel)jtable.getModel()).setRowCount(0);
			}
			
		}
		
		else if(e.getSource()==backButton)
		{
			treatmentHistoryFrame.dispose();
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
