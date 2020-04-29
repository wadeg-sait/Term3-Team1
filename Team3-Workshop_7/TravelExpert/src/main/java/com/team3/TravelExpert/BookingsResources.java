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




@Path("bookings")
public class BookingsResources {
	
	BookingDBConnection bookdb= new BookingDBConnection();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bookings> getBookings()
	
	{	
		System.out.println("Test");
		return bookdb.getBookings();

	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bookings getBooking(@PathParam("id") int id)
	{
		return bookdb.getBooking(id);
		
	}

	@POST
	@Path("addBooking")
	@Consumes(MediaType.APPLICATION_JSON)
	public String  addBooking(String jsonString)
	
	{
		System.out.print(jsonString);
		
		Gson gson = new Gson();
		Bookings b = gson.fromJson(jsonString, Bookings.class);
		
		
	
		
		System.out.println(b);
		bookdb.addBooking(b);
		
		return jsonString;
		
		
	}
	
	@PUT
	@Path("updateBooking")
	@Consumes(MediaType.APPLICATION_JSON)
	public Bookings updateBooking(String jsonString)
	
	{
		Gson gson = new Gson();
		Bookings ub = gson.fromJson(jsonString, Bookings.class);
		System.out.println(ub);
		
		if(bookdb.getBooking(ub.getBookingId()).getBookingId()==0)
		{
			bookdb.addBooking(ub);
		}
		
		else {
			bookdb.updateBooking(ub);
		}
		System.out.println(ub);
		
		return ub;
	}
	
	@DELETE 
	@Path("deleteBooking/{id}")
	public Bookings deleteBooking(@PathParam("id") int id)
	
	{
		Bookings booking= bookdb.getBooking(id);
		if (booking.getBookingId()!=0)
			bookdb.deleteBooking(id);
		
		return booking;
		
	}
	
	
	
		
}
