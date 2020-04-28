/*package com.team3.TravelExpert;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 
	@Path("agents")
	public class AgentsResource {
		
		BookingDBConnection bookdb= new BookingDBConnection();
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Agents> getAgents()
		
		{	
		
		}
		
		@GET
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Agents getAgent(@PathParam("id") int id)
		{
			
		}
		
		@POST
		@Path("addAgent")
		@Consumes(MediaType.APPLICATION_JSON)
		public Agents  addAgent(Agents b)
		
		{
		
			
			
		}
		
		@PUT
		@Path("updateAgent")
		@Consumes(MediaType.APPLICATION_JSON)
		public Agents updateAgent(Agents ub)
		{
			
		}
		
		@DELETE 
		@Path("deleteAgent/{id}")
		public Agents deleteAgent(@PathParam("id") int id)
		
		{
			
		}
		
		
}*/
