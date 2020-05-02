/**
 * 
 */
function loadAllAgents() {
	console.log("in loadAllAgents");
	var req = new XMLHttpRequest();
	
	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var agentsArray = JSON.parse(req.responseText);
			var agentSelect = document.getElementById("agents");

			for (i = 0; i < agentsArray.length; i++) {
				var agent = agentsArray[i];
				var option = document.createElement("option");
				option.text = agent.agtFirstName + " " + agent.agtLastName;
				option.value = agent.agentId;
				agentSelect.add(option);
			}
		}
	}
	req.open("GET", "rs/agent/getallagents");
	req.send();
}

function loadAgent(agentId) {
	console.log("in loadAgent, agentId=" + agentId);
	//var agentDiv = document.getElementById("agentDiv");
	
	//agentDiv.innerHTML = "agentId: " + agentId + "<br />"
	
	var req = new XMLHttpRequest();
	req.onreadystatechange = function(){
		if (req.readyState == 4 && req.status == 200){
				var agent = JSON.parse(req.responseText);
				var agentDiv = document.getElementById("agentDiv");
				
				agentDiv.innerHTML = "agentId: " + agent.agentId + "<br />"
				+ "agtFirstName: " + agent.agtFirstName + "<br />"
				+ "agtMiddleInitial: " + agent.agtMiddleInitial + "<br />"
				+ "agtLastName: " + agent.agtLastName + "<br />"
				+ "agtBusPhone: " + agent.agtBusPhone + "<br />"
				+ "agtEmail: " + agent.agtEmail + "<br />"
				+ "agtPosition: " + agent.agtPosition + "<br />"
				+ "agencyId: " + agent.agencyId + "<br />" + "agtUserId: "
				+ agent.agtUserId + "<br />" + "agtPassword: "
				+ agent.agtPassword + "<br />"
				var agentDetails = document.getElementById("agentDetails");
				agentDetails.style="display:block";
			}
	}
	
req.open("GET","http://localhost:8080/Workshop7-1/rs/agent/getagent/"+ agentId)
req.send();

}

function loadForm(agentId) {
	console.log("in loadForm, agentId=" + agentId);
	var req = new XMLHttpRequest();

	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var agent = JSON.parse(req.responseText);
			document.getElementById("agentId").value = agent.agentId;
			document.getElementById("agtFirstName").value = agent.agtFirstName;
			document.getElementById("agtMiddleInitial").value = agent.agtMiddleInitial;
			document.getElementById("agtLastName").value = agent.agtLastName;
			document.getElementById("agtBusPhone").value = agent.agtBusPhone;
			document.getElementById("agtEmail").value = agent.agtEmail;
			document.getElementById("agtPosition").value = agent.agtPosition;
			document.getElementById("agencyId").value = agent.agencyId;
			document.getElementById("agtUserId").value = agent.agtUserId;
			document.getElementById("agtPassword").value = agent.agtPassword;
		}
	}
	req.open("GET", "rs/agent/getagent/" + agentId);
	req.send();

}

function updateAgent() {
	console.log("in updateAgent");
	
	//get a collection of the child nodes inside the div of fields in the agentupdate.html file 
	var divChildren = $("#myFields input");
	//create a JSON object shell
	var mydata = {};
	//loop through the fields and add the fieldname and value to the object
	for (i = 0; i < divChildren.length; i++) {
		mydata[divChildren[i].id] = divChildren[i].value;

	}
	//console.log(JSON.stringify(mydata));

	$.ajax({
		url:"rs/agent/postagent",
		type:"POST",
		data:JSON.stringify(mydata),
		complete:function(req,stat){ $("#message").html(stat); },
		success:function(data){ $("#message").append("<br />" + data); },
		dataType:"text",
		contentType:"application/json; charset=UTF-8"
	});
	

}