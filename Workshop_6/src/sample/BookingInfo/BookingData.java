package sample.BookingInfo;

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
@Override
public String toString(){

    return null;
}

}
