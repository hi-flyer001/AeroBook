package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	
	private String payment_mode;
	
	private double amount;
	
	private String status;
	
	@OneToOne
	@JoinColumn(name="bid")
	private Booking booking;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(String payment_mode, double amount, String status, Booking booking) {
		super();
		this.payment_mode = payment_mode;
		this.amount = amount;
		this.status = status;
		this.booking = booking;
	}

	public int getId() {
		return pid;
	}

	public void setId(int pid) {
		this.pid = pid;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", payment_mode=" + payment_mode + ", amount=" + amount + ", status=" + status
				+ ", booking=" + booking + "]";
	}
	
	

}
