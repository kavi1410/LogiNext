package org.example.DataBase;

import org.example.Customer.Customer;
import org.example.DeliveryBoy.DeliveryBoy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoDeliveryBoys {
    public void insert(Connection connection, List<DeliveryBoy> deliveryBoys) throws SQLException {
        connection.setAutoCommit(false);

        String insertQuery = "INSERT INTO DeliveryBoys (name, startTime, endTime, totalOrders, totalWorkHours) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            for (DeliveryBoy deliveryBoy : deliveryBoys) {
                preparedStatement.setString(1, deliveryBoy.getName());
                preparedStatement.setInt(2, deliveryBoy.getStartTime());
                preparedStatement.setInt(3, deliveryBoy.getEndTime());
                preparedStatement.setInt(4, deliveryBoy.getTotalOrders());
                preparedStatement.setInt(5, deliveryBoy.getTotalOrders());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public List<DeliveryBoy> get(Connection connection) throws SQLException {
        List<DeliveryBoy> deliveryBoys = new ArrayList<>();
        String selectQuery = "SELECT * FROM deliveryboys";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int startTime = resultSet.getInt("startTime");
                int endTime = resultSet.getInt("endTime");
                int totalOrders = resultSet.getInt("totalOrders");
                int totalWorkHours = resultSet.getInt("totalWorkHours");
                deliveryBoys.add(new DeliveryBoy(id,name, startTime, endTime, totalOrders, totalWorkHours));
            }
        }
        return deliveryBoys;
    }

    public void update(Connection connection,DeliveryBoy updatedeliveryBoy) throws SQLException {
        connection.setAutoCommit(true);
        String updateQuery = "UPDATE DeliveryBoys SET startTime = ?, endTime = ?, totalOrders = ?, totalWorkHours = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, updatedeliveryBoy.getStartTime());
                preparedStatement.setInt(2, updatedeliveryBoy.getEndTime());
                preparedStatement.setInt(3, updatedeliveryBoy.getTotalOrders());
                preparedStatement.setInt(4, updatedeliveryBoy.getTotalWorkHours());
                preparedStatement.setInt(5, updatedeliveryBoy.getId());
             preparedStatement.executeUpdate();
        }
    }
}