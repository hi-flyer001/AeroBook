package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.FlightDao;
import com.project.entity.Flight;

@Service
public class FlightService {
	
	@Autowired
	private FlightDao dao;
	
	public void add(Flight flight) {
		dao.add(flight);
	}
	
	

}
