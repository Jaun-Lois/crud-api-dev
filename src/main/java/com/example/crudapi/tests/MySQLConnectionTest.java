package com.example.crudapi.tests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnectionTest {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/crud_database?useSSL=false";
        String username = "root";
        String password = "";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the MySQL server
            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                System.out.println("Successfully connected to the MySQL database!");

                // Execute a simple query to test the connection
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT 1");

                if (resultSet.next()) {
                    System.out.println("The test query executed successfully!");
                } else {
                    System.out.println("The test query failed to execute.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error connecting to the MySQL database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
