package com.usa.nj.gov.ed.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanStatusResponse;

/**
 * This Class method is used for verification business condition About Ccap Plan
 * 
 * @author Rahul Kumar
 *
 */
public class CcapRulesService implements IRuleService {

	private static final Logger log = LoggerFactory.getLogger(CcapRulesService.class);

	/**
	 * Business Logic To Vefify Business Condition
	 */
	@Override
	public PlanStatusResponse executeRules(IndvInfoRequest request) {

		Double income = request.getMonthlyIncome();
		Integer kidsCount = request.getNoOfKids();
		PlanStatusResponse response = new PlanStatusResponse();
		response.setPlanName(request.getPlanName());
		
		//verfiy Condition
		if (income <= 1000 && kidsCount >= 0) {
			// Approve condition 
			response.setPlanStatus("Activate Plan Done");
			response.setBenefitAmt(350.00);
			response.setPlanStartDate(new Date());
			response.setPlanEndDate(new Date());
		} else {
			// Denied condition
			response.setPlanStatus("DeActive Plan ");
			response.setDenialReason("Sorry! You Are Not Eligible To This Plan Due High Income or No Children.");
		}

		return response;
	}

}
