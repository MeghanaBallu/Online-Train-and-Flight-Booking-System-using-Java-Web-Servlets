package com.cmr.prj.model;

public class paymentdetails {

	public String card_no;
	public String carder_name;
	public int month;
	public int year;
	public int cvv;
	public paymentdetails() {
		super();
		
	}
	public paymentdetails(String card_no, String carder_name, int month, int year, int cvv) {
		super();
		this.card_no = card_no;
		this.carder_name = carder_name;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getCarder_name() {
		return carder_name;
	}
	public void setCarder_name(String carder_name) {
		this.carder_name = carder_name;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "paymentdetails [card_no=" + card_no + ", carder_name=" + carder_name + ", month=" + month + ", year="
				+ year + ", cvv=" + cvv + "]";
	}
	
	
	
}
