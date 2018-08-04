package com.utilities;
import java.io.Serializable;

import javax.json.Json;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "response_result")

public class ResposeResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Boolean is_error;
	private String result;
	
	
	public ResposeResult(Boolean is_error, String result) {
		this.is_error = is_error;
		this.result = result;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Boolean getIs_error() {
		return is_error;
	}
	
	public Object getResult() {
		return result;
	}


	public void setIs_error(Boolean is_error) {
		this.is_error = is_error;
	}


	public void setResult(String result) {
		this.result = result;
	}

	
}
