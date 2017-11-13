package org.prasad.ratingsnormalization.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.prasad.ratingsnormalization.model.Business;
import org.prasad.ratingsnormalization.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * A simple REST services web-app to facilitate querying current and normalized-ratings of businesses.
 * There are 2 services provided:
 * 1. Get the business entity by passing business name. Name is more user friendly than ID and hence this provision. 
 * 2. Get the list of businesses which are affected by reviews from miser people. 
 * @author DurgaPrasad
 *
 */
@Controller
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	BusinessService businessService;

	static final Logger logger = Logger.getLogger(BusinessController.class);

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public @ResponseBody
	Business getBusiness(@PathVariable("name") String name) {
		Business business = null;
		try {
			business = businessService.getBusinessByName(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return business;
	}
	
	@RequestMapping(value = "/affectedbusinesses", method = RequestMethod.GET)
	public @ResponseBody
	List<Business> getBusiness() {
		List<Business> businesses = null;
		try {
			businesses = businessService.getAffectedBusinesses();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return businesses;
	}
}
