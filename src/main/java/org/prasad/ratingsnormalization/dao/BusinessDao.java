package org.prasad.ratingsnormalization.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.prasad.ratingsnormalization.model.Business;
import org.springframework.beans.factory.annotation.Autowired;

public class BusinessDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public Business getBusinessByName(String name) throws Exception {
		
		Session session = sessionFactory.openSession();

		Business business = null; 
		try {
			Query query = session.createQuery("from Business where name = :name");
			query.setParameter("name", name);
			
			business = (Business) query.uniqueResult();
			session.close();

		} catch (Exception e) {
			session.close();
		}
		return business;
	}

	public List<Business> getAffectedBusinesses() {
		Session session = sessionFactory.openSession();
		List<Business> businesses = null;
		try{
			Query query = session.createQuery("from Business where stars != normalized_stars");
			businesses = query.list();			
			session.close();
		}catch(Exception e){
			session.close();
		}
		return businesses;
	}

}
