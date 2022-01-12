package f_t.servlet;

import java.io.IOException;
import java.util.List;

import com.cmr.prj.model.booked;

import com.cmr.prj.repository.VoyageRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/bookedretrieve")
public class BookedRetrieve_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public BookedRetrieve_Servlet() {
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String query=request.getParameter("search");
		//System.out.println(query);
		VoyageRepository repo=new VoyageRepository();
		List<booked> bookList=repo.getAllAdminInfo(query);
		request.setAttribute("bookedList",bookList );
		
		HttpSession session=request.getSession();
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if(session.getAttribute("userName")==null){
			response.sendRedirect("main.html");
		}
		
		else {
	RequestDispatcher rd= request.getRequestDispatcher("Admin_booked_details.jsp");
	
	rd.include(request, response);
		}
	}

}
