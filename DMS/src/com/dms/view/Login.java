package com.dms.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener{

	JFrame f;
	JButton loginButton,resetButton;
	JTextField usernameField;
	JPasswordField passwordField;
	JLabel userLabel,passwordLabel;
	
	
	public Login() {
		
		f=new JFrame();
		
		f.setPreferredSize(new Dimension(600, 400));
		
		userLabel=new JLabel("Username");
		passwordLabel=new JLabel("Password");
		
		usernameField=new JTextField();
		passwordField=new JPasswordField();
		
		loginButton=new JButton("Login");
		resetButton=new JButton("Reset");
		
		userLabel.setBounds(120, 50, 202, 50);
		passwordLabel.setBounds(120, 100, 202, 50);
		
		usernameField.setBounds(190, 65, 202, 25);
		passwordField.setBounds(190, 115, 202, 25);
		
		loginButton.setBounds(190, 200, 80, 20);
		resetButton.setBounds(280, 200, 80, 20);
		
		
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		f.add(userLabel);
		f.add(passwordLabel);
		f.add(usernameField);
		f.add(passwordField);
		f.add(loginButton);
		f.add(resetButton);
		
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		
		
	}
	
	public static void main(String[] args) {
		
		new Login();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==loginButton) {
			
			if(usernameField.getText().equals("shashi") && passwordField.getText().equals("shashi123")) {
				f.dispose();
				new Home();
			}
			else if(!usernameField.getText().isEmpty() && passwordField.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Please enter password!");	
			
			else if(usernameField.getText().isEmpty() && !passwordField.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Please enter username!");	
			
			else {
				JOptionPane.showMessageDialog(null, "Please enter correct details!");
			}
			
		}
		else if(e.getSource()==resetButton) {
			
			usernameField.setText("");
			passwordField.setText("");
			
		}
		
	}
	
	
}
