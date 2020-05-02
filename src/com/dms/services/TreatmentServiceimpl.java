package com.dms.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dms.model.Treatment;

public class TreatmentServiceimpl implements TreatmentService {

	@Override
	public boolean[] checktreatmentinfo(Treatment treatment) {
		boolean treatmentnameBoolean=false,treatmentcostBoolean=false,treatmenttimeBoolean=false;
		
		String regex = "[+-]?[0-9][0-9]*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(Integer.toString(treatment.getCost()));
		
		if("".equals(treatment.getName()))
			treatmentnameBoolean=true;
		if("".equals(treatment.getCost())||!m.matches()||treatment.getCost()==0)
			treatmentcostBoolean=true;
		if("".equals(treatment.getTime()))
			treatmenttimeBoolean=true;
		return new boolean[] {treatmentnameBoolean,treatmentcostBoolean,treatmenttimeBoolean};
	}

}
