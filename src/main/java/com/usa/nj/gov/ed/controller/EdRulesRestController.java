package com.usa.nj.gov.ed.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanStatusResponse;
import com.usa.nj.gov.ed.service.EdRulesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:9090/v2/api-docs
//http://localhost:9090/swagger-ui.html

@RestController
@Api(value = "EDRestApi", description = "This is used to Verify plan Info........")
public class EdRulesRestController {
	private static final Logger logger = LoggerFactory.getLogger(EdRulesRestController.class);
	@Autowired
	private EdRulesService service;

	@ApiOperation(httpMethod = "POST", produces = "text/html", value = "This is used to Verify Info About Plan Eligibility...", response = String.class, tags = "getWelcomeNote")
	@PostMapping(value = "/determineElig", consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public @ResponseBody PlanStatusResponse checkEligibility(@RequestBody IndvInfoRequest request) {

		logger.debug("*****Rest Controller Method Started successfully*****");

		PlanStatusResponse response = service.findEligibility(request);

		logger.debug("*****Rest Controller Method Ended Successfully ***** ");
		logger.info("********Rest Controller Method Excecuted Successfully *****");

		return response;
	}

}
