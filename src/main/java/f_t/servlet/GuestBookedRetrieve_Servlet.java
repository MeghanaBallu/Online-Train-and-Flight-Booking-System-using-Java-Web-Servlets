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


@WebServlet("/guestbookedretrieve")
public class GuestBookedRetrieve_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public GuestBookedRetrieve_Servlet() {
      
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String query=(String) session.getAttribute("userName");
		String f_query=request.getParameter("search");
		VoyageRepository repo=new VoyageRepository();
		List<booked> bookList=repo.getAllGuest_BookedInfo(query,f_query);
		//System.out.println(bookList);
		request.setAttribute("bookedList",bookList );
		
		
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if(session.getAttribute("userName")==null){
			response.sendRedirect("main.html");
		}
		
		else {
	RequestDispatcher rd= request.getRequestDispatcher("Guest_Booked_Details.jsp");
	
	rd.include(request, response);
		}
		
		
		
		
	}

}
