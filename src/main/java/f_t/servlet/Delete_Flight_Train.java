package f_t.servlet;

import java.io.IOException;

import com.cmr.prj.repository.VoyageRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete_flight_train")
public class Delete_Flight_Train extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Delete_Flight_Train() {
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("num");
		
		VoyageRepository repo=new VoyageRepository();
		int res=repo.deletef_t(num);
		
        response.setContentType("text/html");
		
		if(res>0) {
			request.setAttribute("successmessage","Details of "+num+" are Deleted Successfully...");
			
			
		}
		else {
			request.setAttribute("dangermessage","Deletion of "+num+"  is Failed....");
			
		}
		RequestDispatcher rd=request.getRequestDispatcher("adminretrieve_f_t");
		rd.include(request, response);
	}

}
