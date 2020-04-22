package sample.BookingInfo;
/*
Created by Wade Grimm
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class BookingData {
    public static Connection Connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelExperts","jdbcusr","jdbc2020");
        return conn;
    }

    public static ObservableList<BookingDetail> loadBookings()
    {
        ObservableList<BookingDetail> bd = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelExperts","jdbcusr","jdbc2020");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.BookingID, b.BookingNo, c.CustFirstName, c.CustLastName " +
                    "FROM Bookings b inner join Customers c on b.customerid = c.customerid");
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                BookingDetail bv = new BookingDetail(Integer.toString( rs.getInt("BookingID")),
                        rs.getString("BookingNo"),
                        rs.getString("CustFirstName") + " "+ rs.getString("CustlastName"));
               /* bv.setBookingID(Integer.toString( rs.getInt("BookingID")));
                bv.setBookingNo(rs.getString("BookingNo"));
                bv.setName(rs.getString("CustFirstName") + " "+ rs.getString("CustlastName"));*/
                //bv.setLastName(rs.getString("CustlastName"));
                bd.add(bv);
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return bd;
    }

    public static BookingDetail getBookingDetail(String bookingNum)
    {
        //ObservableList<BookingDetail> bd = FXCollections.observableArrayList();
        BookingDetail bv = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelExperts","jdbcusr","jdbc2020");
            Statement stmt = conn.createStatement();
            String sql = "SELECT b.BookingID, b.BookingDate, b.CustomerId, b.TravelerCount, " +
                    "b.CustomerId, b.TripTypeID ,c.CustFirstName, c.CustLastName, bd.TripStart, bd.TripEnd, bd.Destination, " +
                    "bd.AgencyCommission, bd.ClassId, bd.ProductSupplierId, bd.Description, bd.ItineraryNo, " +
                    "bd.BasePrice, bd.RegionId, bd.FeeId " +
                    "FROM Bookings b inner join Customers c on b.customerid = c.customerid " +
                    "inner join bookingdetails bd on b.BookingId = bd.BookingId " +
                    "WHERE b.BookingNo = " + "'" + bookingNum + "'";
            ResultSet rs = stmt.executeQuery(sql);
            //ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                    bv = new BookingDetail(Integer.toString( rs.getInt("BookingID")),
                        bookingNum,
                        rs.getString("CustFirstName") + " "+ rs.getString("CustLastName"),
                        rs.getDate("BookingDate"), rs.getInt("CustomerID"), rs.getInt("TravelerCount"),
                        rs.getString("TripTypeID"), rs.getDate("TripStart"),rs.getDate("TripEnd"),rs.getString("Destination"),
                        rs.getFloat("AgencyCommission"),rs.getString("ClassID"),rs.getInt("ProductSupplierID"),rs.getString("Description"),
                        rs.getInt("ItineraryNo"),rs.getFloat("BasePrice"),rs.getString("RegionID"),rs.getString("FeeID"));


            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return bv;
    }

@Override
public String toString(){

    return null;
}

}
