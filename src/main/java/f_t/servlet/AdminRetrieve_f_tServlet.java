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
import jakarta.servlet.http.HttpSession;


@WebServlet("/adminretrieve_f_t")
public class AdminRetrieve_f_tServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminRetrieve_f_tServlet() {
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String query=request.getParameter("search");
		VoyageRepository repo=new VoyageRepository();
		List<f_t> fl_trList=repo.getAllTravelInfo(query);
		
		//System.out.println("Tour List"+fl_trList);
		
		request.setAttribute("flight_trainList", fl_trList);
		HttpSession session=request.getSession();
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if(session.getAttribute("userName")==null){
			response.sendRedirect("main.html");
		}
		else {
	RequestDispatcher rd= request.getRequestDispatcher("AdminDisplayFlight_Train.jsp");
	
	rd.include(request, response);
	}

}
}