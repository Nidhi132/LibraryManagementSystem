package org.jss.entity;

public class admin {
	private String username;
	private String password;
	
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
	
	public admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public admin(String username) {
		super();
		this.username = username;
	}
	
	

}