package com.specialized;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "specialize")

public class Specialized implements Serializable {

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	private int id;
	private int consultant_id;
	private String country;
	private String subject;
	
	public Specialized() {
		
	}
	
	public Specialized(int id, int consultant_id, String country, String subject) {
		this.id = id;
		this.consultant_id = consultant_id;
		this.country = country;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConsultant_id() {
		return consultant_id;
	}

	public void setConsultant_id(int consultant_id) {
		this.consultant_id = consultant_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
