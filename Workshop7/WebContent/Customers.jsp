<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/travelExpert.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">

<title>Travel Expert</title>
<style>

body {
      background-image: url("imgs/background1.jpg");

      color: black;
      font-family: "Quicksand", sans-serif;
      font-weight: 300;
      background-size: cover; 
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
      <li class="nav-item">
        <a class="nav-link" href="index.jsp">Home</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="Customers.jsp">Customers<span class="sr-only">(current)</span></a>
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
<div  class="row collapse" id="customer" data-toggle="collapse" class="container" style="background-color:lightyellow;border:solid;margin-top:50px;font-size: 18px;font-style:italic;font-weight: bold;font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;">
        <div  >
          <div class="col" style="margin-left:200px">
            <h3> Travel World Registration Form</h3>
          <form  class="form-inline" style="font-size: 18px;font-style:italic;font-weight: bold;font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;"> 
                    <div class="col-md-4 mb-3 form-group">
                        <label for="bkid" >Booking ID</label>
                        <input type="text" class="form-control " id="bkid" required>
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="csdt">Customer ID</label>
                      <input type="text" class="form-control" id="csdt">
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="cfn">First Name</label>
                      <input type="text" class="form-control" id="cfn" required>
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="cfn">Last Name</label>
                      <input type="text" class="form-control" id="cln">
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="cad">Address</label>
                      <input type="text" class="form-control" id="cad" required>
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="cct">City</label>
                      <input type="text" class="form-control" id="cct" required>
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="chp">Home Phone</label>
                      <input type="text" class="form-control" id="chp" required>
                    </div>
                     <button class="btn btn-primary badge-pill" type="submit" style="margin-left:40px" id="submit">Submit</button>
                    <button class="btn btn-primary badge-pill" type="reset" style="margin-left:10px" id="cancel">Cancel</button>
                  </form>
                          
                </div>
        </div>
    </div>
<h3>Customer Details</h3>
    <table class="table table-hover table-bordered  text-center font-weight-bold" id="customerData">
      <thead class="thead-dark">
        <tr>
          <th scope="col">Customer ID</th>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col">Address</th>
          <th scope="col">City</th>
          <th scope="col">Home Phone</th>
          <th scope="col">Email</th>
          <th scope="col">Edit Booking</th>
          <th scope="col">Delete Booking</th>
        
       
        </tr>
      </thead>
      <tbody id="tablerow">
  
      </tbody>
    </table>




</body>
<script src="Customers.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>