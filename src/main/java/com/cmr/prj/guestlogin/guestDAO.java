package com.cmr.prj.guestlogin;

public interface guestDAO {
	public int insertguest(guest g);
	
	public guest getguest(String userName, String password);

	
}
