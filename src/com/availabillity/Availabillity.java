package com.availabillity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "availabillity")


public class Availabillity implements Serializable {

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	private int id;
	private int consultant_id;
	private String sun;
	private String mon;
	private String tue;
	private String wed;
	private String thu;
	private String fri;
	private String sat;
	
	public Availabillity() {
		
	}
	
	public Availabillity(int id, int consultant_id, String sun, String mon, String tue, String wed, String thu,
			String fri, String sat) {
		this.id = id;
		this.consultant_id = consultant_id;
		this.sun = sun;
		this.mon = mon;
		this.tue = tue;
		this.wed = wed;
		this.thu = thu;
		this.fri = fri;
		this.sat = sat;
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

	public String getSun() {
		return sun;
	}

	public void setSun(String sun) {
		this.sun = sun;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getTue() {
		return tue;
	}

	public void setTue(String tue) {
		this.tue = tue;
	}

	public String getWed() {
		return wed;
	}

	public void setWed(String wed) {
		this.wed = wed;
	}

	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public String getFri() {
		return fri;
	}

	public void setFri(String fri) {
		this.fri = fri;
	}

	public String getSat() {
		return sat;
	}

	public void setSat(String sat) {
		this.sat = sat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
