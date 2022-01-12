.<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
        .menu{
            color: white;

        }
        .menu:hover{
            background-color: white;
            color: black;
        }
        .login{
            box-shadow: rgba(0, 0, 0, 0.09) 0px 2px 1px, rgba(0, 0, 0, 0.09) 0px 4px 2px, rgba(0, 0, 0, 0.09) 0px 8px 4px, rgba(0, 0, 0, 0.09) 0px 16px 8px, rgba(0, 0, 0, 0.09) 0px 32px 16px;
             width: 650px;
        }
    </style>
</head>
<body>
<script>  
function verifyPassword() {  
  var pw = document.getElementById("gpass").value;  

  if(pw == "") {  
     document.getElementById("message").innerHTML = "**Fill the password please!";  
     return false;  
  }  
   
 
  if(pw.length < 8) {  
     document.getElementById("message").innerHTML = "**Password length must be atleast 8 characters";  
     return false;  
  }  
  
  
  if(pw.length > 15) {  
     document.getElementById("message").innerHTML = "**Password length must not exceed 15 characters";  
     return false;  
  } 
  var pw2 = document.getElementById("cgpass").value;  
  if(pw != pw2)  
  {   
	  document.getElementById("message2").innerHTML = "Passwords did not match";  
    
    return false;
  } 
  
}  

</script>  

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

%>
    <nav class="navbar navbar-expand-lg heading ">
        <br><br>
        <a href="" class="navbar-brand text-white">Voyage</a>
        <button class="navbar-toggler bg-white" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
            <span class="navbar-toggler-icon"><i class="glyphicon glyphicon-menu-hamburger"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a href="main.html" class="nav-link menu">Home</a></li>
                <li class="nav-item"><a href="retrieve_f_t" class="nav-link menu">Flight/Train</a></li>
                <li class="nav-item"><a href="admin_login.jsp" class="nav-link menu">Admin Login</a></li>
                <li class="nav-item"><a href="guest_login.jsp" class="nav-link menu">Guest Login</a></li>
            </ul>
        </div>
    </nav>
    <!---->
    <br><br><br>
    <div class="container login">
        <h4 class="text-success offset-md-5">Guest Signup</h4>
           <div class="col-md-7 offset-md-2">
               <form action="guest_signup" method="post" onsubmit ="return verifyPassword()">
                <label for="email">Email </label>
                <input type="email" name="email" id="email" placeholder="abc@gmail.com" class="form-control" required>
                <br>
                <label for="gpass">Password</label>
                <input type="password" name="gpass" id="gpass" placeholder="Password" class="form-control" required>
                <span id = "message" style="color:red"> </span>
                <br>
                <label for="cgpass">Confirm Password</label>
                <input type="password" name="cgpass" id="cgpass" placeholder="Confirm Password" class="form-control" required>
                 <span id = "message2" style="color:red"> </span>
                <br>
                <button name="gsign" class="btn btn-success btn-md" type="submit"  value="gsign">SignUp</button> 
                <br><br>
               <center>
                 
                   <h5 style="color:red;"> ${dangermessage}</h5>
                  </center>
               </form>
               
           </div>
       </div>
       
  
   <!---->
    <div class=" text-center fixed-bottom" style="padding:15px;background-color: black;">
        <h4 class="text-white">&copy; Voyage 2021</h4>
    </div>
    
</body>



</html>