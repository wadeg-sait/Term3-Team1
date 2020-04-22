package sample;

import java.sql.*;

public class MyDBConnection {

    public static Connection getConnectionString() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts",
                    "root", "");
            System.out.println("********Database connection established.********");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("********Database connection could not be established********");
        }
        return conn;
    }

    public static ResultSet getResults(String query) {
        return getResults(query, getConnectionString());
    }


    // executing query with overloaded method
    public static ResultSet getResults(String query, Connection connection) {
        ResultSet rSet = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            rSet = stmt.executeQuery();
            System.out.println("********Query Executed.********");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("********Query cannot be Executed.********");
        }
        return rSet;
    }

    // getting result set
    public static ResultSet getResults(String query, Integer queryParameter) {
        ResultSet rSet = null;
        Connection conn = getConnectionString();
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, queryParameter);
            rSet = stmt.executeQuery();
            System.out.println("********Query Executed.********");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("********Query cannot be Executed.********");
        }
        return rSet;
    }
    // update statement
    public static void updateDatabase(String query) {
        Connection conn = getConnectionString();
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }
}
