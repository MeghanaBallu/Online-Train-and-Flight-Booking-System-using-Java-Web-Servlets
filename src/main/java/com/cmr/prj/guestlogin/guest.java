package com.cmr.prj.guestlogin;

public class guest {
public String email;
public String pass;

public guest() {
	super();
	// TODO Auto-generated constructor stub
}
public guest(String email, String pass) {
	super();
	this.email = email;
	this.pass = pass;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
@Override
public String toString() {
	return "guest [email=" + email + ", pass=" + pass + "]";
}


}
