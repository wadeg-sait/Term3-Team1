package sample;
/*
Created by Wade Grimm
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import sample.BookingInfo.BookingData;
import sample.BookingInfo.BookingDetail;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;

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

    @FXML
    private Label lblBookingDate;

    @FXML
    private Label lblCustomerID;

    @FXML
    private Label lblError;

    @FXML
    private Label lblTripStart;

    @FXML
    private Label lblDestination;

    @FXML
    private Label lblAgencyComm;

    @FXML
    private Label lblTravelerCount;

    @FXML
    private Label lblTripType;

    @FXML
    private Label lblItinerary;

    @FXML
    private Label lblTripEnd;

    @FXML
    private Label lblBasePrice;

    @FXML
    private Label lblRegionID;

    @FXML
    private Label lblClassID;

    @FXML
    private Label lblSupplierID;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblFeeID;

    @FXML
    private Label lblFuture;

    @FXML
    private AnchorPane apDetails;


    @FXML
    void contentClicked(MouseEvent event) {
        String bookingNum;

        BookingDetail detail = null;
        bookingNum = tvBookings.getSelectionModel().getSelectedItem().getBookingNo();
        detail = BookingData.getBookingDetail(bookingNum);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        DateFormat dateFormat = DateFormat.getDateInstance();
        try {
            lblError.setVisible(false);
            lblBookingDate.textProperty().set(dateFormat.format(detail.getBookingDate()));
            lblCustomerID.textProperty().set(Integer.toString(detail.getCustomerID()));
            lblTripStart.textProperty().set(dateFormat.format(detail.getTripStart()));
            lblDestination.textProperty().set(detail.getDestination());
            lblAgencyComm.textProperty().set(currency.format(detail.getAgencyCommission()));
            lblTravelerCount.textProperty().set(Integer.toString(detail.getTravelerCount()));
            lblTripType.textProperty().set(detail.getTripTypeID());
            lblItinerary.textProperty().set(Integer.toString(detail.getItineraryNo()));
            lblTripEnd.textProperty().set(dateFormat.format(detail.getTripEnd()));
            lblBasePrice.textProperty().set(currency.format(detail.getBasePrice()));
            lblRegionID.textProperty().set(detail.getRegionID());
            lblClassID.textProperty().set(detail.getClassID());
            lblSupplierID.textProperty().set(Integer.toString(detail.getProductSupplierID()));
            lblDescription.textProperty().set(detail.getDescription());
            lblFeeID.textProperty().set(detail.getFeeID());
            apDetails.setVisible(true);
            lblFuture.setVisible(true);
        }
        catch(NullPointerException e){
            lblError.setVisible(true);
            lblError.textProperty().set("Error Loading record details: " + e.toString());
            apDetails.setVisible(false);
            lblFuture.setVisible(false);
        }

    }


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
        ObservableList<BookingDetail> details;
        apDetails.setVisible(false);
        lblFuture.setVisible(false);
        lblError.setVisible(false);
        details = FXCollections.observableArrayList();
        details = BookingData.loadBookings();

        colBookingName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colBookingID.setCellValueFactory(cellData -> cellData.getValue().bookingIDProperty());
        colBookingNo.setCellValueFactory(cellData -> cellData.getValue().bookingNoProperty());
        tvBookings.setItems(null);
        tvBookings.setItems(details);

    }
}
