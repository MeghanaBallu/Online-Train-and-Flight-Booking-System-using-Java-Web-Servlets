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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <style>
           body{
            background-color: white;
        }
        .heading{
            box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
            background-color: black;
           
        }
        .box{
            box-shadow: rgba(0, 0, 0, 0.09) 0px 2px 1px, rgba(0, 0, 0, 0.09) 0px 4px 2px, rgba(0, 0, 0, 0.09) 0px 8px 4px, rgba(0, 0, 0, 0.09) 0px 16px 8px, rgba(0, 0, 0, 0.09) 0px 32px 16px;
            width: 900px;
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
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("userName")==null){
	response.sendRedirect("main.html");
}
%>
    <nav class="navbar navbar-expand-lg heading ">
        <br><br>
        <a href="" class="navbar-brand text-white">Voyage</a>
        <button class="navbar-toggler bg-white" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
            <span class="navbar-toggler-icon"><i class="glyphicon glyphicon-menu-hamburger"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a href="admin_login.jsp" class="nav-link  menu">Home</a></li>
                <li class="nav-item"><a href="insertadd_f_t.jsp" class="nav-link  menu">Add Flight/Train</a></li>
                <li class="nav-item"><a href="adminretrieve_f_t" class="nav-link  menu">Flight/Train View</a></li>
                <li class="nav-item"><a href="bookedretrieve" class="nav-link  menu">Book Ticket Report</a></li>
            </ul>
             <ul class="navbar-nav navbar-right">
                <div class="nav-item">
                    
                    <a href="adminlogout.jsp" class="btn btn-danger btn-md" style="margin-top:5px;">Logout</a>
                </div>
                

            </ul>
        </div>
    </nav>
    <!---->
    <div class="container box">
        <h3 class="text-success offset-md-5">Update <span class="glyphicon glyphicon-plane"></span>  /  <span class="fa fa-train"></span> </h3>
        <br>
        <div class="col-md-6 offset-md-3">
            <div>
            <form action="update_flight_train" method="post">
       
             <label for="f_tr">Choose Flight/Train</label>&nbsp;&nbsp;&nbsp;
             <%if(request.getParameter("choose").equals("Flight")){%>
             <input type="radio" name="f_tr" value="Flight" id="f_tr" checked required>
             Flight&nbsp;&nbsp;&nbsp;
             <%}else{%>
             <input type="radio" name="f_tr" value="Flight" id="f_tr"  required>
             Flight&nbsp;&nbsp;&nbsp;
             <%}%>
             <%if(request.getParameter("choose").equals("Train")){%>
             <input type="radio" name="f_tr" value= "Train" id="f_tr" checked required>
             Train
             <%}else{%>
             <input type="radio" name="f_tr" value="Train" id="f_tr"  required>
             Train
             <%}%>
             <br><br>
         
             <label for="ftno">Flight/Train Number</label>
             <input type="text" name="ftno" id="ftno" placeholder="Number" value=<%=request.getParameter("num") %> class="form-control" readonly="readonly" required>
             <br>
             <label for="ftname">Flight/Train Name</label>
             <input type="text" name="ftname" id="ftname" value="${param.name}" placeholder="Name" class="form-control" required>
             <br>
             <label for="fcity">From City</label>
             <input type="text" name="fcity" id="fcity" placeholder="From City" value="${param.from_city}" class="form-control" required >
             <br>
             <label for="tcity">To City</label>
             <input type="text" name="tcity" id="tcity" placeholder="To City" value="${param.to_city}" class="form-control" required>
             <br>
             <label for="tdate">Date</label>
             <input type="date" name="tdate" id="tdate" value=<%=request.getParameter("journey_date") %> class="form-control" required>
             <br>
             <label for="time">Time</label>
             <input type="text" name="time" id="time"  placeholder="Enter the Time" value=<%=request.getParameter("journey_time") %> class="form-control" required>
             <br>
             <label for="depname">Departure Station Name</label>
             <input type="text" name="depname" id="depname" placeholder="Departure Station Name" value="${param.dep_name}" class="form-control" required>
             <br>
             <label for="price">Ticket Price</label>
             <input type="text" name="price" id="price" placeholder="Enter the Price" value=<%=request.getParameter("price") %> class="form-control" required>
             <br>
             <label for="class_type">Class</label>
             <select name="class_type" id="class_type"  class="form-control"  required>
                
                 
                <option value="Economy Class">Economy Class</option>
                <option value="Business Class">Business Class</option>
                <option value="First Class">First Class</option>
                <option value="AC Compartment">AC Compartment</option>
                <option value="Non-AC Compartment">Non-AC Compartment</option>
             </select>
             
             <br>
             <input  name="Update" class="btn btn-success btn-md " type="submit" id="Update" value="Update">
             <button  name="reset" class="btn btn-danger btn-md " type="reset" value="reset">Reset</button> 
             <br><br><br>
           
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