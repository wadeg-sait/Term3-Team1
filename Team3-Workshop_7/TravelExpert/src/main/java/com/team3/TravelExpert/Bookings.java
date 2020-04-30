package com.team3.TravelExpert;

import java.sql.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;



@XmlRootElement

public class Bookings {
	
	
	

	private int BookingId;
	@XmlElement
	@XmlSchemaType(name="date")
	private Date  BookingDate;
	private String BookingNo;
	private double TravelerCount;
	private int CustomerId;
	private String TripTypeId;
	private int PackageId;
	
	
	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public Date getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}
	public String getBookingNo() {
		return BookingNo;
	}
	public void setBookingNo(String bookingNo) {
		BookingNo = bookingNo;
	}
	public double getTravelerCount() {
		return TravelerCount;
	}
	public void setTravelerCount(double travelerCount) {
		TravelerCount = travelerCount;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getTripTypeId() {
		return TripTypeId;
	}
	public void setTripTypeId(String tripTypeId) {
		TripTypeId = tripTypeId;
	}
	public int getPackageId() {
		return PackageId;
	}
	public void setPackageId(int packageId) {
		PackageId = packageId;
	}
	@Override
	public String toString() {
		return "Bookings [BookingId=" + BookingId + ", BookingDate=" + BookingDate + ", BookingNo=" + BookingNo
				+ ", TravelerCount=" + TravelerCount + ", CustomerId=" + CustomerId + ", TripTypeId=" + TripTypeId
				+ ", PackageId=" + PackageId + "]";
	}


	
	
	
	
	
	

}
