package com.dms.view;
/*
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
*/

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JFrame implements ActionListener {

	private Image img_logo = new ImageIcon(Login.class.getResource("/icon1.png")).getImage().getScaledInstance(90, 90,
			Image.SCALE_SMOOTH);
	private Image img_UserName = new ImageIcon(Login.class.getResource("/icon2.jpeg")).getImage().getScaledInstance(30,
			30, Image.SCALE_SMOOTH);
	private Image img_Password = new ImageIcon(Login.class.getResource("/icon3.png")).getImage().getScaledInstance(30,
			30, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton loginButton, resetButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginButton) {

			if (usernameField.getText().equals("shashi") && passwordField.getText().equals("shashi123")) {
				this.dispose();
				new Home();
			} else if (!usernameField.getText().isEmpty() && passwordField.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Please enter password!");

			else if (usernameField.getText().isEmpty() && !passwordField.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Please enter username!");

			else {
				JOptionPane.showMessageDialog(null, "Please enter correct details!");
			}

		} else if (e.getSource() == resetButton) {

			usernameField.setText("");
			passwordField.setText("");

		}

	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(176, 163, 250, 40);
		panel.add(panel_1);

		usernameField = new JTextField();
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (usernameField.getText().equals("Username")) {
					usernameField.setText("");
				} else {
					usernameField.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (usernameField.getText().equals(""))
					usernameField.setText("Username");
			}
		});
		usernameField.setBorder(null);
		usernameField.setFont(new Font("Arial", Font.PLAIN, 12));
		usernameField.setText("Username");
		panel_1.add(usernameField);
		usernameField.setColumns(10);

		JLabel lblIconUserName = new JLabel("");
		lblIconUserName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblIconUserName);
		lblIconUserName.setIcon(new ImageIcon(img_UserName));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(176, 215, 250, 40);
		panel.add(panel_2);

		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equals("Password")) {
					((JPasswordField) passwordField).setEchoChar('•');
					passwordField.setText("");
				} else {
					passwordField.selectAll();
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().equals(""))
					passwordField.setText("Password");
				((JPasswordField) passwordField).setEchoChar((char) 0);
			}
		});
		passwordField.setBorder(null);
		((JPasswordField) passwordField).setEchoChar((char) 0);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
		passwordField.setText("Password");
		panel_2.add(passwordField);
		passwordField.setColumns(10);

		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblIconPassword);
		lblIconPassword.setIcon(new ImageIcon(img_Password));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setBounds(176, 267, 250, 40);
		panel.add(panel_3);
		panel_3.setLayout(new CardLayout());

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 14));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(97, 6, 111, 25);
		// panel_3.add(lblLogin);

		loginButton = new JButton("Login");
		resetButton = new JButton("Reset");

		// loginButton.setFont(new Font("Arial", Font.BOLD, 14));
		// loginButton.setForeground(Color.WHITE);

		// loginButton.setBounds(20, 3, 250, 40);
		resetButton.setBounds(280, 200, 80, 20);

		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		panel_3.add(loginButton);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?",
						"Confirmation", JOptionPane.YES_NO_OPTION) == 0)
					Login.this.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setBounds(572, 6, 20, 20);
		panel.add(lblX);

		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(172, 19, 258, 132);
		panel.add(lblIconLogo);
		setUndecorated(true);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		setLocationRelativeTo(null);
	}
}
