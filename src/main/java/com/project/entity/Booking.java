package com.project.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bid;

    private Date bookingDate;

    @ManyToOne
    @JoinColumn(name="uid")
    private User user;

    @ManyToOne
    @JoinColumn(name="flightId")
    private Flight flight;
    
    public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking( Date bookingDate, User user, Flight flight) {
		super();
		this.bookingDate = bookingDate;
		this.user = user;
		this.flight = flight;
	}

	public long getId() {
		return bid;
	}

	public void setId(long bid) {
		this.bid = bid;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", bookingDate=" + bookingDate + ", user=" + user + ", flight=" + flight + "]";
	}
	
	
	
	
    
    
}
