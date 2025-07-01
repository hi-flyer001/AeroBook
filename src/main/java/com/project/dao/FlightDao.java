package com.project.dao;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.DTO.FlightDTO;
import com.project.entity.Airline;
import com.project.entity.Flight;
import com.project.entity.Location;


@Repository
public class FlightDao {
	
	@Autowired
	private SessionFactory sf;
	
	public void add(FlightDTO flightdto) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Airline a1 = s.get(Airline.class, flightdto.getSourceAirlineId());
		Location l1 = s.get(Location.class, flightdto.getSourceLocationId());
		Location l2 = s.get(Location.class, flightdto.getStop1ArrivalLocationId());
		Location l3 = s.get(Location.class, flightdto.getStop1DepartureLocationId());
		Location l4 = s.get(Location.class, flightdto.getDestinationLocationId());
		Flight flight = new Flight();
		flight.setSourceairline(a1);
		flight.setSourceLocation(l1);
		flight.setSourcedepartureTime(LocalDateTime.now());
		flight.setStop1ArrivalLocation(l2);
		flight.setStop1ArrivalDateTime(LocalDateTime.now().plusMinutes(60));
		flight.setStop1DepartureLocation(l3);
		flight.setStop1DepartureDateTime(LocalDateTime.now().plusHours(4));
		flight.setDestionationLocation(l4);
		flight.setDestinationArrivalDateTime(LocalDateTime.now().plusHours(8));
		flight.setPrice(flightdto.getPrice());
		flight.setNo_of_seats(flightdto.getNo_of_seats());
	
		s.save(flight);
		tx.commit();

	}
	
	

}
