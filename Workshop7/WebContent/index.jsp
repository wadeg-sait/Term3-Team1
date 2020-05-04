<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/travelExpert.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Travel Expert</title>
<style>


body {
      background-image: url("imgs/bg-masthead.jpg");

      color: black;
      font-family: "Quicksand", sans-serif;
      font-weight: 300;
      background-size: cover; 
    }
    
 .mycarousel {
      opacity: 0.5;
      
    }
    
.sticky {
      position: fixed;
      top: 0;
      width: 100%;
    }
    
    .sticky + .content {
      padding-top: 60px;
    }
    
 #mysection {
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 20px;
      
  		overflow: hidden;
    }
.carousel-inner > .item {
   height: 630px;
}


</style>
</head>

<script src="travelExpert.js/"></script>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="index.jsp">Travel Expert</a>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Customers.jsp">Customers</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Agents.jsp" tabindex="-1">Agents</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="Bookings.jsp" tabindex="-1">Bookings</a>
      </li>
    </ul>
    
  </div>
</nav>

<div class="container">
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
          <li data-target="#myCarousel" data-slide-to="3"></li>
          <li data-target="#myCarousel" data-slide-to="4"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
        
        	<div class="item active">
            <img src="imgs/andriod7.jpg" alt="image1" />
          </div>
          
          <div class="item">
            <img src="imgs/cool.jpeg" alt="image2" />
          </div>
          
        	<div class="item">
           <img src="imgs/andriod5.jpg" alt="image3" />
          </div>

          <div class="item">
            <img src="imgs/andriod4.jpg" alt="image4" />
          </div>

          <div class="item">
            <img src="imgs/web1.jpg" alt="image5" />
          </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>