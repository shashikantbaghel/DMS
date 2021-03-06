package com.dms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import com.dms.dao.PatientDaoImpl;
import com.dms.dao.TreatmentDaoimpl;
import com.dms.dao.TreatmentMasterDaoImpl;
import com.dms.model.Treatment;
import com.dms.model.TreatmentMasterModel;
import com.dms.services.TreatmentMasterServiceIml;

public class TreatmentMaster implements ActionListener,ItemListener {
	
	
	JFrame treatmentMasterFarme;
	JComboBox patientNameBox,treatmentNameBox,phoneBox;
	JTextField apprximatetimeField,approximatecostField,totalpaidamountField,balanceamountField;
	JLabel selectpatientNameLabel,selecttreatmentNameLabel,approximatetimeLabel,approximatecostLabel,totalpaidamountLabel,balanceamountLabel
	,headingLabel,prescriptionLabel,phoneLabel;
	JTextArea prescriptionArea;
	JButton saveButton,save_Printbutton,restbutton,backButton;
	public TreatmentMaster() {

		treatmentMasterFarme=new JFrame("Treatment");
		treatmentMasterFarme.setPreferredSize(new Dimension(1366,768));
		
		headingLabel=new JLabel("Treatment Master");
		headingLabel.setFont(new Font("Aerial", Font.PLAIN, 50));
		
		selectpatientNameLabel=new JLabel("Patient Name");
		selecttreatmentNameLabel=new JLabel("Treatment Name");
		approximatetimeLabel=new JLabel("Approximate Time:");
		approximatecostLabel=new JLabel("Approximate Cost:");
		totalpaidamountLabel=new JLabel("Total Paid");
		balanceamountLabel=new JLabel("Balance Amonut");
		prescriptionLabel=new JLabel("Prescription");
		phoneLabel=new JLabel("Phone");
		
		patientNameBox=new JComboBox();
		treatmentNameBox=new JComboBox();
		phoneBox=new JComboBox();
		
		
		prescriptionArea=new JTextArea();
		prescriptionArea.setPreferredSize(new Dimension(100,100));
		prescriptionArea.setLayout(new BorderLayout());
		prescriptionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		saveButton=new JButton("Save");
		save_Printbutton=new JButton("Save & Print");
		restbutton=new JButton("Reset");
		backButton=new JButton("Backs");
		
		saveButton.addActionListener(this);
		save_Printbutton.addActionListener(this);
		restbutton.addActionListener(this);
		backButton.addActionListener(this);
		//patientNameBox.addActionListener(this);
		patientNameBox.addItemListener(this);
		treatmentNameBox.addActionListener(this);
		phoneBox.addActionListener(this);
		
		apprximatetimeField=new JTextField();
		approximatecostField=new JTextField();
		totalpaidamountField=new JTextField();
		balanceamountField=new JTextField();
		
		
       List<String> l=new PatientDaoImpl().getPatientNames();
		
		for(String i:l) {
			patientNameBox.addItem(i);
		}
       List<String> l1=new TreatmentDaoimpl().getTreatmentNames();
		
		for(String i:l1) {
			treatmentNameBox.addItem(i);
		}
		headingLabel.setBounds(50, -25, 400, 100);
		
		selectpatientNameLabel.setBounds(10, 100, 202, 30);
		selecttreatmentNameLabel.setBounds(450, 100, 202, 30);
		approximatetimeLabel.setBounds(700, 100, 202, 30);
		approximatecostLabel.setBounds(950, 100, 202, 30);
        totalpaidamountLabel.setBounds(700, 200, 202, 30);
        balanceamountLabel.setBounds(950, 200, 202, 30);
		prescriptionLabel.setBounds(200, 200, 202, 30);
        phoneLabel.setBounds(220, 100, 202, 30);
		
        patientNameBox.setBounds(10, 150, 202, 30);
        treatmentNameBox.setBounds(450, 150, 202, 30);
        phoneBox.setBounds(220, 150, 202, 30);
        
        apprximatetimeField.setBounds(700, 150, 202, 30);
		approximatecostField.setBounds(950, 150, 202, 30);
		totalpaidamountField.setBounds(700, 250, 202, 30);
		balanceamountField.setBounds(950, 250, 202, 30);
		
		prescriptionArea.setBounds(200, 250, 452, 200);
		
		saveButton.setBounds(700, 350, 100, 30);
		save_Printbutton.setBounds(830, 350, 110, 30);
		restbutton.setBounds(970, 350, 100, 30);
		backButton.setBounds(1100, 350, 100, 30);
		
		treatmentMasterFarme.add(headingLabel);
		treatmentMasterFarme.add(selectpatientNameLabel);
		treatmentMasterFarme.add(selecttreatmentNameLabel);
		treatmentMasterFarme.add(approximatetimeLabel);
		treatmentMasterFarme.add(approximatecostLabel);
		treatmentMasterFarme.add(totalpaidamountLabel);
		treatmentMasterFarme.add(balanceamountLabel);
		treatmentMasterFarme.add(prescriptionLabel);
		treatmentMasterFarme.add(phoneLabel);
		
		treatmentMasterFarme.add(patientNameBox);
		treatmentMasterFarme.add(treatmentNameBox);
		treatmentMasterFarme.add(phoneBox);
		
		treatmentMasterFarme.add(apprximatetimeField);
		treatmentMasterFarme.add(approximatecostField);
		treatmentMasterFarme.add(totalpaidamountField);
		treatmentMasterFarme.add(balanceamountField);
		
		treatmentMasterFarme.add(prescriptionArea);
		
		treatmentMasterFarme.add(saveButton);
		treatmentMasterFarme.add(save_Printbutton);
		treatmentMasterFarme.add(restbutton);
		treatmentMasterFarme.add(backButton);
		
		treatmentMasterFarme.setLayout(null);
		treatmentMasterFarme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		treatmentMasterFarme.pack();
		treatmentMasterFarme.setLocationRelativeTo(null);
		treatmentMasterFarme.setVisible(true);
	
	}
	public static void main(String[] args) {
		new TreatmentMaster();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource()==saveButton)
		{
			TreatmentMasterModel masterModel=new TreatmentMasterModel();
			masterModel.setPatientName(patientNameBox.getSelectedItem().toString());
			masterModel.setTreatmentName(treatmentNameBox.getSelectedItem().toString());
			masterModel.setApproximatetime(apprximatetimeField.getText());
			masterModel.setPrescription(prescriptionArea.getText());
			masterModel.setTreatmentDate(new Date());
			try {
			masterModel.setApprximatecost(Integer.parseInt(approximatecostField.getText()));
			masterModel.setTotalpaidamount(Integer.parseInt(totalpaidamountField.getText()));
			masterModel.setBalanceamount(Integer.parseInt(balanceamountField.getText()));
			}
			catch(Exception e1){
				
			}
			boolean[] b=new TreatmentMasterServiceIml().checkTreatmentMasterInfo(masterModel);
			System.out.println(masterModel);
			System.out.println(b[0]+""+b[1]+""+b[2]+""+b[3]+""+b[4]+""+b[5]);
			
			if(b[0]==true||b[1]==true||b[2]==true||b[3]==true||b[4]==true||b[5]==true)
			{
				
				JOptionPane.showMessageDialog(null, "Please enter the correct details!");
			}
			if(b[0]==false && b[1]==false && b[2]==false && b[3]==false && b[4]==false && b[5]==false)
			{
				if(new TreatmentMasterDaoImpl().saveTreatment(masterModel))
				{
					JOptionPane.showMessageDialog(null, "Treatment saved successfully!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Oops Something went wrong!");
				}
				
			}
			
		}
		else if(e.getSource()==save_Printbutton)
		{
			
			TreatmentMasterModel masterModel=new TreatmentMasterModel();
			masterModel.setPatientName(patientNameBox.getSelectedItem().toString());
			masterModel.setTreatmentName(treatmentNameBox.getSelectedItem().toString());
			masterModel.setApproximatetime(apprximatetimeField.getText());
			masterModel.setPrescription(prescriptionArea.getText());
			masterModel.setTreatmentDate(new Date());
			try {
			masterModel.setApprximatecost(Integer.parseInt(approximatecostField.getText()));
			masterModel.setTotalpaidamount(Integer.parseInt(totalpaidamountField.getText()));
			masterModel.setBalanceamount(Integer.parseInt(balanceamountField.getText()));
			}
			catch(Exception e1){
				
			}
			boolean[] b=new TreatmentMasterServiceIml().checkTreatmentMasterInfo(masterModel);
			System.out.println(masterModel);
			System.out.println(b[0]+""+b[1]+""+b[2]+""+b[3]+""+b[4]+""+b[5]);
			
			if(b[0]==true||b[1]==true||b[2]==true||b[3]==true||b[4]==true||b[5]==true)
			{
				
				JOptionPane.showMessageDialog(null, "Please enter the correct details!");
			}
			if(b[0]==false && b[1]==false && b[2]==false && b[3]==false && b[4]==false && b[5]==false)
			{

				if(new TreatmentMasterDaoImpl().saveTreatment(masterModel))
				{
					try {
						new Report(masterModel);
						JOptionPane.showMessageDialog(null, "Treatment saved successfully!");
					} 
					catch (BadLocationException e1) 
					{
						
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Oops Something went wrong!");
					}
					
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Oops Something went wrong!");
				}
				
				
				
				
			}
			
			
			
		}
		else if(e.getSource()==restbutton)
		{
			
			approximatecostField.setText("");
			apprximatetimeField.setText("");
			totalpaidamountField.setText("");
			balanceamountField.setText("");
		}
		else if(e.getSource()==backButton) 
		{
			
			new Home();
			treatmentMasterFarme.dispose();
		}
		
