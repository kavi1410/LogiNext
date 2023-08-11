package org.example.DataBase;

import org.example.Customer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCustomer {
    public static void insert(Connection connection, List<Customer> customers) throws SQLException {
        connection.setAutoCommit(false);
        String insertQuery = "INSERT INTO Customers (name, orderTime, deliveryTime) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            for (Customer customer : customers) {
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setInt(2, customer.getOrderTime());
                preparedStatement.setInt(3, customer.getDeliveryTime());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public List<Customer> get(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int orderTime = resultSet.getInt("orderTime");
                int deliveryTime = resultSet.getInt("deliveryTime");
                customers.add(new Customer(orderTime, deliveryTime, name));
            }
        }
        return customers;
    }
}
