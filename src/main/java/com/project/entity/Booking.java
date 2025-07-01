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
    
    private int no_of_seats;
    
    public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking( Date bookingDate, User user, Flight flight,int no_of_seats) {
		super();
		this.bookingDate = bookingDate;
		this.user = user;
		this.flight = flight;
		this.no_of_seats=no_of_seats;
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
	
	

	public int getNo_of_seats() {
		return no_of_seats;
	}

	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", bookingDate=" + bookingDate + ", user=" + user + ", flight=" + flight + "]";
	}
	
	
	
	
    
    
}
