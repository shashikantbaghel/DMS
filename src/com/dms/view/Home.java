package com.dms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Home extends JFrame implements ActionListener {

	JButton NewPatientButton, AppointmentButton, RecordButton, TreatmentInfoButton, TreatmentButton, ReportsButton,
			btnLogout;
	Image patient_logo = new ImageIcon(Home.class.getResource("/patients.png")).getImage().getScaledInstance(100, 100,
			Image.SCALE_SMOOTH);
	Image records_logo = new ImageIcon(Home.class.getResource("/record.png")).getImage().getScaledInstance(100, 100,
			Image.SCALE_SMOOTH);
	Image appointment_logo = new ImageIcon(Home.class.getResource("/appointment.png")).getImage().getScaledInstance(100,
			100, Image.SCALE_SMOOTH);
	Image treatment_logo = new ImageIcon(Home.class.getResource("/treatment.png")).getImage().getScaledInstance(100,
			100, Image.SCALE_SMOOTH);
	Image treatment_info = new ImageIcon(Home.class.getResource("/treatmentinfo.png")).getImage().getScaledInstance(100,
			100, Image.SCALE_SMOOTH);
	Image reports_logo = new ImageIcon(Home.class.getResource("/reports.png")).getImage().getScaledInstance(100, 100,
			Image.SCALE_SMOOTH);
	JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new LineBorder(new Color(139, 0, 0), 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setUndecorated(true);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 105, 30));
		panel_1.setBounds(0, 0, 1390, 93);
		panel.add(panel_1);

		NewPatientButton = new JButton("New Patient");
		NewPatientButton.setBounds(309, 192, 117, 29);
		panel.add(NewPatientButton);

		NewPatientButton.addActionListener(this);

		AppointmentButton = new JButton("Appointment");
		AppointmentButton.setBounds(669, 192, 117, 29);
		panel.add(AppointmentButton);
		AppointmentButton.addActionListener(this);

		RecordButton = new JButton("Record");
		RecordButton.setBounds(1045, 192, 117, 29);
		panel.add(RecordButton);
		RecordButton.addActionListener(this);

		TreatmentInfoButton = new JButton("Treatment Info");
		TreatmentInfoButton.setBounds(309, 396, 117, 29);
		panel.add(TreatmentInfoButton);
		TreatmentInfoButton.addActionListener(this);

		TreatmentButton = new JButton("Treatment");
		TreatmentButton.setBounds(669, 396, 117, 29);
		panel.add(TreatmentButton);
		TreatmentButton.addActionListener(this);

		ReportsButton = new JButton("Reports");
		ReportsButton.setBounds(1045, 396, 117, 29);
		panel.add(ReportsButton);
		ReportsButton.addActionListener(this);

		JLabel lblPatientIcon = new JLabel("");
		lblPatientIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientIcon.setBounds(309, 218, 134, 133);
		panel.add(lblPatientIcon);
		lblPatientIcon.setIcon(new ImageIcon(patient_logo));

		JLabel lblAppointment = new JLabel("");
		lblAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointment.setBounds(679, 233, 107, 108);
		panel.add(lblAppointment);
		lblAppointment.setIcon(new ImageIcon(appointment_logo));

		JLabel lblReportlogo = new JLabel("");
		lblReportlogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportlogo.setBounds(1055, 233, 95, 108);
		panel.add(lblReportlogo);
		lblReportlogo.setIcon(new ImageIcon(records_logo));

		JLabel lbltrmntInfo = new JLabel("");
		lbltrmntInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltrmntInfo.setBounds(319, 437, 107, 105);
		panel.add(lbltrmntInfo);
		lbltrmntInfo.setIcon(new ImageIcon(treatment_info));

		JLabel lbltreatment = new JLabel("");
		lbltreatment.setHorizontalAlignment(SwingConstants.CENTER);
		lbltreatment.setBounds(679, 437, 107, 105);
		panel.add(lbltreatment);
		lbltreatment.setIcon(new ImageIcon(treatment_logo));

		JLabel lblReports = new JLabel("");
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblReports.setBounds(1055, 437, 107, 105);
		panel.add(lblReports);
		lblReports.setIcon(new ImageIcon(reports_logo));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(210, 105, 30));
		panel_2.setBounds(0, 0, 117, 802);
		panel.add(panel_2);
		setLocationRelativeTo(null);

		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnLogout.setBounds(1267, 93, 117, 29);
		panel.add(btnLogout);
		setLocationRelativeTo(null);
		btnLogout.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogout) {
			this.dispose();
			new Login();
		} else if (e.getSource() == TreatmentInfoButton) {
			this.dispose();
			new TreatmentInfo();
		} else if (e.getSource() == NewPatientButton) {
			this.dispose();
			new PatientMaster();
		} else if (e.getSource() == TreatmentButton) {
			this.dispose();
			new TreatmentMaster();
		} else if (e.getSource() == RecordButton) {
			this.dispose();
			new Record();

		} else if (e.getSource() == AppointmentButton) {
			this.dispose();
			new Appointment();

		} else if (e.getSource() == ReportsButton) {

			try {
				new Report();
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
