package com.dms.services;

import com.dms.model.Patient;

public interface PatientService {
	
	boolean[] checkPatientInfo(Patient patient);
    boolean savepatient(Patient patient);
}
