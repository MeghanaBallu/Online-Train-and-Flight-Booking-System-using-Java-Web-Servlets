package com.cmr.prj.adminlogin;

public interface adminDAO {
	public int insertadmin(admin a);
	public admin getadmin(String emailid,String password);
}
