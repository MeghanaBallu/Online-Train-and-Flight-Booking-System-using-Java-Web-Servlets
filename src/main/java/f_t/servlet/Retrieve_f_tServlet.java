package f_t.servlet;

import java.io.IOException;
import java.util.List;

import com.cmr.prj.model.f_t;
import com.cmr.prj.repository.VoyageRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/retrieve_f_t")
public class Retrieve_f_tServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public Retrieve_f_tServlet() {
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query=request.getParameter("search");
		VoyageRepository repo=new VoyageRepository();
		List<f_t> fl_trList=repo.getAllTravelInfo(query);
		
		
		request.setAttribute("flight_trainList", fl_trList);
	RequestDispatcher rd= request.getRequestDispatcher("DisplayFlight_Train.jsp");
	
	rd.include(request, response);
	
	
		
	}

}
