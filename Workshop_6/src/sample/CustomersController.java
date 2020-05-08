package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


public class CustomersController {

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtFirst;

    @FXML
    private TextField txtLast;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCountry;

    @FXML
    private TextField txtEmail;

    @FXML
    private ComboBox<?> comboCust;

    @FXML
    void clickedCancel(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene((stage));

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    @FXML
    void getCustomerId(ActionEvent event) {

    }

    private ArrayList<Integer> getCustomerList() {
        ArrayList<Integer> lst= new ArrayList<>();

        try {

            Connection conn = MyDBConnection.getConnectionString();
            String str = "SELECT * from customers";
            ResultSet rset = MyDBConnection.getResults(str, conn);
            ResultSetMetaData rsmd = rset.getMetaData();

            while(rset.next()) {

                lst.add(rset.getInt("CustomerId"));
            }
            rset.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lst;

    }

        private void getCustomer() {
            Integer custSelectedID = (Integer) comboCust.getSelectionModel().getSelectedItem();

            try {
                Connection conn = MyDBConnection.getConnectionString();
                String str = "SELECT * from customers where CustomerId =" + custSelectedID;
                ResultSet rset = MyDBConnection.getResults(str, conn);
                ResultSetMetaData rsmd = rset.getMetaData();

                while (rset.next()) {

                    txtFirst.setText(rset.getString("CustFirstName"));
                    txtLast.setText(rset.getString("CustLastName"));
                    txtAddress.setText(rset.getString("CustAddressPhone"));
                    txtCity.setText(rset.getString("CustEmail"));
                    txtCountry.setText(rset.getString("CustCountry"));
                    txtEmail.setText(rset.getString("CustEmail"));
                }
                rset.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
