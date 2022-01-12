package com.cmr.prj.guestlogin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/guest_login")
public class Guest_Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Guest_Login_Servlet() {
       
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
		
		String userName=request.getParameter("email");
		String password=request.getParameter("gpass");
		 
         guestDAO gu=new guestDAOImpl();
		
		
		String submitType=request.getParameter("submit");
		guest a=gu.getguest(userName, password);
		if(submitType.equals("glogin") && userName.equals(a.getEmail()) && password.equals(a.getPass())) {
			HttpSession session=request.getSession();
			session.setAttribute("userName",userName );
			request.getRequestDispatcher("guest_main.jsp").forward(request, response);
			
		}
		else {
			request.setAttribute("message","Incorrect Username or Password");
		    request.getRequestDispatcher("guest_login.jsp").forward(request, response);
		}
	}


}
