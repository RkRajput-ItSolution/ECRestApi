package com.usa.nj.gov.ed.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanStatusResponse;

public class SnapRulesService implements IRuleService {

	private static final Logger log = LoggerFactory.getLogger(SnapRulesService.class);

	/**
	 * This method is used to execute SNAP Business Rules
	 */
	@Override
	public PlanStatusResponse executeRules(IndvInfoRequest request) {

		Double income = request.getMonthlyIncome();

		PlanStatusResponse response = new PlanStatusResponse();
		response.setPlanName(request.getPlanName());
		if (income > 1000) {
			// denied
			response.setPlanStatus("DeActivate Plan");
			response.setDenialReason("Sorry! You Are Not Eligible For This Plan...! "
					+ "Due To High Income. ThankYou For Your Interest.");
		} else {
			// approved
			response.setPlanStatus("AP");
			response.setBenefitAmt(300.00);
			response.setPlanStartDate(new Date());
			response.setPlanEndDate(new Date());// add +30
		}
	
		return response;
	}

}
