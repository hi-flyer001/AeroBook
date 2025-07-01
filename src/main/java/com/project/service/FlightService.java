package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DTO.FlightDTO;
import com.project.dao.FlightDao;

@Service
public class FlightService {
	
	@Autowired
	private FlightDao dao;
	
	public void add(FlightDTO flightdto) {
		dao.add(flightdto);
	}
	
	

}
