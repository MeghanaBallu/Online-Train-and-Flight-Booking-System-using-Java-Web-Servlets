package f_t.servlet;

import java.io.IOException;

import com.cmr.prj.model.booking;
import com.cmr.prj.model.f_t;
import com.cmr.prj.repository.VoyageRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/booking_insertion")
public class Booking_Insertion extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public Booking_Insertion() {
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fname=request.getParameter("fname");
		
		String lname=request.getParameter("lname");
		String mob=request.getParameter("mobile");
		String email=request.getParameter("email");
		String booking_date=request.getParameter("bdate");
		int no_of_persons=Integer.parseInt(request.getParameter("npersons"));
		String address=request.getParameter("address");
		
		booking book=new booking();
		
		book.setFname(fname);
		book.setLname(lname);
		book.setMob(mob);
		book.setEmail(email);
		book.setBooking_date(booking_date);
		book.setNo_of_persons(no_of_persons);
		book.setAddress(address);
		
		String a=request.getParameter("a");
		String b=request.getParameter("b");
		String c=request.getParameter("c");
		String d=request.getParameter("d");
		String e=request.getParameter("e");
		String f=request.getParameter("f");
		String g=request.getParameter("g");
		String h=request.getParameter("h");
		int i=Integer.parseInt(request.getParameter("i"));
		String j=request.getParameter("j");
		f_t dt=new f_t();
		
		dt.setChoose(a);
		dt.setNum(b);
		dt.setName(c);
		dt.setFrom_city(d);
		dt.setTo_city(e);
		dt.setJourney_date(f);
		dt.setJourney_time(g);
		dt.setDep_name(h);
		dt.setPrice(i);
		dt.setClass_type(j);
		
		
		
		VoyageRepository repo=new VoyageRepository();
		int res= repo.insert_booking(book);
		if(res>0) {
			request.setAttribute("book", book);
			request.setAttribute("dt", dt);
			RequestDispatcher rd=request.getRequestDispatcher("Payment.jsp");
			
			rd.include(request, response);
			
			
		}
		else {
			
			request.setAttribute("dangermessage","Your Ticket is not Booked");
			
		
		RequestDispatcher rd=request.getRequestDispatcher("retrieve_f_t");
		rd.include(request, response);
		}
		
		
		
		
	}

}
