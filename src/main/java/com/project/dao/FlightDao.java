package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Flight;


@Repository
public class FlightDao {
	
	@Autowired
	private SessionFactory sf;
	
	public void add(Flight flight) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		s.save(flight);
		tx.commit();

	}
	
	

}
