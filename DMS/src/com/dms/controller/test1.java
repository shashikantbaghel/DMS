package com.Erp.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.Erp.dao.ErpCustomerDao;
import com.Erp.dao.ErpFirmDao;
import com.Erp.dao.ErpProductDao;
import com.Erp.dao.ErpSaleDao;
import com.Erp.dao.ErpStockDao;
import com.Erp.dao.ErpVendorDao;
import com.Erp.model.ErpCustomerVo;
import com.Erp.model.ErpFirmVo;
import com.Erp.model.ErpProductVo;
import com.Erp.model.ErpVendorVo;
import com.itextpdf.text.DocumentException;

public class ErpGuiSale implements ActionListener {

	static JComboBox<String> firmBox, customerBox, productBox, addressBox;
	static JLabel firmLabel, srNoLabel, nameLabel, billNoLabel, dateLabel, addressLabel, phoneLabel, balanceLabel,
			gstNoLabel, transportModeLabel;
	static JTextField srNoTextField, billNoTextField, dateTextField, balanceTextField, gstNoTextField, phoneTextField,
			transportModeField;
	static String firmName;

	static JTextField prName1, hsn1, packing1, qty1, free1, rate1, unit1, dsc1, taxableAmount1, taxRate1, taxAmount1,
			amount1;
	static JTextField prName2, hsn2, packing2, qty2, free2, rate2, unit2, dsc2, taxableAmount2, taxRate2, taxAmount2,
			amount2;
	static JTextField prName3, hsn3, packing3, qty3, free3, rate3, unit3, dsc3, taxableAmount3, taxRate3, taxAmount3,
			amount3;
	static JTextField prName4, hsn4, packing4, qty4, free4, rate4, unit4, dsc4, taxableAmount4, taxRate4, taxAmount4,
			amount4;
	static JTextField prName5, hsn5, packing5, qty5, free5, rate5, unit5, dsc5, taxableAmount5, taxRate5, taxAmount5,
			amount5;
	static JTextField prName6, hsn6, packing6, qty6, free6, rate6, unit6, dsc6, taxableAmount6, taxRate6, taxAmount6,
			amount6;
	static JTextField prName7, hsn7, packing7, qty7, free7, rate7, unit7, dsc7, taxableAmount7, taxRate7, taxAmount7,
			amount7;
	static JTextField prName8, hsn8, packing8, qty8, free8, rate8, unit8, dsc8, taxableAmount8, taxRate8, taxAmount8,
			amount8;
	static JTextField prName9, hsn9, packing9, qty9, free9, rate9, unit9, dsc9, taxableAmount9, taxRate9, taxAmount9,
			amount9;
	static JTextField prName10, hsn10, packing10, qty10, free10, unit10, rate10, dsc10, taxableAmount10, taxRate10,
			taxAmount10, amount10;

	public static JTextField taxableValue1, taxableValue2, taxableValue3, taxableValue4;
	static JTextField rateSgst1, rateSgst2, rateSgst3, rateSgst4;
	static JTextField amountSgst1, amountSgst2, amountSgst3, amountSgst4;
	static JTextField rateCgst1, rateCgst2, rateCgst3, rateCgst4;
	static JTextField amountCgst1, amountCgst2, amountCgst3, amountCgst4;
	static JTextField totalTaxableValue, totalSgstAmount, totalCgstAmount;

	static JTextField netAmount, cgstAmount, sgstAmount, totalTax, subAmount, grandTotal, totalField, roundOffField;

	static JComboBox<String> b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

	JLabel sr1, srLabel, prNameLabel, hsnLabel, packingLabel, qtyLabel, freeLabel, rateLabel, unitLabel, dscLabel,
			taxableAmountLabel, taxRateLabel, cgstLabel, sgstLabel, totalTaxLabel, subTotalLabel, taxableValueLabel,
			rateSgstLabel, rateCgstLabel, amountSgstLabel, amountCgstLabel, subTotalCommonLabel, grandTotalLabel,
			totalLabel, roundOffLabel;

	JButton generateBillButton, addButton, clearButton, backButton;

	DefaultTableModel defaultTableModel;

	JFrame f;
	JPanel p;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	DecimalFormat decimalFormat = new DecimalFormat("#.00");

