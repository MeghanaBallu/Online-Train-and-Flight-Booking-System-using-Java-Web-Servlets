<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/4.5.6/css/ionicons.min.css">
	<link rel="stylesheet" href="css/style.css">
    
    <title>Voyage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
    .jumbotron{
            background-color: rgba(152, 235, 159, 0.39);
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
                <li class="nav-item"><a href="admin_main.jsp" class="nav-link  menu">Home</a></li>
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
   <div class="jumbotron text-center ">
        <h1 style="letter-spacing:4px;">VOYAGE</h1> 
        <p style="font-family: Georgia;letter-spacing:2px;">On for Adventure</p> 
    </div>
        <img src="train&flight.png" alt="Train" style="margin-top:-10px; width:90%; margin-left:40px;"/>
     <hr>
    <section class="ftco-section" style="margin-top:-100px;">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">
						<h2 class="heading-section mb-5 text-monospace">Destinations </h2>
					</div>
					<div class="col-md-12">
						<div class="featured-carousel owl-carousel">
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/Charminar.jpg);">
										<div class="text w-100">
										
											<h3><a href="#">Charminar</a></h3>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/China.jpg);">
										<div class="text w-100">
											
											<h3><a href="#">China</a></h3>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/Dubai.jpg);">
										<div class="text w-100">
											
											<h3><a href="#">Dubai</a></h3>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/IndiaGate.jpg);">
										<div class="text w-100">
											
											<h3><a href="#">India Gate</a></h3>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/LondonBridge.jpg);">
										<div class="text w-100">
											
											<h3><a href="#">London</a></h3>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/Nepal.jpg);">
										<div class="text w-100">
											
											<h3><a href="#">Nepal</a></h3>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/Paris.jpg);">
										<div class="text w-100">
											
											<h3><a href="#">Paris</a></h3>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/SouthKorea.jpg);">
										<div class="text w-100">
											
											<h3><a href="#">South Korea</a></h3>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/TajMahal.jpg);">
										<div class="text w-100">
											
											<h3><a href="#">Taj Mahal</a></h3>
										</div>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<div class="img d-flex align-items-end justify-content-center" style="background-image: url(images/Italy.jpg);">
										<div class="text w-100">
										
											<h3><a href="#">Italy</a></h3>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
    
     <center>
        <h2 class="text-success"  style="margin-top:-100px;"><tt><b>Contact Us</b></tt></h2>
        <br>
         <h4><b>Email:</b> Voyage@gmail.com</h4>
        <h4><b>phone no:</b> +91-123456789</h4>
        <h4><b>Address:</b> India,Telangana,Hyderabad</h4></center>
        <br><br><br>
   <!---->
    <div class=" text-center fixed-bottom" style="padding:15px;background-color: black;">
        <h4 class="text-white">© Voyage 2021</h4>
    </div>
    
</body>
</html>