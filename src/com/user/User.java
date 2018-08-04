package com.user;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String role;
	private String password;
	private String email;
	private int active;
	
	
	public User(int id, String name, String role, String password, String email, int active) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
		this.email = email;
		this.active = active;
	}

	
	public User() {
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
