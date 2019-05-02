package com.usa.nj.gov.ed.service;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanStatusResponse;
/**
 * This Class Provide Rules Based on Plan Name According To Request
 * @author Rahul Kumar
 *
 */
@Service
public class EdRulesServiceImpl implements EdRulesService {

	private static final Logger log = LoggerFactory.getLogger(EdRulesServiceImpl.class);

	/**
	 * This method is used to Verify Eligibility Rules based on Plan Name
	 */
	@Override
	public PlanStatusResponse findEligibility(IndvInfoRequest request) {
		log.debug("*****Service Class Method findEligibility Started Successfully.");
		String planName = request.getPlanName();
		PlanStatusResponse response = null;
		try {
			Class clz = Class.forName("com.usa.nj.gov.ed.service." + planName + "RulesService");
			
			Object obj = clz.newInstance();
			
			Method method = clz.getDeclaredMethod("executeRules", IndvInfoRequest.class);
			
			Object retVal = method.invoke(obj, request);
			
			response = (PlanStatusResponse) retVal;
			log.debug("*****Service Class Method findEligibility Ended Successfully.");
			log.info("**** Service class Method findEligibility Excuted Successfully.");
					} 
		catch (Exception e) {
		log.error("***** EdRulesServiceImpl Class Method findEligibility Got Error:::"+e.getMessage());
		}
		
		return response;
	}

}
