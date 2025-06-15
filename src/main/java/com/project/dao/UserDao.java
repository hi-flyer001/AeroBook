package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	public void login(String uname,String pass) {
		Session s = sf.openSession();
		User user = s.get(User.class, uname);
		
		if(user!=null && user.getPassword().equals(pass)) {
			System.out.println("Login success");
		}
		else {
			System.out.println("Invalid login");
		}
	}

}
