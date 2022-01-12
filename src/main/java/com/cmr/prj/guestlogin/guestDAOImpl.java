package com.cmr.prj.guestlogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import package1.DbConnection;

public class guestDAOImpl implements guestDAO {

	static Connection con;
	static PreparedStatement pstmt;

		@Override
		
		public int insertguest(guest g) {
			int status=0;
			try {
				con=DbConnection.getConnection();
				pstmt=con.prepareStatement("insert into guest_signup(?,?)");
				pstmt.setString(1, g.getEmail());
				pstmt.setString(2, g.getPass());
				
				status=pstmt.executeUpdate();
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			return status;
		}

		@Override
		public guest getguest(String userName, String password) {
			guest g=new guest();
	try {
		con=DbConnection.getConnection();
		
		pstmt=con.prepareStatement("select * from guest_signup where email=? and pass=?");
		pstmt.setString(1, userName);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			
			g.setEmail(rs.getString(1));
			g.setPass(rs.getString(2));
			}
		}
		catch(Exception e) {
				System.out.println(e);
			}
			
		
			return g;
		}

		

		

	}