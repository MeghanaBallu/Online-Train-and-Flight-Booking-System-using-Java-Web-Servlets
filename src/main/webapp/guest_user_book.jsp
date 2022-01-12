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
            background-color: white;
        }
        .heading{
            box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
            background-color: black;
            
        }
        .box{
            background-color: whitesmoke;
            box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;  
            padding:40px; 
            border-radius: 10px;  
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
    <nav class="navbar navbar-expand-lg heading ">
        <br><br>
        <a href="" class="navbar-brand text-white">Voyage</a>
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

   <div class="container box">
       <h3 class="text-success offset-md-5">Book Ticket</h3>
       <div class="col-md-5 offset-md-3">
           <div>
           <form action="guest_booking_insertion" method="post">
            <label for="fname">First Name</label>
            <input type="text" name="fname" id="fname" placeholder="First Name" class="form-control" title="eg.Jhon" pattern="[a-zA-Z\s\.]{2,}"required>
            <br>
            <label for="lname">Last Name</label>
            <input type="text" name="lname" id="lname" placeholder="Last Name" class="form-control" title="eg.Stone" pattern="[a-zA-Z\s\.]{2,}"required>
            <br>
            <label for="mobile">Mobile</label>
            <input type="text" name="mobile" id="mobile" placeholder="Enter mobile number" title="eg.+91-923456789"class="form-control" pattern="[+]91[-][6-9]{1}[0-9]{9}" required >
            <br>
            <label for="email">Email</label>
            <input type="email" name="email" id="email" placeholder="abc@gmail.com" title="eg.abc.123@gmail.com"pattern="[a-zA-Z0-9\.]*@(gmail|yahoo|rediff)[.]com]" class="form-control" required>
            <br>
            <label for="bdate">Booking Date</label>
            <input type="date" name="bdate" id="bdate"  class="form-control" required>
            <br>
            <label for="npersons">Number Of Persons</label>
            <input type="number" name="npersons" id="npersons" min="1" title="Please enter the number of persons" class="form-control" pattern="[0-9]*"required>
            <br>
            <label for="address">Address</label>
            <textarea name="address" id="address" cols="30" rows="5" class="form-control" required></textarea> 
            <br>
            <button  name="book" class="btn btn-success btn-md " type="submit" value="book">Process to Payment</button> 
            <a href="guest_main.jsp" name="payment" class="btn btn-danger btn-md ">Cancel</a>           
             
             <input type="hidden" id="a" name="a" value=<%=request.getParameter("choose") %>>
            <input type="hidden" name="b" id="b" value=<%=request.getParameter("num") %>>
            <input type="hidden" id="c" name="c" value="${param.name}"  >
            <input type="hidden" name="d" id="d" value="${param.from_city}">
            <input type="hidden" name="e" id="e" value="${param.to_city}">
            <input type="hidden" name="f" id="f" value=<%=request.getParameter("journey_date") %>>
            <input type="hidden" name="g" id="g" value=<%=request.getParameter("journey_time") %>>
            <input type="hidden" name="h" id="h" value="${param.dep_name}">
            <input type="hidden" name="i" id="i" value=<%=request.getParameter("price") %>>
            <input type="hidden" name="j" id="j" value="${param.class_type }">
            
           </form>
        </div>
       </div>
   </div>
   <br><br><br><br><br><br>
   
   <!---->
    <div class=" text-center fixed-bottom" style="padding:15px;background-color: black;">
        <h4 class="text-white">© Voyage 2021</h4>
    </div>
    
</body>
</html>