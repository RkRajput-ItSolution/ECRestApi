package com.usa.nj.gov.ed.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "status-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class IndvInfoRequest {

	private Integer indvId;
	private Long ssn;
	private String firstName;
	private String lastName;
	private String planName;
	private Integer age;
	private String gender;
	private Double monthlyIncome;
	private Integer noOfKids;
	private String maritualStatus;
	private boolean qhpPurchased;
	private Double monthlyOtherIncome;
}
