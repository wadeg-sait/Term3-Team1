/**
 * 
 */

function enableControls(){
	console.log("in enableControls");
	document.getElementById("agtFirstName").disabled=false;
	document.getElementById("agtMiddleInitial").disabled=false;
	document.getElementById("agtLastName").disabled=false;
	document.getElementById("agtBusPhone").disabled=false;
	document.getElementById("agtEmail").disabled=false;
	document.getElementById("agtPosition").disabled=false;
	document.getElementById("btnEdit").disabled=true;
	document.getElementById("btnReset").style="display:block";
	document.getElementById("btnReset").disabled=false;
	document.getElementById("btnSave").style="display:block";
	document.getElementById("btnSave").disabled=true;
	
}

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

function updateAgent() {
	System.out.println("in update");
	console.log("In update");
	var req = new XMLHttpRequest();
	var obj = new Object();
	obj.agentId = document.getElementById("agentId").value;
	obj.agtFirstName= document.getElementById("agtFirstName").value;
	obj.agtMiddleInitial= document.getElementById("agtMiddleInitial").value;
	obj.agtLastName =document.getElementById("agtLastName").value;
	obj.agtBusPhone =document.getElementById("agtBusPhone").value;
	obj.agtEmail = document.getElementById("agtEmail").value;
	obj.agtPosition = document.getElementById("agtPosition").value;
	obj.agencyId =document.getElementById("agencyId").value;
	var data = JSON.stringify(obj);
	req.open("POST","http://localhost:8080/Workshop7-1/rs/agent/postagent");
	req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	req.send(data);
}

function loadAgent(agentId) {
	console.log("in loadAgent, agentId=" + agentId);
	var req = new XMLHttpRequest();
	req.onreadystatechange = function(){
		if (req.readyState == 4 && req.status == 200){
				var agent = JSON.parse(req.responseText);
				var agentDiv = document.getElementById("agentDiv");			
				var agentDetails = document.getElementById("agentDetails");
				agentDetails.style="display:block";
				document.getElementById("agentId").value = agent.agentId;
				document.getElementById("agentId").disabled=true;
				document.getElementById("agtFirstName").value = agent.agtFirstName;
				document.getElementById("agtFirstName").disabled=true;
				document.getElementById("agtMiddleInitial").value = agent.agtMiddleInitial;
				document.getElementById("agtMiddleInitial").disabled=true;
				document.getElementById("agtLastName").value = agent.agtLastName;
				document.getElementById("agtLastName").disabled=true;
				document.getElementById("agtBusPhone").value = agent.agtBusPhone;
				document.getElementById("agtBusPhone").disabled=true;
				document.getElementById("agtEmail").value = agent.agtEmail;
				document.getElementById("agtEmail").disabled=true;
				document.getElementById("agtPosition").value = agent.agtPosition;
				document.getElementById("agtPosition").disabled=true;
				document.getElementById("agencyId").value = agent.agencyId;
				document.getElementById("agencyId").disabled=true;
				document.getElementById("btnEdit").disabled=false;
				document.getElementById("btnReset").style="display:block";
				document.getElementById("btnReset").disabled=true;
				document.getElementById("btnSave").style="display:block";
				document.getElementById("btnSave").disabled=true;
			}
	}
	
req.open("GET","http://localhost:8080/Workshop7-1/rs/agent/getagent/"+ agentId)
req.send();

}
