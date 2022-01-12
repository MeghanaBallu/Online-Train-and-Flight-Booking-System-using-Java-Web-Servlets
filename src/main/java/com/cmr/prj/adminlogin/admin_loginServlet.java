package com.cmr.prj.adminlogin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/adminlogin")
public class admin_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public admin_loginServlet() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		adminDAO ad=new adminDAOImpl();
		
		String userName=request.getParameter("logemail");
		String password=request.getParameter("pass");
		String submitType=request.getParameter("submit");
		admin a=ad.getadmin(userName, password);
		if(submitType.equals("Login") && userName.equals(a.getLogemail()) && password.equals(a.getPass())) {
			HttpSession session=request.getSession();
			session.setAttribute("userName",userName );
			request.getRequestDispatcher("admin_main.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message","Incorrect Username or Password");
		    request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
	}

}
