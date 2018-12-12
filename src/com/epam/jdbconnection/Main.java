package com.epam.jdbconnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "1234";
        String connectionUrl = "jdbc:mysql://localhost:3306/billing_simple?useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password)) {
            System.out.println("We're connected!");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO billing (payer_email, recipient_email, sum, currency, billing_date, comment) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1,"akbol_96@mail.ru");
            preparedStatement.setString(2,"akbolzhasakbaev@gmail.com");
            preparedStatement.setInt(3,500);
            preparedStatement.setString(4,"KZT");
            preparedStatement.setDate(5, Date.valueOf("2018-12-13"));
            preparedStatement.setString(6,"I've sent you card cash");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
