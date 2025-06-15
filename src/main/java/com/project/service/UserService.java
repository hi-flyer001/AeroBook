package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	public void register(User user) {
		dao.register(user);
	}
	
	public void login(String uname,String password) {
		dao.login(uname, password);
	}

}
