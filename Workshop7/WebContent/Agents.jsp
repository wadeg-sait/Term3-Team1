<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/travelExpert.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="ajax.js"></script>
<script src="jquery.js"></script>
<title>Travel Expert</title>
</head>

<script src="travelExpert.js"></script>
<body onload="loadAllAgents()">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="#">Travel Expert</a>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home
			</a></li>
			<li class="nav-item"><a class="nav-link" href="Customers.jsp">Customers</a>
			</li>
			<li class="nav-item active"><a class="nav-link"
				href="Agents.jsp" tabindex="-1">Agents<span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="Bookings.jsp"
				tabindex="-1">Bookings</a></li>
		</ul>

	</div>
	</nav>
	<div class="offset-1" style="height: 90vh; margin-top: 25px">
		<select name='agents' id='agents' onchange='loadAgent(this.value)'>
			<option value=''>Select an agent from the list</option>
		</select>


		<div id='agentDetails'
			class="section jumbotron see-through small-pad col-md-6"
			style="display: none">
			<!-- Section div -->

			<div class="form-row">
				<div class="form-group col-6">
					<label for="agentId">Agent Id:</label> <input type="text"
						class="form-control" id="agentId" placeholder="Agent ID"
						name="agentId" disabled>
				</div>
				<div class="form-group col-6">
					<label for="agencyId">Agency Id:</label> <input type="text"
						class="form-control" id="agencyId" placeholder="Agency ID"
						name="agencyId" disabled>

				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-4">
					<label for="agtFirstName">First Name:</label> <input type="text"
						class="form-control" id="agtFirstName" placeholder="First Name"
						name="agtFirstName" disabled>
				</div>
				<div class="form-group col-4">
					<label for="agtMiddleInitial">Middle Initial:</label> <input
						type="text" class="form-control" id="agtMiddleInitial"
						placeholder="Middle Initial" name="agtMiddleInitial" disabled>

				</div>
				<div class="form-group col-4">
					<label for="agtLastName">Last Name:</label> <input type="text"
						class="form-control" id="agtLastName" placeholder="Last Name"
						name="agtLastName" disabled>

				</div>
			</div>
			<div class="form-row ">
				<div class="form-group col-6">
					<label for="agtBusPhone">Business Phone:</label> <input type="text"
						class="form-control" id="agtBusPhone" placeholder="(403)555-1234"
						name="agtBusPhone" disabled>

				</div>
				<div class="form-group col-6">
					<label for="agtPosition">Position</label> <input type="text"
						class="form-control" id="agtPosition"
						placeholder="Senior Manager, Junior Sales" name="agtPosition" disabled>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-6">
					<label for="agtEmail">Email</label> <input type="email"
						class="form-control" id="agtEmail" placeholder="Email"
						name="agtEmail" disabled>
				</div>

			</div>

		</div>
		<!-- Section div -->
	</div>

</body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</html>