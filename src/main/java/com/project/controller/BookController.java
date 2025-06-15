package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.BookingDTO;
import com.project.service.BookingService;

@RestController
public class BookController {
	
	@Autowired
	private BookingService service;
	
	@PostMapping("/book")
	public String book(@RequestBody BookingDTO dto) {
		service.book(dto);
		return "Booking successfully";
	}

}
