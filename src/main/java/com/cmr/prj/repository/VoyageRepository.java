package com.cmr.prj.repository;
import java.util.*;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import com.cmr.prj.guestlogin.guest;
 
import com.cmr.prj.model.booked;
import com.cmr.prj.model.booking;
import com.cmr.prj.model.f_t;
import com.cmr.prj.model.paymentdetails;



public class VoyageRepository {


public List<f_t> getAllTravelInfo(String query){
	
	List<f_t> flight_trainList=new ArrayList<f_t>();
	try {
		
		
		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		String SQLQUERY;
		PreparedStatement pstmt;
		if(query!=null) {
			
			
			SQLQUERY="select * from add_f_t where choose like '%"+query+"%' or name like '%"+query+"%' or num like '%"+query+"%' or from_city like '%"+query+"%' or to_city like '%"+query+"%' or journey_date like '%"+query+"%' or journey_time like '%"+query+"%' or dep_name like '%"+query+"%' or class_type like '%"+query+"%'"; 
			pstmt=con.prepareStatement(SQLQUERY);
			
		}
		else {
		 SQLQUERY="select * from add_f_t";
		
		pstmt=con.prepareStatement(SQLQUERY);
		}
		
		//System.out.println("PreparedStatement is created successfully..");
		
		ResultSet rs=pstmt.executeQuery();
		//System.out.println("Statement executed successfully");
		
		
		while(rs.next())
		{
		f_t fl_tr= new f_t();
		fl_tr.setChoose(rs.getString(1));
		fl_tr.setNum(rs.getString(2));
		
		fl_tr.setName(rs.getString(3));
		
		fl_tr.setFrom_city(rs.getString(4));
		
		fl_tr.setTo_city(rs.getString(5));
		
		
		fl_tr.setJourney_date(rs.getString(6));
		fl_tr.setJourney_time(rs.getString(7));
		
		
		fl_tr.setDep_name(rs.getString(8));
		
		fl_tr.setPrice(rs.getInt(9));
		fl_tr.setClass_type(rs.getString(10));
		
		flight_trainList.add(fl_tr);
		}
		
		
		rs.close();
		pstmt.close();
		//con.close();
		
		
		
	}
	
	catch (SQLException e) {
		 System.out.println(e); 
	}
	return flight_trainList;
}

public int updatef_t(f_t fl_tr){
	
	int res=0;
	
	try {
		
		
		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		
		final String SQLQUERY="update add_f_t set choose=?,name=?,from_city=?,to_city=?,journey_date=?,journey_time=?,dep_name=?,price=?,class_type=? where num like ?";
		PreparedStatement pstmt=con.prepareStatement(SQLQUERY);
		
		//System.out.println("PreparedStatement is created successfully..");
		
		
		pstmt.setString(1, fl_tr.getChoose());
		
		pstmt.setString(2, fl_tr.getName());
		
		pstmt.setString(3, fl_tr.getFrom_city());
		
		pstmt.setString(4, fl_tr.getTo_city());
		
		
		
		String s=fl_tr.getJourney_date();
        int j=s.length();
        String x="";
        int i=0;
        for ( i=0;i<j;i++){
            char c = s.charAt(i);
            if (c=='-')
            {
                
                break;
            }
            x=x+c;
          
        }
       
       String  y="";
        for ( i=i+1;i<j;i++){
            char c = s.charAt(i);
            
            if (c=='-')
            {
                
                break;
            }
            y=y+c;
            
           
        }
        String z="";
        for ( i=i+1;i<j;i++){
            char c = s.charAt(i);
            if (c=='-')
            {
                
                break;
            }
            z=z+c;
            
            
        }
          String  rt=z+"/"+y+"/"+x;
         //System.out.println(rt);
         
		
		
		pstmt.setString(5,rt );
		pstmt.setString(6, fl_tr.getJourney_time());
		
		pstmt.setString(7, fl_tr.getDep_name());
		
		
		pstmt.setInt(8, fl_tr.getPrice());
		pstmt.setString(9, fl_tr.getClass_type());
		pstmt.setString(10, fl_tr.getNum());
		
		res=pstmt.executeUpdate();
		
		pstmt.close();
		
		
	}
	
	catch (SQLException e) {
		 System.out.println(e); 
	}

	return res;
}

public int deletef_t(String num){
	
	int res=0;
	
	try {
		
		
		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		
		final String SQLQUERY="delete from add_f_t where num like ?";
		PreparedStatement pstmt=con.prepareStatement(SQLQUERY);
		
		//System.out.println("PreparedStatement is created successfully..");
		
		
		pstmt.setString(1, num);
		
		res=pstmt.executeUpdate();
		
		pstmt.close();
		
		
	}
	
	catch (SQLException e) {
		 System.out.println(e); 
	}

	return res;
}

public int insert_f_t(f_t fl_tr){
	
	int res=0;
	
	try {

		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		
		final String SQLQUERY="insert into add_f_t values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(SQLQUERY);
		
		//System.out.println("PreparedStatement is created successfully..");

		pstmt.setString(1, fl_tr.getChoose());
		//System.out.println(fl_tr.getChoose());
		
		pstmt.setString(2, fl_tr.getNum());
		//System.out.println(fl_tr.getNum());
		
		
		pstmt.setString(3, fl_tr.getName());
		pstmt.setString(4, fl_tr.getFrom_city());	
		pstmt.setString(5, fl_tr.getTo_city());
		
	
		String s=fl_tr.getJourney_date();
        int j=s.length();
        String x="";
        int i=0;
        for ( i=0;i<j;i++){
            char c = s.charAt(i);
            if (c=='-')
            {
                
                break;
            }
            x=x+c;
          
        }
       
       String  y="";
        for ( i=i+1;i<j;i++){
            char c = s.charAt(i);
            
            if (c=='-')
            {       
                break;
            }
            y=y+c;
    
        }
        String z="";
        for ( i=i+1;i<j;i++){
            char c = s.charAt(i);
            if (c=='-')
            {
                
                break;
            }
            z=z+c;  
        }
          String  rt=z+"/"+y+"/"+x;
         //System.out.println(rt);
         
		pstmt.setString(6,rt );
		pstmt.setString(7, fl_tr.getJourney_time());
		pstmt.setString(8, fl_tr.getDep_name());
		pstmt.setInt(9, fl_tr.getPrice());
		pstmt.setString(10, fl_tr.getClass_type());
		
		res=pstmt.executeUpdate();
		
		pstmt.close();
		
		
	}
	
	catch (SQLException e) {
	
		 System.out.println(e); 
		 
	}
	return res;
}

public int insert_booking(booking book){
	
	int res=0;
	
	try {

		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		
		final String SQLQUERY="insert into booking values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(SQLQUERY);
		
		//System.out.println("PreparedStatement is created successfully..");

		pstmt.setString(1, book.getFname());
		//System.out.println(book.getFname());
		pstmt.setString(2, book.getLname());
		pstmt.setString(3, book.getMob());	
		pstmt.setString(4, book.getEmail());
	
		String s=book.getBooking_date();
        int j=s.length();
        String x="";
        int i=0;
        for ( i=0;i<j;i++){
            char c = s.charAt(i);
            if (c=='-')
            {
                
                break;
            }
            x=x+c;
          
        }
       
       String  y="";
        for ( i=i+1;i<j;i++){
            char c = s.charAt(i);
            
            if (c=='-')
            {       
                break;
            }
            y=y+c;
    
        }
        String z="";
        for ( i=i+1;i<j;i++){
            char c = s.charAt(i);
            if (c=='-')
            {
                
                break;
            }
            z=z+c;  
        }
          String  rt=z+"/"+y+"/"+x;
         //System.out.println(rt);
         
         pstmt.setString(5, rt);
		pstmt.setInt(6, book.getNo_of_persons());
		pstmt.setString(7, book.getAddress());
		
		
		res=pstmt.executeUpdate();
		
		pstmt.close();
		
		
	}
	
	catch (SQLException e) {
	
		 System.out.println(e); 
		 
	}
	return res;
}

public int insert_payment(paymentdetails details){
	
	int res=0;
	
	try {

		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		
		final String SQLQUERY="insert into payment values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(SQLQUERY);
		
		//System.out.println("PreparedStatement is created successfully..");

		pstmt.setString(1, details.getCard_no());
		
		pstmt.setString(2, details.getCarder_name());
		pstmt.setInt(5, details.getCvv());	
		pstmt.setInt(4, details.getYear());
        pstmt.setInt(3,details.getMonth());
		
		
		res=pstmt.executeUpdate();
		
		pstmt.close();
		
		
	}
	
	catch (SQLException e) {
	
		 System.out.println(e); 
		 
	}
	return res;
}

public void insert_bookeddetails(booked bk){
	

	
	try {

		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		
		final String SQLQUERY="insert into booked values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(SQLQUERY);
		
		//System.out.println("PreparedStatement is created successfully..");
       
		pstmt.setString(1, bk.getMode_transport());
		pstmt.setString(2, bk.getNum());
		pstmt.setString(3, bk.getName());
		pstmt.setString(4, bk.getFrom_city());	
		pstmt.setString(5, bk.getTo_city());
    
		String s=bk.getJourney_date();
        int j=s.length();
        String x="";
        int i=0;
        for ( i=0;i<j;i++){
            char c = s.charAt(i);
            if (c=='-')
            {
                
                break;
            }
            x=x+c;
          
        }
       
       String  y="";
        for ( i=i+1;i<j;i++){
            char c = s.charAt(i);
            
            if (c=='-')
            {       
                break;
            }
            y=y+c;
    
        }
        String z="";
        for ( i=i+1;i<j;i++){
            char c = s.charAt(i);
            if (c=='-')
            {
                
                break;
            }
            z=z+c;  
        }
          String  rt=z+"/"+y+"/"+x;
       
         
		pstmt.setString(6,rt );
		pstmt.setString(7, bk.getJourney_time());
		pstmt.setString(8, bk.getDep_name());
		pstmt.setInt(9, bk.getPrice());
		pstmt.setString(10, bk.getClass_type());
		pstmt.setString(11, bk.getCus_name());
		pstmt.setString(12, bk.getMob());	
		pstmt.setString(13, bk.getEmail());
		pstmt.setInt(14, bk.getNo_of_persons());
	
		String[] array={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};  
		 java.util.Random random = new java.util.Random();
		 int p=bk.getNo_of_persons();
		 String s1="";
		 
		 for (int i1=0;i1<3;i1++){
   	    	int random_string = random.nextInt(array.length);
   	    	s1=s1+array[random_string];

   	        }
		 //System.out.println(s1);
		 String q = "";
		 for (int j1=1;j1<=p;j1++)
		 { 
			  
			 if(j1==(p)){
		         
	      	q=q+s1+j1;
		     }
		     else{
		         
	      	q=q+s1+j1+",";
		     }
			// System.out.println(q);
		     
		 }
		 //System.out.println(s1);
		// System.out.println(q);
		 pstmt.setString(15, q);
		
	
		pstmt.executeUpdate();
		pstmt.close();
		
		
	}
	
	catch (SQLException e) {
	
		 System.out.println(e); 
		 
	}
	
}

public List<booked> getAllAdminInfo(String query){
	
	List<booked> bookedList=new ArrayList<booked>();
	try {
		
		
		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		String SQLQUERY;
		PreparedStatement pstmt;
		if(query!=null) {
			
			//SQLQUERY="select * from booked where mode_transport like ? or name like ? or num like ? or from_city like ? or to_city like ? or journey_date like ? or journey_time like ? or dep_name like ? or class_type like ? or cus_name like ? or mob like ? or email like ?";
			SQLQUERY="select * from booked where mode_transport like '%"+query+"%' or name like '%"+query+"%' or num like '%"+query+"%' or from_city like '%"+query+"%' or to_city like '%"+query+"%' or journey_date like '%"+query+"%' or journey_time like '%"+query+"%' or dep_name like '%"+query+"%' or class_type like '%"+query+"%' or cus_name like '%"+query+"%' or mob like '%"+query+"%' or email like '%"+query+"%' or seat_numbers like '%"+query+"%'"; 
			pstmt=con.prepareStatement(SQLQUERY);
			
		}
		else {
		 SQLQUERY="select * from booked";
		
		pstmt=con.prepareStatement(SQLQUERY);
		}
		//System.out.println("PreparedStatement is created successfully..");
		
		
		ResultSet rs=pstmt.executeQuery();
		//System.out.println("Statement executed successfully");
		
		
		while(rs.next())
		{
		booked book= new booked();
		book.setMode_transport(rs.getString(1));
		book.setName(rs.getString(3));
		book.setNum(rs.getString(2));
		book.setFrom_city(rs.getString(4));
		book.setTo_city(rs.getString(5));
		//System.out.println(rs.getString(6));
		String s=rs.getString(6);
      
        String x="";
         int i;
        for ( i=0;i<10;i++){
            char c = s.charAt(i);
           
            x=x+c;
          
        }

    
		book.setJourney_date(x);
		
		book.setJourney_time(rs.getString(7));
		book.setDep_name(rs.getString(8));
		book.setPrice(rs.getInt(9));
		book.setClass_type(rs.getString(10));
		book.setCus_name(rs.getString(11));
		book.setMob(rs.getString(12));
		book.setEmail(rs.getString(13));
		book.setNo_of_persons(rs.getInt(14));
		//System.out.println(rs.getString(15));
		book.setSeat_numbers(rs.getString(15));
		
		bookedList.add(book);
		}
		
		
		rs.close();
		pstmt.close();
		//con.close();
		
		
		
	}
	
	catch (SQLException e) {
		 System.out.println(e); 
	}
	return bookedList;
}

public int insert_guest(guest gu){
	
	int res=0;
	
	try {

		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		
		final String SQLQUERY="insert into guest_signup values(?,?)";
		PreparedStatement pstmt=con.prepareStatement(SQLQUERY);
		
		//System.out.println("PreparedStatement is created successfully..");

		pstmt.setString(1, gu.getEmail());
		
		pstmt.setString(2, gu.getPass());
		
		
		
		res=pstmt.executeUpdate();
		
		pstmt.close();
		
		
	}
	
	catch (SQLException e) {
	    
		 System.out.println(e); 
		 
	}
	return res;
}

public List<booked> getAllGuest_BookedInfo(String query,String f_query){
	
	List<booked> bookedList=new ArrayList<booked>();
	try {
		
		
		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		String SQLQUERY;
		PreparedStatement pstmt;
		
			
		if(f_query!=null) {
			
			
			SQLQUERY="select * from booked where email like '%"+f_query+"%' and email like '%"+f_query+"%' or mode_transport like '%"+f_query+"%' or name like '%"+f_query+"%' or num like '%"+f_query+"%' or from_city like '%"+f_query+"%' or to_city like '%"+f_query+"%' or journey_date like '%"+f_query+"%' or journey_time like '%"+f_query+"%' or dep_name like '%"+f_query+"%' or class_type like '%"+f_query+"%' or cus_name like '%"+f_query+"%' or mob like '%"+f_query+"%' or seat_numbers like '%"+f_query+"%'"; 
			pstmt=con.prepareStatement(SQLQUERY);
			
		}
		else {
			SQLQUERY="select * from booked where email like ?";
		
		pstmt=con.prepareStatement(SQLQUERY);
		pstmt.setString(1, query);
		}
			
			 
		//System.out.println("PreparedStatement is created successfully..");
		
		
		ResultSet rs=pstmt.executeQuery();
		//System.out.println("Statement executed successfully");
		
		
		while(rs.next())
		{
		booked book= new booked();
		book.setMode_transport(rs.getString(1));
		book.setName(rs.getString(3));
		book.setNum(rs.getString(2));
		book.setFrom_city(rs.getString(4));
		book.setTo_city(rs.getString(5));
		//System.out.println(rs.getString(6));
		String s=rs.getString(6);
      
        String x="";
         int i;
        for ( i=0;i<10;i++){
            char c = s.charAt(i);
           
            x=x+c;
          
        }

    
		book.setJourney_date(x);
		
		book.setJourney_time(rs.getString(7));
		book.setDep_name(rs.getString(8));
		book.setPrice(rs.getInt(9));
		book.setClass_type(rs.getString(10));
		book.setCus_name(rs.getString(11));
		book.setMob(rs.getString(12));
		book.setEmail(rs.getString(13));
		book.setNo_of_persons(rs.getInt(14));
		//System.out.println(rs.getString(15));
		book.setSeat_numbers(rs.getString(15));
		bookedList.add(book);
		}
		
		
		rs.close();
		pstmt.close();
		//con.close();
		
		
		
	}
	
	catch (SQLException e) {
		 System.out.println(e); 
	}
	return bookedList;
}

public int guest_forgot_password(guest gt){
	
	int res=0;
	
	try {
		
		
		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		
		final String SQLQUERY="update guest_signup set pass=? where email like ?";
		PreparedStatement pstmt=con.prepareStatement(SQLQUERY);
		
		//System.out.println("PreparedStatement is created successfully..");
		
		
		pstmt.setString(2, gt.getEmail());
		
		pstmt.setString(1, gt.getPass());
		
		
		
		res=pstmt.executeUpdate();
		
		pstmt.close();
		
		
	}
	
	catch (SQLException e) {
		 System.out.println(e); 
	}

	return res;
}
public int guest_reset_password(guest gt, String newpass){
	
	int res=0;
	
	try {
		
		
		Connection con=DbConnection.getConnection();
		//System.out.println("Established connection successfully");
		
		final String SQLQUERY="update guest_signup set pass=? where email like ? and pass like ?";
		PreparedStatement pstmt=con.prepareStatement(SQLQUERY);
		
		//System.out.println("PreparedStatement is created successfully..");
		
		pstmt.setString(1, newpass);
		pstmt.setString(2, gt.getEmail());
		
		pstmt.setString(3, gt.getPass());

		res=pstmt.executeUpdate();
		
		pstmt.close();
		
		
	}
	
	catch (SQLException e) {
		 System.out.println(e); 
	}

	return res;
}


}