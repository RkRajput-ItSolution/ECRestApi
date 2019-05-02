package com.usa.nj.gov.ed.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanStatusResponse;

/**
 * This Class method is used for verification business condition About Medicare
 * Plan(This plan only is available for which person is age under 65 or above)
 * 
 * @author Rahul Kumar
 *
 */
public class MedicareRulesService implements IRuleService {

	private static final Logger log = LoggerFactory.getLogger(MedicareRulesService.class);

	/**
	 * Business Logic To Vefify Business Condition
	 */
	@Override
	public PlanStatusResponse executeRules(IndvInfoRequest request) {
		Integer age = request.getAge();
		Double income = request.getMonthlyIncome();
		PlanStatusResponse response = new PlanStatusResponse();
		response.setPlanName(request.getPlanName());

		// verfiy Condition
		if (age >= 65) {
			// Approve condition
			response.setPlanStatus("Activate Plan Done");
			response.setBenefitAmt(400.00);
			response.setPlanStartDate(new Date());
			response.setPlanEndDate(new Date());
		} else {
			// Denied condition
			response.setPlanStatus("DeActive Plan ");
			response.setDenialReason(
					"Sorry! You Are Not Eligible To This Plan Due High Income and Age should be greater than 20 and lessthan 60.");
		}

		return response;
	}

}
