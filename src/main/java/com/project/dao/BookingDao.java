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
		if(f.getPrice()!=book.getAmount()) {
			throw new RuntimeException("please pay valid amount");
		}
		if(f.getNo_of_seats()<0) {
			throw new RuntimeException("no seats available");
		}
		
		
		
		f.setNo_of_seats(f.getNo_of_seats()-book.getNo_of_seats());
		double amount = book.getAmount()*book.getNo_of_seats();
		
		Booking b = new Booking();
		b.setUser(u);
		b.setFlight(f);
		b.setBookingDate(new Date());
		b.setNo_of_seats(book.getNo_of_seats());
		s.save(b);
	
		Payment pay = new Payment();
		pay.setPayment_mode(book.getPayment_mode());
		pay.setAmount(amount);
		pay.setStatus("Success");
		pay.setBooking(b);
		s.update(f);
		
		s.save(pay);
		
		tx.commit();
		
	}

}
