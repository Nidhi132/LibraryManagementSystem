package org.jss.entity;

import java.util.Date;

public class lending {
   private int b_id;
   private String us_id;
   private Date day_out;
   private Date due_date;
public int getB_id() {
	return b_id;
}
public void setB_id(int b_id) {
	this.b_id = b_id;
}
public String getUs_id() {
	return us_id;
}
public void setUs_id(String us_id) {
	this.us_id = us_id;
}
public Date getDay_out() {
	return day_out;
}
public void setDay_out(Date day_out) {
	this.day_out = day_out;
}
public Date getDue_date() {
	return due_date;
}
public void setDue_date(Date due_date) {
	this.due_date = due_date;
}
public lending(int b_id, String us_id, Date day_out, Date due_date) {
	super();
	this.b_id = b_id;
	this.us_id = us_id;
	this.day_out = day_out;
	this.due_date = due_date;
}
public lending(int b_id, String us_id, Date due_date) {
	super();
	this.b_id = b_id;
	this.us_id = us_id;
	this.due_date = due_date;
}
public lending(int b_id, Date day_out, Date due_date) {
	super();
	this.b_id = b_id;
	this.day_out = day_out;
	this.due_date = due_date;
}


   
} 
