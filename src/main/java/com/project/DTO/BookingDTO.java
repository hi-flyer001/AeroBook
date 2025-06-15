package com.project.DTO;

import java.util.Date;

public class BookingDTO {
	
	private int uid;
	
	private int fid;
	
	private Date booking_date;
	
	private String payment_mode;
	
	private double amount;
	
	public BookingDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookingDTO(int uid, int fid, Date booking_date, String payment_mode, double amount) {
		super();
		this.uid = uid;
		this.fid = fid;
		this.booking_date = booking_date;
		this.payment_mode = payment_mode;
		this.amount = amount;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
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

	@Override
	public String toString() {
		return "BookingDTO [uid=" + uid + ", fid=" + fid + ", booking_date=" + booking_date + ", payment_mode="
				+ payment_mode + ", amount=" + amount + "]";
	}

	
	
	
	

}
