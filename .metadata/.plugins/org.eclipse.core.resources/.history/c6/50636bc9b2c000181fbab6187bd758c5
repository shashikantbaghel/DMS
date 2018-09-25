package com.dms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dms.model.TreatmentMasterModel;


public class TreatmentMasterDaoImpl implements TreatmentMasterDao {

	@Override
	public boolean saveTreatment(TreatmentMasterModel master) {
		
		//save treatment to database
		return true;
	}

	@Override
	public List<TreatmentMasterModel> getTreatmentMasterModelByPatientName(String patientName) {
		//get list of model object using patient name
		List list = null;
		try {
			if(patientName.equalsIgnoreCase("Anuj"))
			{
				list=new ArrayList<TreatmentMasterModel>();
				TreatmentMasterModel masterModel=new TreatmentMasterModel();
				masterModel.setTreatmentid(1);
				masterModel.setPatientName("Anuj");
				masterModel.setTreatmentName("phlia ilaaz");
				masterModel.setTreatmentDate(new Date());
				masterModel.setApproximatetime("2 days");
				masterModel.setApprximatecost(2000);
				masterModel.setBalanceamount(0);
				masterModel.setTotalpaidamount(2000);
				masterModel.setPrescription("");
				list.add(masterModel);
			}
			else if(patientName.equalsIgnoreCase("shashi"))
			{
				list=new ArrayList<TreatmentMasterModel>();
				TreatmentMasterModel masterModel=new TreatmentMasterModel();
				masterModel.setTreatmentid(1);
				masterModel.setPatientName("shashi");
				masterModel.setTreatmentName("dusra ilaaz");
				masterModel.setTreatmentDate(new Date());
				masterModel.setApproximatetime("2 days");	
				masterModel.setApprximatecost(4000);
				masterModel.setBalanceamount(2000);
				masterModel.setTotalpaidamount(2000);
				masterModel.setPrescription("");
				list.add(masterModel);
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<TreatmentMasterModel> getTreatmentMasterModelByTreatmentName(String treatNmeName) {
		
		List list = null;
		try {
			if(treatNmeName.equalsIgnoreCase("Phla Ilaaz"))
			{
				list=new ArrayList<TreatmentMasterModel>();
				TreatmentMasterModel masterModel=new TreatmentMasterModel();
				masterModel.setTreatmentid(1);
				masterModel.setPatientName("Anuj");
				masterModel.setTreatmentName("phlia ilaaz");
				masterModel.setTreatmentDate(new Date());
				masterModel.setApproximatetime("2 days");
				masterModel.setApprximatecost(2000);
				masterModel.setBalanceamount(0);
				masterModel.setTotalpaidamount(2000);
				masterModel.setPrescription("");
				list.add(masterModel);
			}
			else if(treatNmeName.equalsIgnoreCase("Dusra Ilaaz"))
			{
				list=new ArrayList<TreatmentMasterModel>();
				TreatmentMasterModel masterModel=new TreatmentMasterModel();
				masterModel.setTreatmentid(2);
				masterModel.setPatientName("shashi");
				masterModel.setTreatmentName("dusra ilaaz");
				masterModel.setTreatmentDate(new Date());
				masterModel.setApproximatetime("2 days");	
				masterModel.setApprximatecost(4000);
				masterModel.setBalanceamount(2000);
				masterModel.setTotalpaidamount(2000);
				masterModel.setPrescription("");
				list.add(masterModel);
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return list;

	}

	

}
