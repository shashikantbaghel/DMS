package com.dms.dao;

import java.util.List;

import com.dms.model.TreatmentMasterModel;

public interface TreatmentMasterDao {
	
	boolean saveTreatment(TreatmentMasterModel master);
	List<TreatmentMasterModel> getTreatmentMasterModelByPatientName(String patientName);
	List<TreatmentMasterModel> getTreatmentMasterModelByTreatmentName(String treatNmeName);

}
