package com.cmr.prj.model;

public class booked {
	private String mode_transport;
	 private String num;
	 private String name;
	 private String from_city;
	 private String to_city;
	 private String journey_date;
	 private String journey_time;
	 private String dep_name;
	 private int price;
	 private String class_type;
	private String cus_name;
	private String mob;
	private String email;
	private int no_of_persons;
	private String seat_numbers;
	public booked() {
		super();
		// TODO Auto-generated constructor stub
	}
	public booked(String mode_transport, String num, String name, String from_city, String to_city, String journey_date,
			String journey_time, String dep_name, int price, String class_type, String cus_name, String mob,
			String email, int no_of_persons, String seat_numbers) {
		super();
		this.mode_transport = mode_transport;
		this.num = num;
		this.name = name;
		this.from_city = from_city;
		this.to_city = to_city;
		this.journey_date = journey_date;
		this.journey_time = journey_time;
		this.dep_name = dep_name;
		this.price = price;
		this.class_type = class_type;
		this.cus_name = cus_name;
		this.mob = mob;
		this.email = email;
		this.no_of_persons = no_of_persons;
		this.seat_numbers = seat_numbers;
	}
	public String getMode_transport() {
		return mode_transport;
	}
	public void setMode_transport(String mode_transport) {
		this.mode_transport = mode_transport;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom_city() {
		return from_city;
	}
	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}
	public String getTo_city() {
		return to_city;
	}
	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}
	public String getJourney_date() {
		return journey_date;
	}
	public void setJourney_date(String journey_date) {
		this.journey_date = journey_date;
	}
	public String getJourney_time() {
		return journey_time;
	}
	public void setJourney_time(String journey_time) {
		this.journey_time = journey_time;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
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
	public int getNo_of_persons() {
		return no_of_persons;
	}
	public void setNo_of_persons(int no_of_persons) {
		this.no_of_persons = no_of_persons;
	}
	public String getSeat_numbers() {
		return seat_numbers;
	}
	public void setSeat_numbers(String seat_numbers) {
		this.seat_numbers = seat_numbers;
	}
	@Override
	public String toString() {
		return "booked [mode_transport=" + mode_transport + ", num=" + num + ", name=" + name + ", from_city="
				+ from_city + ", to_city=" + to_city + ", journey_date=" + journey_date + ", journey_time="
				+ journey_time + ", dep_name=" + dep_name + ", price=" + price + ", class_type=" + class_type
				+ ", cus_name=" + cus_name + ", mob=" + mob + ", email=" + email + ", no_of_persons=" + no_of_persons
				+ ", seat_numbers=" + seat_numbers + "]";
	}
	
	
}
