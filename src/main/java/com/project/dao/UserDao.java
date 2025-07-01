package com.project.dao;

import java.time.LocalDateTime;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.OTP;
import com.project.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private SessionFactory sf;
	
	public void register(User user) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		
	}
	
	public OTP generateOTP(String email) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Random r = new Random();
		int otp_no = r.nextInt(100000,999999);
		OTP otp = new OTP();
		
		otp.setCode(otp_no);
		otp.setCreatedAt(LocalDateTime.now());
		otp.setExpiredAt(LocalDateTime.now().plusMinutes(5));
		otp.setEmail(email);
		s.save(otp);
		tx.commit();
		return otp;
		
	}
	
	public OTP resend(String email) {
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(OTP.class);
		
		cr.add(Restrictions.eq("email", email));
		
		cr.addOrder(Order.desc("createdAt"));
		
		cr.setMaxResults(1);
		
		OTP latest = (OTP)cr.uniqueResult();
		
		return latest;
		
	}
	
	public User getById(int id) {
		Session s = sf.openSession();
		User user = s.get(User.class, id);
		
		return user;
		
	}
	
//	public void login(String uname,String pass) {
//		Session s = sf.openSession();
//		User user = s.get(User.class, uname);
//		
//		if(user!=null && user.getPassword().equals(pass)) {
//			System.out.println("Login success");
//		}
//		else {
//			System.out.println("Invalid login");
//		}
//	}

}
