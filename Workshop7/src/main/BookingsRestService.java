package main;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Agent;
import model.Booking;


@Path("/bookings")
public class BookingsRestService {
	
	BookingDBConnection bookdb= new BookingDBConnection();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bookings> getBookings()
	
	{	
		System.out.println("Test");
		return bookdb.getBookings();

	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bookings getBooking(@PathParam("id") int id)
	{
		return bookdb.getBooking(id);
		
	}

	@GET
	@Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
	public String getSomething(@QueryParam("request") String request ,
			 @DefaultValue("1") @QueryParam("version") int version) {

        return "test123";	
	}
	


	@POST
	@Path("/postBooking")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postSomething(String jsonString) {
		
	
		EntityManagerFactory factory =
		Persistence.createEntityManagerFactory("Workshop7");
		EntityManager em =
		 factory.createEntityManager();
		

		Gson gson = new Gson();
		Booking booking = gson.fromJson(jsonString, Booking.class);
		
		System.out.println(booking);
	
		em.getTransaction().begin(); 
		Booking newBooking = em.merge(booking);
		em.getTransaction().commit(); em.close(); factory.close();
		 
        return "Booking has been posted";	
	}

	@PUT
	@Path("/updateBooking")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateBooking(String jsonString)
		
	
	{
		
		  EntityManagerFactory factory =
		  Persistence.createEntityManagerFactory("Workshop7"); EntityManager em =
		  factory.createEntityManager();
		 

		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		Booking booking = gson.fromJson(jsonString, Booking.class);
		 
		System.out.println(booking.getBookingNo());
		
		  em.getTransaction().begin(); em.persist(booking);
		  em.getTransaction().commit(); em.close(); factory.close();
		 

			 
		return "Booking has been Updated";
	}

	@DELETE 
	@Path("deleteBooking/{id}")
	public String deleteBooking(@PathParam("id") int id)
	
	{
		Bookings booking= bookdb.getBooking(id);
		if (booking.getBookingId()!=0)
		{
			bookdb.deleteBooking(id);
			if (bookdb.getBooking(booking.getBookingId()).getBookingId()!=0)
			{
				return "There was an error while deleting this booking";
			}
			
			else {
				return "Booking deleted";
			}
			
		}
		
		return "Booking not present in table";
			
	
	}
}
