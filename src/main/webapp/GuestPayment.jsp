<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Voyage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        body{
            background-color: rgb(255, 255, 255);
        }
        .heading{
            box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
            background-color: black;
            
        }
        table{
            box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;


        }
       .payment{
           width: 700px;
           box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
           
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
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); %>
<%@ page import="com.cmr.prj.model.booking" %>
<%@ page import="com.cmr.prj.model.f_t" %>

<% 
booking book1=(booking)request.getAttribute("book");
%>
<% f_t dt2=(f_t)request.getAttribute("dt");
%>


    <nav class="navbar navbar-expand-lg heading  ">
        <br><br>
        <a href="#" class="navbar-brand text-white">Voyage</a>
        <button class="navbar-toggler bg-white" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
            <span class="navbar-toggler-icon"><i class="glyphicon glyphicon-menu-hamburger"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a href="guest_main.jsp" class="nav-link menu">Home</a></li>
                <li class="nav-item"><a href="guestretrieve_f_t" class="nav-link menu">Flight/Train</a></li>
                <li class="nav-item"><a href="guestbookedretrieve" class="nav-link  menu">Your Bookings</a></li>
                
            </ul>
            <ul class="navbar-nav navbar-right">
                <div class="nav-item">
                    <a href="Guest_Reset_password.jsp?userName=<%=session.getAttribute("userName") %>" class="btn btn-primary btn-md" style="margin-top:5px;">Reset Password</a>
                    <a href="guest_logout.jsp" class="btn btn-danger btn-md" style="margin-top:5px;">Logout</a>
                </div>
                

            </ul>
        </div>
    </nav>
    <!---->
    <div class="container ">
        <div class="col-md-9 offset-md-2">
            <table class="table table-striped">
                <thead>
                    <tr ><th colspan="2">Confirm Details</th></tr>
                </thead>
                <tbody>
                    <tr><td><b>Mode of Transport:&nbsp;</b><%=dt2.getChoose() %>&nbsp; </td> <td><b><%=dt2.getChoose() %>&nbsp;Number:</b>&nbsp;<%=dt2.getNum() %>&nbsp;</td></tr>
                    <tr><td><b>Travel:</b>&nbsp;<%= dt2.getFrom_city() %>&nbsp;<b>To</b>&nbsp;<%= dt2.getTo_city() %></td><td><b><%=dt2.getChoose() %>&nbsp;Name: </b>&nbsp;<%=dt2.getName() %></td></tr>
                    <tr><td><b>Travel Date:</b>&nbsp;<%=dt2.getJourney_date() %></td><td><b>Time:</b>&nbsp;<%=dt2.getJourney_time() %></td></tr>
                    <tr><td><b>Departure Name:</b>&nbsp;${param.h}</td><td><b>Class Type:</b>&nbsp;<%=dt2.getClass_type()%></td></tr>
                    <tr><td colspan="2" ><b>Ticket Price:</b>&nbsp;Rs.<%=dt2.getPrice() %></td></tr>
                </tbody>
            </table>
            <table class="table table-striped ">
                <thead>
                    <tr><th colspan="2">Your Details</th></tr>
                </thead>
                <tbody>
                    <tr><td><b>Name:</b>&nbsp;<%=book1.getFname() %> &nbsp;<%=book1.getLname() %></td> <td><b>Mobile:</b>&nbsp;<%=book1.getMob() %>  </td></tr>
                    <tr><td><b>Email:</b>&nbsp;<%=book1.getEmail() %></td><td><b>Booking Date:</b>&nbsp;<%=book1.getBooking_date() %></td></tr>
                    <tr><td><b>No.of Persons:</b>&nbsp;<%=book1.getNo_of_persons() %></td><td><b>Address:</b>&nbsp; <%=book1.getAddress() %></td></tr>
                    <tr><td colspan="2" ><b>Final Amount:</b>&nbsp;Rs.<%=book1.getNo_of_persons()*dt2.getPrice() %></td></tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="container">
        <div class="panel panel-info  payment offset-md-3">
            <div class="panel-heading">Payment </div>
            <div class="panel-body">
         
      
        <div class="col-md-5 offset-md-3">
            <form action="guestpayment_insertion" method="post">
            <label for="cardno">Card No</label>
            <input type="text" name="cardno" id="cardno" placeholder="Enter Card Number" class="form-control" required>
            <br>
            <label for="cname">Card holder Name</label>
            <input type="text" name="cname" id="cname" placeholder="Enter Cardholder Name" class="form-control" required>
            <br>
            <label for="month">Month</label>
            <input type="text" name="month" id="month" placeholder="MM" class="form-control" pattern="(0[1-9]|1[012]" title="eg.10" required >
            <br>
            <label for="year">Year</label>
            <input type="text" name="year" id="year" placeholder="YYYY" pattern="\d{4}" title="eg.2021"class="form-control" required >
            <br>
            <label for="cvv">CVV No.</label>
            <input type="text" name="cvv" id="cvv" placeholder="Enter CVV Number"pattern="\d{1,}" class="form-control" required >
            <br>
            
            
             <input type="hidden" id="a" name="a" value=<%=dt2.getChoose() %>>
            <input type="hidden" name="b" id="b" value=<%=dt2.getNum() %>>
            <input type="hidden" id="c" name="c" value="${param.c }" >
            <input type="hidden" name="d" id="d" value="${param.d }">
            <input type="hidden" name="e" id="e" value="${param.e }">
            <input type="hidden" name="f" id="f" value=<%=dt2.getJourney_date() %>>
            <input type="hidden" name="g" id="g" value=<%=dt2.getJourney_time() %>>
            <input type="hidden" name="h" id="h" value="${param.h}">
            <input type="hidden" name="i" id="i" value=<%=dt2.getPrice() %>>
            <input type="hidden" name="j" id="j" value="${param.j }">
           
             <input type="hidden" id="k" name="k" value=<%=book1.getFname() %>>
            <input type="hidden" name="l" id="l" value=<%=book1.getLname() %>>
            
            <input type="hidden" id="m" name="m" value=<%=book1.getMob() %>  >
            <input type="hidden" name="n" id="n" value=<%=book1.getEmail() %>>
            <input type="hidden" name="o" id="o" value=<%=book1.getBooking_date() %>>
            <input type="hidden" name="p" id="p" value=<%=book1.getNo_of_persons() %>>
            <input type="hidden" name="q" id="q" value="${param.address }">
            
             <%String com=book1.getFname()+"_"+book1.getLname();%>
             <input type="hidden" name="z" id="z" value=<%=com%>>
            
            <button name="payment" class="btn btn-success btn-md " type="submit" value="payment">Payment To Book</button> 
            
            <a href="guest_main.jsp"  class="btn btn-danger btn-md ">Cancel</a> 
             
           
            
            </form>
        </div>
            </div>
    </div>
    </div>
    <br>
   <br>
   <br>
   <!---->
     <div class=" text-center fixed-bottom" style="padding:15px;background-color: black;">
        <h4 class="text-white">&copy; Voyage 2021</h4>
    </div>
    
</body>
</html>