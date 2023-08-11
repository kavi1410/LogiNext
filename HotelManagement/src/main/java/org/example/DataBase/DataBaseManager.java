package org.example.DataBase;

import org.example.CustomException.DataBaseNotFound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseManager {
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/delivery_management";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "root";

        public static Connection getConnection() throws DataBaseNotFound {
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                return connection;

            } catch (SQLException e) {
                throw new DataBaseNotFound("No suitable driver found");
            }
        }
        public static void createTable(Connection connection) throws SQLException {
            createCustomersTable(connection);
            createDeliveryBoysTable(connection);
        }

        private static void createCustomersTable(Connection connection) throws SQLException {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Customers (\n" +
                    "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    name VARCHAR(30) NOT NULL,\n" +
                    "    orderTime INT,\n" +
                    "    deliveryTime INT\n" +
                    ");";
            executeUpdate(connection, createTableSQL);
        }

        private static void createDeliveryBoysTable(Connection connection) throws SQLException {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS DeliveryBoys (\n" +
                    "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    name VARCHAR(30) NOT NULL,\n" +
                    "    startTime INT,\n" +
                    "    endTime INT,\n" +
                    "    totalOrders INT DEFAULT 0,\n" +
                    "    totalWorkHours INT\n" +
                    ");";
            executeUpdate(connection, createTableSQL);
        }

        private static void executeUpdate(Connection connection, String sql) throws SQLException {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.executeUpdate();
            }
        }
    }
