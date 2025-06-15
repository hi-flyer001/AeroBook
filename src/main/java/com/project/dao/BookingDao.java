package com.project.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.DTO.BookingDTO;
import com.project.entity.Booking;
import com.project.entity.Flight;
import com.project.entity.Payment;
import com.project.entity.User;

@Repository
public class BookingDao {
	
	@Autowired
	private SessionFactory sf;
	
	public void book(BookingDTO book) {		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		User u = s.get(User.class, book.getUid());
		Flight f = s.get(Flight.class, book.getFid());
		if(u==null || f==null) {
			throw new RuntimeException("User not found");
		}
		Booking b = new Booking();
		b.setUser(u);
		b.setFlight(f);
		b.setBookingDate(new Date());
		s.save(b);
	
		Payment pay = new Payment();
		pay.setPayment_mode(book.getPayment_mode());
		pay.setAmount(book.getAmount());
		pay.setStatus("Success");
		pay.setBooking(b);
		
		
		s.save(pay);
		
		tx.commit();
		
	}

}