	public ErpGuiSale() {

		f = new JFrame("Lucro 360---------Sale----------//");

		p = new JPanel();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		JScrollPane jScrollPane = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		firmLabel = new JLabel("Firm");
		firmLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		firmLabel.setBounds(5, -25, 100, 100);

		srNoLabel = new JLabel("Sr No");
		srNoLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		srNoLabel.setBounds(705, -25, 100, 100);

		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		nameLabel.setBounds(5, 20, 100, 100);

		billNoLabel = new JLabel("Bill No");
		billNoLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		billNoLabel.setBounds(700, 20, 100, 100);

		dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		dateLabel.setBounds(1000, 20, 100, 100);

		addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		addressLabel.setBounds(5, 65, 100, 100);

		phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		phoneLabel.setBounds(800, 65, 100, 100);

		balanceLabel = new JLabel("Balance");
		balanceLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		balanceLabel.setBounds(5, 110, 100, 100);

		gstNoLabel = new JLabel("GST No");
		gstNoLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		gstNoLabel.setBounds(400, 110, 100, 100);

		transportModeLabel = new JLabel("Transport");
		transportModeLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
		transportModeLabel.setBounds(750, 110, 100, 100);

		srLabel = new JLabel("Sr");
		srLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		srLabel.setBounds(10, 230, 100, 30);
		prNameLabel = new JLabel("Product");
		prNameLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		prNameLabel.setBounds(130, 230, 100, 30);
		hsnLabel = new JLabel("HSN");
		hsnLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		hsnLabel.setBounds(500, 230, 100, 30);
		packingLabel = new JLabel("Packing");
		packingLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		packingLabel.setBounds(584, 230, 100, 30);
		qtyLabel = new JLabel("Qty");
		qtyLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		qtyLabel.setBounds(690, 230, 100, 30);
		freeLabel = new JLabel("Free");
		freeLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		freeLabel.setBounds(780, 230, 100, 30);
		rateLabel = new JLabel("Rate");
		rateLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		rateLabel.setBounds(880, 230, 100, 30);
		unitLabel = new JLabel("Per");
		unitLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		unitLabel.setBounds(980, 230, 100, 30);
		dscLabel = new JLabel("Dsc(%)");
		dscLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		dscLabel.setBounds(1100, 230, 100, 30);
		taxableAmountLabel = new JLabel("Taxable Amount");
		taxableAmountLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		taxableAmountLabel.setBounds(1200, 230, 120, 30);
		taxRateLabel = new JLabel("Tax(%)");
		taxRateLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		taxRateLabel.setBounds(1040, 230, 50, 30);

		taxableValueLabel = new JLabel("Taxable Value");
		taxableValueLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		taxableValueLabel.setBounds(200, 650, 150, 30);

		rateSgstLabel = new JLabel("SGST Rate");
		rateSgstLabel.setFont(new Font("Aerial", Font.BOLD, 14));
		rateSgstLabel.setBounds(350, 650, 150, 30);

		amountSgstLabel = new JLabel("SGST Amount");
		amountSgstLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		amountSgstLabel.setBounds(460, 650, 150, 30);

		rateCgstLabel = new JLabel("CGST Rate");
		rateCgstLabel.setFont(new Font("Aerial", Font.BOLD, 14));
		rateCgstLabel.setBounds(600, 650, 150, 30);

		amountCgstLabel = new JLabel("CGST Amount");
		amountCgstLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		amountCgstLabel.setBounds(710, 650, 150, 30);

		subTotalCommonLabel = new JLabel("Sub Total");
		subTotalCommonLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		subTotalCommonLabel.setBounds(50, 817, 150, 30);

		grandTotalLabel = new JLabel("Grand Total");
		grandTotalLabel.setFont(new Font("Aerial", Font.BOLD, 15));
		grandTotalLabel.setBounds(1100, 650, 150, 30);

		subTotalLabel = new JLabel("Sub Total");
		subTotalLabel.setFont(new Font("Aerial", Font.BOLD, 17));
		subTotalLabel.setBounds(1050, 565, 100, 30);

		totalTaxLabel = new JLabel("Total Tax");
		totalTaxLabel.setFont(new Font("Aerial", Font.PLAIN, 17));
		totalTaxLabel.setBounds(1000, 590, 100, 30);
		cgstLabel = new JLabel("CGST Amount");
		cgstLabel.setFont(new Font("Aerial", Font.PLAIN, 15));
		cgstLabel.setBounds(1000, 617, 100, 30);
		sgstLabel = new JLabel("SGST Amount");
		sgstLabel.setFont(new Font("Aerial", Font.PLAIN, 15));
		sgstLabel.setBounds(1000, 644, 100, 30);

		totalLabel = new JLabel("Total");
		totalLabel.setFont(new Font("Aerial", Font.PLAIN, 15));
		totalLabel.setBounds(1050, 644, 100, 30);

		roundOffLabel = new JLabel("Round Off");
		roundOffLabel.setFont(new Font("Aerial", Font.PLAIN, 15));
		roundOffLabel.setBounds(1100, 644, 100, 30);

		int ycord = 280;

		for (int g = 1; g < 11; g++) {

			sr1 = new JLabel(String.valueOf(g));

			sr1.setBounds(10, ycord, 30, 17);
			p.add(sr1);

			ycord += 28;

		}

		prName1 = new JTextField();
		prName1.setBounds(40, 270, 260, 30);
		prName1.setFont(new Font("Aerial", Font.PLAIN, 17));

		prName2 = new JTextField();
		prName2.setBounds(40, 299, 260, 30);
		prName2.setFont(new Font("Aerial", Font.PLAIN, 17));

		prName3 = new JTextField();
		prName3.setBounds(40, 327, 260, 30);
		prName3.setFont(new Font("Aerial", Font.PLAIN, 17));

		prName4 = new JTextField();
		prName4.setBounds(40, 355, 260, 30);
		prName4.setFont(new Font("Aerial", Font.PLAIN, 17));

		prName5 = new JTextField();
		prName5.setBounds(40, 384, 260, 30);
		prName5.setFont(new Font("Aerial", Font.PLAIN, 17));

		prName6 = new JTextField();
		prName6.setBounds(40, 412, 260, 30);
		prName6.setFont(new Font("Aerial", Font.PLAIN, 17));

		prName7 = new JTextField();
		prName7.setBounds(40, 440, 260, 30);
		prName7.setFont(new Font("Aerial", Font.PLAIN, 17));

		prName8 = new JTextField();
		prName8.setBounds(40, 468, 260, 30);
		prName8.setFont(new Font("Aerial", Font.PLAIN, 17));

		prName9 = new JTextField();
		prName9.setBounds(40, 496, 260, 30);
		prName9.setFont(new Font("Aerial", Font.PLAIN, 17));

		prName10 = new JTextField();
		prName10.setBounds(40, 524, 260, 30);
		prName10.setFont(new Font("Aerial", Font.PLAIN, 17));

		hsn1 = new JTextField();
		hsn1.setBounds(470, 270, 100, 30);
		hsn1.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn1.setEditable(false);

		hsn2 = new JTextField();
		hsn2.setBounds(470, 298, 100, 30);
		hsn2.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn2.setEditable(false);

		hsn3 = new JTextField();
		hsn3.setBounds(470, 327, 100, 30);
		hsn3.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn3.setEditable(false);

		hsn4 = new JTextField();
		hsn4.setBounds(470, 355, 100, 30);
		hsn4.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn4.setEditable(false);

		hsn5 = new JTextField();
		hsn5.setBounds(470, 383, 100, 30);
		hsn5.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn5.setEditable(false);

		hsn6 = new JTextField();
		hsn6.setBounds(470, 412, 100, 30);
		hsn6.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn6.setEditable(false);

		hsn7 = new JTextField();
		hsn7.setBounds(470, 440, 100, 30);
		hsn7.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn7.setEditable(false);

		hsn8 = new JTextField();
		hsn8.setBounds(470, 468, 100, 30);
		hsn8.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn8.setEditable(false);

		hsn9 = new JTextField();
		hsn9.setBounds(470, 496, 100, 30);
		hsn9.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn9.setEditable(false);

		hsn10 = new JTextField();
		hsn10.setBounds(470, 524, 100, 30);
		hsn10.setFont(new Font("Aerial", Font.PLAIN, 17));
		hsn10.setEditable(false);

		packing1 = new JTextField();
		packing1.setBounds(580, 270, 80, 30);
		packing1.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing1.setEditable(false);

		packing2 = new JTextField();
		packing2.setBounds(580, 298, 80, 30);
		packing2.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing2.setEditable(false);

		packing3 = new JTextField();
		packing3.setBounds(580, 326, 80, 30);
		packing3.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing3.setEditable(false);

		packing4 = new JTextField();
		packing4.setBounds(580, 355, 80, 30);
		packing4.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing4.setEditable(false);

		packing5 = new JTextField();
		packing5.setBounds(580, 383, 80, 30);
		packing5.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing5.setEditable(false);

		packing6 = new JTextField();
		packing6.setBounds(580, 411, 80, 30);
		packing6.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing6.setEditable(false);

		packing7 = new JTextField();
		packing7.setBounds(580, 440, 80, 30);
		packing7.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing7.setEditable(false);

		packing8 = new JTextField();
		packing8.setBounds(580, 468, 80, 30);
		packing8.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing8.setEditable(false);

		packing9 = new JTextField();
		packing9.setBounds(580, 496, 80, 30);
		packing9.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing9.setEditable(false);

		packing10 = new JTextField();
		packing10.setBounds(580, 524, 80, 30);
		packing10.setFont(new Font("Aerial", Font.PLAIN, 17));
		packing10.setEditable(false);

		qty1 = new JTextField();
		qty1.setBounds(670, 270, 80, 30);
		qty1.setFont(new Font("Aerial", Font.PLAIN, 17));

		qty2 = new JTextField();
		qty2.setBounds(670, 298, 80, 30);
		qty2.setFont(new Font("Aerial", Font.PLAIN, 17));

		qty3 = new JTextField();
		qty3.setBounds(670, 326, 80, 30);
		qty3.setFont(new Font("Aerial", Font.PLAIN, 17));

		qty4 = new JTextField();
		qty4.setBounds(670, 354, 80, 30);
		qty4.setFont(new Font("Aerial", Font.PLAIN, 17));

		qty5 = new JTextField();
		qty5.setBounds(670, 382, 80, 30);
		qty5.setFont(new Font("Aerial", Font.PLAIN, 17));

		qty6 = new JTextField();
		qty6.setBounds(670, 410, 80, 30);
		qty6.setFont(new Font("Aerial", Font.PLAIN, 17));

		qty7 = new JTextField();
		qty7.setBounds(670, 438, 80, 30);
		qty7.setFont(new Font("Aerial", Font.PLAIN, 17));

		qty8 = new JTextField();
		qty8.setBounds(670, 466, 80, 30);
		qty8.setFont(new Font("Aerial", Font.PLAIN, 17));

		qty9 = new JTextField();
		qty9.setBounds(670, 494, 80, 30);
		qty9.setFont(new Font("Aerial", Font.PLAIN, 17));

		qty10 = new JTextField();
		qty10.setBounds(670, 522, 80, 30);
		qty10.setFont(new Font("Aerial", Font.PLAIN, 17));

		free1 = new JTextField();
		free1.setBounds(760, 270, 80, 30);
		free1.setFont(new Font("Aerial", Font.PLAIN, 17));

		free2 = new JTextField();
		free2.setBounds(760, 298, 80, 30);
		free2.setFont(new Font("Aerial", Font.PLAIN, 17));

		free3 = new JTextField();
		free3.setBounds(760, 326, 80, 30);
		free3.setFont(new Font("Aerial", Font.PLAIN, 17));

		free4 = new JTextField();
		free4.setBounds(760, 354, 80, 30);
		free4.setFont(new Font("Aerial", Font.PLAIN, 17));

		free5 = new JTextField();
		free5.setBounds(760, 382, 80, 30);
		free5.setFont(new Font("Aerial", Font.PLAIN, 17));

		free6 = new JTextField();
		free6.setBounds(760, 410, 80, 30);
		free6.setFont(new Font("Aerial", Font.PLAIN, 17));

		free7 = new JTextField();
		free7.setBounds(760, 438, 80, 30);
		free7.setFont(new Font("Aerial", Font.PLAIN, 17));

		free8 = new JTextField();
		free8.setBounds(760, 466, 80, 30);
		free8.setFont(new Font("Aerial", Font.PLAIN, 17));

		free9 = new JTextField();
		free9.setBounds(760, 494, 80, 30);
		free9.setFont(new Font("Aerial", Font.PLAIN, 17));

		free10 = new JTextField();
		free10.setBounds(760, 522, 80, 30);
		free10.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate1 = new JTextField();
		rate1.setBounds(850, 270, 100, 30);
		rate1.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate2 = new JTextField();
		rate2.setBounds(850, 298, 100, 30);
		rate2.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate3 = new JTextField();
		rate3.setBounds(850, 326, 100, 30);
		rate3.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate4 = new JTextField();
		rate4.setBounds(850, 354, 100, 30);
		rate4.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate5 = new JTextField();
		rate5.setBounds(850, 382, 100, 30);
		rate5.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate6 = new JTextField();
		rate6.setBounds(850, 410, 100, 30);
		rate6.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate7 = new JTextField();
		rate7.setBounds(850, 438, 100, 30);
		rate7.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate8 = new JTextField();
		rate8.setBounds(850, 466, 100, 30);
		rate8.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate9 = new JTextField();
		rate9.setBounds(850, 494, 100, 30);
		rate9.setFont(new Font("Aerial", Font.PLAIN, 17));

		rate10 = new JTextField();
		rate10.setBounds(850, 522, 100, 30);
		rate10.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit1 = new JTextField();
		unit1.setBounds(960, 270, 70, 30);
		unit1.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit2 = new JTextField();
		unit2.setBounds(960, 298, 70, 30);
		unit2.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit3 = new JTextField();
		unit3.setBounds(960, 326, 70, 30);
		unit3.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit4 = new JTextField();
		unit4.setBounds(960, 354, 70, 30);
		unit4.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit5 = new JTextField();
		unit5.setBounds(960, 382, 70, 30);
		unit5.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit6 = new JTextField();
		unit6.setBounds(960, 410, 70, 30);
		unit6.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit7 = new JTextField();
		unit7.setBounds(960, 438, 70, 30);
		unit7.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit8 = new JTextField();
		unit8.setBounds(960, 466, 70, 30);
		unit8.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit9 = new JTextField();
		unit9.setBounds(960, 494, 70, 30);
		unit9.setFont(new Font("Aerial", Font.PLAIN, 17));

		unit10 = new JTextField();
		unit10.setBounds(960, 522, 70, 30);
		unit10.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc1 = new JTextField();
		dsc1.setBounds(1100, 270, 50, 30);
		dsc1.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc2 = new JTextField();
		dsc2.setBounds(1100, 298, 50, 30);
		dsc2.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc3 = new JTextField();
		dsc3.setBounds(1100, 326, 50, 30);
		dsc3.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc4 = new JTextField();
		dsc4.setBounds(1100, 354, 50, 30);
		dsc4.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc5 = new JTextField();
		dsc5.setBounds(1100, 382, 50, 30);
		dsc5.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc6 = new JTextField();
		dsc6.setBounds(1100, 410, 50, 30);
		dsc6.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc7 = new JTextField();
		dsc7.setBounds(1100, 438, 50, 30);
		dsc7.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc8 = new JTextField();
		dsc8.setBounds(1100, 466, 50, 30);
		dsc8.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc9 = new JTextField();
		dsc9.setBounds(1100, 494, 50, 30);
		dsc9.setFont(new Font("Aerial", Font.PLAIN, 17));

		dsc10 = new JTextField();
		dsc10.setBounds(1100, 522, 50, 30);
		dsc10.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount1 = new JTextField();
		taxableAmount1.setBounds(1160, 270, 170, 30);
		taxableAmount1.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount2 = new JTextField();
		taxableAmount2.setBounds(1160, 298, 170, 30);
		taxableAmount2.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount3 = new JTextField();
		taxableAmount3.setBounds(1160, 326, 170, 30);
		taxableAmount3.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount4 = new JTextField();
		taxableAmount4.setBounds(1160, 354, 170, 30);
		taxableAmount4.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount5 = new JTextField();
		taxableAmount5.setBounds(1160, 382, 170, 30);
		taxableAmount5.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount6 = new JTextField();
		taxableAmount6.setBounds(1160, 410, 170, 30);
		taxableAmount6.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount7 = new JTextField();
		taxableAmount7.setBounds(1160, 438, 170, 30);
		taxableAmount7.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount8 = new JTextField();
		taxableAmount8.setBounds(1160, 466, 170, 30);
		taxableAmount8.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount9 = new JTextField();
		taxableAmount9.setBounds(1160, 494, 170, 30);
		taxableAmount9.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableAmount10 = new JTextField();
		taxableAmount10.setBounds(1160, 522, 170, 30);
		taxableAmount10.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate1 = new JTextField();
		taxRate1.setBounds(1040, 270, 50, 30);
		taxRate1.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate2 = new JTextField();
		taxRate2.setBounds(1040, 298, 50, 30);
		taxRate2.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate3 = new JTextField();
		taxRate3.setBounds(1040, 326, 50, 30);
		taxRate3.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate4 = new JTextField();
		taxRate4.setBounds(1040, 354, 50, 30);
		taxRate4.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate5 = new JTextField();
		taxRate5.setBounds(1040, 382, 50, 30);
		taxRate5.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate6 = new JTextField();
		taxRate6.setBounds(1040, 410, 50, 30);
		taxRate6.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate7 = new JTextField();
		taxRate7.setBounds(1040, 438, 50, 30);
		taxRate7.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate8 = new JTextField();
		taxRate8.setBounds(1040, 466, 50, 30);
		taxRate8.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate9 = new JTextField();
		taxRate9.setBounds(1040, 494, 50, 30);
		taxRate9.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxRate10 = new JTextField();
		taxRate10.setBounds(1040, 522, 50, 30);
		taxRate10.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount1 = new JTextField();
		taxAmount1.setBounds(1370, 270, 170, 30);
		taxAmount1.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount2 = new JTextField();
		taxAmount2.setBounds(1370, 298, 170, 30);
		taxAmount2.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount3 = new JTextField();
		taxAmount3.setBounds(1370, 326, 170, 30);
		taxAmount3.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount4 = new JTextField();
		taxAmount4.setBounds(1370, 354, 170, 30);
		taxAmount4.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount5 = new JTextField();
		taxAmount5.setBounds(1370, 382, 170, 30);
		taxAmount5.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount6 = new JTextField();
		taxAmount6.setBounds(1370, 410, 170, 30);
		taxAmount6.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount7 = new JTextField();
		taxAmount7.setBounds(1370, 438, 170, 30);
		taxAmount7.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount8 = new JTextField();
		taxAmount8.setBounds(1370, 466, 170, 30);
		taxAmount8.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount9 = new JTextField();
		taxAmount9.setBounds(1370, 494, 170, 30);
		taxAmount9.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxAmount10 = new JTextField();
		taxAmount10.setBounds(1370, 522, 170, 30);
		taxAmount10.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount1 = new JTextField();
		amount1.setBounds(1550, 270, 170, 30);
		amount1.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount2 = new JTextField();
		amount2.setBounds(1550, 298, 170, 30);
		amount2.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount3 = new JTextField();
		amount3.setBounds(1550, 326, 170, 30);
		amount3.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount4 = new JTextField();
		amount4.setBounds(1550, 354, 170, 30);
		amount4.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount5 = new JTextField();
		amount5.setBounds(1550, 382, 170, 30);
		amount5.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount6 = new JTextField();
		amount6.setBounds(1550, 410, 170, 30);
		amount6.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount7 = new JTextField();
		amount7.setBounds(1550, 438, 170, 30);
		amount7.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount8 = new JTextField();
		amount8.setBounds(1550, 466, 170, 30);
		amount8.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount9 = new JTextField();
		amount9.setBounds(1550, 494, 170, 30);
		amount9.setFont(new Font("Aerial", Font.PLAIN, 17));

		amount10 = new JTextField();
		amount10.setBounds(1550, 522, 170, 30);
		amount10.setFont(new Font("Aerial", Font.PLAIN, 17));

		netAmount = new JTextField();
		netAmount.setBounds(1050, 700, 195, 100);
		netAmount.setFont(new Font("Aerial", Font.PLAIN, 42));
		netAmount.setForeground(Color.GREEN);

		subAmount = new JTextField();
		subAmount.setBounds(1160, 565, 170, 30);
		subAmount.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableValue1 = new JTextField();
		taxableValue1.setBounds(150, 690, 170, 30);
		taxableValue1.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableValue2 = new JTextField();
		taxableValue2.setBounds(150, 718, 170, 30);
		taxableValue2.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableValue3 = new JTextField();
		taxableValue3.setBounds(150, 746, 170, 30);
		taxableValue3.setFont(new Font("Aerial", Font.PLAIN, 17));

		taxableValue4 = new JTextField();
		taxableValue4.setBounds(150, 774, 170, 30);
		taxableValue4.setFont(new Font("Aerial", Font.PLAIN, 17));

		totalTaxableValue = new JTextField();
		totalTaxableValue.setBounds(150, 817, 170, 30);
		totalTaxableValue.setFont(new Font("Aerial", Font.PLAIN, 17));

		rateSgst1 = new JTextField("2.5%");
		rateSgst1.setBounds(320, 690, 80, 30);
		rateSgst1.setFont(new Font("Aerial", Font.PLAIN, 17));
		rateSgst1.setEditable(false);

		rateSgst2 = new JTextField("6%");
		rateSgst2.setBounds(320, 718, 80, 30);
		rateSgst2.setFont(new Font("Aerial", Font.PLAIN, 17));
		rateSgst2.setEditable(false);

		rateSgst3 = new JTextField("9%");
		rateSgst3.setBounds(320, 746, 80, 30);
		rateSgst3.setFont(new Font("Aerial", Font.PLAIN, 17));
		rateSgst3.setEditable(false);

		rateSgst4 = new JTextField("14%");
		rateSgst4.setBounds(320, 774, 80, 30);
		rateSgst4.setFont(new Font("Aerial", Font.PLAIN, 17));
		rateSgst4.setEditable(false);

		amountSgst1 = new JTextField();
		amountSgst1.setBounds(400, 690, 170, 30);
		amountSgst1.setFont(new Font("Aerial", Font.PLAIN, 17));

		amountSgst2 = new JTextField();
		amountSgst2.setBounds(400, 718, 170, 30);
		amountSgst2.setFont(new Font("Aerial", Font.PLAIN, 17));

		amountSgst3 = new JTextField();
		amountSgst3.setBounds(400, 746, 170, 30);
		amountSgst3.setFont(new Font("Aerial", Font.PLAIN, 17));

		amountSgst4 = new JTextField();
		amountSgst4.setBounds(400, 774, 170, 30);
		amountSgst4.setFont(new Font("Aerial", Font.PLAIN, 17));

		totalSgstAmount = new JTextField();
		totalSgstAmount.setBounds(400, 817, 170, 30);
		totalSgstAmount.setFont(new Font("Aerial", Font.PLAIN, 17));

		rateCgst1 = new JTextField("2.5%");
		rateCgst1.setBounds(570, 690, 80, 30);
		rateCgst1.setFont(new Font("Aerial", Font.PLAIN, 17));
		rateCgst1.setEditable(false);

		rateCgst2 = new JTextField("6%");
		rateCgst2.setBounds(570, 718, 80, 30);
		rateCgst2.setFont(new Font("Aerial", Font.PLAIN, 17));
		rateCgst2.setEditable(false);

		rateCgst3 = new JTextField("9%");
		rateCgst3.setBounds(570, 746, 80, 30);
		rateCgst3.setFont(new Font("Aerial", Font.PLAIN, 17));
		rateCgst3.setEditable(false);

		rateCgst4 = new JTextField("14%");
		rateCgst4.setBounds(570, 774, 80, 30);
		rateCgst4.setFont(new Font("Aerial", Font.PLAIN, 17));
		rateCgst4.setEditable(false);

		amountCgst1 = new JTextField();
		amountCgst1.setBounds(650, 690, 170, 30);
		amountCgst1.setFont(new Font("Aerial", Font.PLAIN, 17));

		amountCgst2 = new JTextField();
		amountCgst2.setBounds(650, 718, 170, 30);
		amountCgst2.setFont(new Font("Aerial", Font.PLAIN, 17));

		amountCgst3 = new JTextField();
		amountCgst3.setBounds(650, 746, 170, 30);
		amountCgst3.setFont(new Font("Aerial", Font.PLAIN, 17));

		amountCgst4 = new JTextField();
		amountCgst4.setBounds(650, 774, 170, 30);
		amountCgst4.setFont(new Font("Aerial", Font.PLAIN, 17));

		totalCgstAmount = new JTextField();
		totalCgstAmount.setBounds(650, 817, 170, 30);
		totalCgstAmount.setFont(new Font("Aerial", Font.PLAIN, 17));

		totalTax = new JTextField();
		totalTax.setBounds(1100, 590, 170, 30);
		totalTax.setFont(new Font("Aerial", Font.PLAIN, 17));

		cgstAmount = new JTextField();
		cgstAmount.setBounds(1100, 617, 170, 30);
		cgstAmount.setFont(new Font("Aerial", Font.PLAIN, 17));

		sgstAmount = new JTextField();
		sgstAmount.setBounds(1100, 644, 170, 30);
		sgstAmount.setFont(new Font("Aerial", Font.PLAIN, 17));

		generateBillButton = new JButton("Generate Bill");
		generateBillButton.setFont(new Font("Aerial", Font.BOLD, 15));
		generateBillButton.setBounds(670, 900, 150, 30);
		generateBillButton.addActionListener(this);

		addButton = new JButton("Add");
		addButton.setFont(new Font("Aerial", Font.BOLD, 15));
		addButton.setBounds(550, 900, 100, 30);
		addButton.addActionListener(this);

		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Aerial", Font.BOLD, 15));
		clearButton.setBounds(200, 900, 100, 30);
		clearButton.addActionListener(this);

		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.BOLD, 15));
		backButton.setBounds(350, 900, 100, 30);
		backButton.addActionListener(this);

		srNoTextField = new JTextField();
		srNoTextField.setFont(new Font("Aerial", Font.PLAIN, 17));
		srNoTextField.setBounds(770, 10, 400, 30);

		billNoTextField = new JTextField();
		billNoTextField.setFont(new Font("Aerial", Font.PLAIN, 17));
		billNoTextField.setBounds(770, 55, 200, 30);

		billNoTextField.setText(String.valueOf(new ErpSaleDao().generateBillNo()));

		dateTextField = new JTextField();
		dateTextField.setFont(new Font("Aerial", Font.PLAIN, 17));
		dateTextField.setBounds(1055, 55, 200, 30);
		dateTextField.setText(dateFormat.format(date));

		addressBox = new JComboBox<String>();
		addressBox.setFont(new Font("Aerial", Font.PLAIN, 17));
		addressBox.setBounds(90, 100, 600, 30);
		addressBox.addActionListener(this);

		phoneTextField = new JTextField();
		phoneTextField.setFont(new Font("Aerial", Font.PLAIN, 17));
		phoneTextField.setBounds(865, 100, 250, 30);
		phoneTextField.setEditable(false);

		balanceTextField = new JTextField();
		balanceTextField.setFont(new Font("Aerial", Font.PLAIN, 17));
		balanceTextField.setBounds(90, 145, 200, 30);

		gstNoTextField = new JTextField();
		gstNoTextField.setFont(new Font("Aerial", Font.PLAIN, 17));
		gstNoTextField.setBounds(480, 145, 200, 30);

		transportModeField = new JTextField();
		transportModeField.setFont(new Font("Aerial", Font.PLAIN, 17));
		transportModeField.setBounds(850, 145, 400, 30);

		srNoTextField.setEditable(false);
		balanceTextField.setEditable(false);
		gstNoTextField.setEditable(false);

		firmBox = new JComboBox<String>();
		customerBox = new JComboBox<String>();
		productBox = new JComboBox<String>();
		b1 = new JComboBox<String>();
		b2 = new JComboBox<String>();
		b3 = new JComboBox<String>();
		b4 = new JComboBox<String>();
		b5 = new JComboBox<String>();
		b6 = new JComboBox<String>();
		b7 = new JComboBox<String>();
		b8 = new JComboBox<String>();
		b9 = new JComboBox<String>();
		b10 = new JComboBox<String>();

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);

		b1.addItem("Select");
		b2.addItem("Select");
		b3.addItem("Select");
		b4.addItem("Select");
		b5.addItem("Select");
		b6.addItem("Select");
		b7.addItem("Select");
		b8.addItem("Select");
		b9.addItem("Select");
		b10.addItem("Select");

		List<ErpFirmVo> fl = new ArrayList<ErpFirmVo>();
		fl = new ErpFirmDao().firmList();

		firmBox.setFont(new Font("Aerial", Font.PLAIN, 17));
		firmBox.addItem("Select");
		for (ErpFirmVo v : fl) {
			firmBox.addItem(v.getFirmName());
		}
		firmBox.setBounds(55, 10, 600, 30);
		firmBox.addActionListener(this);

		
		List<String> v=new ArrayList<String>();
		customerBox.setFont(new Font("Aerial", Font.PLAIN, 17));
		customerBox.setBounds(70, 55, 600, 30);
		List<ErpCustomerVo> list = new ArrayList<ErpCustomerVo>();
		ErpCustomerDao dao = new ErpCustomerDao();
		list = dao.customerRedundantName();
		customerBox.addActionListener(this);
		customerBox.addItem("Select");
		for (ErpCustomerVo customerList : list) {
			//customerBox.addItem(customerList.getCustName());
			v.add(customerList.getCustName());
		}
			
		Collections.sort(v);
		DefaultComboBoxModel model = new DefaultComboBoxModel(v.toArray());
		customerBox.setModel(model);
		
		
		List<ErpProductVo> proList = new ArrayList<ErpProductVo>();
		proList = new ErpProductDao().displayProducts();

		for (ErpProductVo l : proList) {
			b1.addItem(l.getProductName());
			b2.addItem(l.getProductName());
			b3.addItem(l.getProductName());
			b4.addItem(l.getProductName());
			b5.addItem(l.getProductName());
			b6.addItem(l.getProductName());
			b7.addItem(l.getProductName());
			b8.addItem(l.getProductName());
			b9.addItem(l.getProductName());
			b10.addItem(l.getProductName());
		}

		b1.setFont(new Font("Aerial", Font.PLAIN, 17));
		b2.setFont(new Font("Aerial", Font.PLAIN, 17));
		b3.setFont(new Font("Aerial", Font.PLAIN, 17));
		b4.setFont(new Font("Aerial", Font.PLAIN, 17));
		b5.setFont(new Font("Aerial", Font.PLAIN, 17));
		b6.setFont(new Font("Aerial", Font.PLAIN, 17));
		b7.setFont(new Font("Aerial", Font.PLAIN, 17));
		b8.setFont(new Font("Aerial", Font.PLAIN, 17));
		b9.setFont(new Font("Aerial", Font.PLAIN, 17));
		b10.setFont(new Font("Aerial", Font.PLAIN, 17));

		b1.setBounds(310, 270, 150, 30);
		b2.setBounds(310, 299, 150, 30);
		b3.setBounds(310, 327, 150, 30);
		b4.setBounds(310, 356, 150, 30);
		b5.setBounds(310, 384, 150, 30);
		b6.setBounds(310, 412, 150, 30);
		b7.setBounds(310, 440, 150, 30);
		b8.setBounds(310, 468, 150, 30);
		b9.setBounds(310, 496, 150, 30);
		b10.setBounds(310, 524, 150, 30);

		p.setLayout(null);
		p.add(firmBox);
		p.add(customerBox);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(b10);
		p.add(firmLabel);
		p.add(srNoLabel);
		p.add(srLabel);
		p.add(nameLabel);
		p.add(srNoTextField);
		p.add(billNoLabel);
		p.add(billNoTextField);
		p.add(transportModeLabel);
		p.add(transportModeField);
		p.add(dateLabel);
		p.add(packingLabel);
		p.add(qtyLabel);
		p.add(freeLabel);
		p.add(rateLabel);
		p.add(dscLabel);
		p.add(taxableAmountLabel);
		p.add(taxRateLabel);
		p.add(subTotalLabel);

		p.add(taxableValueLabel);

		p.add(rateSgstLabel);
		p.add(amountSgstLabel);
		p.add(rateCgstLabel);
		p.add(amountCgstLabel);

		p.add(subTotalCommonLabel);

		p.add(grandTotalLabel);

		p.add(dateTextField);
		p.add(addressLabel);
		// p.add(addressTextField);
		p.add(addressBox);
		p.add(phoneLabel);
		p.add(phoneTextField);
		p.add(balanceLabel);
		p.add(balanceTextField);
		p.add(gstNoLabel);
		p.add(gstNoTextField);
		p.add(prNameLabel);
		p.add(hsnLabel);
		p.add(generateBillButton);
		p.add(clearButton);
		p.add(backButton);
		p.add(addButton);
		p.add(unitLabel);

		p.add(prName2);
		p.add(prName3);
		p.add(prName4);
		p.add(prName5);
		p.add(prName6);
		p.add(prName7);
		p.add(prName8);
		p.add(prName9);
		p.add(prName1);
		p.add(prName10);

		p.add(hsn1);
		p.add(hsn2);
		p.add(hsn3);
		p.add(hsn4);
		p.add(hsn5);
		p.add(hsn6);
		p.add(hsn7);
		p.add(hsn8);
		p.add(hsn9);
		p.add(hsn10);

		p.add(packing1);
		p.add(packing2);
		p.add(packing3);
		p.add(packing4);
		p.add(packing5);
		p.add(packing6);
		p.add(packing7);
		p.add(packing8);
		p.add(packing9);
		p.add(packing10);

		p.add(qty1);
		p.add(qty2);
		p.add(qty3);
		p.add(qty4);
		p.add(qty5);
		p.add(qty6);
		p.add(qty7);
		p.add(qty8);
		p.add(qty9);
		p.add(qty10);

		p.add(free1);
		p.add(free2);
		p.add(free3);
		p.add(free4);
		p.add(free5);
		p.add(free6);
		p.add(free7);
		p.add(free8);
		p.add(free9);
		p.add(free10);

		p.add(rate1);
		p.add(rate2);
		p.add(rate3);
		p.add(rate4);
		p.add(rate5);
		p.add(rate6);
		p.add(rate7);
		p.add(rate8);
		p.add(rate9);
		p.add(rate10);

		p.add(unit1);
		p.add(unit2);
		p.add(unit3);
		p.add(unit4);
		p.add(unit5);
		p.add(unit6);
		p.add(unit7);
		p.add(unit8);
		p.add(unit9);
		p.add(unit10);

		p.add(dsc1);
		p.add(dsc2);
		p.add(dsc3);
		p.add(dsc4);
		p.add(dsc5);
		p.add(dsc6);
		p.add(dsc7);
		p.add(dsc8);
		p.add(dsc9);
		p.add(dsc10);

		p.add(taxableAmount1);
		p.add(taxableAmount2);
		p.add(taxableAmount3);
		p.add(taxableAmount4);
		p.add(taxableAmount5);
		p.add(taxableAmount6);
		p.add(taxableAmount7);
		p.add(taxableAmount8);
		p.add(taxableAmount9);
		p.add(taxableAmount10);

		p.add(taxRate1);
		p.add(taxRate2);
		p.add(taxRate3);
		p.add(taxRate4);
		p.add(taxRate5);
		p.add(taxRate6);
		p.add(taxRate7);
		p.add(taxRate8);
		p.add(taxRate9);
		p.add(taxRate10);

		p.add(taxableValue1);
		p.add(taxableValue2);
		p.add(taxableValue3);
		p.add(taxableValue4);

		p.add(rateSgst1);
		p.add(rateSgst2);
		p.add(rateSgst3);
		p.add(rateSgst4);

		p.add(amountSgst1);
		p.add(amountSgst2);
		p.add(amountSgst3);
		p.add(amountSgst4);

		p.add(rateCgst1);
		p.add(rateCgst2);
		p.add(rateCgst3);
		p.add(rateCgst4);

		p.add(amountCgst1);
		p.add(amountCgst2);
		p.add(amountCgst3);
		p.add(amountCgst4);

		p.add(totalTaxableValue);
		p.add(totalSgstAmount);
		p.add(totalCgstAmount);

		p.add(netAmount);
		p.add(subAmount);

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if ((firmBox.getItemAt(firmBox.getSelectedIndex())).equals("Select")) {

					JOptionPane.showMessageDialog(null, "Please select Firm");

				}

				else if ((customerBox.getItemAt(customerBox.getSelectedIndex()).equals("Select"))) {

					JOptionPane.showMessageDialog(null, "Please select Customer");

				} else {

					if (prName1.getText().equals("") && prName2.getText().equals("") && prName3.getText().equals("")
							&& prName4.getText().equals("") && prName5.getText().equals("")
							&& prName6.getText().equals("") && prName7.getText().equals("")
							&& prName8.getText().equals("") && prName9.getText().equals("")
							&& prName10.getText().equals("")) {

						JOptionPane.showMessageDialog(qty5, "Please provide some information");

					}

					else if (!prName1.getText().equals("") && prName2.getText().equals("")
							&& prName3.getText().equals("") && prName4.getText().equals("")
							&& prName5.getText().equals("") && prName6.getText().equals("")
							&& prName7.getText().equals("") && prName8.getText().equals("")
							&& prName9.getText().equals("") && prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;

							float am1 = a1 + t1;

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));

							subAmount.setText(String.valueOf(decimalFormat.format(a1)));

							taxAmount1.setText(String.valueOf(decimalFormat.format(t1)));

							amount1.setText(String.valueOf(decimalFormat.format(am1)));

							totalTax.setText(String.valueOf(decimalFormat.format(t1)));
							sgstAmount.setText(String.valueOf(decimalFormat.format((t1) / 2)));
							cgstAmount.setText(String.valueOf(decimalFormat.format((t1) / 2)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));

							netAmount.setText(String.valueOf(Math.round(am1)));

						}

					}

					else if (!prName1.getText().equals("") && !prName2.getText().equals("")
							&& prName3.getText().equals("") && prName4.getText().equals("")
							&& prName5.getText().equals("") && prName6.getText().equals("")
							&& prName7.getText().equals("") && prName8.getText().equals("")
							&& prName9.getText().equals("") && prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("") || qty2.getText().equals("")
								|| free2.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float taxableValue5b = 0;
							float taxableValue12b = 0;
							float taxableValue18b = 0;
							float taxableValue28b = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);
							float a2 = (float) ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
									- ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
											* (Float.parseFloat(dsc2.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;
							float t2 = (float) ((a2) * (Float.parseFloat(taxRate2.getText()))) / 100;

							float am1 = (float) (a1 + t1);
							float am2 = (float) (a2 + t2);

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));
							taxableAmount2.setText(String.valueOf(decimalFormat.format(a2)));

							subAmount.setText(String.valueOf(decimalFormat.format(a1 + a2)));

							taxAmount1.setText(String.valueOf(decimalFormat.format(t1)));
							taxAmount2.setText(String.valueOf(decimalFormat.format(t2)));

							amount1.setText(String.valueOf(decimalFormat.format(am1)));
							amount2.setText(String.valueOf(decimalFormat.format(am2)));

							totalTax.setText(String.valueOf(decimalFormat.format(t1 + t2)));
							sgstAmount.setText(String.valueOf(decimalFormat.format((t1 + t2) / 2)));
							cgstAmount.setText(String.valueOf(decimalFormat.format((t1 + t2) / 2)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								;
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							if (Float.parseFloat(taxRate2.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount2.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a)));
								float g = ((taxableValue5b + taxableValue5a) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount2.getText());
								taxableValue2.setText(
										String.valueOf(decimalFormat.format(taxableValue12b + taxableValue12a)));
								float g = ((taxableValue12b + taxableValue12a) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount2.getText());
								taxableValue3.setText(
										String.valueOf(decimalFormat.format(taxableValue18b + taxableValue18a)));
								float g = ((taxableValue18b + taxableValue18a) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount2.getText());
								taxableValue4.setText(
										String.valueOf(decimalFormat.format(taxableValue28b + taxableValue28a)));
								float g = ((taxableValue28b + taxableValue28a) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));

							netAmount.setText(String.valueOf(Math.round(am1 + am2)));

						}

					}

					else if (!prName1.getText().equals("") && !prName2.getText().equals("")
							&& !prName3.getText().equals("") && prName4.getText().equals("")
							&& prName5.getText().equals("") && prName6.getText().equals("")
							&& prName7.getText().equals("") && prName8.getText().equals("")
							&& prName9.getText().equals("") && prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("") || qty2.getText().equals("")
								|| free2.getText().equals("") || qty3.getText().equals("")
								|| free3.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float taxableValue5b = 0;
							float taxableValue12b = 0;
							float taxableValue18b = 0;
							float taxableValue28b = 0;

							float taxableValue5c = 0;
							float taxableValue12c = 0;
							float taxableValue18c = 0;
							float taxableValue28c = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);
							float a2 = (float) ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
									- ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
											* (Float.parseFloat(dsc2.getText()))) / 100);
							float a3 = (float) ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
									- ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
											* (Float.parseFloat(dsc3.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;
							float t2 = (float) ((a2) * (Float.parseFloat(taxRate2.getText()))) / 100;
							float t3 = (float) ((a3) * (Float.parseFloat(taxRate3.getText()))) / 100;

							float am1 = (float) (a1 + t1);
							float am2 = (float) (a2 + t2);
							float am3 = (float) (a3 + t3);

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));
							taxableAmount2.setText(String.valueOf(decimalFormat.format(a2)));
							taxableAmount3.setText(String.valueOf(decimalFormat.format(a3)));

							taxAmount1.setText(String.valueOf(decimalFormat.format(t1)));
							taxAmount2.setText(String.valueOf(decimalFormat.format(t2)));
							taxAmount3.setText(String.valueOf(decimalFormat.format(t3)));

							amount1.setText(String.valueOf(decimalFormat.format(am1)));
							amount2.setText(String.valueOf(decimalFormat.format(am2)));
							amount3.setText(String.valueOf(decimalFormat.format(am3)));

							subAmount.setText(String.valueOf(decimalFormat.format(a1 + a2 + a3)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							if (Float.parseFloat(taxRate2.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount2.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a)));
								float g = ((taxableValue5b + taxableValue5a) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount2.getText());
								taxableValue2.setText(
										String.valueOf(decimalFormat.format(taxableValue12b + taxableValue12a)));
								float g = ((taxableValue12b + taxableValue12a) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount2.getText());
								taxableValue3.setText(
										String.valueOf(decimalFormat.format(taxableValue18b + taxableValue18a)));
								float g = ((taxableValue18b + taxableValue18a) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount2.getText());
								taxableValue4.setText(
										String.valueOf(decimalFormat.format(taxableValue28b + taxableValue28a)));
								float g = ((taxableValue28b + taxableValue28a) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate3.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount3.getText());
								taxableValue1.setText(String.valueOf(
										decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount3.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount3.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount3.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));

							netAmount.setText(String.valueOf(Math.round(am1 + am2 + am3)));

							totalTax.setText(String.valueOf(t1 + t2 + t3));
							sgstAmount.setText(String.valueOf((t1 + t2 + t3) / 2));
							cgstAmount.setText(String.valueOf((t1 + t2 + t3) / 2));

						}

					}

					else if (!prName1.getText().equals("") && !prName2.getText().equals("")
							&& !prName3.getText().equals("") && !prName4.getText().equals("")
							&& prName5.getText().equals("") && prName6.getText().equals("")
							&& prName7.getText().equals("") && prName8.getText().equals("")
							&& prName9.getText().equals("") && prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("") || qty2.getText().equals("")
								|| free2.getText().equals("") || qty3.getText().equals("") || free3.getText().equals("")
								|| qty4.getText().equals("") || free4.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float taxableValue5b = 0;
							float taxableValue12b = 0;
							float taxableValue18b = 0;
							float taxableValue28b = 0;

							float taxableValue5c = 0;
							float taxableValue12c = 0;
							float taxableValue18c = 0;
							float taxableValue28c = 0;

							float taxableValue5d = 0;
							float taxableValue12d = 0;
							float taxableValue18d = 0;
							float taxableValue28d = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);
							float a2 = (float) ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
									- ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
											* (Float.parseFloat(dsc2.getText()))) / 100);
							float a3 = (float) ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
									- ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
											* (Float.parseFloat(dsc3.getText()))) / 100);
							float a4 = (float) ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
									- ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
											* (Float.parseFloat(dsc4.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;
							float t2 = (float) ((a2) * (Float.parseFloat(taxRate2.getText()))) / 100;
							float t3 = (float) ((a3) * (Float.parseFloat(taxRate3.getText()))) / 100;
							float t4 = (float) ((a4) * (Float.parseFloat(taxRate4.getText()))) / 100;

							float am1 = (float) (a1 + t1);
							float am2 = (float) (a2 + t2);
							float am3 = (float) (a3 + t3);
							float am4 = (float) (a4 + t4);

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));
							taxableAmount2.setText(String.valueOf(decimalFormat.format(a2)));
							taxableAmount3.setText(String.valueOf(decimalFormat.format(a3)));
							taxableAmount4.setText(String.valueOf(decimalFormat.format(a4)));

							taxAmount1.setText(String.valueOf(t1));
							taxAmount2.setText(String.valueOf(t2));
							taxAmount3.setText(String.valueOf(t3));
							taxAmount4.setText(String.valueOf(t4));

							amount1.setText(String.valueOf(am1));
							amount2.setText(String.valueOf(am2));
							amount3.setText(String.valueOf(am3));
							amount4.setText(String.valueOf(am4));

							subAmount.setText(String.valueOf(decimalFormat.format(a1 + a2 + a3 + a4)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							if (Float.parseFloat(taxRate2.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount2.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a)));
								float g = ((taxableValue5b + taxableValue5a) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount2.getText());
								taxableValue2.setText(
										String.valueOf(decimalFormat.format(taxableValue12b + taxableValue12a)));
								float g = ((taxableValue12b + taxableValue12a) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount2.getText());
								taxableValue3.setText(
										String.valueOf(decimalFormat.format(taxableValue18b + taxableValue18a)));
								float g = ((taxableValue18b + taxableValue18a) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount2.getText());
								taxableValue4.setText(
										String.valueOf(decimalFormat.format(taxableValue28b + taxableValue28a)));
								float g = ((taxableValue28b + taxableValue28a) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate3.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount3.getText());
								taxableValue1.setText(String.valueOf(
										decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount3.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount3.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount3.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate4.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount4.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount4.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(
										taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount4.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(
										taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount4.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(
										taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));
							netAmount.setText(String.valueOf(Math.round(am1 + am2 + am3 + am4)));

							totalTax.setText(String.valueOf(t1 + t2 + t3 + t4));
							sgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4) / 2));
							cgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4) / 2));
						}

					}

					else if (!prName1.getText().equals("") && !prName2.getText().equals("")
							&& !prName3.getText().equals("") && !prName4.getText().equals("")
							&& !prName5.getText().equals("") && prName6.getText().equals("")
							&& prName7.getText().equals("") && prName8.getText().equals("")
							&& prName9.getText().equals("") && prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("") || qty2.getText().equals("")
								|| free2.getText().equals("") || qty3.getText().equals("") || free3.getText().equals("")
								|| qty4.getText().equals("") || free4.getText().equals("") || qty5.getText().equals("")
								|| free5.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float taxableValue5b = 0;
							float taxableValue12b = 0;
							float taxableValue18b = 0;
							float taxableValue28b = 0;

							float taxableValue5c = 0;
							float taxableValue12c = 0;
							float taxableValue18c = 0;
							float taxableValue28c = 0;

							float taxableValue5d = 0;
							float taxableValue12d = 0;
							float taxableValue18d = 0;
							float taxableValue28d = 0;

							float taxableValue5e = 0;
							float taxableValue12e = 0;
							float taxableValue18e = 0;
							float taxableValue28e = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);
							float a2 = (float) ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
									- ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
											* (Float.parseFloat(dsc2.getText()))) / 100);
							float a3 = (float) ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
									- ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
											* (Float.parseFloat(dsc3.getText()))) / 100);
							float a4 = (float) ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
									- ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
											* (Float.parseFloat(dsc4.getText()))) / 100);
							float a5 = (float) ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
									- ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
											* (Float.parseFloat(dsc5.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;
							float t2 = (float) ((a2) * (Float.parseFloat(taxRate2.getText()))) / 100;
							float t3 = (float) ((a3) * (Float.parseFloat(taxRate3.getText()))) / 100;
							float t4 = (float) ((a4) * (Float.parseFloat(taxRate4.getText()))) / 100;
							float t5 = (float) ((a5) * (Float.parseFloat(taxRate5.getText()))) / 100;

							float am1 = (float) (a1 + t1);
							float am2 = (float) (a2 + t2);
							float am3 = (float) (a3 + t3);
							float am4 = (float) (a4 + t4);
							float am5 = (float) (a5 + t5);

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));
							taxableAmount2.setText(String.valueOf(decimalFormat.format(a2)));
							taxableAmount3.setText(String.valueOf(decimalFormat.format(a3)));
							taxableAmount4.setText(String.valueOf(decimalFormat.format(a4)));
							taxableAmount5.setText(String.valueOf(decimalFormat.format(a5)));

							taxAmount1.setText(String.valueOf(t1));
							taxAmount2.setText(String.valueOf(t2));
							taxAmount3.setText(String.valueOf(t3));
							taxAmount4.setText(String.valueOf(t4));
							taxAmount5.setText(String.valueOf(t5));

							amount1.setText(String.valueOf(am1));
							amount2.setText(String.valueOf(am2));
							amount3.setText(String.valueOf(am3));
							amount4.setText(String.valueOf(am4));
							amount5.setText(String.valueOf(am5));

							subAmount.setText(String.valueOf(decimalFormat.format(a1 + a2 + a3 + a4 + a5)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							if (Float.parseFloat(taxRate2.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount2.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a)));
								float g = ((taxableValue5b + taxableValue5a) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount2.getText());
								taxableValue2.setText(
										String.valueOf(decimalFormat.format(taxableValue12b + taxableValue12a)));
								float g = ((taxableValue12b + taxableValue12a) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount2.getText());
								taxableValue3.setText(
										String.valueOf(decimalFormat.format(taxableValue18b + taxableValue18a)));
								float g = ((taxableValue18b + taxableValue18a) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount2.getText());
								taxableValue4.setText(
										String.valueOf(decimalFormat.format(taxableValue28b + taxableValue28a)));
								float g = ((taxableValue28b + taxableValue28a) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate3.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount3.getText());
								taxableValue1.setText(String.valueOf(
										decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount3.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount3.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount3.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate4.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount4.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount4.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(
										taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount4.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(
										taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount4.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(
										taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate5.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount5.getText());
								taxableValue1.setText(String.valueOf(decimalFormat.format(taxableValue5b
										+ taxableValue5a + taxableValue5c + taxableValue5d + taxableValue5e)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount5.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount5.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount5.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));

							netAmount.setText(String.valueOf(Math.round(am1 + am2 + am3 + am4 + am5)));

							totalTax.setText(String.valueOf(t1 + t2 + t3 + t4 + t5));
							sgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5) / 2));
							cgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5) / 2));
						}

					}

					else if (!prName1.getText().equals("") && !prName2.getText().equals("")
							&& !prName3.getText().equals("") && !prName4.getText().equals("")
							&& !prName5.getText().equals("") && !prName6.getText().equals("")
							&& prName7.getText().equals("") && prName8.getText().equals("")
							&& prName9.getText().equals("") && prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("") || qty2.getText().equals("")
								|| free2.getText().equals("") || qty3.getText().equals("") || free3.getText().equals("")
								|| qty4.getText().equals("") || free4.getText().equals("") || qty5.getText().equals("")
								|| free5.getText().equals("") || qty6.getText().equals("")
								|| free6.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float taxableValue5b = 0;
							float taxableValue12b = 0;
							float taxableValue18b = 0;
							float taxableValue28b = 0;

							float taxableValue5c = 0;
							float taxableValue12c = 0;
							float taxableValue18c = 0;
							float taxableValue28c = 0;

							float taxableValue5d = 0;
							float taxableValue12d = 0;
							float taxableValue18d = 0;
							float taxableValue28d = 0;

							float taxableValue5e = 0;
							float taxableValue12e = 0;
							float taxableValue18e = 0;
							float taxableValue28e = 0;

							float taxableValue5f = 0;
							float taxableValue12f = 0;
							float taxableValue18f = 0;
							float taxableValue28f = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);
							float a2 = (float) ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
									- ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
											* (Float.parseFloat(dsc2.getText()))) / 100);
							float a3 = (float) ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
									- ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
											* (Float.parseFloat(dsc3.getText()))) / 100);
							float a4 = (float) ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
									- ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
											* (Float.parseFloat(dsc4.getText()))) / 100);
							float a5 = (float) ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
									- ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
											* (Float.parseFloat(dsc5.getText()))) / 100);
							float a6 = (float) ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
									- ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
											* (Float.parseFloat(dsc6.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;
							float t2 = (float) ((a2) * (Float.parseFloat(taxRate2.getText()))) / 100;
							float t3 = (float) ((a3) * (Float.parseFloat(taxRate3.getText()))) / 100;
							float t4 = (float) ((a4) * (Float.parseFloat(taxRate4.getText()))) / 100;
							float t5 = (float) ((a5) * (Float.parseFloat(taxRate5.getText()))) / 100;
							float t6 = (float) ((a6) * (Float.parseFloat(taxRate6.getText()))) / 100;

							float am1 = (float) (a1 + t1);
							float am2 = (float) (a2 + t2);
							float am3 = (float) (a3 + t3);
							float am4 = (float) (a4 + t4);
							float am5 = (float) (a5 + t5);
							float am6 = (float) (a6 + t6);

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));
							taxableAmount2.setText(String.valueOf(decimalFormat.format(a2)));
							taxableAmount3.setText(String.valueOf(decimalFormat.format(a3)));
							taxableAmount4.setText(String.valueOf(decimalFormat.format(a4)));
							taxableAmount5.setText(String.valueOf(decimalFormat.format(a5)));
							taxableAmount6.setText(String.valueOf(decimalFormat.format(a6)));

							taxAmount1.setText(String.valueOf(t1));
							taxAmount2.setText(String.valueOf(t2));
							taxAmount3.setText(String.valueOf(t3));
							taxAmount4.setText(String.valueOf(t4));
							taxAmount5.setText(String.valueOf(t5));
							taxAmount6.setText(String.valueOf(t6));

							amount1.setText(String.valueOf(am1));
							amount2.setText(String.valueOf(am2));
							amount3.setText(String.valueOf(am3));
							amount4.setText(String.valueOf(am4));
							amount5.setText(String.valueOf(am5));
							amount6.setText(String.valueOf(am6));

							subAmount.setText(String.valueOf(decimalFormat.format(a1 + a2 + a3 + a4 + a5 + a6)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							if (Float.parseFloat(taxRate2.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount2.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a)));
								float g = ((taxableValue5b + taxableValue5a) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount2.getText());
								taxableValue2.setText(
										String.valueOf(decimalFormat.format(taxableValue12b + taxableValue12a)));
								float g = ((taxableValue12b + taxableValue12a) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount2.getText());
								taxableValue3.setText(
										String.valueOf(decimalFormat.format(taxableValue18b + taxableValue18a)));
								float g = ((taxableValue18b + taxableValue18a) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount2.getText());
								taxableValue4.setText(
										String.valueOf(decimalFormat.format(taxableValue28b + taxableValue28a)));
								float g = ((taxableValue28b + taxableValue28a) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate3.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount3.getText());
								taxableValue1.setText(String.valueOf(
										decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount3.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount3.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount3.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate4.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount4.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount4.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(
										taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount4.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(
										taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount4.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(
										taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate5.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount5.getText());
								taxableValue1.setText(String.valueOf(decimalFormat.format(taxableValue5b
										+ taxableValue5a + taxableValue5c + taxableValue5d + taxableValue5e)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount5.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount5.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount5.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate6.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount6.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a
												+ taxableValue5c + taxableValue5d + taxableValue5e + taxableValue5f)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount6.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c
												+ taxableValue12d + taxableValue12e + taxableValue12f)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount6.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c
												+ taxableValue18d + taxableValue18e + taxableValue18f)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount6.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c
												+ taxableValue28d + taxableValue28e + taxableValue28f)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));

							netAmount.setText(String.valueOf(Math.round(am1 + am2 + am3 + am4 + am5 + am6)));

							totalTax.setText(String.valueOf(t1 + t2 + t3 + t4 + t5 + t6));
							sgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6) / 2));
							cgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6) / 2));
						}

					}

					else if (!prName1.getText().equals("") && !prName2.getText().equals("")
							&& !prName3.getText().equals("") && !prName4.getText().equals("")
							&& !prName5.getText().equals("") && !prName6.getText().equals("")
							&& !prName7.getText().equals("") && prName8.getText().equals("")
							&& prName9.getText().equals("") && prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("") || qty2.getText().equals("")
								|| free2.getText().equals("") || qty3.getText().equals("") || free3.getText().equals("")
								|| qty4.getText().equals("") || free4.getText().equals("") || qty5.getText().equals("")
								|| free5.getText().equals("") || qty6.getText().equals("") || free6.getText().equals("")
								|| qty7.getText().equals("") || free7.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float taxableValue5b = 0;
							float taxableValue12b = 0;
							float taxableValue18b = 0;
							float taxableValue28b = 0;

							float taxableValue5c = 0;
							float taxableValue12c = 0;
							float taxableValue18c = 0;
							float taxableValue28c = 0;

							float taxableValue5d = 0;
							float taxableValue12d = 0;
							float taxableValue18d = 0;
							float taxableValue28d = 0;

							float taxableValue5e = 0;
							float taxableValue12e = 0;
							float taxableValue18e = 0;
							float taxableValue28e = 0;

							float taxableValue5f = 0;
							float taxableValue12f = 0;
							float taxableValue18f = 0;
							float taxableValue28f = 0;

							float taxableValue5g = 0;
							float taxableValue12g = 0;
							float taxableValue18g = 0;
							float taxableValue28g = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);
							float a2 = (float) ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
									- ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
											* (Float.parseFloat(dsc2.getText()))) / 100);
							float a3 = (float) ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
									- ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
											* (Float.parseFloat(dsc3.getText()))) / 100);
							float a4 = (float) ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
									- ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
											* (Float.parseFloat(dsc4.getText()))) / 100);
							float a5 = (float) ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
									- ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
											* (Float.parseFloat(dsc5.getText()))) / 100);
							float a6 = (float) ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
									- ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
											* (Float.parseFloat(dsc6.getText()))) / 100);
							float a7 = (float) ((Float.parseFloat(qty7.getText()) * Float.parseFloat(rate7.getText()))
									- ((Float.parseFloat(qty7.getText()) * Float.parseFloat(rate7.getText()))
											* (Float.parseFloat(dsc7.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;
							float t2 = (float) ((a2) * (Float.parseFloat(taxRate2.getText()))) / 100;
							float t3 = (float) ((a3) * (Float.parseFloat(taxRate3.getText()))) / 100;
							float t4 = (float) ((a4) * (Float.parseFloat(taxRate4.getText()))) / 100;
							float t5 = (float) ((a5) * (Float.parseFloat(taxRate5.getText()))) / 100;
							float t6 = (float) ((a6) * (Float.parseFloat(taxRate6.getText()))) / 100;
							float t7 = (float) ((a7) * (Float.parseFloat(taxRate7.getText()))) / 100;

							float am1 = (float) (a1 + t1);
							float am2 = (float) (a2 + t2);
							float am3 = (float) (a3 + t3);
							float am4 = (float) (a4 + t4);
							float am5 = (float) (a5 + t5);
							float am6 = (float) (a6 + t6);
							float am7 = (float) (a7 + t7);

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));
							taxableAmount2.setText(String.valueOf(decimalFormat.format(a2)));
							taxableAmount3.setText(String.valueOf(decimalFormat.format(a3)));
							taxableAmount4.setText(String.valueOf(decimalFormat.format(a4)));
							taxableAmount5.setText(String.valueOf(decimalFormat.format(a5)));
							taxableAmount6.setText(String.valueOf(decimalFormat.format(a6)));
							taxableAmount7.setText(String.valueOf(decimalFormat.format(a7)));

							taxAmount1.setText(String.valueOf(t1));
							taxAmount2.setText(String.valueOf(t2));
							taxAmount3.setText(String.valueOf(t3));
							taxAmount4.setText(String.valueOf(t4));
							taxAmount5.setText(String.valueOf(t5));
							taxAmount6.setText(String.valueOf(t6));
							taxAmount7.setText(String.valueOf(t7));

							amount1.setText(String.valueOf(am1));
							amount2.setText(String.valueOf(am2));
							amount3.setText(String.valueOf(am3));
							amount4.setText(String.valueOf(am4));
							amount5.setText(String.valueOf(am5));
							amount6.setText(String.valueOf(am6));
							amount7.setText(String.valueOf(am7));

							subAmount.setText(String.valueOf(decimalFormat.format(a1 + a2 + a3 + a4 + a5 + a6 + a7)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							if (Float.parseFloat(taxRate2.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount2.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a)));
								float g = ((taxableValue5b + taxableValue5a) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount2.getText());
								taxableValue2.setText(
										String.valueOf(decimalFormat.format(taxableValue12b + taxableValue12a)));
								float g = ((taxableValue12b + taxableValue12a) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount2.getText());
								taxableValue3.setText(
										String.valueOf(decimalFormat.format(taxableValue18b + taxableValue18a)));
								float g = ((taxableValue18b + taxableValue18a) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount2.getText());
								taxableValue4.setText(
										String.valueOf(decimalFormat.format(taxableValue28b + taxableValue28a)));
								float g = ((taxableValue28b + taxableValue28a) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate3.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount3.getText());
								taxableValue1.setText(String.valueOf(
										decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount3.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount3.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount3.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate4.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount4.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount4.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(
										taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount4.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(
										taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount4.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(
										taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate5.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount5.getText());
								taxableValue1.setText(String.valueOf(decimalFormat.format(taxableValue5b
										+ taxableValue5a + taxableValue5c + taxableValue5d + taxableValue5e)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount5.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount5.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount5.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate6.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount6.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a
												+ taxableValue5c + taxableValue5d + taxableValue5e + taxableValue5f)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount6.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c
												+ taxableValue12d + taxableValue12e + taxableValue12f)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount6.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c
												+ taxableValue18d + taxableValue18e + taxableValue18f)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount6.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c
												+ taxableValue28d + taxableValue28e + taxableValue28f)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate7.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount7.getText());
								taxableValue1.setText(String
										.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c
												+ taxableValue5d + taxableValue5e + taxableValue5f + taxableValue5g)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount7.getText());
								taxableValue2.setText(String.valueOf(decimalFormat
										.format(taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
												+ taxableValue12e + taxableValue12f + taxableValue12g)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount7.getText());
								taxableValue3.setText(String.valueOf(decimalFormat
										.format(taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
												+ taxableValue18e + taxableValue18f + taxableValue18g)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount7.getText());
								taxableValue4.setText(String.valueOf(decimalFormat
										.format(taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
												+ taxableValue28e + taxableValue28f + taxableValue28g)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));

							netAmount.setText(String.valueOf(Math.round(am1 + am2 + am3 + am4 + am5 + am6 + am7)));

							totalTax.setText(String.valueOf(t1 + t2 + t3 + t4 + t5 + t6 + t7));
							sgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6 + t7) / 2));
							cgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6 + t7) / 2));
						}

					}

					else if (!prName1.getText().equals("") && !prName2.getText().equals("")
							&& !prName3.getText().equals("") && !prName4.getText().equals("")
							&& !prName5.getText().equals("") && !prName6.getText().equals("")
							&& !prName7.getText().equals("") && !prName8.getText().equals("")
							&& prName9.getText().equals("") && prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("") || qty2.getText().equals("")
								|| free2.getText().equals("") || qty3.getText().equals("") || free3.getText().equals("")
								|| qty4.getText().equals("") || free4.getText().equals("") || qty5.getText().equals("")
								|| free5.getText().equals("") || qty6.getText().equals("") || free6.getText().equals("")
								|| qty7.getText().equals("") || free7.getText().equals("") || qty8.getText().equals("")
								|| free8.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float taxableValue5b = 0;
							float taxableValue12b = 0;
							float taxableValue18b = 0;
							float taxableValue28b = 0;

							float taxableValue5c = 0;
							float taxableValue12c = 0;
							float taxableValue18c = 0;
							float taxableValue28c = 0;

							float taxableValue5d = 0;
							float taxableValue12d = 0;
							float taxableValue18d = 0;
							float taxableValue28d = 0;

							float taxableValue5e = 0;
							float taxableValue12e = 0;
							float taxableValue18e = 0;
							float taxableValue28e = 0;

							float taxableValue5f = 0;
							float taxableValue12f = 0;
							float taxableValue18f = 0;
							float taxableValue28f = 0;

							float taxableValue5g = 0;
							float taxableValue12g = 0;
							float taxableValue18g = 0;
							float taxableValue28g = 0;

							float taxableValue5h = 0;
							float taxableValue12h = 0;
							float taxableValue18h = 0;
							float taxableValue28h = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);
							float a2 = (float) ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
									- ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
											* (Float.parseFloat(dsc2.getText()))) / 100);
							float a3 = (float) ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
									- ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
											* (Float.parseFloat(dsc3.getText()))) / 100);
							float a4 = (float) ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
									- ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
											* (Float.parseFloat(dsc4.getText()))) / 100);
							float a5 = (float) ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
									- ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
											* (Float.parseFloat(dsc5.getText()))) / 100);
							float a6 = (float) ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
									- ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
											* (Float.parseFloat(dsc6.getText()))) / 100);
							float a7 = (float) ((Float.parseFloat(qty7.getText()) * Float.parseFloat(rate7.getText()))
									- ((Float.parseFloat(qty7.getText()) * Float.parseFloat(rate7.getText()))
											* (Float.parseFloat(dsc7.getText()))) / 100);
							float a8 = (float) ((Float.parseFloat(qty8.getText()) * Float.parseFloat(rate8.getText()))
									- ((Float.parseFloat(qty8.getText()) * Float.parseFloat(rate8.getText()))
											* (Float.parseFloat(dsc8.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;
							float t2 = (float) ((a2) * (Float.parseFloat(taxRate2.getText()))) / 100;
							float t3 = (float) ((a3) * (Float.parseFloat(taxRate3.getText()))) / 100;
							float t4 = (float) ((a4) * (Float.parseFloat(taxRate4.getText()))) / 100;
							float t5 = (float) ((a5) * (Float.parseFloat(taxRate5.getText()))) / 100;
							float t6 = (float) ((a6) * (Float.parseFloat(taxRate6.getText()))) / 100;
							float t7 = (float) ((a7) * (Float.parseFloat(taxRate7.getText()))) / 100;
							float t8 = (float) ((a8) * (Float.parseFloat(taxRate8.getText()))) / 100;

							float am1 = (float) (a1 + t1);
							float am2 = (float) (a2 + t2);
							float am3 = (float) (a3 + t3);
							float am4 = (float) (a4 + t4);
							float am5 = (float) (a5 + t5);
							float am6 = (float) (a6 + t6);
							float am7 = (float) (a7 + t7);
							float am8 = (float) (a8 + t8);

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));
							taxableAmount2.setText(String.valueOf(decimalFormat.format(a2)));
							taxableAmount3.setText(String.valueOf(decimalFormat.format(a3)));
							taxableAmount4.setText(String.valueOf(decimalFormat.format(a4)));
							taxableAmount5.setText(String.valueOf(decimalFormat.format(a5)));
							taxableAmount6.setText(String.valueOf(decimalFormat.format(a6)));
							taxableAmount7.setText(String.valueOf(decimalFormat.format(a7)));
							taxableAmount8.setText(String.valueOf(decimalFormat.format(a8)));

							taxAmount1.setText(String.valueOf(t1));
							taxAmount2.setText(String.valueOf(t2));
							taxAmount3.setText(String.valueOf(t3));
							taxAmount4.setText(String.valueOf(t4));
							taxAmount5.setText(String.valueOf(t5));
							taxAmount6.setText(String.valueOf(t6));
							taxAmount7.setText(String.valueOf(t7));
							taxAmount8.setText(String.valueOf(t8));

							amount1.setText(String.valueOf(am1));
							amount2.setText(String.valueOf(am2));
							amount3.setText(String.valueOf(am3));
							amount4.setText(String.valueOf(am4));
							amount5.setText(String.valueOf(am5));
							amount6.setText(String.valueOf(am6));
							amount7.setText(String.valueOf(am7));
							amount8.setText(String.valueOf(am8));

							subAmount.setText(
									String.valueOf(decimalFormat.format(a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							if (Float.parseFloat(taxRate2.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount2.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a)));
								float g = ((taxableValue5b + taxableValue5a) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount2.getText());
								taxableValue2.setText(
										String.valueOf(decimalFormat.format(taxableValue12b + taxableValue12a)));
								float g = ((taxableValue12b + taxableValue12a) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount2.getText());
								taxableValue3.setText(
										String.valueOf(decimalFormat.format(taxableValue18b + taxableValue18a)));
								float g = ((taxableValue18b + taxableValue18a) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount2.getText());
								taxableValue4.setText(
										String.valueOf(decimalFormat.format(taxableValue28b + taxableValue28a)));
								float g = ((taxableValue28b + taxableValue28a) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate3.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount3.getText());
								taxableValue1.setText(String.valueOf(
										decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount3.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount3.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount3.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate4.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount4.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount4.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(
										taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount4.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(
										taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount4.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(
										taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate5.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount5.getText());
								taxableValue1.setText(String.valueOf(decimalFormat.format(taxableValue5b
										+ taxableValue5a + taxableValue5c + taxableValue5d + taxableValue5e)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount5.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount5.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount5.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate6.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount6.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a
												+ taxableValue5c + taxableValue5d + taxableValue5e + taxableValue5f)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount6.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c
												+ taxableValue12d + taxableValue12e + taxableValue12f)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount6.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c
												+ taxableValue18d + taxableValue18e + taxableValue18f)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount6.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c
												+ taxableValue28d + taxableValue28e + taxableValue28f)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate7.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount7.getText());
								taxableValue1.setText(String
										.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c
												+ taxableValue5d + taxableValue5e + taxableValue5f + taxableValue5g)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount7.getText());
								taxableValue2.setText(String.valueOf(decimalFormat
										.format(taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
												+ taxableValue12e + taxableValue12f + taxableValue12g)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount7.getText());
								taxableValue3.setText(String.valueOf(decimalFormat
										.format(taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
												+ taxableValue18e + taxableValue18f + taxableValue18g)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount7.getText());
								taxableValue4.setText(String.valueOf(decimalFormat
										.format(taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
												+ taxableValue28e + taxableValue28f + taxableValue28g)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate8.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount8.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
												+ taxableValue5e + taxableValue5f + taxableValue5g + taxableValue5h)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g + taxableValue5h)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate8.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount8.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e
										+ taxableValue12f + taxableValue12g + taxableValue12h)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g + taxableValue12h) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate8.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount8.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e
										+ taxableValue18f + taxableValue18g + taxableValue18h)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g + taxableValue18h) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate8.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount8.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e
										+ taxableValue28f + taxableValue28g + taxableValue28h)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g + taxableValue28h) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));

							netAmount
									.setText(String.valueOf(Math.round(am1 + am2 + am3 + am4 + am5 + am6 + am7 + am8)));

							totalTax.setText(String.valueOf(t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8));
							sgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8) / 2));
							cgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8) / 2));
						}

					}

					else if (!prName1.getText().equals("") && !prName2.getText().equals("")
							&& !prName3.getText().equals("") && !prName4.getText().equals("")
							&& !prName5.getText().equals("") && !prName6.getText().equals("")
							&& !prName7.getText().equals("") && !prName8.getText().equals("")
							&& !prName9.getText().equals("") && prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("") || qty2.getText().equals("")
								|| free2.getText().equals("") || qty3.getText().equals("") || free3.getText().equals("")
								|| qty4.getText().equals("") || free4.getText().equals("") || qty5.getText().equals("")
								|| free5.getText().equals("") || qty6.getText().equals("") || free6.getText().equals("")
								|| qty7.getText().equals("") || free7.getText().equals("") || qty8.getText().equals("")
								|| free8.getText().equals("") || qty9.getText().equals("")
								|| free9.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float taxableValue5b = 0;
							float taxableValue12b = 0;
							float taxableValue18b = 0;
							float taxableValue28b = 0;

							float taxableValue5c = 0;
							float taxableValue12c = 0;
							float taxableValue18c = 0;
							float taxableValue28c = 0;

							float taxableValue5d = 0;
							float taxableValue12d = 0;
							float taxableValue18d = 0;
							float taxableValue28d = 0;

							float taxableValue5e = 0;
							float taxableValue12e = 0;
							float taxableValue18e = 0;
							float taxableValue28e = 0;

							float taxableValue5f = 0;
							float taxableValue12f = 0;
							float taxableValue18f = 0;
							float taxableValue28f = 0;

							float taxableValue5g = 0;
							float taxableValue12g = 0;
							float taxableValue18g = 0;
							float taxableValue28g = 0;

							float taxableValue5h = 0;
							float taxableValue12h = 0;
							float taxableValue18h = 0;
							float taxableValue28h = 0;

							float taxableValue5i = 0;
							float taxableValue12i = 0;
							float taxableValue18i = 0;
							float taxableValue28i = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);
							float a2 = (float) ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
									- ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
											* (Float.parseFloat(dsc2.getText()))) / 100);
							float a3 = (float) ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
									- ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
											* (Float.parseFloat(dsc3.getText()))) / 100);
							float a4 = (float) ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
									- ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
											* (Float.parseFloat(dsc4.getText()))) / 100);
							float a5 = (float) ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
									- ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
											* (Float.parseFloat(dsc5.getText()))) / 100);
							float a6 = (float) ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
									- ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
											* (Float.parseFloat(dsc6.getText()))) / 100);
							float a7 = (float) ((Float.parseFloat(qty7.getText()) * Float.parseFloat(rate7.getText()))
									- ((Float.parseFloat(qty7.getText()) * Float.parseFloat(rate7.getText()))
											* (Float.parseFloat(dsc7.getText()))) / 100);
							float a8 = (float) ((Float.parseFloat(qty8.getText()) * Float.parseFloat(rate8.getText()))
									- ((Float.parseFloat(qty8.getText()) * Float.parseFloat(rate8.getText()))
											* (Float.parseFloat(dsc8.getText()))) / 100);
							float a9 = (float) ((Float.parseFloat(qty9.getText()) * Float.parseFloat(rate9.getText()))
									- ((Float.parseFloat(qty9.getText()) * Float.parseFloat(rate9.getText()))
											* (Float.parseFloat(dsc9.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;
							float t2 = (float) ((a2) * (Float.parseFloat(taxRate2.getText()))) / 100;
							float t3 = (float) ((a3) * (Float.parseFloat(taxRate3.getText()))) / 100;
							float t4 = (float) ((a4) * (Float.parseFloat(taxRate4.getText()))) / 100;
							float t5 = (float) ((a5) * (Float.parseFloat(taxRate5.getText()))) / 100;
							float t6 = (float) ((a6) * (Float.parseFloat(taxRate6.getText()))) / 100;
							float t7 = (float) ((a7) * (Float.parseFloat(taxRate7.getText()))) / 100;
							float t8 = (float) ((a8) * (Float.parseFloat(taxRate8.getText()))) / 100;
							float t9 = (float) ((a9) * (Float.parseFloat(taxRate9.getText()))) / 100;

							float am1 = (float) (a1 + t1);
							float am2 = (float) (a2 + t2);
							float am3 = (float) (a3 + t3);
							float am4 = (float) (a4 + t4);
							float am5 = (float) (a5 + t5);
							float am6 = (float) (a6 + t6);
							float am7 = (float) (a7 + t7);
							float am8 = (float) (a8 + t8);
							float am9 = (float) (a9 + t9);

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));
							taxableAmount2.setText(String.valueOf(decimalFormat.format(a2)));
							taxableAmount3.setText(String.valueOf(decimalFormat.format(a3)));
							taxableAmount4.setText(String.valueOf(decimalFormat.format(a4)));
							taxableAmount5.setText(String.valueOf(decimalFormat.format(a5)));
							taxableAmount6.setText(String.valueOf(decimalFormat.format(a6)));
							taxableAmount7.setText(String.valueOf(decimalFormat.format(a7)));
							taxableAmount8.setText(String.valueOf(decimalFormat.format(a8)));
							taxableAmount9.setText(String.valueOf(decimalFormat.format(a9)));

							taxAmount1.setText(String.valueOf(t1));
							taxAmount2.setText(String.valueOf(t2));
							taxAmount3.setText(String.valueOf(t3));
							taxAmount4.setText(String.valueOf(t4));
							taxAmount5.setText(String.valueOf(t5));
							taxAmount6.setText(String.valueOf(t6));
							taxAmount7.setText(String.valueOf(t7));
							taxAmount8.setText(String.valueOf(t8));
							taxAmount9.setText(String.valueOf(t9));

							amount1.setText(String.valueOf(am1));
							amount2.setText(String.valueOf(am2));
							amount3.setText(String.valueOf(am3));
							amount4.setText(String.valueOf(am4));
							amount5.setText(String.valueOf(am5));
							amount6.setText(String.valueOf(am6));
							amount7.setText(String.valueOf(am7));
							amount8.setText(String.valueOf(am8));
							amount9.setText(String.valueOf(am9));

							subAmount.setText(
									String.valueOf(decimalFormat.format(a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							if (Float.parseFloat(taxRate2.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount2.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a)));
								float g = ((taxableValue5b + taxableValue5a) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount2.getText());
								taxableValue2.setText(
										String.valueOf(decimalFormat.format(taxableValue12b + taxableValue12a)));
								float g = ((taxableValue12b + taxableValue12a) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount2.getText());
								taxableValue3.setText(
										String.valueOf(decimalFormat.format(taxableValue18b + taxableValue18a)));
								float g = ((taxableValue18b + taxableValue18a) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount2.getText());
								taxableValue4.setText(
										String.valueOf(decimalFormat.format(taxableValue28b + taxableValue28a)));
								float g = ((taxableValue28b + taxableValue28a) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate3.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount3.getText());
								taxableValue1.setText(String.valueOf(
										decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount3.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount3.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount3.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate4.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount4.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount4.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(
										taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount4.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(
										taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount4.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(
										taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate5.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount5.getText());
								taxableValue1.setText(String.valueOf(decimalFormat.format(taxableValue5b
										+ taxableValue5a + taxableValue5c + taxableValue5d + taxableValue5e)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount5.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount5.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount5.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate6.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount6.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a
												+ taxableValue5c + taxableValue5d + taxableValue5e + taxableValue5f)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount6.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c
												+ taxableValue12d + taxableValue12e + taxableValue12f)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount6.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c
												+ taxableValue18d + taxableValue18e + taxableValue18f)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount6.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c
												+ taxableValue28d + taxableValue28e + taxableValue28f)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate7.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount7.getText());
								taxableValue1.setText(String
										.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c
												+ taxableValue5d + taxableValue5e + taxableValue5f + taxableValue5g)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount7.getText());
								taxableValue2.setText(String.valueOf(decimalFormat
										.format(taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
												+ taxableValue12e + taxableValue12f + taxableValue12g)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount7.getText());
								taxableValue3.setText(String.valueOf(decimalFormat
										.format(taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
												+ taxableValue18e + taxableValue18f + taxableValue18g)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount7.getText());
								taxableValue4.setText(String.valueOf(decimalFormat
										.format(taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
												+ taxableValue28e + taxableValue28f + taxableValue28g)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate8.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount8.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
												+ taxableValue5e + taxableValue5f + taxableValue5g + taxableValue5h)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g + taxableValue5h)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate8.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount8.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e
										+ taxableValue12f + taxableValue12g + taxableValue12h)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g + taxableValue12h) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate8.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount8.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e
										+ taxableValue18f + taxableValue18g + taxableValue18h)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g + taxableValue18h) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate8.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount8.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e
										+ taxableValue28f + taxableValue28g + taxableValue28h)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g + taxableValue28h) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate9.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount9.getText());
								taxableValue1.setText(String.valueOf(decimalFormat.format(taxableValue5b
										+ taxableValue5a + taxableValue5c + taxableValue5d + taxableValue5e
										+ taxableValue5f + taxableValue5g + taxableValue5h + taxableValue5i)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g + taxableValue5h
										+ taxableValue5i) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate9.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount9.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e
										+ taxableValue12f + taxableValue12g + taxableValue12h + taxableValue12i)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g + taxableValue12h
										+ taxableValue12i) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate9.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount9.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e
										+ taxableValue18f + taxableValue18g + taxableValue18h + taxableValue18i)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g + taxableValue18h
										+ taxableValue18i) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate9.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount9.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e
										+ taxableValue28f + taxableValue28g + taxableValue28h + taxableValue28i)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g + taxableValue28h
										+ taxableValue28i) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));
							netAmount.setText(
									String.valueOf(Math.round(am1 + am2 + am3 + am4 + am5 + am6 + am7 + am8 + am9)));

							totalTax.setText(String.valueOf(t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9));
							sgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9) / 2));
							cgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9) / 2));
						}

					}

					else if (!prName1.getText().equals("") && !prName2.getText().equals("")
							&& !prName3.getText().equals("") && !prName4.getText().equals("")
							&& !prName5.getText().equals("") && !prName6.getText().equals("")
							&& !prName7.getText().equals("") && !prName8.getText().equals("")
							&& !prName9.getText().equals("") && !prName10.getText().equals("")) {

						if (qty1.getText().equals("") || free1.getText().equals("") || qty2.getText().equals("")
								|| free2.getText().equals("") || qty3.getText().equals("") || free3.getText().equals("")
								|| qty4.getText().equals("") || free4.getText().equals("") || qty5.getText().equals("")
								|| free5.getText().equals("") || qty6.getText().equals("") || free6.getText().equals("")
								|| qty7.getText().equals("") || free7.getText().equals("") || qty8.getText().equals("")
								|| free8.getText().equals("") || qty9.getText().equals("") || free9.getText().equals("")
								|| qty10.getText().equals("") || free10.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter correct order");

						}

						else {

							float taxableValue5a = 0;
							float taxableValue12a = 0;
							float taxableValue18a = 0;
							float taxableValue28a = 0;

							float taxableValue5b = 0;
							float taxableValue12b = 0;
							float taxableValue18b = 0;
							float taxableValue28b = 0;

							float taxableValue5c = 0;
							float taxableValue12c = 0;
							float taxableValue18c = 0;
							float taxableValue28c = 0;

							float taxableValue5d = 0;
							float taxableValue12d = 0;
							float taxableValue18d = 0;
							float taxableValue28d = 0;

							float taxableValue5e = 0;
							float taxableValue12e = 0;
							float taxableValue18e = 0;
							float taxableValue28e = 0;

							float taxableValue5f = 0;
							float taxableValue12f = 0;
							float taxableValue18f = 0;
							float taxableValue28f = 0;

							float taxableValue5g = 0;
							float taxableValue12g = 0;
							float taxableValue18g = 0;
							float taxableValue28g = 0;

							float taxableValue5h = 0;
							float taxableValue12h = 0;
							float taxableValue18h = 0;
							float taxableValue28h = 0;

							float taxableValue5i = 0;
							float taxableValue12i = 0;
							float taxableValue18i = 0;
							float taxableValue28i = 0;

							float taxableValue5j = 0;
							float taxableValue12j = 0;
							float taxableValue18j = 0;
							float taxableValue28j = 0;

							float a1 = (float) ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
									- ((Float.parseFloat(qty1.getText()) * Float.parseFloat(rate1.getText()))
											* (Float.parseFloat(dsc1.getText()))) / 100);
							float a2 = (float) ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
									- ((Float.parseFloat(qty2.getText()) * Float.parseFloat(rate2.getText()))
											* (Float.parseFloat(dsc2.getText()))) / 100);
							float a3 = (float) ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
									- ((Float.parseFloat(qty3.getText()) * Float.parseFloat(rate3.getText()))
											* (Float.parseFloat(dsc3.getText()))) / 100);
							float a4 = (float) ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
									- ((Float.parseFloat(qty4.getText()) * Float.parseFloat(rate4.getText()))
											* (Float.parseFloat(dsc4.getText()))) / 100);
							float a5 = (float) ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
									- ((Float.parseFloat(qty5.getText()) * Float.parseFloat(rate5.getText()))
											* (Float.parseFloat(dsc5.getText()))) / 100);
							float a6 = (float) ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
									- ((Float.parseFloat(qty6.getText()) * Float.parseFloat(rate6.getText()))
											* (Float.parseFloat(dsc6.getText()))) / 100);
							float a7 = (float) ((Float.parseFloat(qty7.getText()) * Float.parseFloat(rate7.getText()))
									- ((Float.parseFloat(qty7.getText()) * Float.parseFloat(rate7.getText()))
											* (Float.parseFloat(dsc7.getText()))) / 100);
							float a8 = (float) ((Float.parseFloat(qty8.getText()) * Float.parseFloat(rate8.getText()))
									- ((Float.parseFloat(qty8.getText()) * Float.parseFloat(rate8.getText()))
											* (Float.parseFloat(dsc8.getText()))) / 100);
							float a9 = (float) ((Float.parseFloat(qty9.getText()) * Float.parseFloat(rate9.getText()))
									- ((Float.parseFloat(qty9.getText()) * Float.parseFloat(rate9.getText()))
											* (Float.parseFloat(dsc9.getText()))) / 100);
							float a10 = (float) ((Float.parseFloat(qty10.getText())
									* Float.parseFloat(rate10.getText()))
									- ((Float.parseFloat(qty10.getText()) * Float.parseFloat(rate10.getText()))
											* (Float.parseFloat(dsc10.getText()))) / 100);

							float t1 = (float) ((a1) * (Float.parseFloat(taxRate1.getText()))) / 100;
							float t2 = (float) ((a2) * (Float.parseFloat(taxRate2.getText()))) / 100;
							float t3 = (float) ((a3) * (Float.parseFloat(taxRate3.getText()))) / 100;
							float t4 = (float) ((a4) * (Float.parseFloat(taxRate4.getText()))) / 100;
							float t5 = (float) ((a5) * (Float.parseFloat(taxRate5.getText()))) / 100;
							float t6 = (float) ((a6) * (Float.parseFloat(taxRate6.getText()))) / 100;
							float t7 = (float) ((a7) * (Float.parseFloat(taxRate7.getText()))) / 100;
							float t8 = (float) ((a8) * (Float.parseFloat(taxRate8.getText()))) / 100;
							float t9 = (float) ((a9) * (Float.parseFloat(taxRate9.getText()))) / 100;
							float t10 = (float) ((a10) * (Float.parseFloat(taxRate10.getText()))) / 100;

							float am1 = (float) (a1 + t1);
							float am2 = (float) (a2 + t2);
							float am3 = (float) (a3 + t3);
							float am4 = (float) (a4 + t4);
							float am5 = (float) (a5 + t5);
							float am6 = (float) (a6 + t6);
							float am7 = (float) (a7 + t7);
							float am8 = (float) (a8 + t8);
							float am9 = (float) (a9 + t9);
							float am10 = (float) (a10 + t10);

							taxableAmount1.setText(String.valueOf(decimalFormat.format(a1)));
							taxableAmount2.setText(String.valueOf(decimalFormat.format(a2)));
							taxableAmount3.setText(String.valueOf(decimalFormat.format(a3)));
							taxableAmount4.setText(String.valueOf(decimalFormat.format(a4)));
							taxableAmount5.setText(String.valueOf(decimalFormat.format(a5)));
							taxableAmount6.setText(String.valueOf(decimalFormat.format(a6)));
							taxableAmount7.setText(String.valueOf(decimalFormat.format(a7)));
							taxableAmount8.setText(String.valueOf(decimalFormat.format(a8)));
							taxableAmount9.setText(String.valueOf(decimalFormat.format(a9)));
							taxableAmount10.setText(String.valueOf(decimalFormat.format(a10)));

							taxAmount1.setText(String.valueOf(t1));
							taxAmount2.setText(String.valueOf(t2));
							taxAmount3.setText(String.valueOf(t3));
							taxAmount4.setText(String.valueOf(t4));
							taxAmount5.setText(String.valueOf(t5));
							taxAmount6.setText(String.valueOf(t6));
							taxAmount7.setText(String.valueOf(t7));
							taxAmount8.setText(String.valueOf(t8));
							taxAmount9.setText(String.valueOf(t9));
							taxAmount10.setText(String.valueOf(t10));

							amount1.setText(String.valueOf(am1));
							amount2.setText(String.valueOf(am2));
							amount3.setText(String.valueOf(am3));
							amount4.setText(String.valueOf(am4));
							amount5.setText(String.valueOf(am5));
							amount6.setText(String.valueOf(am6));
							amount7.setText(String.valueOf(am7));
							amount8.setText(String.valueOf(am8));
							amount9.setText(String.valueOf(am9));
							amount10.setText(String.valueOf(am10));

							subAmount.setText(String
									.valueOf(decimalFormat.format(a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10)));

							if (Float.parseFloat(taxRate1.getText()) == 5) {
								taxableValue5a += Float.parseFloat(taxableAmount1.getText());
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue1.setText(String.valueOf(taxableValue5a));
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue5a * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 12) {
								taxableValue12a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue18a = 0;
								taxableValue28a = 0;
								taxableValue2.setText(String.valueOf(taxableValue12a));
								taxableValue1.setText("0");
								taxableValue3.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue12a * (float) 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst1.setText("0");
								amountSgst3.setText("0");
								amountSgst4.setText("0");
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText("0");
								amountCgst3.setText("0");
								amountCgst4.setText("0");

							} else if (Float.parseFloat(taxRate1.getText()) == 18) {
								taxableValue18a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue28a = 0;
								taxableValue3.setText(String.valueOf(taxableValue18a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue4.setText("0");
								float g = (taxableValue18a * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst1.setText("0");
								amountSgst4.setText("0");
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst1.setText("0");
								amountCgst4.setText("0");
							} else if (Float.parseFloat(taxRate1.getText()) == 28) {
								taxableValue28a += Float.parseFloat(taxableAmount1.getText());
								taxableValue5a = 0;
								taxableValue12a = 0;
								taxableValue18a = 0;
								taxableValue4.setText(String.valueOf(taxableValue28a));
								taxableValue1.setText("0");
								taxableValue2.setText("0");
								taxableValue3.setText("0");
								float g = (taxableValue28a * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountSgst2.setText("0");
								amountSgst3.setText("0");
								amountSgst1.setText("0");
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText("0");
								amountCgst3.setText("0");
								amountCgst1.setText("0");
							}

							if (Float.parseFloat(taxRate2.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount2.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a)));
								float g = ((taxableValue5b + taxableValue5a) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount2.getText());
								taxableValue2.setText(
										String.valueOf(decimalFormat.format(taxableValue12b + taxableValue12a)));
								float g = ((taxableValue12b + taxableValue12a) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount2.getText());
								taxableValue3.setText(
										String.valueOf(decimalFormat.format(taxableValue18b + taxableValue18a)));
								float g = ((taxableValue18b + taxableValue18a) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate2.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount2.getText());
								taxableValue4.setText(
										String.valueOf(decimalFormat.format(taxableValue28b + taxableValue28a)));
								float g = ((taxableValue28b + taxableValue28a) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate3.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount3.getText());
								taxableValue1.setText(String.valueOf(
										decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount3.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount3.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate3.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount3.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate4.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount4.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount4.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(
										taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount4.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(
										taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate4.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount4.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(
										taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate5.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount5.getText());
								taxableValue1.setText(String.valueOf(decimalFormat.format(taxableValue5b
										+ taxableValue5a + taxableValue5c + taxableValue5d + taxableValue5e)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount5.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount5.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate5.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount5.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate6.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount6.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a
												+ taxableValue5c + taxableValue5d + taxableValue5e + taxableValue5f)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount6.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c
												+ taxableValue12d + taxableValue12e + taxableValue12f)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount6.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c
												+ taxableValue18d + taxableValue18e + taxableValue18f)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate6.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount6.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c
												+ taxableValue28d + taxableValue28e + taxableValue28f)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate7.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount7.getText());
								taxableValue1.setText(String
										.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a + taxableValue5c
												+ taxableValue5d + taxableValue5e + taxableValue5f + taxableValue5g)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount7.getText());
								taxableValue2.setText(String.valueOf(decimalFormat
										.format(taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
												+ taxableValue12e + taxableValue12f + taxableValue12g)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount7.getText());
								taxableValue3.setText(String.valueOf(decimalFormat
										.format(taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
												+ taxableValue18e + taxableValue18f + taxableValue18g)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate7.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount7.getText());
								taxableValue4.setText(String.valueOf(decimalFormat
										.format(taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
												+ taxableValue28e + taxableValue28f + taxableValue28g)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate8.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount8.getText());
								taxableValue1.setText(String.valueOf(decimalFormat
										.format(taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
												+ taxableValue5e + taxableValue5f + taxableValue5g + taxableValue5h)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g + taxableValue5h)
										* (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate8.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount8.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e
										+ taxableValue12f + taxableValue12g + taxableValue12h)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g + taxableValue12h) * 6)
										/ 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate8.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount8.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e
										+ taxableValue18f + taxableValue18g + taxableValue18h)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g + taxableValue18h) * 9)
										/ 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate8.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount8.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e
										+ taxableValue28f + taxableValue28g + taxableValue28h)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g + taxableValue28h) * 14)
										/ 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate9.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount9.getText());
								taxableValue1.setText(String.valueOf(decimalFormat.format(taxableValue5b
										+ taxableValue5a + taxableValue5c + taxableValue5d + taxableValue5e
										+ taxableValue5f + taxableValue5g + taxableValue5h + taxableValue5i)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g + taxableValue5h
										+ taxableValue5i) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate9.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount9.getText());
								taxableValue2.setText(String.valueOf(decimalFormat.format(taxableValue12b
										+ taxableValue12a + taxableValue12c + taxableValue12d + taxableValue12e
										+ taxableValue12f + taxableValue12g + taxableValue12h + taxableValue12i)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g + taxableValue12h
										+ taxableValue12i) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate9.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount9.getText());
								taxableValue3.setText(String.valueOf(decimalFormat.format(taxableValue18b
										+ taxableValue18a + taxableValue18c + taxableValue18d + taxableValue18e
										+ taxableValue18f + taxableValue18g + taxableValue18h + taxableValue18i)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g + taxableValue18h
										+ taxableValue18i) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate9.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount9.getText());
								taxableValue4.setText(String.valueOf(decimalFormat.format(taxableValue28b
										+ taxableValue28a + taxableValue28c + taxableValue28d + taxableValue28e
										+ taxableValue28f + taxableValue28g + taxableValue28h + taxableValue28i)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g + taxableValue28h
										+ taxableValue28i) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							if (Float.parseFloat(taxRate10.getText()) == 5) {

								taxableValue5b += Float.parseFloat(taxableAmount10.getText());
								taxableValue1
										.setText(String.valueOf(decimalFormat.format(taxableValue5b + taxableValue5a
												+ taxableValue5c + taxableValue5d + taxableValue5e + taxableValue5f
												+ taxableValue5g + taxableValue5h + taxableValue5i + taxableValue5j)));
								float g = ((taxableValue5b + taxableValue5a + taxableValue5c + taxableValue5d
										+ taxableValue5e + taxableValue5f + taxableValue5g + taxableValue5h
										+ taxableValue5i + taxableValue5j) * (float) 2.5) / 100;
								amountSgst1.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst1.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate10.getText()) == 12) {

								taxableValue12b += Float.parseFloat(taxableAmount10.getText());
								taxableValue2.setText(String.valueOf(
										decimalFormat.format(taxableValue12b + taxableValue12a + taxableValue12c
												+ taxableValue12d + taxableValue12e + taxableValue12f + taxableValue12g
												+ taxableValue12h + taxableValue12i + taxableValue12j)));
								float g = ((taxableValue12b + taxableValue12a + taxableValue12c + taxableValue12d
										+ taxableValue12e + taxableValue12f + taxableValue12g + taxableValue12h
										+ taxableValue12i + taxableValue12j) * 6) / 100;
								amountSgst2.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst2.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate10.getText()) == 18) {

								taxableValue18b += Float.parseFloat(taxableAmount10.getText());
								taxableValue3.setText(String.valueOf(
										decimalFormat.format(taxableValue18b + taxableValue18a + taxableValue18c
												+ taxableValue18d + taxableValue18e + taxableValue18f + taxableValue18g
												+ taxableValue18h + taxableValue18i + taxableValue18j)));
								float g = ((taxableValue18b + taxableValue18a + taxableValue18c + taxableValue18d
										+ taxableValue18e + taxableValue18f + taxableValue18g + taxableValue18h
										+ taxableValue18i + taxableValue18j) * 9) / 100;
								amountSgst3.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst3.setText(String.valueOf(decimalFormat.format(g)));

							}

							else if (Float.parseFloat(taxRate10.getText()) == 28) {

								taxableValue28b += Float.parseFloat(taxableAmount10.getText());
								taxableValue4.setText(String.valueOf(
										decimalFormat.format(taxableValue28b + taxableValue28a + taxableValue28c
												+ taxableValue28d + taxableValue28e + taxableValue28f + taxableValue28g
												+ taxableValue28h + taxableValue28i + taxableValue28j)));
								float g = ((taxableValue28b + taxableValue28a + taxableValue28c + taxableValue28d
										+ taxableValue28e + taxableValue28f + taxableValue28g + taxableValue28h
										+ taxableValue28i + taxableValue28j) * 14) / 100;
								amountSgst4.setText(String.valueOf(decimalFormat.format(g)));
								amountCgst4.setText(String.valueOf(decimalFormat.format(g)));

							}

							totalTaxableValue.setText(
									String.valueOf(decimalFormat.format(Float.parseFloat(taxableValue1.getText())
											+ Float.parseFloat(taxableValue2.getText())
											+ Float.parseFloat(taxableValue3.getText())
											+ Float.parseFloat(taxableValue4.getText()))));
							totalSgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountSgst1.getText()) + Float.parseFloat(amountSgst2.getText())
											+ Float.parseFloat(amountSgst3.getText())
											+ Float.parseFloat(amountSgst4.getText()))));
							totalCgstAmount.setText(String.valueOf(decimalFormat.format(
									Float.parseFloat(amountCgst1.getText()) + Float.parseFloat(amountCgst2.getText())
											+ Float.parseFloat(amountCgst3.getText())
											+ Float.parseFloat(amountCgst4.getText()))));

							netAmount.setText(String
									.valueOf(Math.round(am1 + am2 + am3 + am4 + am5 + am6 + am7 + am8 + am9 + am10)));

							totalTax.setText(String.valueOf(t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10));
							sgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10) / 2));
							cgstAmount.setText(String.valueOf((t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10) / 2));
						}

					}

				}

			}
		});

		p.setPreferredSize(new Dimension(1800, 1500));
		f.setPreferredSize(new Dimension(1366, 768));
		f.add(jScrollPane);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	public static void main(String args[]) {
		new ErpGuiSale();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ErpCustomerVo erpCustomerVo0 = new ErpCustomerVo();
		ErpStockDao erpStockDao = new ErpStockDao();
		ErpSaleDao erpSaleDao = new ErpSaleDao();

		if (firmBox.hasFocus()) {

			List<ErpFirmVo> fl = new ArrayList<ErpFirmVo>();
			fl = new ErpFirmDao().firmListByName(firmBox.getItemAt(firmBox.getSelectedIndex()));
			for (ErpFirmVo v : fl) {
				srNoTextField.setText(String.valueOf(v.getFirmSrNo()));
			}

		}

		else if (customerBox.hasFocus()) {

			List<ErpCustomerVo> l = new ErpCustomerDao()
					.selectAddressFromName(customerBox.getItemAt(customerBox.getSelectedIndex()));
			addressBox.removeAllItems();
			for (ErpCustomerVo v : l) {
				addressBox.addItem(v.getCustAdress());
			}

		}

		if (addressBox.hasFocus()) {

			erpCustomerVo0 = erpSaleDao.setCustomerDetailsDao(customerBox.getItemAt(customerBox.getSelectedIndex()),
					addressBox.getItemAt(addressBox.getSelectedIndex()));
			
			gstNoTextField.setText(String.valueOf(erpCustomerVo0.getCustGstNo()));
			balanceTextField.setText(String.valueOf(erpCustomerVo0.getCustBalance()));
			phoneTextField.setText(String.valueOf(erpCustomerVo0.getCustPhone()));
			
			prName1.setText("");
			prName2.setText("");
			prName3.setText("");
			prName4.setText("");
			prName5.setText("");
			prName6.setText("");
			prName7.setText("");
			prName8.setText("");
			prName9.setText("");
			prName10.setText("");

			hsn1.setText("");
			hsn2.setText("");
			hsn3.setText("");
			hsn4.setText("");
			hsn5.setText("");
			hsn6.setText("");
			hsn7.setText("");
			hsn8.setText("");
			hsn9.setText("");
			hsn10.setText("");

			packing1.setText("");
			packing2.setText("");
			packing3.setText("");
			packing4.setText("");
			packing5.setText("");
			packing6.setText("");
			packing7.setText("");
			packing8.setText("");
			packing9.setText("");
			packing10.setText("");

			qty1.setText("");
			qty2.setText("");
			qty3.setText("");
			qty4.setText("");
			qty5.setText("");
			qty6.setText("");
			qty7.setText("");
			qty8.setText("");
			qty9.setText("");
			qty10.setText("");

			free1.setText("");
			free2.setText("");
			free3.setText("");
			free4.setText("");
			free5.setText("");
			free6.setText("");
			free7.setText("");
			free8.setText("");
			free9.setText("");
			free10.setText("");

			rate1.setText("");
			rate2.setText("");
			rate3.setText("");
			rate4.setText("");
			rate5.setText("");
			rate6.setText("");
			rate7.setText("");
			rate8.setText("");
			rate9.setText("");
			rate10.setText("");

			dsc1.setText("");
			dsc2.setText("");
			dsc3.setText("");
			dsc4.setText("");
			dsc5.setText("");
			dsc6.setText("");
			dsc7.setText("");
			dsc8.setText("");
			dsc9.setText("");
			dsc10.setText("");

			taxableAmount1.setText("");
			taxableAmount2.setText("");
			taxableAmount3.setText("");
			taxableAmount4.setText("");
			taxableAmount5.setText("");
			taxableAmount6.setText("");
			taxableAmount7.setText("");
			taxableAmount8.setText("");
			taxableAmount9.setText("");
			taxableAmount10.setText("");

			taxRate1.setText("");
			taxRate2.setText("");
			taxRate3.setText("");
			taxRate4.setText("");
			taxRate5.setText("");
			taxRate6.setText("");
			taxRate7.setText("");
			taxRate8.setText("");
			taxRate9.setText("");
			taxRate10.setText("");

			taxAmount1.setText("");
			taxAmount2.setText("");
			taxAmount3.setText("");
			taxAmount4.setText("");
			taxAmount5.setText("");
			taxAmount6.setText("");
			taxAmount7.setText("");
			taxAmount8.setText("");
			taxAmount9.setText("");
			taxAmount10.setText("");

			amount1.setText("");
			amount2.setText("");
			amount3.setText("");
			amount4.setText("");
			amount5.setText("");
			amount6.setText("");
			amount7.setText("");
			amount8.setText("");
			amount9.setText("");
			amount10.setText("");

			netAmount.setText("");
			totalTax.setText("");
			sgstAmount.setText("");
			cgstAmount.setText("");

		}

		else if (b1.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b1.getItemAt(b1.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b1.getItemAt(b1.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName1.setText(b1.getItemAt(b1.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName1.getText().equals(l.getProductName())) {
						hsn1.setText(String.valueOf(l.getProductHsn()));
						packing1.setText(l.getProductPacking());

						if (l.getProductGst() == 5) {
							rate1.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate1.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate1.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate1.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}

						dsc1.setText(String.valueOf(l.getProductDsc()));
						taxRate1.setText(String.valueOf(l.getProductGst()));

					}
				}
			}

		}

		else if (b2.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b2.getItemAt(b2.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b2.getItemAt(b2.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName2.setText(b2.getItemAt(b2.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName2.getText().equals(l.getProductName())) {
						hsn2.setText(String.valueOf(l.getProductHsn()));
						packing2.setText(l.getProductPacking());
						if (l.getProductGst() == 5) {
							rate2.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate2.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate2.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate2.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}
						dsc2.setText(String.valueOf(l.getProductDsc()));
						taxRate2.setText(String.valueOf(l.getProductGst()));
					}
				}
			}

		}

		else if (b3.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b3.getItemAt(b3.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b3.getItemAt(b3.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName3.setText(b3.getItemAt(b3.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName3.getText().equals(l.getProductName())) {
						hsn3.setText(String.valueOf(l.getProductHsn()));
						packing3.setText(l.getProductPacking());
						if (l.getProductGst() == 5) {
							rate3.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate3.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate3.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate3.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}
						dsc3.setText(String.valueOf(l.getProductDsc()));
						taxRate3.setText(String.valueOf(l.getProductGst()));
					}
				}
			}

		}

		else if (b4.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b4.getItemAt(b4.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b4.getItemAt(b4.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName4.setText(b4.getItemAt(b4.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName4.getText().equals(l.getProductName())) {
						hsn4.setText(String.valueOf(l.getProductHsn()));
						packing4.setText(l.getProductPacking());
						if (l.getProductGst() == 5) {
							rate4.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate4.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate4.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate4.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}
						dsc4.setText(String.valueOf(l.getProductDsc()));
						taxRate4.setText(String.valueOf(l.getProductGst()));
					}
				}
			}

		}

		else if (b5.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b5.getItemAt(b5.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b5.getItemAt(b5.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName5.setText(b5.getItemAt(b5.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName5.getText().equals(l.getProductName())) {
						hsn5.setText(String.valueOf(l.getProductHsn()));
						packing5.setText(l.getProductPacking());
						if (l.getProductGst() == 5) {
							rate5.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate5.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate5.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate5.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}
						dsc5.setText(String.valueOf(l.getProductDsc()));
						taxRate5.setText(String.valueOf(l.getProductGst()));
					}
				}
			}

		}

		else if (b6.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b6.getItemAt(b6.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b6.getItemAt(b6.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName6.setText(b6.getItemAt(b6.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName6.getText().equals(l.getProductName())) {
						hsn6.setText(String.valueOf(l.getProductHsn()));
						packing6.setText(l.getProductPacking());
						if (l.getProductGst() == 5) {
							rate6.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate6.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate6.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate6.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}
						dsc6.setText(String.valueOf(l.getProductDsc()));
						taxRate6.setText(String.valueOf(l.getProductGst()));
					}
				}
			}

		}

		else if (b7.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b7.getItemAt(b7.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b7.getItemAt(b7.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName7.setText(b7.getItemAt(b7.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName7.getText().equals(l.getProductName())) {
						hsn7.setText(String.valueOf(l.getProductHsn()));
						packing7.setText(l.getProductPacking());
						if (l.getProductGst() == 5) {
							rate7.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate7.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate7.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate7.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}
						dsc7.setText(String.valueOf(l.getProductDsc()));
						taxRate7.setText(String.valueOf(l.getProductGst()));
					}
				}
			}

		}

		else if (b8.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b8.getItemAt(b8.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b8.getItemAt(b8.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName8.setText(b8.getItemAt(b8.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName8.getText().equals(l.getProductName())) {
						hsn8.setText(String.valueOf(l.getProductHsn()));
						packing8.setText(l.getProductPacking());
						if (l.getProductGst() == 5) {
							rate8.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate8.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate8.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate8.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}
						dsc8.setText(String.valueOf(l.getProductDsc()));
						taxRate8.setText(String.valueOf(l.getProductGst()));
					}
				}
			}

		}

		else if (b9.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b9.getItemAt(b9.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b9.getItemAt(b9.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName9.setText(b9.getItemAt(b9.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName9.getText().equals(l.getProductName())) {
						hsn9.setText(String.valueOf(l.getProductHsn()));
						packing9.setText(l.getProductPacking());
						if (l.getProductGst() == 5) {
							rate9.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate9.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate9.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate9.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}
						dsc9.setText(String.valueOf(l.getProductDsc()));
						taxRate9.setText(String.valueOf(l.getProductGst()));
					}
				}
			}

		}

		else if (b10.hasFocus()) {

			double qty = new ErpStockDao().displayTotalQty(b10.getItemAt(b10.getSelectedIndex()));

			if (qty == 0) {
				JOptionPane.showMessageDialog(qty5, b10.getItemAt(b10.getSelectedIndex()) + " is out of stock");

			}

			else {
				prName10.setText(b10.getItemAt(b10.getSelectedIndex()));

				List<ErpProductVo> list = new ArrayList<ErpProductVo>();
				list = new ErpProductDao().displayProducts();
				for (ErpProductVo l : list) {
					if (prName10.getText().equals(l.getProductName())) {
						hsn10.setText(String.valueOf(l.getProductHsn()));
						packing10.setText(l.getProductPacking());
						if (l.getProductGst() == 5) {
							rate10.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.05)));
						} else if (l.getProductGst() == 12) {
							rate10.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.12)));
						} else if (l.getProductGst() == 18) {
							rate10.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.18)));
						} else if (l.getProductGst() == 28) {
							rate10.setText(String.valueOf(decimalFormat.format(l.getSaleRate() / 1.28)));
						}
						dsc10.setText(String.valueOf(l.getProductDsc()));
						taxRate10.setText(String.valueOf(l.getProductGst()));
					}
				}
			}

		}

		if (e.getSource() == generateBillButton) {

			int flag = 0;
			List<ErpProductVo> billList = new ErpSaleDao().billNoList();

			for (ErpProductVo v : billList) {
				if (v.getBillNo() == Long.parseLong(billNoTextField.getText())) {
					JOptionPane.showMessageDialog(null, "Bill already exist");
					flag = 1;
					break;
				}
			}

			if (flag != 1) {
				if (prName1.getText().equals("") && prName2.getText().equals("") && prName3.getText().equals("")
						&& prName4.getText().equals("") && prName5.getText().equals("") && prName6.getText().equals("")
						&& prName7.getText().equals("") && prName8.getText().equals("") && prName9.getText().equals("")
						&& prName10.getText().equals("")) {

					JOptionPane.showMessageDialog(qty5, "Please provide some information");

				}

				else if (!prName1.getText().equals("") && prName2.getText().equals("") && prName3.getText().equals("")
						&& prName4.getText().equals("") && prName5.getText().equals("") && prName6.getText().equals("")
						&& prName7.getText().equals("") && prName8.getText().equals("") && prName9.getText().equals("")
						&& prName10.getText().equals("")) {

					float totalQty = Float.parseFloat(qty1.getText()) + Float.parseFloat(free1.getText());

					if (new ErpStockDao().displayTotalQty(prName1.getText()) == 0) {

						JOptionPane.showMessageDialog(qty5, prName1.getText() + " is out of stock");

					}

					else if (new ErpStockDao().displayTotalQty(prName1.getText()) < totalQty) {

						JOptionPane.showMessageDialog(qty5,
								"Only " + new ErpStockDao().displayTotalQty(prName1.getText()) + " " + prName1.getText()
										+ " left");

					}

					else {

						ErpProductVo erpProductVo = new ErpProductVo();
						ErpCustomerVo erpCustomerVo = new ErpCustomerVo();

						erpProductVo.setProductName(prName1.getText());
						erpProductVo.setProductHsn(Integer.parseInt(hsn1.getText()));
						erpProductVo.setProductPacking(packing1.getText());
						erpProductVo.setProductQty(Float.parseFloat(qty1.getText()));
						erpProductVo.setProductFree(Float.parseFloat(free1.getText()));
						erpProductVo.setProductSaleRate(Float.parseFloat(rate1.getText()));
						erpProductVo.setProductDsc(Float.parseFloat(dsc1.getText()));
						erpProductVo.setTaxableAmount(Float.parseFloat(taxableAmount1.getText()));
						erpProductVo.setProductGst(Float.parseFloat(taxRate1.getText()));
						erpProductVo.setProductAmount(Float.parseFloat(amount1.getText()));
						erpProductVo.setCgstAmount(Float.parseFloat(cgstAmount.getText()));
						erpProductVo.setSgstAmount(Float.parseFloat(sgstAmount.getText()));
						erpProductVo.setNetAmount(Float.parseFloat(netAmount.getText()));
						erpCustomerVo.setCustName(customerBox.getItemAt(customerBox.getSelectedIndex()));
						erpCustomerVo.setCustAdress(addressBox.getItemAt(addressBox.getSelectedIndex()));
						erpCustomerVo.setCustGstNo(gstNoTextField.getText());
						erpCustomerVo.setCustPhone(Long.parseLong(phoneTextField.getText()));
						erpProductVo.setBillNo(Long.parseLong(billNoTextField.getText()));
						try {

							java.util.Date date = dateFormat.parse(dateTextField.getText());
							erpProductVo.setSaleDate(date);

						} catch (ParseException e1) {
							e1.printStackTrace();
						}

						erpProductVo.setSgst5(Float.parseFloat(amountSgst1.getText()));
						erpProductVo.setCgst5(Float.parseFloat(amountCgst1.getText()));
						erpProductVo.setSgst12(Float.parseFloat(amountSgst2.getText()));
						erpProductVo.setCgst12(Float.parseFloat(amountCgst2.getText()));
						erpProductVo.setSgst18(Float.parseFloat(amountSgst3.getText()));
						erpProductVo.setCgst18(Float.parseFloat(amountCgst3.getText()));
						erpProductVo.setSgst28(Float.parseFloat(amountSgst4.getText()));
						erpProductVo.setCgst28(Float.parseFloat(amountCgst4.getText()));

						erpStockDao.decreaseStock(prName1.getText(), Float.parseFloat(qty1.getText()),
								Float.parseFloat(free1.getText()));
						erpSaleDao.insertSale(erpProductVo, erpCustomerVo);

						new ErpCustomerDao().addCustomerBalance(gstNoTextField.getText(),
								customerBox.getItemAt(customerBox.getSelectedIndex()),
								addressBox.getItemAt(addressBox.getSelectedIndex()),
								Float.parseFloat(netAmount.getText()));

						ErpBillGenerator billGenerator = new ErpBillGenerator();
						try {
							billGenerator.bill1(erpProductVo, erpCustomerVo, Float.parseFloat(taxableValue1.getText()),
									Float.parseFloat(taxableValue2.getText()),
									Float.parseFloat(taxableValue3.getText()),
									Float.parseFloat(taxableValue4.getText()), transportModeField.getText(),
									unit1.getText());
						} catch (IOException e1) {

							e1.printStackTrace();
						} catch (DocumentException e1) {

							e1.printStackTrace();
						}
					}

				}

				else if (!prName1.getText().equals("") && !prName2.getText().equals("") && prName3.getText().equals("")
						&& prName4.getText().equals("") && prName5.getText().equals("") && prName6.getText().equals("")
						&& prName7.getText().equals("") && prName8.getText().equals("") && prName9.getText().equals("")
						&& prName10.getText().equals("")) {

					ErpProductVo erpProductVo = null;
					ErpCustomerVo erpCustomerVo = null;
					ErpProductVo erpProductVo1 = null;
					ErpCustomerVo erpCustomerVo1 = null;

					float totalQty = Float.parseFloat(qty1.getText()) + Float.parseFloat(free1.getText());

					if (new ErpStockDao().displayTotalQty(prName1.getText()) <= 0) {

						JOptionPane.showMessageDialog(qty5, prName1.getText() + " is out of stock");

					}

					else if (new ErpStockDao().displayTotalQty(prName1.getText()) < totalQty) {

						JOptionPane.showMessageDialog(qty5,
								"Only " + new ErpStockDao().displayTotalQty(prName1.getText()) + " " + prName1.getText()
										+ " left");

					}

					else {

						erpProductVo = new ErpProductVo();
						erpCustomerVo = new ErpCustomerVo();

						erpProductVo.setProductName(prName1.getText());
						erpProductVo.setProductHsn(Integer.parseInt(hsn1.getText()));
						erpProductVo.setProductPacking(packing1.getText());
						erpProductVo.setProductQty(Float.parseFloat(qty1.getText()));
						erpProductVo.setProductFree(Float.parseFloat(free1.getText()));
						erpProductVo.setProductSaleRate(Float.parseFloat(rate1.getText()));
						erpProductVo.setProductDsc(Float.parseFloat(dsc1.getText()));
						erpProductVo.setTaxableAmount(Float.parseFloat(taxableAmount1.getText()));
						erpProductVo.setProductGst(Float.parseFloat(taxRate1.getText()));
						erpProductVo.setProductAmount(Float.parseFloat(amount1.getText()));
						erpProductVo.setCgstAmount(Float.parseFloat(cgstAmount.getText()));
						erpProductVo.setSgstAmount(Float.parseFloat(sgstAmount.getText()));
						erpProductVo.setNetAmount(Float.parseFloat(netAmount.getText()));
						erpCustomerVo.setCustName(customerBox.getItemAt(customerBox.getSelectedIndex()));
						erpCustomerVo.setCustAdress(addressBox.getItemAt(addressBox.getSelectedIndex()));
						erpCustomerVo.setCustGstNo(gstNoTextField.getText());
						erpCustomerVo.setCustPhone(Long.parseLong(phoneTextField.getText()));
						erpProductVo.setBillNo(Long.parseLong(billNoTextField.getText()));
						try {

							java.util.Date date = dateFormat.parse(dateTextField.getText());
							erpProductVo.setSaleDate(date);

						} catch (ParseException e1) {
							e1.printStackTrace();
						}

						erpProductVo.setSgst5(Float.parseFloat(amountSgst1.getText()));
						erpProductVo.setCgst5(Float.parseFloat(amountCgst1.getText()));
						erpProductVo.setSgst12(Float.parseFloat(amountSgst2.getText()));
						erpProductVo.setCgst12(Fl