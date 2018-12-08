package com.epam.jdbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "1234";
        String connectionUrl ="jdbc:mysql://localhost:3306";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,userName,password)) {
            System.out.println("We're connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
