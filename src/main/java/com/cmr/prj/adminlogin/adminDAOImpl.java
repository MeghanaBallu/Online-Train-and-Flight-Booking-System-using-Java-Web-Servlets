package com.cmr.prj.adminlogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import package1.DbConnection;


public class adminDAOImpl implements adminDAO {
static Connection con;
static PreparedStatement pstmt;

	@Override
	public int insertadmin(admin a) {
		int status=0;
		try {
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("insert into admin_signup(?,?)");
			pstmt.setString(1, a.getLogemail());
			pstmt.setString(2, a.getPass());
			
			status=pstmt.executeUpdate();
			//con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public admin getadmin(String emailid, String password) {
		admin a=new admin();
try {
	con=DbConnection.getConnection();
	
	pstmt=con.prepareStatement("select * from admin_signup where loginid=? and pass=?");
	pstmt.setString(1, emailid);
	pstmt.setString(2, password);
	ResultSet rs=pstmt.executeQuery();
	while (rs.next()) {
		
		a.setLogemail(rs.getString(1));
		a.setPass(rs.getString(2));
		}
	}
	catch(Exception e) {
			System.out.println(e);
		}
		
	
		return a;
	}

}