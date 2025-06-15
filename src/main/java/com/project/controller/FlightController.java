package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Flight;
import com.project.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	@PostMapping("/addFlight")
	public String add(@RequestBody Flight flight) {
		service.add(flight);
		return "Flight added successfully";
	}
	
}
