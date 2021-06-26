package org.jss.entity;

public class User {
	private String u_id;
	private String name;
	private int age;
	private long phone;
	private String address;
	private String password;
	
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String u_id, String name, int age, long phone, String address, String password) {
		super();
		this.u_id = u_id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}
	
	public User(String u_id, String name, String address) {
		super();
		this.u_id = u_id;
		this.name = name;
		this.address = address;
	}
	public User(String u_id, String password) {
		super();
		this.u_id = u_id;
		this.password = password;
	}
	
	

}
