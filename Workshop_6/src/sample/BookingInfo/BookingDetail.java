package sample.BookingInfo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookingDetail {

    private final SimpleStringProperty bookingID;
    private final SimpleStringProperty bookingNo;
    private final SimpleStringProperty name;

    public BookingDetail(String bookingID, String bookingNo, String name) {
        this.bookingID = new SimpleStringProperty(bookingID);
        this.bookingNo = new SimpleStringProperty(bookingNo);
        this.name = new SimpleStringProperty(name);
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





}
