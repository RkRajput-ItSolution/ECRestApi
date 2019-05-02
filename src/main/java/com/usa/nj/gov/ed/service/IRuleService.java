package com.usa.nj.gov.ed.service;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanStatusResponse;

public interface IRuleService {

	public PlanStatusResponse executeRules(IndvInfoRequest request);

}
