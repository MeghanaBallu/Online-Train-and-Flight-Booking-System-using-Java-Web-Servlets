package com.cmr.prj.guestlogin;

import java.io.IOException;

import com.cmr.prj.repository.VoyageRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/guest_signup")
public class Guest_Signup_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public Guest_Signup_servlet() {
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("email");
		String password=request.getParameter("gpass");
		 
		guest gu=new guest();
		gu.setEmail(userName);
		gu.setPass(password);
		response.setContentType("text/html");
		VoyageRepository repo=new VoyageRepository();
		int res= repo.insert_guest(gu);
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if(res>0) {
			request.setAttribute(userName, userName);
			request.setAttribute("successmessage","Sign-in done successfully...Continue to Login..");
			RequestDispatcher rd=request.getRequestDispatcher("guest_login.jsp");
			rd.include(request, response);
			
		}
		else {
			
			request.setAttribute("dangermessage","Already Signed-In!! Please Login..");
			RequestDispatcher rd=request.getRequestDispatcher("guest_signup.jsp");
			rd.include(request, response);
		}


}
}