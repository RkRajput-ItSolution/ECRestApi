package com.usa.nj.gov.ed.service;

import java.util.Date;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanStatusResponse;
/**
 * 
 * @author Rahul Kumar
 *
 */
public class RIWRulesService implements IRuleService {
/**
 * This methos is used to RIW Business Logic.
 */
	@Override
	public PlanStatusResponse executeRules(IndvInfoRequest request) {
		PlanStatusResponse response = null;
		// logic for rules
		// create PlanInfo class object
		response = new PlanStatusResponse();
		response.setPlanName(request.getPlanName());
		Double income = request.getMonthlyIncome();
		if(income<1000) {
		response.setPlanStatus("Active");
		response.setPlanStartDate(new Date());
		response.setPlanEndDate(new Date());
		response.setBenefitAmt(350.00);
		}
		else {
			response.setPlanStatus("DeActivate");
		response.setDenialReason("you are not eligible for this plan");
		}
		// return planInfo
		return response;
	}

}