		else if(treatmentNameBox.hasFocus()) {
			if("select".equalsIgnoreCase(treatmentNameBox.getSelectedItem().toString())||"".equals(treatmentNameBox.getSelectedItem().toString()))
			{
				approximatecostField.setText("");
				apprximatetimeField.setText("");
				totalpaidamountField.setText("");
				balanceamountField.setText("");
			}
			else
			{
				Treatment treatment=new TreatmentDaoimpl().getTreatmentbyName(treatmentNameBox.getSelectedItem().toString());
				approximatecostField.setText(Integer.toString(treatment.getCost()));
				apprximatetimeField.setText(treatment.getTime());
				totalpaidamountField.setText(Integer.toString(treatment.getCost()));
				balanceamountField.setText((Integer.toString(treatment.getCost())));
			}
		}
		
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent event) {
		
		 if (event.getStateChange() == ItemEvent.SELECTED) {
	          Object item = event.getItem();
	          
	          
	        	  if(!item.equals("Select"))
				{
	        		  phoneBox.removeAllItems();
					List<String> list=null;
					 list=new PatientDaoImpl().getPhonenumberListByName(item.toString());
					
					for(String i:list)
					{
						
						phoneBox.addItem(i);
					}
				}
				else if(item.equals("Select"))
				{
					phoneBox.removeAllItems();
					
				}	     
	          }
		
	}
	

}
