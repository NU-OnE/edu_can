package com.token;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "token")

public class Token implements Serializable {

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	private int id;
	private int user_id;
	private String token;
	private String name;
	private String type;
	private String expire_at;
	private String created_at;
	
	
	public Token() {
		
	}
	
	public Token(int id, int user_id, String token,  String name, String type, String expire_at, String created_at) {
		this.id = id;
		this.user_id = user_id;
		this.token = token;
		this.name = name;
		this.type = type;
		this.expire_at = expire_at;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getExpire_at() {
		return expire_at;
	}

	public void setExpire_at(String expire_at) {
		this.expire_at = expire_at;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
