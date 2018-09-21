package com.Erp.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.Erp.controller.ErpController;
import com.Erp.resources.ErpGuiResources;

public class ErpGuiHome implements ActionListener {

	JFrame homeFrame;

	JButton purchaseButton, saleButton, purchaseListButton, salesListButton, stockButton, itemMasterButton,
			customerMasterButton, vendorMasterButton, firmMasterButton, logoutButton, vendorCashReciept,
			custCashReciept, vendorLedger, custLedger, bankHistoryButton, cashHistoryButton, bankMasterButton,
			itcButton, expenseButton, expenseSheetBtton,bankEntryButton;
	public JLabel userNameLabel;

	public ErpGuiHome() {

		homeFrame = new JFrame("Lucro 360------Home----------//");

		Image bg = null;

		ErpGuiResources.load();

		homeFrame.setContentPane(new JLabel(new ImageIcon(ErpGuiResources.homeBg)));

		purchaseButton = new JButton();
		saleButton = new JButton();
		purchaseListButton = new JButton();
		salesListButton = new JButton();
		stockButton = new JButton();
		itemMasterButton = new JButton();
		customerMasterButton = new JButton();
		vendorMasterButton = new JButton();
		firmMasterButton = new JButton();
		logoutButton = new JButton();
		vendorCashReciept = new JButton();
		custCashReciept = new JButton();
		vendorLedger = new JButton();
		custLedger = new JButton();
		bankHistoryButton = new JButton();
		cashHistoryButton = new JButton();
		bankMasterButton = new JButton();
		itcButton = new JButton();
		expenseButton = new JButton();
		expenseSheetBtton = new JButton();
		bankEntryButton=new JButton();

		userNameLabel = new JLabel("Hi " + "naresh" + "!");
		userNameLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
		userNameLabel.setForeground(Color.GRAY);

		purchaseButton.setBounds(90, 200, 202, 50);
		saleButton.setBounds(1065, 200, 202, 50);
		purchaseListButton.setBounds(195, 500, 202, 50);
		salesListButton.setBounds(951, 500, 202, 50);
		stockButton.setBounds(753, 400, 202, 50);
		itemMasterButton.setBounds(792, 300, 202, 50);
		customerMasterButton.setBounds(913, 600, 202, 50);
		vendorMasterButton.setBounds(230, 600, 202, 50);
		logoutButton.setBounds(1245, 65, 85, 20);
		vendorCashReciept.setBounds(125, 300, 202, 50);
		custCashReciept.setBounds(1028, 300, 202, 50);
		vendorLedger.setBounds(160, 400, 202, 50);
		custLedger.setBounds(990, 400, 202, 50);
		bankHistoryButton.setBounds(320, 200, 202, 50);
		cashHistoryButton.setBounds(830, 200, 202, 50);
		bankMasterButton.setBounds(355, 300, 202, 50);
		firmMasterButton.setBounds(390, 400, 202, 50);
		itcButton.setBounds(465, 600, 202, 50);
		bankEntryButton.setBounds(680, 600, 202, 50);
		expenseButton.setBounds(430, 500, 202, 50);
		expenseSheetBtton.setBounds(718, 500, 202, 50);

		bankMasterButton.setIcon(new ImageIcon(ErpGuiResources.bankMaster));
		bankHistoryButton.setIcon(new ImageIcon(ErpGuiResources.bankTrans));
		firmMasterButton.setIcon(new ImageIcon(ErpGuiResources.firmMaster));
		itcButton.setIcon(new ImageIcon(ErpGuiResources.itc));
		cashHistoryButton.setIcon(new ImageIcon(ErpGuiResources.cashTrans));
		itemMasterButton.setIcon(new ImageIcon(ErpGuiResources.itemMaster));
		stockButton.setIcon(new ImageIcon(ErpGuiResources.stock));
		purchaseButton.setIcon(new ImageIcon(ErpGuiResources.purchaseEntry));
		vendorCashReciept.setIcon(new ImageIcon(ErpGuiResources.vendorCashReciept));
		vendorLedger.setIcon(new ImageIcon(ErpGuiResources.vendorLedger));
		purchaseListButton.setIcon(new ImageIcon(ErpGuiResources.purchaseRecord));
		vendorMasterButton.setIcon(new ImageIcon(ErpGuiResources.vendorMaster));
		saleButton.setIcon(new ImageIcon(ErpGuiResources.saleEntry));
		custCashReciept.setIcon(new ImageIcon(ErpGuiResources.customerCashReciept));
		custLedger.setIcon(new ImageIcon(ErpGuiResources.customerLedger));
		salesListButton.setIcon(new ImageIcon(ErpGuiResources.saleRecord));
		customerMasterButton.setIcon(new ImageIcon(ErpGuiResources.customerMaster));
		logoutButton.setIcon(new ImageIcon(ErpGuiResources.logout));
		expenseButton.setIcon(new ImageIcon(ErpGuiResources.expenseEntry));
		expenseSheetBtton.setIcon(new ImageIcon(ErpGuiResources.expenseSheet));
		bankEntryButton.setIcon(new ImageIcon(ErpGuiResources.bankEntry));

		userNameLabel.setBounds(1240, -10, 100, 100);

		homeFrame.setPreferredSize(new Dimension(1366, 768));

		homeFrame.add(purchaseButton);
		homeFrame.add(saleButton);
		homeFrame.add(purchaseListButton);
		homeFrame.add(salesListButton);
		homeFrame.add(stockButton);
		homeFrame.add(itemMasterButton);
		homeFrame.add(customerMasterButton);
		homeFrame.add(vendorMasterButton);
		homeFrame.add(firmMasterButton);
		homeFrame.add(logoutButton);
		homeFrame.add(vendorCashReciept);
		homeFrame.add(custCashReciept);
		homeFrame.add(vendorLedger);
		homeFrame.add(custLedger);
		homeFrame.add(bankHistoryButton);
		homeFrame.add(cashHistoryButton);
		homeFrame.add(bankMasterButton);
		homeFrame.add(itcButton);
		homeFrame.add(userNameLabel);
		homeFrame.add(bankEntryButton);

		homeFrame.add(expenseButton);
		homeFrame.add(expenseSheetBtton);

		logoutButton.addActionListener(this);
		purchaseButton.addActionListener(this);
		itemMasterButton.addActionListener(this);
		vendorMasterButton.addActionListener(this);
		customerMasterButton.addActionListener(this);
		stockButton.addActionListener(this);
		purchaseListButton.addActionListener(this);
		salesListButton.addActionListener(this);
		saleButton.addActionListener(this);
		firmMasterButton.addActionListener(this);
		bankHistoryButton.addActionListener(this);
		bankMasterButton.addActionListener(this);
		cashHistoryButton.addActionListener(this);
		vendorCashReciept.addActionListener(this);
		custCashReciept.addActionListener(this);
		vendorLedger.addActionListener(this);
		custLedger.addActionListener(this);
		itcButton.addActionListener(this);
		expenseButton.addActionListener(this);
		expenseSheetBtton.addActionListener(this);
		bankEntryButton.addActionListener(this);

		homeFrame.setLayout(null);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.pack();
		homeFrame.setLocationRelativeTo(null);
		homeFrame.setVisible(true);

	}

