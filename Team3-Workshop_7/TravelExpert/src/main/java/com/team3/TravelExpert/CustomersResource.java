package com.team3.TravelExpert;


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

import com.google.gson.Gson;


@Path("customers")
public class CustomersResource {
	BookingDBConnection bookdb= new BookingDBConnection();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customers> getCustomers()
	
	{	
		System.out.println("Test");
		return bookdb.getCustomers();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customers getCustomers(@PathParam("id") int id)
	{
		return bookdb.getCustomer(id);
	}
	
	@DELETE 
	@Path("deleteCustomer/{id}")
	public Customers deleteCustomer(@PathParam("id") int id)
	
	{
		Customers customer= bookdb.getCustomer(id);
		if (customer.getCustomerId()!=0)
			bookdb.deleteCustomer(id);
		
		return customer;
	}
	
	@POST
	@Path("addCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	public String  addCustomer(String jsonString)
	
	{
		System.out.print(jsonString);
		
		Gson gson = new Gson();
		Customers b = gson.fromJson(jsonString, Customers.class);
		
		System.out.println(b);
		bookdb.addCustomer(b);
		
		return jsonString;
		
		
	}
	
	
	
	@PUT
	@Path("updateCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Customers updateCustomer(String jsonString)
	{
		
		Gson gson = new Gson();
		Customers ub = gson.fromJson(jsonString, Customers.class);
		System.out.println(ub);
		if (bookdb.getCustomer(ub.getCustomerId()).getCustomerId()==0)
		{
			bookdb.addCustomer(ub);
		}
		
		
		else {
			bookdb.updateCustomer(ub);
		}
		System.out.println(ub);
		
		return ub;
		
	}
	

	
}