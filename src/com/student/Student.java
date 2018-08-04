package com.student;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "student")

public class Student implements Serializable {

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;	 
	private int id;
	private String name;
	private String gender;
	private String contact_no;
	private String email;
	
	public Student(int id, String name, String gender, String contact_no, String email) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.contact_no = contact_no;
		this.email = email;
	}
	
	
	public Student() {
		
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getGender() {
		return gender;
	}


	public String getContact_no() {
		return contact_no;
	}


	public String getEmail() {
		return email;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	

}
