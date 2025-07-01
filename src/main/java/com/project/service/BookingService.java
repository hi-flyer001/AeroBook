package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DTO.BookingDTO;
import com.project.dao.BookingDao;

@Service
public class BookingService {
	
	@Autowired
	private BookingDao dao;
	
	public void book(BookingDTO dto) {
		 
		dao.book(dto);
	}

}
