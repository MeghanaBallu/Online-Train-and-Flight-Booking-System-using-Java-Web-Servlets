<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Voyage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        body{
            background-color: white;
        }
        .heading{
            box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
            background-color: black;
            
        }
        .menu{
            color: white;

        }
        .menu:hover{
            background-color: white;
            color: black;
        }
    </style>
</head>
<body>

 <%@ page import="java.util.List" %>
		<%@ page import="com.cmr.prj.model.f_t" %>
		<%
		List<f_t> fl_trList=(List<f_t>)request.getAttribute("flight_trainList");
		
		
		%>
		
    <nav class="navbar navbar-expand-lg heading">
       
        <a href="" class="navbar-brand text-white">Voyage</a>
        <button class="navbar-toggler bg-white" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
            <span class="navbar-toggler-icon"><i class="glyphicon glyphicon-menu-hamburger"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item "><a href="main.html" class="nav-link menu">Home</a></li>
                <li class="nav-item"><a href="retrieve_f_t" class="nav-link menu">Flight/Train</a></li>
                <li class="nav-item"><a href="admin_login.jsp" class="nav-link menu">Admin Login</a></li>
                <li class="nav-item"><a href="guest_login.jsp" class="nav-link menu">Guest Login</a></li>
            </ul>
        </div>
    </nav>
    <!---->
   
     <center>
      <h5 style="color:red;"> ${dangermessage}</h5>
         
     </center>
   
     <div class="row">

            <div class="col-md-5">
	             <h3 style="margin-right:100px; margin-left:125px; margin-top:80px" >Available Flights or Trains</h3>
	      
	      </div>
	       <div class="col-md-4">
		        <form action="" method="post">
		        
		        	<input type="text" class="form-control offset-md-10 col-md-5" placeholder="Search" name="search" id="search" style="margin-top:85px; margin-left:200px">
		   
		    </form>
		   </div>
		   <div class="col-md-4 ">   	
		        	<a href="retrieve_f_t" class="btn btn-primary btn-md" style="margin-top:-50px; margin-left:700px">View All</a>
		     </div>   	
		       
		       <div class="col-md-12 "> 
		        <h5 style="color:red; margin-top:-50px; margin-right:-150px" class="offset-9">Note: Search Date by DD-MM-YY format.</h5>
	 </div> 
  		 </div> 
     
     
     
    <div>
        <table class="table">
            <thead>
                <tr>
                    <th>Flight/Train</th>
                    <th>Number</th>
                    <th>Name</th>
                    <th>From City</th>
                    <th>To City</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Departure Station Name</th>
                    <th>Ticket Price</th>
                    <th>Class</th>
                    <th>Book</th>
                </tr>
            </thead>
            <tbody>
                <%
                for(f_t fl_tr: fl_trList){
                %>
                <tr>
                    <td><%= fl_tr.getChoose() %></td>
                   <td><%=fl_tr.getNum() %></td>
                   <td><%=fl_tr.getName() %></td>
                   <td><%=fl_tr.getFrom_city() %></td>
                   <td><%=fl_tr.getTo_city() %></td>
                   
                   <% 
                   String a= fl_tr.getJourney_date();
                   String s="";
                   for (int i=0;i<=9;i++){
                	   char c = a.charAt(i);
                	  
                	   s=s+c;
                   }
                   %>
                   
                   <td><%=s %></td>
                   <td><%=fl_tr.getJourney_time() %></td>
                   <td><%=fl_tr.getDep_name() %></td>
                   <td>Rs.<%=fl_tr.getPrice() %></td>
                    <td><%=fl_tr.getClass_type() %></td>
                    
                    <%
                    String querystring="choose="+fl_tr.getChoose()+"&num="+fl_tr.getNum()+"&name="+fl_tr.getName()+"&from_city="+fl_tr.getFrom_city()+"&to_city="+fl_tr.getTo_city()+"&journey_date="+fl_tr.getJourney_date()+"&journey_time="+fl_tr.getJourney_time()+"&dep_name="+fl_tr.getDep_name()+"&price="+fl_tr.getPrice()+"&class_type="+fl_tr.getClass_type()+"";
                
                    %>
                    <td><a href="user_book.jsp?<%=querystring %>" class="btn btn-primary btn-md">Book</a></td>
                </tr>
               <%
               }
               %>
            </tbody>
        </table>

    
    </div>
   

      <br><br><br><br>


   <!---->
    <div class=" text-center fixed-bottom" style="padding:15px;background-color: black;">
        <h4 class="text-white">© Voyage 2021</h4>
    </div>
    
</body>
</html>