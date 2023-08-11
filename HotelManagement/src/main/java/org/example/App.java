package org.example;

import org.example.CustomException.DataBaseNotFound;
import org.example.DataBase.DataBaseManager;
import org.example.Orders.OrderManager;

import java.sql.Connection;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws DataBaseNotFound, SQLException {
        Connection connection = DataBaseManager.getConnection();
        DataBaseManager.createTable(connection);
        OrderManager customerManager = new OrderManager();
        customerManager.get(connection);
    }
}