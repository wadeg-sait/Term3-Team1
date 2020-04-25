package sample.BookingInfo;
/*
Created by Wade Grimm
 */


import javafx.beans.property.SimpleStringProperty;


import java.sql.Date;

public class BookingDetail {

    private final SimpleStringProperty bookingID;
    private final SimpleStringProperty bookingNo;
    private final SimpleStringProperty name;

    private Date bookingDate;
    private int travelerCount;
    private int customerID;
    private String tripTypeID;
    //private int packageID;
    private int bookingDetailID;
    private int itineraryNo;
    private Date tripStart;
    private Date tripEnd;
    private String description;
    private String destination;
    private float basePrice;
    private float agencyCommission;
    private String regionID;
    private String classID;
    private String feeID;
    private int productSupplierID;

    public BookingDetail(String bookingID, String bookingNo, String name) {
        this.bookingID = new SimpleStringProperty(bookingID);
        this.bookingNo = new SimpleStringProperty(bookingNo);
        this.name = new SimpleStringProperty(name);
    }


    public BookingDetail(String bookingID, String bookingNo, String name, Date bookingDate, Integer customerID, Integer travelerCount, String tripTypeID,
                         Date tripStart, Date tripEnd, String destination, float agencyCommission, String classID, Integer productSupplierID,
                         String description, Integer itineraryNo, float basePrice, String regionID, String feeID) {
        this.bookingID = new SimpleStringProperty(bookingID);
        this.bookingNo = new SimpleStringProperty(bookingNo);
        this.name = new SimpleStringProperty(name);
        this.bookingDate = bookingDate;
        this.customerID = customerID;
        this.travelerCount = travelerCount;
        this.tripTypeID = tripTypeID;
        this.tripStart = tripStart;
        this.tripEnd = tripEnd;
        this.destination = destination;
        this.agencyCommission = agencyCommission;
        this.classID = classID;
        this.productSupplierID = productSupplierID;
        this.description = description;
        this.itineraryNo = itineraryNo;
        this.basePrice  = basePrice;
        this.regionID = regionID;
        this.feeID = feeID;

    }
// getters
    public String getName() {
        return name.get();
    }
    public String getBookingID() {
        return bookingID.get();
    }
    public String getBookingNo() {
        return bookingNo.get();
    }

    //setters
    public void setName(String name) {
        this.name.set(name);
    }
    public void setBookingID(String bookingID) {
        this.bookingID.set(bookingID);
    }
    public void setBookingNo(String bookingNo) {
        this.bookingNo.set(bookingNo);
    }

// property values
    public SimpleStringProperty nameProperty(){
        return name;
    }
    public SimpleStringProperty bookingIDProperty(){
        return bookingID;
    }
    public SimpleStringProperty bookingNoProperty(){
        return bookingNo;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getTravelerCount() {
        return travelerCount;
    }

    public void setTravelerCount(int travelerCount) {
        this.travelerCount = travelerCount;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getTripTypeID() {
        return tripTypeID;
    }

    public void setTripTypeID(String tripTypeID) {
        this.tripTypeID = tripTypeID;
    }

    public int getBookingDetailID() {
        return bookingDetailID;
    }

    public void setBookingDetailID(int bookingDetailID) {
        this.bookingDetailID = bookingDetailID;
    }

    public Integer getItineraryNo() {
        return itineraryNo;
    }

    public void setItineraryNo(int itineraryNo) {
        this.itineraryNo = itineraryNo;
    }

    public Date getTripStart() {
        return tripStart;
    }

    public void setTripStart(Date tripStart) {
        this.tripStart = tripStart;
    }

    public Date getTripEnd() {
        return tripEnd;
    }

    public void setTripEnd(Date tripEnd) {
        this.tripEnd = tripEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getAgencyCommission() {
        return agencyCommission;
    }

    public void setAgencyCommission(float agencyCommission) {
        this.agencyCommission = agencyCommission;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getFeeID() {
        return feeID;
    }

    public void setFeeID(String feeID) {
        this.feeID = feeID;
    }

    public int getProductSupplierID() {
        return productSupplierID;
    }

    public void setProductSupplierID(int productSupplierID) {
        this.productSupplierID = productSupplierID;
    }



}
