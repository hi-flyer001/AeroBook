package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.FlightDTO;
import com.project.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	@PostMapping("/addFlight")
	public String add(@RequestBody FlightDTO flightdto) {
		service.add(flightdto);
		return "Flight added successfully";
	}
	
}
