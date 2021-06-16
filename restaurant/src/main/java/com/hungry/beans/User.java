package com.hungry.beans;

public class User {

	private int user_id;
	private String username;
	private String password;
	private String phone;
	private String identity;
	
	public User(int user_id, String username, String password, String phone, String identity) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.identity=identity;
		
	}
	
	public User( String username, String password, String phone, String identity) {
		super();
		
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.identity=identity;
		
	}
	public User( String phone,String password,String identity) {
		super();
		this.password = password;
		this.phone = phone;
		this.identity=identity;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", identity=" + identity + "]";
	}

	

	
	
	
	
}
