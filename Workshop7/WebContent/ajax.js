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
	document.getElementById("btnSave").disabled=false;
	document.getElementById("btnDelete").style="display:block";
	document.getElementById("btnDelete").disabled=false;
	
}

function removeOptions(selectElement) {
	   var i, L = selectElement.options.length - 1;
	   for(i = L; i >= 0; i--) {
	      selectElement.remove(i);
	   }
	   
	   var option = document.createElement("option");
		option.text = "Select an agent from the list";
		option.value = "";
		selectElement.add(option);
}


	

function loadAllAgents() {
	console.log("in loadAllAgents");
	agentDetails.style="display:none";
	removeOptions(document.getElementById("agents"));
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
	if(obj.agentId!=0){
		req.open("POST","http://localhost:8080/Workshop7-1/rs/agent/postagent",false);
	}else{
		req.open("PUT","http://localhost:8080/Workshop7-1/rs/agent/putagent",false);
		obj.agentId = null;
	}
	
	req.setRequestHeader("Content-Type", "application/json");
	console.log("json being sent: \n"+data);
	req.send(data);
	//if (req.readyState == 4 && req.status == 200) {
		loadAllAgents();
	//}
}

function loadAgent(agentId) {
	console.log("in loadAgent, agentId=" + agentId);
	
	if(agentId>0 && agentId !=null){
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
					if(agentId >9){
						document.getElementById("btnDelete").disabled=false;
						document.getElementById("btnDelete").style="display:block";
					}else{
						document.getElementById("btnDelete").disabled=true;
						document.getElementById("btnDelete").style="display:none";
					}
				}
		}
		
	req.open("GET","http://localhost:8080/Workshop7-1/rs/agent/getagent/"+ agentId)
	req.send();
	}else{
		agentDetails.style="display:block";
		document.getElementById("btnSave").style="display:block";
		document.getElementById("btnSave").disabled=false;
		document.getElementById("btnEdit").disabled=true;
		document.getElementById("btnReset").style="display:block";
		document.getElementById("btnReset").disabled=true;
		document.getElementById("agentId").disabled=true;
		document.getElementById("agentId").value ="0";
		document.getElementById("agtFirstName").disabled=false;
		document.getElementById("agtFirstName").value=null;
		document.getElementById("agtMiddleInitial").disabled=false;
		document.getElementById("agtMiddleInitial").value=null;
		document.getElementById("agtLastName").disabled=false;
		document.getElementById("agtLastName").value=null;
		document.getElementById("agtBusPhone").disabled=false;
		document.getElementById("agtBusPhone").value=null;
		document.getElementById("agtEmail").disabled=false;
		document.getElementById("agtEmail").value=null;
		document.getElementById("agtPosition").disabled=false;
		document.getElementById("agtPosition").value=null;
		document.getElementById("agencyId").disabled=false;
		document.getElementById("agencyId").value=null;
	}
}

function deleteAgent(agentId) {
	console.log("in loadAgent, agentId=" + agentId);
	if(agentId > 9){
		var req = new XMLHttpRequest();
		req.open("DELETE","http://localhost:8080/Workshop7-1/rs/agent/deleteagent/"+agentId,false);
		req.setRequestHeader("Content-Type", "application/json");
		
		console.log("json being sent: \n"+agentId);
		req.send(agentId);
	}else{
		alert("unable to delete agent:");
		console.log("Can't delete an existing agent");
	}
	//removeOptions(document.getElementById("agents"));
	//if (req.readyState == 4 && req.status == 200) {
		loadAllAgents();
	//}

}