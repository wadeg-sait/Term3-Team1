package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.BookingInfo.BookingData;
import sample.BookingInfo.BookingDetail;

import java.io.IOException;
import java.sql.*;

public class Bookings {

    @FXML
    private TableView<BookingDetail> tvBookings;

    @FXML
    private TableColumn<BookingDetail, String> colBookingID;

    @FXML
    private TableColumn<BookingDetail, String> colBookingNo;

    @FXML
    private TableColumn<BookingDetail, String> colBookingName;
    @FXML
    private Button btnCancel;

    private ObservableList<BookingDetail> details;
    private Connection conn;

    @FXML
    void clickedCancel(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene((stage));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }
    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        details = FXCollections.observableArrayList();
        //details = BookingData.loadBookings();
        conn = BookingData.Connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT b.BookingID, b.BookingNo, c.CustFirstName, c.CustLastName " +
                "FROM Bookings b inner join Customers c on b.customerid = c.customerid");

        while(rs.next()) {
            details.add(new BookingDetail(Integer.toString( rs.getInt("BookingID")),
                    rs.getString("BookingNo"),
                    rs.getString("CustFirstName") + " " + rs.getString("CustLastName")));

        }

        colBookingName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colBookingID.setCellValueFactory(cellData -> cellData.getValue().bookingIDProperty());
        colBookingNo.setCellValueFactory(cellData -> cellData.getValue().bookingNoProperty());
        tvBookings.setItems(null);
        tvBookings.setItems(details);




    }
}
