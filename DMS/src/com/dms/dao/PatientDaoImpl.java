package com.dms.dao;

import java.util.ArrayList;
import java.util.List;

import com.dms.model.Patient;

public class PatientDaoImpl implements PatientDao {

	@Override
	public boolean savepatient(Patient patient)
	{
		
		//save data to database
		return true;
	}
	@Override
	public Patient getPatientbyName(String patientName) {
		//select given name patient from database
		Patient p=new Patient();
		if(patientName.equals("Anuj")) {
			p.setName("Anuj");
			p.setAddress("Gurgaon");
			p.setMobile("9999999999");
			p.setAge(22);
			p.setSex("MALE");
			p.setStatus("ACTIVE");
		}
		else if(patientName.equals("Shashi")) {
			p.setName("Shashi");
			p.setAddress("Gurgaon");
			p.setMobile("1234567890");
			p.setAge(23);
			p.setSex("MALE");
			p.setStatus("ACTIVE");
		}
	
	
			
		return p;
	}
	@Override
	public List<String> getPatientNames(){
		
		List<String> l=new ArrayList<>();
		//select all name of patients from database and load into list
		l.add("Select");
		l.add("Anuj");
		l.add("Shashi");
		return l;
		
	}
	@Override
	public boolean deltePatient(Patient patient) {
		//delete query
		return true;
	}
	@Override
	public boolean modifyPatient(Patient patient) {
		//update query
		return true;
	}
	

}
