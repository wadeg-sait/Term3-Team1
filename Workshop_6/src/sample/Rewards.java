package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class Rewards { String connectionURL = "jdbc:mysql://localhost:3306/travelexperts";
    Connection connection;
    Rewards reward;
}

    @FXML
    void clickedCancel(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene((stage));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    private ObservableList<Rewards> GetRewards() throws SQLException {
        String selectQuery = "SELECT * from rewards";
        PreparedStatement selectRewards = null;
        Rewards reward;
        try {
            selectRewards = connection.prepareStatement(selectQuery);
            ResultSet rset = selectRewards.executeQuery(selectQuery);
            while (rset.next()) {
                Rewards = new Rewards(
                        rset.getInt("RewardId"),
                        rset.getString("RwdName")

                );
                System.out.println(reward);
                Rewards.add(reward);



