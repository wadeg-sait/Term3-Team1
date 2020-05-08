package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class AgencyController {

    @FXML
    private AnchorPane mainPage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<?> comboAgency;

    @FXML
    private ListView<?> lstAgt;

    @FXML
    private Label toplblAgt;


    @FXML
    private Label lblAgtAgencyID;

    @FXML
    private TextField txtAgtId;

    @FXML
    private TextField txtAgtEmail;

    @FXML
    private TextField txtAgtFirstName;

    @FXML
    private TextField txtAgtMiddleName;

    @FXML
    private TextField txtAgtLastName;

    @FXML
    private TextField txtAgtPhone;

    @FXML
    private TextField txtAgtPosition;

    @FXML
    private ComboBox<?>  txtAgtAgencyID;

    @FXML
    private Button btnAgtADD;

    @FXML
    private Button btnAgtEdit;

    @FXML
    private Button btnAgtAddSave;

    @FXML
    private Button btnAgtEditSave;

    @FXML
    private Label lblAgencyID;

    @FXML
    private Button btnAgencyAdd;

    @FXML
    private Button btnAgencyEdit;

    @FXML
    private Button btnAgencyAddSave;

    @FXML
    private Button btnAgencyUpdate;

    @FXML
    private TextField txtAgencyAddress;

    @FXML
    private TextField txtAgencyCity;

    @FXML
    private TextField txtAgencyProv;

    @FXML
    private TextField txtAgencyPost;

    @FXML
    private TextField txtAgencyCountry;

    @FXML
    private TextField txtAgencyPhone;

    @FXML
    private TextField txtAgencyFax;

    @FXML
    private TextField txtAgencyID;

    @FXML
    private ComboBox<?> comboAgencyID;

    @FXML
    private Button reset;

    @FXML
    private Tab tabAgency;

    @FXML
    private Tab tabAgent;


    @FXML
    private Label lblAllFields;


    @FXML
    private Label lblRes;

    @FXML
    private Label lblError;




    @FXML
    private Label toplblAgencyId;

    ObservableList agentList= FXCollections.observableArrayList();
    ObservableList agenList= FXCollections.observableArrayList();

    @FXML
    void agtReset(MouseEvent event) {




    }


    @FXML
    void addAgt() {

        lblAllFields.setVisible(false);
        txtAgtFirstName.setText("");
        txtAgtMiddleName.setText("");
        txtAgtLastName.setText("");
        txtAgtPosition.setText("");
        txtAgtEmail.setText("");
        txtAgtPhone.setText("");
        txtAgtId.setText("");
        comboAgency.setDisable(true);
        txtAgtFirstName.setEditable(true);
        txtAgtLastName.setEditable((true));
        txtAgtMiddleName.setEditable(true);
        txtAgtPhone.setEditable(true);
        txtAgtEmail.setEditable(true);
        txtAgtPosition.setEditable(true);
        txtAgencyID.setEditable(true);
        btnAgtEdit.setVisible(false);
        btnAgtAddSave.setVisible(true);
        btnAgtEditSave.setVisible(false);
        btnAgtADD.setVisible(false );
        txtAgtAgencyID.setDisable(false);
        toplblAgt.setVisible(false);
        txtAgtId.setVisible(false);
        lblAgtAgencyID.setVisible(true);
        txtAgtAgencyID.setVisible(true);
        reset.setVisible(true);
        txtAgtAgencyID.getItems().clear();
        txtAgtAgencyID.getItems().addAll(agenList);
        txtAgtAgencyID.getSelectionModel().selectFirst();
       lstAgt.setDisable(true);
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");
    }

    @FXML
    void  editAgt() {
        lblAllFields.setVisible(false);
        txtAgtFirstName.setEditable(true);
        txtAgtLastName.setEditable((true));
        txtAgtMiddleName.setEditable(true);
        txtAgtPhone.setEditable(true);
        txtAgtEmail.setEditable(true);
        txtAgtPosition.setEditable(true);
        txtAgencyID.setEditable(true);
        btnAgtEdit.setVisible(false);
        btnAgtAddSave.setVisible(true);
        btnAgtEditSave.setVisible(false);
        btnAgtEdit.setVisible(false );
        btnAgtADD.setVisible(false);
        btnAgtEditSave.setVisible(true);
        txtAgtAgencyID.setDisable(false);
        btnAgtAddSave.setVisible(false);
        toplblAgt.setVisible(false);
        txtAgtId.setVisible(false);
        lblAgtAgencyID.setVisible(true);
        txtAgtAgencyID.setVisible(true);
        txtAgtAgencyID.getItems().clear();
        txtAgtAgencyID.getItems().addAll(agenList);
        txtAgtAgencyID.getSelectionModel().selectFirst();
        reset.setVisible(true);
        txtAgtAgencyID.getSelectionModel().select(Integer.parseInt(String.valueOf(comboAgency.getSelectionModel().getSelectedIndex())));
        lstAgt.setDisable(true);
        comboAgency.setDisable(true);
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");
    }

    @FXML
    void addAgtSave() {

        if(txtAgtFirstName.getText().isEmpty()||txtAgtMiddleName.getText().isEmpty()||txtAgtLastName.getText().isEmpty()
        ||txtAgtPhone.getText().isEmpty()||txtAgtEmail.getText().isEmpty()||txtAgtPosition.getText().isEmpty()){
            lblAllFields.setVisible(true);
            return;
        }
        Pattern patternPhone= Pattern.compile("^\\(?([0-9]{3})\\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$");
        Matcher matcherPhone= patternPhone.matcher(txtAgtPhone.getText());

        if(matcherPhone.matches()==false)
        {
            System.out.println("Invalid Phone");
            lblError.setVisible(true);
            lblError.setText("");
            lblError.setText("Invalid Phone Number");
            return;
        }


        Pattern patternEmail = Pattern.compile("^(.+)@(.+)$");
        Matcher matcherEmail = patternEmail.matcher(txtAgtEmail.getText());

        if(matcherEmail.matches()==false)
        {
            System.out.println("Invalid Email");
            lblError.setVisible(true);
            lblError.setText("");
            lblError.setText("Invalid Email Address");
            return;
        }

        txtAgtFirstName.setEditable(false);
        txtAgtLastName.setEditable((false));
        txtAgtMiddleName.setEditable(false);
        txtAgtPhone.setEditable(false);
        txtAgtEmail.setEditable(false);
        txtAgtPosition.setEditable(false);
        txtAgencyID.setEditable(false);
        btnAgtEdit.setVisible(true);
        btnAgtAddSave.setVisible(false);
        btnAgtEditSave.setVisible(false);
        btnAgtADD.setVisible(true );
        txtAgtAgencyID.setDisable(true);
        btnAgtEdit.setVisible(true);
        btnAgtEditSave.setVisible(false);
        toplblAgt.setVisible(true);
        txtAgtId.setVisible(true);
        lblAgtAgencyID.setVisible(false);
        txtAgtAgencyID.setVisible(false);
        reset.setVisible(false);
        lstAgt.setDisable(false);
        comboAgency.setDisable(false);




        try{
            Connection conn  = MyDBConnection.getConnectionString();


            String query = "INSERT  into agents (AgtFirstName,AgtMiddleInitial,AgtLastName,AgtBusPhone,AgtEmail,AgtPosition,AgencyId)"+
                    "values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, txtAgtFirstName.getText());
            stmt.setString(2, txtAgtMiddleName.getText() );
            stmt.setString(3, txtAgtLastName.getText());
            stmt.setString(4, txtAgtPhone.getText());
            stmt.setString(5, txtAgtEmail.getText());
            stmt.setString(6, txtAgtPosition.getText());

            stmt.setInt(7,Integer.parseInt(String.valueOf(txtAgtAgencyID.getSelectionModel().getSelectedItem())));

            stmt.execute();
            conn.close();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }

        initialize();
        lblRes.setText("");
        lblRes.setVisible(true);
        lblRes.setText(("Agents have been added"));
        lblError.setVisible(false);
        lblError.setText("");

    }
    @FXML
    void editAgtSave() {

        if(txtAgtFirstName.getText().isEmpty()||txtAgtMiddleName.getText().isEmpty()||txtAgtLastName.getText().isEmpty()
                ||txtAgtPhone.getText().isEmpty()||txtAgtEmail.getText().isEmpty()||txtAgtPosition.getText().isEmpty()){

            lblAllFields.setVisible(true);
            return;
        }




        Pattern patternPhone= Pattern.compile("^\\(?([0-9]{3})\\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$");
        Matcher matcherPhone= patternPhone.matcher(txtAgtPhone.getText());

        if(matcherPhone.matches()==false)
            {
            System.out.println("Invalid Phone");
                lblError.setVisible(true);
                lblError.setText("");
                lblError.setText("Invalid Phone Number");
            return;
        }


        Pattern patternEmail = Pattern.compile("^(.+)@(.+)$");
        Matcher matcherEmail = patternEmail.matcher(txtAgtEmail.getText());

        if(matcherEmail.matches()==false)
        {
            System.out.println("Invalid Email");
            lblError.setVisible(true);
            lblError.setText("");
            lblError.setText("Invalid Email Address");
            return;
        }

        txtAgtFirstName.setEditable(false);
        txtAgtLastName.setEditable((false));
        txtAgtMiddleName.setEditable(false);
        txtAgtPhone.setEditable(false);
        txtAgtEmail.setEditable(false);
        txtAgtPosition.setEditable(false);
        txtAgencyID.setEditable(false);
        btnAgtEdit.setVisible(true);
        btnAgtAddSave.setVisible(false);
        btnAgtEditSave.setVisible(false);
        btnAgtADD.setVisible(true );
        txtAgtAgencyID.setDisable(true);
        btnAgtEdit.setVisible(true);
        btnAgtEditSave.setVisible(false);
        toplblAgt.setVisible(true);
        txtAgtId.setVisible(true);
        lblAgtAgencyID.setVisible(false);
        txtAgtAgencyID.setVisible(false);
        reset.setVisible(false);
        lstAgt.setDisable(false);
        comboAgency.setDisable(false);



        try{
            Connection conn  = MyDBConnection.getConnectionString();
            String query = "UPDATE agents SET AgtFirstName=?," +
                    " AgtMiddleInitial =?,AgtLastName=?,AgtBusPhone=?," +
                    "AgtEmail=?,AgtPosition=?,AgencyId=? WHERE AgentID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, txtAgtFirstName.getText());
            stmt.setString(2, txtAgtMiddleName.getText() );
            stmt.setString(3, txtAgtLastName.getText());
            stmt.setString(4, txtAgtPhone.getText());
            stmt.setString(5, txtAgtEmail.getText());
            stmt.setString(6, txtAgtPosition.getText());

            stmt.setInt(7,Integer.parseInt(String.valueOf(txtAgtAgencyID.getSelectionModel().getSelectedItem())));
            System.out.println("Test"+Integer.parseInt(String.valueOf(txtAgtAgencyID.getSelectionModel().getSelectedItem())));
            stmt.setInt(8, Integer.parseInt(txtAgtId.getText()));

            stmt.executeUpdate();
            conn.close();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }

        initialize();
        lblRes.setText("");
        lblRes.setVisible(true);
        lblRes.setText(("Agents have been Edited"));
        lblError.setVisible(false);
        lblError.setText("");

    }




    @FXML
    void addAgency() {
        lblAllFields.setVisible(false);
        btnAgencyAdd.setVisible(false);
        btnAgencyEdit.setVisible(false);
        btnAgencyAddSave.setVisible(true);
        btnAgencyUpdate.setVisible(false);
        txtAgencyID.setVisible(false);
        reset.setVisible(true);
        txtAgencyAddress.setText("");
        txtAgencyPhone.setText("");
        txtAgencyCountry.setText("");
        txtAgencyFax.setText("");
        txtAgencyPost.setText("");
        txtAgencyProv.setText("");
        txtAgencyCity.setText("");
        txtAgencyAddress.setEditable(true);
        txtAgencyCity.setEditable(true);
        txtAgencyCountry.setEditable(true);
        txtAgencyFax.setEditable(true);
        txtAgencyPhone.setEditable(true);
        txtAgencyPost.setEditable(true);
        txtAgencyProv.setEditable(true);
        comboAgencyID.setDisable(true);
        toplblAgencyId.setVisible(false);
        comboAgencyID.setVisible(false);
        reset.setVisible(true);
        lstAgt.setDisable(false);
        comboAgency.setDisable(false);
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");

    }

    @FXML
    void editAgency() {
        lblAllFields.setVisible(false);
        btnAgencyAdd.setVisible(false);
        btnAgencyEdit.setVisible(false);
        btnAgencyAddSave.setVisible(false);
        btnAgencyUpdate.setVisible(true);
        txtAgencyID.setVisible(false);
        reset.setVisible(true);
        lblAgencyID.setVisible(false);
        txtAgencyID.setEditable(true);
        txtAgencyAddress.setEditable(true);
        txtAgencyCity.setEditable(true);
        txtAgencyCountry.setEditable(true);
        txtAgencyFax.setEditable(true);
        txtAgencyPhone.setEditable(true);
        txtAgencyPost.setEditable(true);
        txtAgencyProv.setEditable(true);
        comboAgencyID.setDisable(true);
        comboAgencyID.setVisible(false);
        toplblAgencyId.setVisible(false);
        reset.setVisible(true);
        lstAgt.setDisable(false);
        comboAgency.setDisable(false);
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");


    }




    @FXML
    void saveAddAgency() {


        if(txtAgencyAddress.getText().isEmpty() || txtAgencyCity.getText().isEmpty() || txtAgencyCountry.getText().isEmpty()  || txtAgencyProv.getText().isEmpty()
                || txtAgencyPhone.getText().isEmpty() ||txtAgencyFax.getText().isEmpty() ||txtAgencyPost.getText().isEmpty() ){

            lblAllFields.setVisible(true);
            return ;

        }


        Pattern patternPostal = Pattern.compile("^[ABCEGHJKLMNPRSTVXYabceghjklmnprstvxy]{1}\\d{1}[A-Za-z]{1}[ ]{0,1}\\d{1}[A-Za-z]{1}\\d{1}$");
        Matcher matcherPostal = patternPostal.matcher(txtAgencyPost.getText());

        if(matcherPostal.matches()==false)
        {
            System.out.println("Invalid Postal Code");
            lblError.setVisible(true);
            lblError.setText("");
            lblError.setText("Invalid Postal Code");
            return;
        }

        Pattern patternPhone= Pattern.compile("^\\(?([0-9]{3})\\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$");
        Matcher matcherPhone= patternPhone.matcher(txtAgencyPhone.getText());

        if(matcherPhone.matches()==false)
        {
            System.out.println("Invalid Agency Phone");
            lblError.setVisible(true);
            lblError.setText("");
            lblError.setText("Invalid Phone Number");
            return;
        }


        Pattern patternFax= Pattern.compile("^\\(?([0-9]{3})\\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$");
        Matcher matcherFax= patternFax  .matcher(txtAgencyFax.getText());

        if(matcherFax.matches()==false)
        {
            System.out.println("Invalid Agency Fax");
            lblError.setVisible(true);
            lblError.setText("");
            lblError.setText("Invalid Fax Number");
            return;
        }


        btnAgencyAdd.setVisible(true);
        btnAgencyEdit.setVisible(true);
        btnAgencyAddSave.setVisible(false);
        btnAgencyUpdate.setVisible(false);
        txtAgencyID.setVisible(false);
        reset.setVisible(false);
        lblAgencyID.setVisible(false);
        txtAgencyID.setEditable(false);
        System.out.println("Adding");
        txtAgencyAddress.setEditable(false);
        txtAgencyCity.setEditable(false);
        txtAgencyCountry.setEditable(false);
        txtAgencyFax.setEditable(false);
        txtAgencyPhone.setEditable(false);
        txtAgencyPost.setEditable(false);
        txtAgencyProv.setEditable(false);
        comboAgencyID.setDisable(false);
        comboAgencyID.setVisible(true);
        toplblAgencyId.setVisible(true);
        reset.setVisible(false);
        lstAgt.setDisable(false);
        comboAgency.setDisable(false);

        try{
            Connection conn  = MyDBConnection.getConnectionString();


            String query = "INSERT  into agencies (AgncyAddress,AgncyCity,AgncyProv,AgncyPostal,AgncyCountry,AgncyPhone,AgncyFax)"+
                    "values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, txtAgencyAddress.getText());
            stmt.setString(2, txtAgencyCity.getText());
            stmt.setString(3, txtAgencyProv.getText());
            stmt.setString(4, txtAgencyPost.getText());
            stmt.setString(5, txtAgencyCountry.getText());
            stmt.setString(6, txtAgencyPhone.getText());

            stmt.setString(7, txtAgencyFax.getText());

            stmt.execute();
            conn.close();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }

        initialize();
        lblRes.setText("");
        lblRes.setVisible(true);
        lblRes.setText(("Agency have been Added"));
        lblError.setVisible(false);
        lblError.setText("");




    }

    @FXML
    void saveEditAgency() {
        if(txtAgencyAddress.getText().isEmpty() || txtAgencyCity.getText().isEmpty() || txtAgencyCountry.getText().isEmpty()  || txtAgencyProv.getText().isEmpty()
                || txtAgencyPhone.getText().isEmpty() ||txtAgencyFax.getText().isEmpty() ||txtAgencyPost.getText().isEmpty() ){

            lblAllFields.setVisible(true);
            return ;

        }


        Pattern patternPostal = Pattern.compile("^[ABCEGHJKLMNPRSTVXYabceghjklmnprstvxy]{1}\\d{1}[A-Za-z]{1}[ ]{0,1}\\d{1}[A-Za-z]{1}\\d{1}$");
        Matcher matcherPostal = patternPostal.matcher(txtAgencyPost.getText());

        if(matcherPostal.matches()==false)
        {
            System.out.println("Invalid Postal Code");
            lblError.setVisible(true);
            lblError.setText("");
            lblError.setText("Invalid Postal Code");
            return;
        }

        Pattern patternPhone= Pattern.compile("^\\(?([0-9]{3})\\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$");
        Matcher matcherPhone= patternPhone.matcher(txtAgencyPhone.getText());

        if(matcherPhone.matches()==false)
        {
            System.out.println("Invalid Agency Phone");
            lblError.setVisible(true);
            lblError.setText("");
            lblError.setText("Invalid Phone Number");
            return;
        }


        Pattern patternFax= Pattern.compile("^\\(?([0-9]{3})\\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$");
        Matcher matcherFax= patternFax  .matcher(txtAgencyFax.getText());

        if(matcherFax.matches()==false)
        {
            System.out.println("Invalid Agency Fax");
            lblError.setVisible(true);
            lblError.setText("");
            lblError.setText("Invalid Fax Number");
            return;
        }


        try{
            Connection conn  = MyDBConnection.getConnectionString();
            String query = "UPDATE agencies SET AgncyAddress=?," +
                    " AgncyCity =?,AgncyProv=?,AgncyPostal=?," +
                    "AgncyCountry=?,AgncyPhone=?,AgncyFax=? WHERE AgencyId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            //System.out.println(txtAgencyAddress.getText());
            stmt.setString(1,txtAgencyAddress.getText().toString());
            stmt.setString(2, txtAgencyCity.getText().toString());
            stmt.setString(3, txtAgencyProv.getText().toString());
            stmt.setString(4, txtAgencyPost.getText().toString());
            stmt.setString(5, txtAgencyCountry.getText().toString());
            stmt.setString(6, txtAgencyPhone.getText().toString());

            stmt.setString(7, txtAgencyFax.getText().toString());
            stmt.setInt(8,Integer.parseInt(String.valueOf(comboAgencyID.getSelectionModel().getSelectedItem())));


            stmt.executeUpdate();
            conn.close();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }

        btnAgencyAdd.setVisible(true);
        btnAgencyEdit.setVisible(true);
        btnAgencyAddSave.setVisible(false);
        btnAgencyUpdate.setVisible(false);
        txtAgencyID.setVisible(false);
        reset.setVisible(false);
        lblAgencyID.setVisible(false);
        txtAgencyID.setEditable(false);
        txtAgencyAddress.setEditable(false);
        txtAgencyCity.setEditable(false);
        txtAgencyCountry.setEditable(false);
        txtAgencyFax.setEditable(false);
        txtAgencyPhone.setEditable(false);
        txtAgencyPost.setEditable(false);
        txtAgencyProv.setEditable(false);
        comboAgencyID.setDisable(false);
        comboAgencyID.setVisible(true);
        toplblAgencyId.setVisible(true);
        reset.setVisible(false);
        comboAgencyID.getSelectionModel().selectFirst();
        lstAgt.setDisable(false);
        getAgencyDetails();
        lblRes.setText("");
        lblRes.setVisible(true);
        lblRes.setText(("Agency have been Edited"));
        lblError.setVisible(false);
        lblError.setText("");

    }

    @FXML
    void reset() {
        lblAllFields.setVisible(false);
       btnAgencyAdd.setVisible(true);
        btnAgencyEdit.setVisible(true);
        btnAgencyAddSave.setVisible(false);
        btnAgencyUpdate.setVisible(false);
        txtAgencyID.setVisible(false);
        reset.setVisible(false);
        lblAgencyID.setVisible(false);
        txtAgencyID.setEditable(false);
        txtAgencyAddress.setEditable(false);
        txtAgencyCity.setEditable(false);
        txtAgencyCountry.setEditable(false);
        txtAgencyFax.setEditable(false);
        txtAgencyPhone.setEditable(false);
        txtAgencyPost.setEditable(false);
        txtAgencyProv.setEditable(false);
        lblAgtAgencyID.setVisible(false);
        txtAgtAgencyID.setVisible(false);
        comboAgencyID.setDisable(false);
        comboAgencyID.setVisible(true);
        toplblAgencyId.setVisible(true);
        comboAgencyID.getSelectionModel().selectFirst();
        getAgencyDetails();
        displayAgentDetails();
        lstAgt.setDisable(false);
        txtAgtFirstName.setEditable(false);
        txtAgtLastName.setEditable((false));
        txtAgtMiddleName.setEditable(false);
        txtAgtPhone.setEditable(false);
        txtAgtEmail.setEditable(false);
        txtAgtPosition.setEditable(false);
        txtAgencyID.setEditable(false);
        btnAgtEdit.setVisible(true);
        btnAgtAddSave.setVisible(false);
        btnAgtEditSave.setVisible(false);
        btnAgtADD.setVisible(true );
        txtAgtAgencyID.setDisable(true);
        btnAgtEdit.setVisible(true);
        btnAgtEditSave.setVisible(false);
        toplblAgt.setVisible(true);
        txtAgtId.setVisible(true);
        comboAgency.setDisable(false);
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");

    }

    @FXML
    private  void tabChangeReset (){
        lblAllFields.setVisible(false);
        btnAgencyAdd.setVisible(true);
        btnAgencyEdit.setVisible(true);
        btnAgencyAddSave.setVisible(false);
        btnAgencyUpdate.setVisible(false);
        txtAgencyID.setVisible(false);
        reset.setVisible(false);
        lblAgencyID.setVisible(false);
        txtAgencyID.setEditable(false);
        txtAgencyAddress.setEditable(false);
        txtAgencyCity.setEditable(false);
        txtAgencyCountry.setEditable(false);
        txtAgencyFax.setEditable(false);
        txtAgencyPhone.setEditable(false);
        txtAgencyPost.setEditable(false);
        txtAgencyProv.setEditable(false);
        lblAgtAgencyID.setVisible(false);
        txtAgtAgencyID.setVisible(false);
        comboAgencyID.setDisable(false);
        comboAgencyID.setVisible(true);
        toplblAgencyId.setVisible(true);
        comboAgencyID.getSelectionModel().selectFirst();
        getAgencyDetails();
        displayAgentDetails();
        lstAgt.setDisable(false);
        txtAgtFirstName.setEditable(false);
        txtAgtLastName.setEditable((false));
        txtAgtMiddleName.setEditable(false);
        txtAgtPhone.setEditable(false);
        txtAgtEmail.setEditable(false);
        txtAgtPosition.setEditable(false);
        txtAgencyID.setEditable(false);
        btnAgtEdit.setVisible(true);
        btnAgtAddSave.setVisible(false);
        btnAgtEditSave.setVisible(false);
        btnAgtADD.setVisible(true );
        txtAgtAgencyID.setDisable(true);
        btnAgtEdit.setVisible(true);
        btnAgtEditSave.setVisible(false);
        toplblAgt.setVisible(true);
        txtAgtId.setVisible(true);
        comboAgency.setDisable(false);
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");

    }


    @FXML
    private void selectedAgencyAgent (){

     /*   txtAgtAgencyID.getItems().clear();
        txtAgtAgencyID.getItems().addAll(agenList);
        Integer agencySelectedID= (Integer) txtAgtAgencyID.getSelectionModel().getSelectedItem();
        System.out.println(txtAgtAgencyID.getSelectionModel().getSelectedIndex());
        System.out.println(agencySelectedID+"Zoha");*/


    }

    @FXML
    private  void selectedAgency (ActionEvent event){

        lblAllFields.setVisible(false);
        getAgencyDetails();
        lstAgt.setDisable(false);
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");
    }


    @FXML
    private  void  SelectAgencyAgent (ActionEvent event){
        lblAllFields.setVisible(false);
        txtAgtFirstName.setEditable(false);
        txtAgtLastName.setEditable((false));
        txtAgtMiddleName.setEditable(false);
        txtAgtPhone.setEditable(false);
        txtAgtEmail.setEditable(false);
        txtAgtPosition.setEditable(false);
        txtAgencyID.setEditable(false);
        btnAgtEdit.setVisible(true);
        btnAgtAddSave.setVisible(false);
        btnAgtEditSave.setVisible(false);
        btnAgtADD.setVisible(true );
        txtAgtAgencyID.setDisable(true);
        btnAgtEdit.setVisible(true);
        btnAgtEditSave.setVisible(false);
        toplblAgt.setVisible(true);
        txtAgtId.setVisible(true);


        txtAgtId.clear();
        txtAgtFirstName.clear();
        txtAgtMiddleName.clear();
        txtAgtLastName.clear();
        txtAgtPhone.clear();
        txtAgtEmail.clear();
        txtAgtPosition.clear();
        lstAgt.getItems().clear();
        getAgentsList();
        lstAgt.getSelectionModel().selectFirst();

        displayAgentDetails();
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");



    }

    @FXML
    private  void displayAgentDetails()

    {
        Integer lstAgent= Integer.parseInt(String.valueOf(lstAgt.getSelectionModel().getSelectedIndex()));

        getSelectedAgentDetails(lstAgent);
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");

    }


    @FXML
    void clearMsg(MouseEvent event) {
        lblRes.setText("");
        lblRes.setVisible(false);
    }



    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'agents.fxml'.";
        assert comboAgency != null : "fx:id=\"comboAgency\" was not injected: check your FXML file 'agents.fxml'.";
        assert lstAgt != null : "fx:id=\"lstAgt\" was not injected: check your FXML file 'agents.fxml'.";
        assert lblAgtAgencyID != null : "fx:id=\"lblAgtAgencyID\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgtId != null : "fx:id=\"txtAgtId\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgtEmail != null : "fx:id=\"txtAgtEmail\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgtFirstName != null : "fx:id=\"txtAgtFirstName\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgtMiddleName != null : "fx:id=\"txtAgtMiddleName\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgtLastName != null : "fx:id=\"txtAgtLastName\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgtPhone != null : "fx:id=\"txtAgtPhone\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgtPosition != null : "fx:id=\"txtAgtPosition\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgtAgencyID != null : "fx:id=\"txtAgtAgencyID\" was not injected: check your FXML file 'agents.fxml'.";
        assert btnAgtADD != null : "fx:id=\"btnAgtADD\" was not injected: check your FXML file 'agents.fxml'.";
        assert btnAgtEdit != null : "fx:id=\"btnAgtEdit\" was not injected: check your FXML file 'agents.fxml'.";
        assert btnAgtAddSave != null : "fx:id=\"btnAgtAddSave\" was not injected: check your FXML file 'agents.fxml'.";
        assert btnAgtEditSave != null : "fx:id=\"btnAgtEditSave\" was not injected: check your FXML file 'agents.fxml'.";
        assert lblAgencyID != null : "fx:id=\"lblAgencyID\" was not injected: check your FXML file 'agents.fxml'.";
        assert btnAgencyAdd != null : "fx:id=\"btnAgencyAdd\" was not injected: check your FXML file 'agents.fxml'.";
        assert btnAgencyEdit != null : "fx:id=\"btnAgencyEdit\" was not injected: check your FXML file 'agents.fxml'.";
        assert btnAgencyAddSave != null : "fx:id=\"btnAgencyAddSave\" was not injected: check your FXML file 'agents.fxml'.";
        assert btnAgencyUpdate != null : "fx:id=\"btnAgencyUpdate\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgencyAddress != null : "fx:id=\"txtAgencyAddress\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgencyCity != null : "fx:id=\"txtAgencyCity\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgencyProv != null : "fx:id=\"txtAgencyProv\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgencyPost != null : "fx:id=\"txtAgencyPost\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgencyCountry != null : "fx:id=\"txtAgencyCountry\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgencyPhone != null : "fx:id=\"txtAgencyPhone\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgencyFax != null : "fx:id=\"txtAgencyFax\" was not injected: check your FXML file 'agents.fxml'.";
        assert txtAgencyID != null : "fx:id=\"txtAgencyID\" was not injected: check your FXML file 'agents.fxml'.";
        assert comboAgencyID != null : "fx:id=\"comboAgencyID\" was not injected: check your FXML file 'agents.fxml'.";
        assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file 'agents.fxml'.";
        assert toplblAgt != null : "fx:id=\"toplblAgt\" was not injected: check your FXML file 'agents.fxml'.";
        assert toplblAgencyId != null : "fx:id=\"toplblAgencyId\" was not injected: check your FXML file 'agents.fxml'.";
        assert tabAgent != null : "fx:id=\"tabAgent\" was not injected: check your FXML file 'agents.fxml'.";
        assert tabAgency != null : "fx:id=\"tabAgency\" was not injected: check your FXML file 'agents.fxml'.";
        assert lblAllFields != null : "fx:id=\"lblAllFields\" was not injected: check your FXML file 'agents.fxml'.";
        assert lblRes != null : "fx:id=\"lblRes\" was not injected: check your FXML file 'agents.fxml'.";
        assert lblError != null : "fx:id=\"lblError\" was not injected: check your FXML file 'agents.fxml'.";
        assert mainPage != null : "fx:id=\"mainPage\" was not injected: check your FXML file 'agents.fxml'.";


        agenList.removeAll(agenList);
        ArrayList<Integer> agencyList=  getAgencyList();
        agenList.addAll(agencyList);
        comboAgency.getItems().clear();
        comboAgency.getItems().addAll(agenList);
        comboAgencyID.getItems().clear();
        comboAgencyID.getItems().addAll(agenList);
        comboAgency.getSelectionModel().selectFirst();
        comboAgencyID.getSelectionModel().selectFirst();
        lstAgt.getItems().clear();

        getAgencyDetails();
        getAgentsList();
        lstAgt.getSelectionModel().selectFirst();
        displayAgentDetails();

    }

    private ArrayList<Integer> getAgencyList() {
        ArrayList<Integer> lst= new ArrayList<>();

        try {
            // Allocate a database 'Connection' object
            Connection conn = MyDBConnection.getConnectionString();
            String str = "SELECT * from agencies";
            ResultSet rset = MyDBConnection.getResults(str, conn);
            ResultSetMetaData rsmd = rset.getMetaData();

            while(rset.next()) {   // Move the cursor to the next row, return false if no more row


                lst.add(rset.getInt("AgencyId"));
            }
            rset.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lst;



    }

    private void getAgencyDetails() {
        Integer agencySelectedID= (Integer) comboAgencyID.getSelectionModel().getSelectedItem();

        try {
            // Allocate a database 'Connection' object
            Connection conn = MyDBConnection.getConnectionString();
            String str = "SELECT * from agencies where AgencyId="+agencySelectedID;
            ResultSet rset = MyDBConnection.getResults(str, conn);
            ResultSetMetaData rsmd = rset.getMetaData();

            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                txtAgencyAddress.setText(rset.getString("AgncyAddress"));
                txtAgencyCity.setText(rset.getString("AgncyCity"));
                txtAgencyProv.setText(rset.getString("AgncyProv"));
                txtAgencyPost.setText(rset.getString("AgncyPostal"));
                txtAgencyCountry.setText(rset.getString("AgncyCountry"));
                txtAgencyPhone.setText(rset.getString("AgncyPhone"));
                txtAgencyFax.setText(rset.getString("AgncyFax"));

            }
            rset.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }




    }

    private void getAgentsList() {
        Integer agencySelectedID= (Integer) comboAgency.getSelectionModel().getSelectedItem();
        agentList.removeAll(agentList);
        ArrayList<String> agentName= new ArrayList<>();

        try {
            // Allocate a database 'Connection' object
            Connection conn = MyDBConnection.getConnectionString();
            String str = "SELECT * from agents where AgencyId ="+ agencySelectedID;
            ResultSet rset = MyDBConnection.getResults(str, conn);
            ResultSetMetaData rsmd = rset.getMetaData();

            while(rset.next()) {   // Move the cursor to the next row, return false if no more row

                agentName.add(rset.getString("AgtLastName")+" , "+rset.getString("AgtFirstName"));
            }
            rset.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        agentList.addAll(agentName);
        lstAgt.getItems().addAll(agentList);
        lblRes.setText("");
        lblRes.setVisible(false);
        lblError.setVisible(false);
        lblError.setText("");



    }





       private void getSelectedAgentDetails(Integer index) {
        Integer agencySelectedID= (Integer)  comboAgency.getSelectionModel().getSelectedItem();


        try {
            // Allocate a database 'Connection' object
            Connection conn = MyDBConnection.getConnectionString();
            String str = "SELECT * from agents where AgencyId ="+ agencySelectedID;
            ResultSet rset = MyDBConnection.getResults(str, conn);
            ResultSetMetaData rsmd = rset.getMetaData();

            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                if (rset.getRow()==index+1){
                    //System.out.println(rset.getRow());

                    txtAgtId.setText(rset.getString("AgentId"));
                    txtAgtFirstName.setText(rset.getString("AgtFirstName"));
                    txtAgtMiddleName.setText(rset.getString("AgtMiddleInitial"));
                    txtAgtLastName.setText(rset.getString("AgtLastName"));
                    txtAgtPhone.setText(rset.getString("AgtBusPhone"));
                    txtAgtEmail.setText(rset.getString("AgtEmail"));
                    txtAgtPosition.setText(rset.getString("AgtPosition"));

                }


            }
            rset.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }


    }






    @FXML
    void clickedCancel(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene((stage));

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }


}
