package com.cmr.prj.model;

public class f_t {
 private String choose;
 private String num;
 private String name;
 private String from_city;
 private String to_city;
 private String journey_date;
 private String journey_time;
 private String dep_name;
 private int price;
 private String class_type;
public f_t() {
	super();
	// TODO Auto-generated constructor stub
}
public f_t(String choose, String num, String name, String from_city, String to_city, String journey_date,
		String journey_time, String dep_name, int price, String class_type) {
	super();
	this.choose = choose;
	this.num = num;
	this.name = name;
	this.from_city = from_city;
	this.to_city = to_city;
	this.journey_date = journey_date;
	this.journey_time = journey_time;
	this.dep_name = dep_name;
	this.price = price;
	this.class_type = class_type;
}

public String getChoose() {
	return choose;
}
public void setChoose(String choose) {
	this.choose = choose;
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
public void setJourney_date(String date) {
	this.journey_date = date;
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
@Override
public String toString() {
	return "f_t [choose=" + choose + ", num=" + num + ", name=" + name + ", from_city=" + from_city + ", to_city="
			+ to_city + ", journey_date=" + journey_date + ", journey_time=" + journey_time + ", dep_name=" + dep_name
			+ ", price=" + price + ", class_type=" + class_type + "]";
}

  
}
