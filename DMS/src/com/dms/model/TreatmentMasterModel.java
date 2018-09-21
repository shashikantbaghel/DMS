package com.dms.model;

import java.util.Date;

public class TreatmentMasterModel {

	private int treatmentid;
	private String approximatetime;
	private int apprximatecost;
	private int totalpaidamount;
	private int balanceamount;
	private String prescription;
	private Date treatmentDate;
	
	
	public Date getTreatmentDate() {
		return treatmentDate;
	}




	public void setTreatmentDate(Date treatmentDate) {
		this.treatmentDate = treatmentDate;
	}




	public String getPrescription() {
		return prescription;
	}




	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}




	
	
	
	
	@Override
	public String toString() {
		return "TreatmentMasterModel [treatmentid=" + treatmentid + ", approximatetime=" + approximatetime
				+ ", apprximatecost=" + apprximatecost + ", totalpaidamount=" + totalpaidamount + ", balanceamount="
				+ balanceamount + ", prescription=" + prescription + ", treatmentDate=" + treatmentDate
				+ ", patientName=" + patientName + ", treatmentName=" + treatmentName + "]";
	}




	public int getTreatmentid() {
		return treatmentid;
	}
	public void setTreatmentid(int treatmentid) {
		this.treatmentid = treatmentid;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
	public String getApproximatetime() {
		return approximatetime;
	}
	public void setApproximatetime(String approximatetime) {
		this.approximatetime = approximatetime;
	}
	public int getApprximatecost() {
		return apprximatecost;
	}
	public void setApprximatecost(int apprximatecost) {
		this.apprximatecost = apprximatecost;
	}
	public int getTotalpaidamount() {
		return totalpaidamount;
	}
	public void setTotalpaidamount(int totalpaidamount) {
		this.totalpaidamount = totalpaidamount;
	}
	public int getBalanceamount() {
		return balanceamount;
	}
	public void setBalanceamount(int balanceamount) {
		this.balanceamount = balanceamount;
	}
	private String patientName;
	private String treatmentName;
	public String getTreatmentName() {
		return treatmentName;
	}
	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}
	
	
	
}