	public static void main(String arge[]) {
		new ErpGuiHome();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == purchaseButton) {
			homeFrame.setVisible(false);
			new ErpGuiPurchase();
		}

		else if (e.getSource() == logoutButton) {
			homeFrame.setVisible(false);
			new ErpGuiLogin();
		}

		else if (e.getSource() == itemMasterButton) {
			homeFrame.setVisible(false);
			new ErpNewProduct();

		}

		else if (e.getSource() == vendorMasterButton) {
			homeFrame.setVisible(false);
			new ErpNewCompany();
		}

		else if (e.getSource() == customerMasterButton) {

			homeFrame.setVisible(false);
			new ErpNewCustomer();

		}

		else if (e.getSource() == purchaseListButton) {
			homeFrame.setVisible(false);
			new ErpPurchaseHistory();
		}

		else if (e.getSource() == salesListButton) {

			homeFrame.setVisible(false);
			new ErpSaleHistory();

		}

		else if (e.getSource() == stockButton) {
			homeFrame.setVisible(false);
			new ErpStock();

		} else if (e.getSource() == saleButton) {
			homeFrame.setVisible(false);
			new ErpGuiSale();
		}

		else if (e.getSource() == vendorCashReciept) {
			homeFrame.setVisible(false);
			new ErpGuiVendorCashReciept();
		}

		else if (e.getSource() == custCashReciept) {
			homeFrame.setVisible(false);
			new ErpGuiCustomerCashReciept();
		}

		else if (e.getSource() == vendorLedger) {
			homeFrame.setVisible(false);
			new ErpGuiVendorRecieptHistory();
		}

		else if (e.getSource() == custLedger) {
			homeFrame.setVisible(false);
			new ErpGuiCustomerRecieptHistory();
		}

		else if (e.getSource() == bankHistoryButton) {
			homeFrame.setVisible(false);
			new ErpGuiBankHistory();
		} else if (e.getSource() == cashHistoryButton) {
			homeFrame.setVisible(false);
			new ErpGuiCashHistory();
		} else if (e.getSource() == bankMasterButton) {
			homeFrame.setVisible(false);
			new ErpGuiNewBank();
		} else if (e.getSource() == itcButton) {
			homeFrame.setVisible(false);
			new ErpGuiITC();
		} else if (e.getSource() == expenseButton) {
			homeFrame.setVisible(false);
			new ErpGuiExpenses();
		} else if (e.getSource() == expenseSheetBtton) {
			homeFrame.setVisible(false);
			new ErpGuiExpenseSheet();
		} else if (e.getSource() == firmMasterButton) {
			homeFrame.setVisible(false);
			new ErpGuiFirmMaster();
		}
		else if(e.getSource()==bankEntryButton){
			homeFrame.setVisible(false);
			new ErpGuiBankEntry();
		}

	}

}