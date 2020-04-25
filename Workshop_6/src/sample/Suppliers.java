package sample;

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ResourceBundle;

public class Suppliers {


    String connectionURL = "jdbc:mysql://localhost:3306/travelexperts";
    Connection connection;
    Supplier supplier;

    @FXML
    private ResourceBundle resources;

    /*@FXML
    private DocFlavor.URL location;*/

    @FXML
    private Button btnCancel;

    @FXML
    private ListView<Supplier> lvSuppliers;

    @FXML
    private TextField txtSupplierId;

    @FXML
    private TextField txtSupplierName;


    ObservableList<Supplier> supplierList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws SQLException {
        System.out.println("in intialize");
        connection = connectToDB();
        if(connection!=null){
            supplierList = GetSuppliers();
            lvSuppliers.getItems().addAll(supplierList);
        }else{
            System.out.println("No Connection");
        }
    }

    //returns a list of agents
    private ObservableList<Supplier> GetSuppliers() throws SQLException{
        String selectQuery = "SELECT * from suppliers";
        PreparedStatement selectSuppliers = null;
        Supplier supplier;
        try {
            selectSuppliers = connection.prepareStatement(selectQuery);
            ResultSet rset = selectSuppliers.executeQuery(selectQuery);
            while (rset.next()) {
                supplier = new Supplier(
                        rset.getInt("SupplierId"),
                        rset.getString("SupName")

                );
                System.out.println(supplier);
                supplierList.add(supplier);
            }
            System.out.println("Suppliers loaded to the ObservableList");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            selectSuppliers.close();
        }
        return supplierList;
    }


    //connection to db
    private Connection connectToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        //user credentials
        String USER = "root";
        String PASS = "";
        //driver to connect to the MYSQL database
        try {
            return DriverManager.getConnection(connectionURL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void btnSupplierSaveClicked(ActionEvent actionEvent) throws SQLException {
        //disableAllFields();
        PreparedStatement saveData = null;
        ResultSet resultSet = null;
        try {
            String UpdateQuery = "UPDATE Suppliers set " +
                    "supName = ? " +
                    "where supplierId = ?";
            saveData = connection.prepareStatement(UpdateQuery);
            saveData.setInt(2, Integer.parseInt(txtSupplierId.getText()));
            saveData.setString(1, txtSupplierName.getText());
            saveData.executeUpdate();



            //System.out.println("Record Updated for Agent: (ID: " + Integer.parseInt(txtAgentId.getText()) + ") " + txtAgentFirstName.getText() + " " + txtAgentLastName.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            saveData.close();
        }
        //figure out how to clear the listview before you add more items to it
        //supplierList.getItems().clear();
        //lvSuppliers.getItems().clear();
        supplierList = GetSuppliers();
        lvSuppliers.getItems().addAll(supplierList);
    }



    @FXML
    void lvSuppliersClicked(MouseEvent event) {

        supplier = lvSuppliers.getSelectionModel().getSelectedItem();
        txtSupplierId.setText(String.valueOf(supplier.getSupplierId()));
        txtSupplierName.setText(supplier.getSupName());
    }



    @FXML
    void clickedCancel(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene((stage));

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);



    }
}
