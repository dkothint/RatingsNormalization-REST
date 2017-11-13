package org.prasad.ratingsnormalization.services;

import java.util.List;

import org.prasad.ratingsnormalization.dao.BusinessDao;
import org.prasad.ratingsnormalization.model.Business;
import org.springframework.beans.factory.annotation.Autowired;

public class BusinessService {

	@Autowired
	BusinessDao businessDao;
	
	public Business getBusinessByName(String name) throws Exception {
		return businessDao.getBusinessByName(name);
	}

	public List<Business> getAffectedBusinesses() {
		return businessDao.getAffectedBusinesses();
	}
}
