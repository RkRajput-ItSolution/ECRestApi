package com.usa.nj.gov.ed.service;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanStatusResponse;

public interface EdRulesService {

	public PlanStatusResponse findEligibility(IndvInfoRequest request);
}
