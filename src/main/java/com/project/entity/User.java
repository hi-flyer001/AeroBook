package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;

	private String name;

	@Column(unique=true)
	private String email;
	
	private String password;
	
	private boolean verify;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int uid, String name, String email, String password, boolean verify) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.verify = verify;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", password=" + password + ", verify="
				+ verify + "]";
	}
	
	
	

	
}
