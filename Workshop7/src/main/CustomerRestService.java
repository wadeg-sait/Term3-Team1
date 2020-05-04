package main;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.google.gson.Gson;

import model.Booking;
import model.Customer;



@Path("/customers")
public class CustomerRestService {
	
	
	BookingDBConnection bookdb= new BookingDBConnection();
	EntityManagerFactory factory =Persistence.createEntityManagerFactory("Workshop7");
	
	@GET
	@Path("/getCustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customers> getCustomers()
	
	{	
		System.out.println("Test");
		return bookdb.getCustomers();

	}

	@GET
	@Path("/getCustomers/{ id }")
	@Produces(MediaType.APPLICATION_JSON)
	public Customers getCustomer(@PathParam("id") int id)
	{
		return bookdb.getCustomer(id);	
	}

	@POST
	@Path("/postCustomer")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postSomething(String jsonString) {
		
		EntityManager em = factory.createEntityManager();
		Gson gson = new Gson();
		Customer customer = gson.fromJson(jsonString, Customer.class);
		em.getTransaction().begin(); 
		Customer newCustomer = em.merge(customer);
		em.getTransaction().commit(); 
		em.close(); 
	 
        return "Customer has been added";	
	}

	@PUT
	@Path("/updateCustomer")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateBooking(String jsonString)
	{  
		EntityManager em = factory.createEntityManager();
		Gson gson = new Gson();
		//Type type = new TypeToken<Agent>() {}.getType();
		Customer customer= gson.fromJson(jsonString, Customer.class);
		  em.getTransaction().begin();
		  em.merge(customer);
		  em.getTransaction().commit(); 
		  em.close();	 
		return "Customer has been Updated";
	}

	@DELETE 
	@Path("/deleteCustomer/{id}")
	public String deleteCustomer(@PathParam("id") int id)
	
	{
		Customers customer= bookdb.getCustomer(id);
		if (customer.getCustomerId()!=0)
		{
			bookdb.deleteCustomer(id);
			if (bookdb.getCustomer(customer.getCustomerId()).getCustomerId()!=0)
			{
				return "There was an error while deleting this customer";
			}
			
			else {
				return "Customer deleted";
			}
			
		}
		
		return "Customer not present in table";
			
	
	}
}
