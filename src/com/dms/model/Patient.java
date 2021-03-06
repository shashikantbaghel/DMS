package com.dms.model;

import java.util.Date;

public class Patient {

	
	
	private String name;
	private String address;
	private String mobile;
	private int age;
	private String sex;
	private String status;
	private Date apponitmentdate;
	
	@Override
	public String toString() {
		return "Patient [name=" + name + ", address=" + address + ", mobile=" + mobile + ", age=" + age + ", sex=" + sex
				+ ", status=" + status + ", apponitmentdate=" + apponitmentdate + "]";
	}
	
	public Patient() {
		
	}
	public Date getApponitmentdate() {
		return apponitmentdate;
	}
	public void setApponitmentdate(Date apponitmentdate) {
		this.apponitmentdate = apponitmentdate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
