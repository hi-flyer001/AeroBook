package com.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;

	
	@ManyToOne
	private Airline sourceairline;
	
	@ManyToOne
	private Location sourceLocation;
	
	private LocalDateTime sourcedepartureTime;


	@ManyToOne
	private Location stop1ArrivalLocation;
	private LocalDateTime stop1ArrivalDateTime;
	
	@ManyToOne
	private Location stop1DepartureLocation;
	private LocalDateTime stop1DepartureDateTime;
	
	@ManyToOne
	private Location destionationLocation;
	private LocalDateTime destinationArrivalDateTime;
	
	private double price;
	private int no_of_seats;
	
	

	public Flight() {
		// TODO Auto-generated constructor stub
	}



	public Flight(int flightId, Airline sourceairline, Location sourceLocation, LocalDateTime sourcedepartureTime,
			Location stop1ArrivalLocation, LocalDateTime stop1ArrivalDateTime, Location stop1DepartureLocation,
			LocalDateTime stop1DepartureDateTime, Location destionationLocation,
			LocalDateTime destinationArrivalDateTime, double price, int no_of_seats) {
		super();
		this.flightId = flightId;
		this.sourceairline = sourceairline;
		this.sourceLocation = sourceLocation;
		this.sourcedepartureTime = sourcedepartureTime;
		this.stop1ArrivalLocation = stop1ArrivalLocation;
		this.stop1ArrivalDateTime = stop1ArrivalDateTime;
		this.stop1DepartureLocation = stop1DepartureLocation;
		this.stop1DepartureDateTime = stop1DepartureDateTime;
		this.destionationLocation = destionationLocation;
		this.destinationArrivalDateTime = destinationArrivalDateTime;
		this.price = price;
		this.no_of_seats = no_of_seats;
	}



	public int getFlightId() {
		return flightId;
	}



	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}



	public Airline getSourceairline() {
		return sourceairline;
	}



	public void setSourceairline(Airline sourceairline) {
		this.sourceairline = sourceairline;
	}



	public Location getSourceLocation() {
		return sourceLocation;
	}



	public void setSourceLocation(Location sourceLocation) {
		this.sourceLocation = sourceLocation;
	}



	public LocalDateTime getSourcedepartureTime() {
		return sourcedepartureTime;
	}



	public void setSourcedepartureTime(LocalDateTime sourcedepartureTime) {
		this.sourcedepartureTime = sourcedepartureTime;
	}



	public Location getStop1ArrivalLocation() {
		return stop1ArrivalLocation;
	}



	public void setStop1ArrivalLocation(Location stop1ArrivalLocation) {
		this.stop1ArrivalLocation = stop1ArrivalLocation;
	}



	public LocalDateTime getStop1ArrivalDateTime() {
		return stop1ArrivalDateTime;
	}



	public void setStop1ArrivalDateTime(LocalDateTime stop1ArrivalDateTime) {
		this.stop1ArrivalDateTime = stop1ArrivalDateTime;
	}



	public Location getStop1DepartureLocation() {
		return stop1DepartureLocation;
	}



	public void setStop1DepartureLocation(Location stop1DepartureLocation) {
		this.stop1DepartureLocation = stop1DepartureLocation;
	}



	public LocalDateTime getStop1DepartureDateTime() {
		return stop1DepartureDateTime;
	}



	public void setStop1DepartureDateTime(LocalDateTime stop1DepartureDateTime) {
		this.stop1DepartureDateTime = stop1DepartureDateTime;
	}



	public Location getDestionationLocation() {
		return destionationLocation;
	}



	public void setDestionationLocation(Location destionationLocation) {
		this.destionationLocation = destionationLocation;
	}



	public LocalDateTime getDestinationArrivalDateTime() {
		return destinationArrivalDateTime;
	}



	public void setDestinationArrivalDateTime(LocalDateTime destinationArrivalDateTime) {
		this.destinationArrivalDateTime = destinationArrivalDateTime;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getNo_of_seats() {
		return no_of_seats;
	}



	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}



	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", sourceairline=" + sourceairline + ", sourceLocation="
				+ sourceLocation + ", sourcedepartureTime=" + sourcedepartureTime + ", stop1ArrivalLocation="
				+ stop1ArrivalLocation + ", stop1ArrivalDateTime=" + stop1ArrivalDateTime + ", stop1DepartureLocation="
				+ stop1DepartureLocation + ", stop1DepartureDateTime=" + stop1DepartureDateTime
				+ ", destionationLocation=" + destionationLocation + ", destinationArrivalDateTime="
				+ destinationArrivalDateTime + ", price=" + price + ", no_of_seats=" + no_of_seats + "]";
	}

	

	



	



}