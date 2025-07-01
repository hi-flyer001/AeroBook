package com.project.service;

import java.time.LocalDateTime;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.entity.OTP;
import com.project.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private EmailService email;
	
	@Autowired
	private PasswordEncoder ps;
	
	  @Autowired
	 private SessionFactory sf;

	    // Step 1: Accept details, only generate OTP, don't save user
	    public void register(User u) {
	        OTP otp = dao.generateOTP(u.getEmail());  // just generates OTP, links it to unsaved user
	        email.sendOtpEmail(u.getEmail(), otp.getCode());
	   //     System.out.println("OTP sent: " + u.getEmail());
	    }

	    // Step 2: Verify OTP, then save user in DB
	    public String verify(User u, int otp) {
	    	User byId = dao.getById(u.getUid());
	    	if(byId==null) {
	    		System.out.println("User not found");
	    	}
	    	
	        OTP latest = dao.resend(u.getEmail());

	        if (latest == null) return "❌ No OTP found";
	        if (latest.getCode() != otp) return "❌ Invalid OTP";
	        if (latest.getExpiredAt().isBefore(LocalDateTime.now())) return "❌ OTP expired";

	        // Save verified user now
	        String hash = ps.encode(u.getPassword());
	        u.setPassword(hash);
	        u.setVerify(true);
	        dao.register(u); // finally save user after verification

	        return "✅ OTP verified and user registered successfully!";
	    }

	    // Optional: Resend logic
	    public void resend(User u) {
	        OTP latest = dao.resend(u.getEmail());
	        if (latest != null && latest.getCreatedAt().plusSeconds(60).isAfter(LocalDateTime.now())) {
	            System.out.println("⚠️ Wait for 1 minute before resending OTP.");
	        } else {
	            OTP newOtp = dao.generateOTP(u.getEmail());
	            System.out.println("🔁 New OTP: " + newOtp.getCode());
	        }
	    }
	
	

}
