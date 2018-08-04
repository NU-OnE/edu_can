package com.counsellor;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "counsellor")

public class Counsellor implements Serializable{
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;	
	private int id;
	private String salute;
	private String name;
	private String contact_no;
	private String email;
	private String address;
	
	
	public Counsellor() {
		
	}
	
	public Counsellor(int id, String salute, String name, String contact_no, String email, String address) {
		this.id = id;
		this.salute = salute;
		this.name = name;
		this.contact_no = contact_no;
		this.email = email;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSalute() {
		return salute;
	}


	public void setSalute(String salute) {
		this.salute = salute;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact_no() {
		return contact_no;
	}


	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
