package com.dms.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.dms.dao.PatientDaoImpl;
import com.dms.dao.TreatmentDaoimpl;
import com.dms.model.Patient;
import com.dms.model.Treatment;
import com.dms.services.TreatmentService;
import com.dms.services.TreatmentServiceimpl;

public class TreatmentInfo implements ActionListener{

	
	
	
	JFrame TreatmentInfoFrame;
	JLabel treatmentnameLabel,approximatetimelabel,approximatecostLabel,headingLabel;
	JTextField treatmentnameField,approximatetimeField,approximatecostField;
	JComboBox treatmentBox;
	JButton saveButton,resetButton,deleteButton,modifyButton,backButton;
	
	public TreatmentInfo() {
	
		TreatmentInfoFrame=new JFrame("Treatment Info");
		TreatmentInfoFrame.setPreferredSize(new Dimension(1366,768));
		
		headingLabel=new JLabel("Treatment Info");
		headingLabel.setFont(new Font("Aerial", Font.PLAIN, 50));
		
		treatmentnameLabel=new JLabel("TREATMENT NAME");
		approximatetimelabel=new JLabel("APPROXIMATE TIME");
		approximatecostLabel=new JLabel("APPROXIMATE COST");
	
	

		
		treatmentnameField=new JTextField();
		approximatetimeField=new JTextField();
		approximatecostField=new JTextField();
		
		treatmentBox=new JComboBox();
		
		List<String> l=new TreatmentDaoimpl().getTreatmentNames();
		
		for(String i:l) {
			treatmentBox.addItem(i);
		}
		
		
		
		saveButton=new JButton("Save");
		resetButton=new JButton("Reset");
		deleteButton=new JButton("Delete");
		modifyButton=new JButton("Modify");
		backButton=new JButton("Back");
		
		saveButton.addActionListener(this);
		resetButton.addActionListener(this);
		deleteButton.addActionListener(this);
		modifyButton.addActionListener(this);
		backButton.addActionListener(this);
	
		treatmentBox.addActionListener(this);
		
		headingLabel.setBounds(50, -25, 400, 100);
		treatmentnameLabel.setBounds(200, 100, 202, 30);
		approximatetimelabel.setBounds(200, 150, 202, 30);
		approximatecostLabel.setBounds(200, 200, 202, 30);
	
		
		treatmentnameField.setBounds(400, 100, 202, 30);
		treatmentBox.setBounds(700, 100, 202, 30);
		approximatetimeField.setBounds(400, 150, 202, 30);
		approximatecostField.setBounds(400, 200, 202, 30);
	

		
		saveButton.setBounds(200,520,100,30);
		resetButton.setBounds(350,520,100,30);
		deleteButton.setBounds(500,520,100,30);
		modifyButton.setBounds(650,520,100,30);
		backButton.setBounds(800,520,100,30);
		
		TreatmentInfoFrame.add(headingLabel);
		TreatmentInfoFrame.add(treatmentnameLabel);
		TreatmentInfoFrame.add(approximatetimelabel);
		TreatmentInfoFrame.add(approximatecostLabel);
		
		
	
		TreatmentInfoFrame.add(treatmentnameField);
		TreatmentInfoFrame.add(approximatetimeField);
		TreatmentInfoFrame.add(approximatecostField);
	
		TreatmentInfoFrame.add(treatmentBox);
	
	    TreatmentInfoFrame.add(saveButton);
	    TreatmentInfoFrame.add(resetButton);
		TreatmentInfoFrame.add(deleteButton);
		TreatmentInfoFrame.add(modifyButton);
		TreatmentInfoFrame.add(backButton);
	    
		TreatmentInfoFrame.setLayout(null);
		TreatmentInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TreatmentInfoFrame.pack();
		TreatmentInfoFrame.setLocationRelativeTo(null);
		TreatmentInfoFrame.setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args) {
		new TreatmentInfo();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
       if(treatmentBox.hasFocus()) {
    	   if(("Select".equalsIgnoreCase(treatmentBox.getSelectedItem().toString())))
    	   {
    		   treatmentnameField.setText("");
   			approximatecostField.setText("");
   			approximatetimeField.setText("");  
    	   }
           else {
			Treatment treatment=new TreatmentDaoimpl().getTreatmentbyName(treatmentBox.getSelectedItem().toString());
			if(treatment!=null)
			{
			treatmentnameField.setText(treatment.getName());
			approximatecostField.setText(Integer.toString(treatment.getCost()));
			approximatetimeField.setText(treatment.getTime());
			}
			else
				JOptionPane.showMessageDialog(null, "Oops Something went wring!");
			}
			
		}
		
		if(e.getSource()==saveButton)
		{
		
			Treatment treatment=new Treatment();
			treatment.setName(treatmentnameField.getText());
			try {
			treatment.setCost(Integer.parseInt(approximatecostField.getText()));
			}
			catch (Exception e1) {
				if(!approximatecostField.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please enter correct cost(only number)");
			}
			
			treatment.setTime(approximatetimeField.getText());
			TreatmentService service=new TreatmentServiceimpl();
			boolean[] b=service.checktreatmentinfo(treatment);
			System.out.println(treatment);
			System.out.println(b[0]+" "+b[1]+" "+b[2]);
			if(b[0]==true||b[2]==true)
			{
				JOptionPane.showMessageDialog(null,"Please enter correct details!");
				
			}
			if(b[0]==false && b[1]==false && b[2]==false) 
			{
				if(new TreatmentDaoimpl().saveTreatmentInfo(treatment))
				{
				JOptionPane.showMessageDialog(null,"Treatmentinfo saved successfully!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Oops Something went wrong!");
				}
			}
			
		}
		else if(e.getSource()==modifyButton)
		{
			Treatment treatment=new Treatment();
			treatment.setName(treatmentnameField.getText());
			try {
			treatment.setCost(Integer.parseInt(approximatecostField.getText()));
			}
			catch (Exception e1) {
				if(!approximatecostField.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please enter correct cost(only number)");
			}
			
			treatment.setTime(approximatetimeField.getText());
			TreatmentService service=new TreatmentServiceimpl();
			boolean[] b=service.checktreatmentinfo(treatment);
			System.out.println(treatment);
			System.out.println(b[0]+" "+b[1]+" "+b[2]);
			if(b[0]==true||b[2]==true)
			{
				JOptionPane.showMessageDialog(null,"Please enter correct details!");
				
			}
			if(b[0]==false && b[1]==false && b[2]==false) 
			{
			   if(new TreatmentDaoimpl().modifyTreatmentInfo(treatment))
			   {
				JOptionPane.showMessageDialog(null,"Treatmentinfo modified successfully!");
			   }
			   else
			   {
				   JOptionPane.showMessageDialog(null, "Oops Something went wrong!");
			   }
			}
		}
		else if(e.getSource()==deleteButton)
		{
			Treatment treatment=new Treatment();
			treatment.setName(treatmentnameField.getText());
			try {
			treatment.setCost(Integer.parseInt(approximatecostField.getText()));
			}
			catch (Exception e1) {
				if(!approximatecostField.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please enter correct cost(only number)");
			}
			
			treatment.setTime(approximatetimeField.getText());
			TreatmentService service=new TreatmentServiceimpl();
			boolean[] b=service.checktreatmentinfo(treatment);
			System.out.println(treatment);
			System.out.println(b[0]+" "+b[1]+" "+b[2]);
			if(b[0]==true||b[2]==true)
			{
				JOptionPane.showMessageDialog(null,"Please enter correct details!");
				
			}
			if(b[0]==false && b[1]==false && b[2]==false) 
			{
			   if(new TreatmentDaoimpl().deleteTreatmentInfo(treatment))
			   {
				JOptionPane.showMessageDialog(null,"Treatmentinfo deleted successfully!");
			   }
			   else
			   {
				   JOptionPane.showMessageDialog(null, "Oops Something went wrong!");
			   }
			}

		}
		else if(e.getSource()==resetButton)
		{
			treatmentnameField.setText("");
			approximatecostField.setText("");
			approximatetimeField.setText("");
			
		}
		
		else if(e.getSource()==backButton)
		{
			TreatmentInfoFrame.dispose();
			new Home();
			
		}
		
		
	}
	
}
