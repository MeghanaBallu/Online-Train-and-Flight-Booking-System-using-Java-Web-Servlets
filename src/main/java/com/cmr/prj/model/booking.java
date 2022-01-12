package com.cmr.prj.model;

public class booking {
private String fname;
private String lname;
private String mob;
private String email;
private String booking_date;
private int no_of_persons;
private String address;
public booking() {
	super();
	
}
public booking(String fname, String lname, String mob, String email, String booking_date, int no_of_persons,
		String address) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.mob = mob;
	this.email = email;
	this.booking_date = booking_date;
	this.no_of_persons = no_of_persons;
	this.address = address;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getMob() {
	return mob;
}
public void setMob(String mob) {
	this.mob = mob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBooking_date() {
	return booking_date;
}
public void setBooking_date(String booking_date) {
	this.booking_date = booking_date;
}
public int getNo_of_persons() {
	return no_of_persons;
}
public void setNo_of_persons(int no_of_persons) {
	this.no_of_persons = no_of_persons;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "booking [fname=" + fname + ", lname=" + lname + ", mob=" + mob + ", email=" + email + ", booking_date="
			+ booking_date + ", no_of_persons=" + no_of_persons + ", address=" + address + "]";
}



}
