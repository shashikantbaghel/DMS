package com.dms.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			//p.setApponitmentdate(new Date());
			try {
				p.setApponitmentdate(new SimpleDateFormat( "dd/MM/yyyy" ).parse( "25/12/1995" ));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(patientName.equals("Shashi")) {
			p.setName("Shashi");
			p.setAddress("Gurgaon");
			p.setMobile("1234567890");
			p.setAge(23);
			p.setSex("MALE");
			p.setStatus("ACTIVE");
			try {
				p.setApponitmentdate(new SimpleDateFormat( "dd/MM/yyyy" ).parse( "21/12/1995" ));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	@Override
	public List<String> getPhonenumberListByName(String patientName) {
		//select all phone number for given name
		List<String> l=new ArrayList<String>();
		if(patientName.equalsIgnoreCase("Anuj"))
		{
		 l.add("9540753012");
		 l.add("8700473576");
		 return l;
		}
		else if(patientName.equalsIgnoreCase("shashi"))
		{
			 l.add("1234567890");
			 l.add("1111111111");
			 return l;
		}
		else
		return l;
	}
	@Override
	public List<Patient> getTodayAppointmentPatient() {
		
		  List<Patient> list=new ArrayList<Patient>();
		
			Patient p=new Patient();
	
			p.setName("Anuj");
			p.setAddress("Gurgaon");
			p.setMobile("9999999999");
			p.setAge(22);
			p.setSex("MALE");
			p.setStatus("ACTIVE");
			
			try {
				p.setApponitmentdate(new SimpleDateFormat( "dd/MM/yyyy" ).parse( "25/12/1995" ));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Patient p1=new Patient();
			p1.setName("Shashi");
			p1.setAddress("Gurgaon");
			p1.setMobile("1234567890");
			p1.setAge(23);
			p1.setSex("MALE");
			p1.setStatus("ACTIVE");
			try {
				p1.setApponitmentdate(new SimpleDateFormat( "dd/MM/yyyy" ).parse( "21/12/1995" ));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(p);
			list.add(p1);
		return list;
				
	}
	
	

}
