package com.dms.services;

import com.dms.model.TreatmentMasterModel;

public class TreatmentMasterServiceIml implements TreatmentMasterService {

	@Override
	public boolean[] checkTreatmentMasterInfo(TreatmentMasterModel master) {
	boolean patientNameBoolean=false,treatmentNameboolean=false,approximatecostBoolean=false,approximatetimeBoolean=false,totalpaidamountBoolean=false,
			balanceamontboolean=false;
		
		if("".equals(master.getPatientName())||"select".equalsIgnoreCase(master.getPatientName()))
			patientNameBoolean=true;
		
	    if("".equals(master.getTreatmentName())||"select".equalsIgnoreCase(master.getTreatmentName()))
	    	treatmentNameboolean=true;
	    if("".equals(master.getApproximatetime()))
	    	approximatetimeBoolean=true;
	    
	    if("".equals(master.getApprximatecost())||master.getApprximatecost()==0)
	    	approximatecostBoolean=true;
	    if("".equals(master.getTotalpaidamount())||master.getTotalpaidamount()==0)
	    	totalpaidamountBoolean=true;
	    if("".equals(master.getBalanceamount())||master.getBalanceamount()==0)
	    	balanceamontboolean=true;
		
		return new boolean[] {patientNameBoolean,treatmentNameboolean,approximatecostBoolean,approximatetimeBoolean,totalpaidamountBoolean,
				balanceamontboolean};
	}


}
