package com.dms.dao;

import java.util.List;

import com.dms.model.Treatment;

public interface TreatmentDao {

	List<String> getTreatmentNames();
	Treatment getTreatmentbyName(String treatmentName); 
	boolean saveTreatmentInfo(Treatment treatment);
	boolean modifyTreatmentInfo(Treatment treatment);
	boolean deleteTreatmentInfo(Treatment treatment);
	
	
}
