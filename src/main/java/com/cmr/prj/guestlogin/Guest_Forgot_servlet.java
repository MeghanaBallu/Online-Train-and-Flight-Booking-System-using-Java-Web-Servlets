package com.cmr.prj.guestlogin;

import java.io.IOException;

import com.cmr.prj.repository.VoyageRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guest_forgot")
public class Guest_Forgot_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Guest_Forgot_servlet() {
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email=request.getParameter("email");
		 String pass=request.getParameter("ngpass");
		 
		 guest gt=new guest();
		 gt.setEmail(email);
		 gt.setPass(pass);
		 
		 VoyageRepository repo=new VoyageRepository();
			int res=repo.guest_forgot_password(gt);
			response.setContentType("text/html");
			
			if(res>0) {
				request.setAttribute("successmessage","Password is updated successfully...");
				
				
			}
			else {
				request.setAttribute("message","Updation of password is Failed....Please try again..");
				
			}
			RequestDispatcher rd=request.getRequestDispatcher("guest_login.jsp");
			rd.include(request, response);
			
	}

}
