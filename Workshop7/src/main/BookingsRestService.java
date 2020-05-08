package main;

//  zoha Ahmed code
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

// API for all bookings
@Path("/bookings")
public class BookingsRestService {
	
	BookingDBConnection bookdb= new BookingDBConnection();
	EntityManagerFactory factory =Persistence.createEntityManagerFactory("Workshop7");
	
	@GET
	@Path("/getbookings")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bookings> getBookings()
	
	{	
		System.out.println("Test");
		return bookdb.getBookings();

	}
// API for booking by id 	
	@GET
	@Path("/getbooking/{ id }")
	@Produces(MediaType.APPLICATION_JSON)
	public Bookings getBooking(@PathParam("id") int id)
	{
		return bookdb.getBooking(id);	
	}
// API for adding booking	
	
	@POST
	@Path("/postBooking")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postSomething(String jsonString) {
		
		EntityManager em = factory.createEntityManager();
		Gson gson = new Gson();
		Booking booking = gson.fromJson(jsonString, Booking.class);
		em.getTransaction().begin(); 
		Booking newBooking = em.merge(booking);
		em.getTransaction().commit(); 
		em.close(); 
	 
        return "Booking has been posted";	
	}
	
	//API for updating bookings

	@PUT
	@Path("/updateBooking")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateBooking(String jsonString)
	{  
		EntityManager em = factory.createEntityManager();
		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		Booking booking = gson.fromJson(jsonString, Booking.class);
		  em.getTransaction().begin();
		  em.merge(booking);
		  em.getTransaction().commit(); 
		  em.close();	 
		return "Booking has been Updated";
	}

	
	//Deleting API bookings
	
	@DELETE 
	@Path("/deleteBooking/{id}")
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
