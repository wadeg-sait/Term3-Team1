<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Travel Experts</title>
	
<style>

body {
      background-image: url("imgs/background3.jpg");

      color: black;
      font-family: "Quicksand", sans-serif;
      font-weight: 300;
      background-size: cover; 
    }

</style>

</head>




<body>


<!-- NavBar Starts -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <a class="navbar-brand" href="index.jsp">Travel Expert</a>
	
	  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	      <li class="nav-item">
	        <a class="nav-link" href="index.jsp">Home</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="Customers.jsp">Customers</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="Agents.jsp" tabindex="-1">Agents</a>
	      </li>
	        <li class="nav-item active">
	        <a class="nav-link" href="Bookings.jsp" tabindex="-1">Bookings<span class="sr-only">(current)</span></a>
	      </li>
	    </ul>
	    
	  </div>
	</nav>
<!-- NavBarEnds -->


<div class="h1 text-uppercase text-dark text-center"> Travel Experts- REST API Bookings</div>
      
      <div class="jumbotron collapse bg-secondary text-white" id="booking">
        <h1 class="display-4 font-weight-bold text-center" id="formTitle"></h1>
        <div class="form-row mt-6">
          <div class="form-group col-sm-12">
            <label for="bkid" class="font-weight-bold">Booking ID:</label>
            <input type="text" class="form-control form-control-lg font-weight-bold" id="bkid" placeholder="Booking ID" disabled>
          </div>

          
          <div class="form-group  col-sm-12">
            <label for="bknm" class="font-weight-bold">Booking Number:</label>
            <input type="text" class="form-control form-control-lg" id="bknm"  placeholder="Booking Number" required>
      
          </div>

        </div>

          <div class="form-row">
            <div class="form-group col-sm-12">
              <label for="trcnt" class="font-weight-bold">Traveler count:</label>
              <input type="number" min="0" class="form-control form-control-lg" id="trcnt" placeholder="Traveler Count" required>
            </div>
          
           
            <div class="form-group  col-sm-12">
              <label for="csid" class="font-weight-bold">Customer Id:</label>
              <input type="text" class="form-control form-control-lg" id="csid" placeholder="Customer Id" required>
            </div>
          </div>
      
      
        <div class="form-row">
          <div class="form-group  col-sm-12">
            <label for="trid" class="font-weight-bold">Trip Type ID:</label>
            <input type="text" class="form-control form-control-lg" id="trid" placeholder="Trip Type ID" required>
          </div>


          <div class="form-group  col-sm-12">
            <label for="pkid" class="font-weight-bold">Package ID:</label>
            <input type="number" min="1" class="form-control form-control-lg" id="pkid"  placeholder="Package ID" required>
          </div>
        </div>

        <div class="form-row">
          
            <button class="col-sm-12 btn btn-primary m-2 btn-lg btn-block badge-pill font-weight-bold" type="button"  id="submit">Submit</button>
            <button class="col-sm-12 btn btn-primary m-2 btn-lg btn-block badge-pill font-weight-bold" type="reset" id="cancel">Cancel</button>
        </div>

        <div class="h4 text-white font-weight-bold" id="error"></div>
      
      </div>


     

      
     <div  id="hideshow">

      <div  class="form-row m-4" >

        <div class="col-sm-12 col-md-4 col-lg-4">
          <button type="button" class="btn btn-info btn-block h-75 m-4 font-weight-bold" id="btn">Sort Toggle</button>

        </div>
        <div class="col-sm-12 col-md-4 col-lg-4">
           
        <button type="button" class="btn btn-primary btn-block h-75 m-4  font-weight-bold" id="addButton">Add Booking</button>

        </div>

      
        <div class="form-group col-sm-12 col-md-4 col-lg-4">
          <input class="form-control input-group-lg m-4 input-group-lg h-75 " id="search" placeholder="Search by Booking ID, Customer ID, Package ID">

        </div>
        
      </div>
      

      <div class="col-12">

        
        <table class="table table-hover table-bordered  text-center font-weight-bold" id="bookingData">
    
          <thead class="thead-dark">
            <tr>
              <th scope="col">Booking Id</th>
              <!-- <th scope="col">Booking Date</th> -->
              <th scope="col">Booking Number</th>
              <th scope="col">Traveler Count</th>
              <th scope="col">Customer ID</th>
              <th scope="col">Trip Type ID</th>
              <th scope="col">Package ID</th>
              <th scope="col">Edit Booking</th>
              <th scope="col">Delete Booking</th>
            
           
            </tr>
          </thead>
          <tbody id="tablerow">
      
          </tbody>
        </table>


      </div>
     

         
    
   


     </div>

<script src="bookings1.js"></script>


</body>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</html>
