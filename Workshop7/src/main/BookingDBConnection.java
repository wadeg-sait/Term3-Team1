
/* Zoha Ahmed Code*/

package main;


import java.sql.*;
import java.sql.Date;
import java.util.*;

import model.Customer;


/* data base connection class using jdbc**/

public class BookingDBConnection {

	
Connection con = null;
	
	
	public BookingDBConnection(){
		
		
		String url="jdbc:mysql://localhost:3306/travelexperts";
		String username= "root";
		String password ="";
		try
		
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);		
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
			
	}
	/** querry for all bookings**/
	public List<Bookings> getBookings(){
		
		List<Bookings> bookingslist = new ArrayList<Bookings>();
		String sql = "select * from  bookings";
		 try 
		 {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 
			 int i=0;
			 while(rs.next())
			 {
				  Bookings booking= new Bookings();
				 	
				 booking.setBookingId(rs.getInt("BookingID"));	
				 booking.setBookingDate(rs.getDate("BookingDate"));
				 booking.setBookingNo(rs.getString("BookingNo"));
				 booking.setTravelerCount(rs.getDouble("TravelerCount"));
				 booking.setCustomerId(rs.getInt("CustomerId"));
				 booking.setTripTypeId(rs.getString("TripTypeId"));
				 booking.setPackageId(rs.getInt("PackageId"));
				 
				 bookingslist.add(booking);
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
			 
		 }
		 
		 return bookingslist;
		
}
	
	/** getting booking by id**/
public Bookings getBooking(int id){
		
		
		String sql = "select * from  bookings where Bookingid="+id;
	
		 Bookings booking= new Bookings();
		
		 try 
		 {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 
			 if (rs.next())
			 {	
				 booking.setBookingId(rs.getInt("BookingID"));	
				 booking.setBookingDate(rs.getDate("BookingDate"));
				 booking.setBookingNo(rs.getString("BookingNo"));
				 booking.setTravelerCount(rs.getDouble("TravelerCount"));
				 booking.setCustomerId(rs.getInt("CustomerId"));
				 booking.setTripTypeId(rs.getString("TripTypeId"));
				 booking.setPackageId(rs.getInt("PackageId"));
				 
			 }
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
			 
		 }
		 
		return booking;
	
		
	}
/** deleting booking**/
	public void deleteBooking(int id)
	{
		String sql= "delete from bookings where BookingId=?";
		try 
		 {	System.out.println("Im here to delete");
			 PreparedStatement st = con.prepareStatement(sql);
		
	
			 st.setInt(1, id);
		
			
			 st.executeUpdate();
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
			 
		 }
	}
	// adding booking
	public void addBooking(Bookings b)
	{
		String sql= "insert into  bookings values (?,?,?,?,?,?,?)";
		try 
		 {	System.out.println("Im heer");
			 PreparedStatement st = con.prepareStatement(sql);
			 st.setInt(1, b.getBookingId());
			 if (b.getBookingDate()==null){
				 st.setNull(2, java.sql.Types.DATE);
				
			 }
			 else{
				 st.setDate(2,b.getBookingDate());
			 }
		
			 st.setString(3, b.getBookingNo());
			
			 st.setDouble(4, b.getTravelerCount());
			 
			 if (b.getCustomerId()==0){
				 st.setNull(5, Types.INTEGER);
			 }
			 else
			 {
				 st.setInt(5, b.getCustomerId());
			 }
			 st.setString(6, b.getTripTypeId());
			 if (b.getPackageId()==0){
				 st.setNull(7, Types.INTEGER);
			 }
			 else
			 {
				 st.setInt(7, b.getPackageId());	 
			 }
		
			 
			 
			 
			 st.executeUpdate();
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
			 
		 }
	}
		// adding booking
	public void updateBooking(Bookings b)
	{
		String sql= "update bookings set BookingDate=?, BookingNo=?, TravelerCount=?, CustomerId=?, TripTypeId=?, PackageId=? where BookingId=?";
		try 
		 {	System.out.println("Im here");
			 PreparedStatement st = con.prepareStatement(sql);
			 
			 if (b.getBookingDate()==null){
				 st.setNull(1, java.sql.Types.DATE);
				
			 }
			 else{
				 st.setDate(1,b.getBookingDate());
			 }
		
			 st.setString(2, b.getBookingNo());
			
			 st.setDouble(3, b.getTravelerCount());
			 
			 if (b.getCustomerId()==0){
				 st.setNull(4, Types.INTEGER);
			 }
			 else
			 {
				 st.setInt(4, b.getCustomerId());
			 }
			 st.setString(5, b.getTripTypeId());
			 if (b.getPackageId()==0){
				 st.setNull(6, Types.INTEGER);
			 }
			 else
			 {
				 st.setInt(6, b.getPackageId());	 
			 }
			 st.setInt(7, b.getBookingId());
		
			 
			 
			 
			 st.executeUpdate();
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
			 
		 }
	 
	
}
	
	public List<Customer> getCustomers(){
		
		List<Customer> customerslist = new ArrayList<Customer>();
		String sql = "select * from  customers";
		 try 
		 {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 
	
			 while(rs.next())
			 {
				 Customer customer= new Customer();
				 	
				 customer.setCustomerId(rs.getInt(1));
				 customer.setCustFirstName(rs.getString(2));
				 customer.setCustLastName(rs.getString(3));
				 customer.setCustAddress(rs.getString(4));
				 customer.setCustCity(rs.getString(5));
				 customer.setCustProv(rs.getString(6));
				 customer.setCustPostal(rs.getString(7));
				 customer.setCustCountry(rs.getString(8));
				 customer.setCustHomePhone(rs.getString(9));
				 customer.setCustBusPhone(rs.getString(10));
				 customer.setCustEmail(rs.getString(11));
				 customer.setAgentId(rs.getShort(12));
				
				 customerslist.add(customer);
			 }
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
			 
		 }
		 
		 return customerslist;
		
		
	}
	
	
	public Customer getCustomer(int id){
		
		
		String sql = "select * from  customers where CustomerId="+id;
		 Customer customer= new Customer();
	
		try 
		 {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 
			 int i=0;
			 while(rs.next())
			 {	
				 customer.setCustomerId(rs.getInt(1));
				 customer.setCustFirstName(rs.getString(2));
				 customer.setCustLastName(rs.getString(3));
				 customer.setCustAddress(rs.getString(4));
				 customer.setCustCity(rs.getString(5));
				 customer.setCustProv(rs.getString(6));
				 customer.setCustPostal(rs.getString(7));
				 customer.setCustCountry(rs.getString(8));
				 customer.setCustHomePhone(rs.getString(9));
				 customer.setCustBusPhone(rs.getString(10));
				 customer.setCustEmail(rs.getString(11));
				 customer.setAgentId(rs.getShort(12));
				
			 }
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
			 
		 }
		 
		 return customer;
	
		
	}
	
	public void deleteCustomer(int id)
	{
		String sql= "delete from customers where CustomerId=?";
		try 
		 {	System.out.println("Im here to delete");
			 PreparedStatement st = con.prepareStatement(sql);
		

			 st.setInt(1, id);
		
			
			 st.executeUpdate();
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
			 
		 }
	
	}
	
	
	
	
	
	
	
	
	
}
