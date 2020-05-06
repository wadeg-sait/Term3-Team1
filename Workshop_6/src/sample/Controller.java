package sample;
/*
Created by Wade Grimm
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button btnAgents;

    @FXML
    private Button btnSuppliers;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnBookings;

    @FXML
    private Button btnRewards;

    @FXML
    void clickedAgents(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("agents.fxml"));
        Scene scene = new Scene((stage));

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    @FXML
    void clickedBookings(ActionEvent event) throws IOException {

        Parent stage = FXMLLoader.load(getClass().getResource("bookings.fxml"));
        Scene scene = new Scene((stage));

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    @FXML
    void clickedCustomers(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("customers.fxml"));
        Scene scene = new Scene((stage));

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    @FXML
    void clickedSuppliers(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("suppliers.fxml"));
        Scene scene = new Scene((stage));

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);

        @FXML
        void clickedSuppliers(ActionEvent event) throws IOException {
            Parent stage = FXMLLoader.load(getClass().getResource("rewards.fxml"));
            Scene scene = new Scene((stage));

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);

    }

}
