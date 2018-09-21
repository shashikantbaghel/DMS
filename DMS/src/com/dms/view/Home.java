package com.dms.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;

public class Home implements ActionListener {

	JFrame homeFrame,exitFrame;
	JButton treatmentInfoButton, patientMasterButton, treatmentButton, appointmentsButton, reportsButton, exitButton,
			logoutButton,yesButton,noButton,recordButton;
	JLabel exitLabel,userNameLabel;

	public Home() {

		homeFrame = new JFrame("DMS");
		homeFrame.setPreferredSize(new Dimension(1366, 768));

		exitLabel=new JLabel("Are you sure?");
		userNameLabel=new JLabel("Welcome Shashikant");
		
		treatmentInfoButton = new JButton("Treatment Info");
		patientMasterButton = new JButton("New Patient");
		treatmentButton = new JButton("Treatment");
		appointmentsButton = new JButton("Appointment");
		reportsButton = new JButton("Reports");
		exitButton = new JButton("Exit");
		logoutButton = new JButton("Logout");
		recordButton=new JButton("Record");
		
		yesButton=new JButton("YES");
		noButton=new JButton("NO");

		treatmentInfoButton.setBounds(200, 150, 202, 50);
		patientMasterButton.setBounds(800, 150, 202, 50);
		treatmentButton.setBounds(200, 350, 202, 50);
		recordButton.setBounds(500, 350, 202, 50);
		appointmentsButton.setBounds(800, 350, 202, 50);
		reportsButton.setBounds(200, 550, 202, 50);
		exitButton.setBounds(800, 550, 202, 50);
		logoutButton.setBounds(1200, 10, 80, 20);
		
		userNameLabel.setBounds(1000,10,150,20);
		exitLabel.setBounds(20,0,150,25);
		yesButton.setBounds(30,30,70,20);
		noButton.setBounds(110,30,70,20);

		treatmentInfoButton.addActionListener(this);
		patientMasterButton.addActionListener(this);
		treatmentButton.addActionListener(this);
		recordButton.addActionListener(this);
		appointmentsButton.addActionListener(this);
		reportsButton.addActionListener(this);
		exitButton.addActionListener(this);
		logoutButton.addActionListener(this);
		yesButton.addActionListener(this);
		noButton.addActionListener(this);

		homeFrame.add(treatmentInfoButton);
		homeFrame.add(patientMasterButton);
		homeFrame.add(treatmentButton);
		homeFrame.add(recordButton);
		homeFrame.add(appointmentsButton);
		homeFrame.add(reportsButton);
		homeFrame.add(exitButton);
		homeFrame.add(logoutButton);
        homeFrame.add(userNameLabel);
		
		homeFrame.setLayout(null);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.pack();
		homeFrame.setLocationRelativeTo(null);
		homeFrame.setVisible(true);

	}

	public static void main(String[] args) {

		new Home();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == logoutButton) {
			homeFrame.setVisible(false);
			new Login();
		} else if (e.getSource() == treatmentInfoButton) {
			homeFrame.setVisible(false);
			new TreatmentInfo();
		} else if (e.getSource() == patientMasterButton) {
			homeFrame.setVisible(false);
			new PatientMaster();
		} else if (e.getSource() == treatmentButton) {
			homeFrame.setVisible(false);
			new TreatmentMaster();
		}
		else if (e.getSource() == recordButton) {
			homeFrame.dispose();
			new Record();
			
		}
		else if (e.getSource() == appointmentsButton) {
			homeFrame.setVisible(false);
		
		} else if (e.getSource() == reportsButton) {
			
			try {
				new Report();
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == exitButton) {
			exitFrame = new JFrame("Exit");
			exitFrame.setPreferredSize(new Dimension(200,100));
			
			
			exitFrame.add(exitLabel);
			exitFrame.add(yesButton);
			exitFrame.add(noButton);
			
			exitFrame.setResizable(false);
			exitFrame.setLayout(null);
			exitFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			exitFrame.pack();
			exitFrame.setLocationRelativeTo(null);
			exitFrame.setVisible(true);
			
			
			// new PatientMaster();
		}
		else if(e.getSource()==yesButton) {
			System.exit(0);
		}
		else if(e.getSource()==noButton){
			exitFrame.setVisible(false);
		}

	}

}
