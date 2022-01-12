package f_t.servlet;

import java.io.IOException;

import com.cmr.prj.model.f_t;
import com.cmr.prj.repository.VoyageRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert_flight_train")
public class Insert_Flight_Train extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Insert_Flight_Train() {
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choose=request.getParameter("f_tr");
        //System.out.println(choose);
        
		String num=request.getParameter("ftno");
		String name=request.getParameter("ftname");
		String from_city=request.getParameter("fcity");
		String to_city=request.getParameter("tcity");
		String journey_date=request.getParameter("tdate");
		String journey_time=request.getParameter("time");
		String dep_name=request.getParameter("depname");
		int price=Integer.parseInt(request.getParameter("price"));
		String class_type=request.getParameter("class_");
		
		
		
		f_t fl_tr = new f_t();
		fl_tr.setChoose(choose);
		fl_tr.setNum(num);
		fl_tr.setName(name);
		fl_tr.setFrom_city(from_city);
		fl_tr.setTo_city(to_city);
		fl_tr.setJourney_date(journey_date);
		fl_tr.setJourney_time(journey_time);
		fl_tr.setDep_name(dep_name);
		fl_tr.setPrice(price);
		fl_tr.setClass_type(class_type);
		
		VoyageRepository repo=new VoyageRepository();
		int res= repo.insert_f_t(fl_tr);
		if(res>0) {
			request.setAttribute("successmessage","Details of "+num+" "+name+" are Inserted successfully...");
			
			
		}
		else {
			
			request.setAttribute("dangermessage",num+" of "+name+" "+choose+" is already available");
			
		}
		RequestDispatcher rd=request.getRequestDispatcher("adminretrieve_f_t");
		rd.include(request, response);
		
	}

}
