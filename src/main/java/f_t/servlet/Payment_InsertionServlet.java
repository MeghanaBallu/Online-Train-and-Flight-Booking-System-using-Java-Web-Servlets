package f_t.servlet;

import java.io.IOException;


import com.cmr.prj.model.booked;
import com.cmr.prj.model.booking;
import com.cmr.prj.model.f_t;
import com.cmr.prj.model.paymentdetails;
import com.cmr.prj.repository.VoyageRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/payment_insertion")
public class Payment_InsertionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Payment_InsertionServlet() {
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String card_no=request.getParameter("cardno");
		String carder_name=request.getParameter("cname");
		int month=Integer.parseInt(request.getParameter("month"));
		int year=Integer.parseInt(request.getParameter("year"));
		int cvv=Integer.parseInt(request.getParameter("cvv"));
		paymentdetails details=new paymentdetails();
		details.setCard_no(card_no);
		details.setCarder_name(carder_name);
		details.setMonth(month);
		details.setYear(year);
		details.setCvv(cvv);
		
        String fname=request.getParameter("k");
		String lname=request.getParameter("l");
		String mob=request.getParameter("m");
		String email=request.getParameter("n");
		String booking_date=request.getParameter("o");
		int no_of_persons=Integer.parseInt(request.getParameter("p"));
		String address=request.getParameter("q");
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
		String cus_name=request.getParameter("z");
		
		booked bk=new booked();
		bk.setMode_transport(a);
		bk.setNum(b);
		bk.setName(c);
		bk.setFrom_city(d);
		bk.setTo_city(e);
		bk.setJourney_date(f);
		bk.setJourney_time(g);
		bk.setDep_name(h);
		bk.setPrice(i);
		bk.setClass_type(j);
		bk.setCus_name(cus_name);
		bk.setMob(mob);
		bk.setEmail(email);
	    bk.setNo_of_persons(no_of_persons);
		
	    //String s_n=request.getParameter("");
	    
	    
	
		VoyageRepository repo1=new VoyageRepository();
		int res=repo1.insert_payment(details);
		if(res>0) {
			
			request.setAttribute("book", book);
			request.setAttribute("dt", dt);
			request.setAttribute("successmessage","Your Ticket is Booked successfully");
			RequestDispatcher rd=request.getRequestDispatcher("ConfirmPayment.jsp");
			
			rd.include(request, response);
			
			
		}
		else {
			
			request.setAttribute("dangermessage","Your Ticket is not Booked");
			
		
		RequestDispatcher rd=request.getRequestDispatcher("retrieve_f_t");
		rd.include(request, response);
		}
		
		
		 VoyageRepository repo=new VoyageRepository();
			repo.insert_bookeddetails(bk);
		
	}
	
	
	

}
