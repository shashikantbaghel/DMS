package com.dms.dao;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

import com.dms.model.Treatment;

public class TreatmentDaoimpl  implements TreatmentDao{

	@Override
	public List<String> getTreatmentNames() {
		List<String> l=new ArrayList<>();
		//select all name of patients from database and load into list
		l.add("Select");
		l.add("Phla Ilaaz");
		l.add("Dusra Ilaaz");
		return l;
		
	}

	@Override
	public boolean saveTreatmentInfo(Treatment treatment) {
		//save data Query
		return true;
	}

	@Override
	public boolean modifyTreatmentInfo(Treatment treatment) {
		//update data Query
		return true;
	}

	@Override
	public boolean deleteTreatmentInfo(Treatment treatment) {
		//delete data Query
		return true;
	}

	@Override
	public Treatment getTreatmentbyName(String treatmentName) {
		//query to get treatment from database using treatment name
		Treatment treatment=new Treatment();
		if(treatmentName.equalsIgnoreCase("Phla Ilaaz"))
		{
		
		treatment.setName("Phla Ilaaz");
		treatment.setCost(20000);
		treatment.setTime("2 days");
		return treatment;
		}
		else if(treatmentName.equalsIgnoreCase("dusra Ilaaz"))
		{
		
		treatment.setName("Dusra Ilaaz");
		treatment.setCost(40000);
		treatment.setTime("4 days");
		return treatment;
		}
		return treatment;
		
	} 

}
