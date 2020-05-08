package oosd.team1.workshop8;
// booking  zoha  code
import java.io.Serializable;
import java.sql.Date;

public class Bookings implements Serializable {

    private int BookingId;
    private Date BookingDate;
    private String BookingNo;
    private double TravelerCount;
    private int CustomerId;
    private String TripTypeId;
    private int PackageId;

    public Bookings(int bookingId, Date bookingDate, String bookingNo, double travelerCount, int customerId, String tripTypeId, int packageId) {
        BookingId = bookingId;
        BookingDate = bookingDate;
        BookingNo = bookingNo;
        TravelerCount = travelerCount;
        CustomerId = customerId;
        TripTypeId = tripTypeId;
        PackageId = packageId;
    }

    public Bookings(){

    }

    @Override
    public String toString() {
        return "Booking ID:"+BookingId+",   "+"Booking No:" +BookingNo;
    }

    public void setBookingId(int bookingId) {
        BookingId = bookingId;
    }

    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }

    public void setBookingNo(String bookingNo) {
        BookingNo = bookingNo;
    }

    public void setTravelerCount(double travelerCount) {
        TravelerCount = travelerCount;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public void setTripTypeId(String tripTypeId) {
        TripTypeId = tripTypeId;
    }

    public void setPackageId(int packageId) {
        PackageId = packageId;
    }

    public int getBookingId() {
        return BookingId;
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public String getBookingNo() {
        return BookingNo;
    }

    public double getTravelerCount() {
        return TravelerCount;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public String getTripTypeId() {
        return TripTypeId;
    }

    public int getPackageId() {
        return PackageId;
    }
}
