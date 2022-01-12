package com.cmr.prj.guestlogin;

import java.io.IOException;

import com.cmr.prj.repository.VoyageRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/guest_reset_password")
public class Guest_Reset_Password extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Guest_Reset_Password() {
      
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("email");
		String oldpass =request.getParameter("ogpass");
		String newpass =request.getParameter("ngpass");
	
		 guest gt=new guest();
		 gt.setEmail(userName);
		 gt.setPass(oldpass);
		 
		 VoyageRepository repo=new VoyageRepository();
			int res=repo.guest_reset_password(gt,newpass);
			response.setContentType("text/html");
			
			if(res>0) {
				request.setAttribute("successmessage","Password is updated successfully...");
				RequestDispatcher rd=request.getRequestDispatcher("guest_main.jsp");
				rd.include(request, response);
				
			}
			else {
				request.setAttribute("dangermessage","Updation of password is Failed....Please try again..");
				
			
			RequestDispatcher rd=request.getRequestDispatcher("Guest_Reset_password.jsp");
			rd.include(request, response);
			}
	}

}
