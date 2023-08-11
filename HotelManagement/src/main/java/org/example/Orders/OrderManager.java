package org.example.Orders;

import org.example.Customer.Customer;
import org.example.DataBase.DaoCustomer;
import org.example.DataBase.DaoDeliveryBoys;
import org.example.DeliveryBoy.DeliveryBoy;
import org.example.DeliveryBoy.OrderByTotalOrders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class OrderManager {

    DaoCustomer daoCustomer = new DaoCustomer();
    DaoDeliveryBoys daoDeliveryBoys = new DaoDeliveryBoys();
    public void get(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the total number of Orders : ");
        int N=scanner.nextInt();
        System.out.println("Enter the total number of Delivery Boys : ");
        int M = scanner.nextInt();
        List<Customer> customers;
        List<DeliveryBoy> deliveryBoys;
        List<Customer> values = new ArrayList<>();
        for(int i=1;i<=N;i++){
            System.out.println("Enter the "+i+" Order Time : ");
            int oTime = scanner.nextInt();
            System.out.println("Enter the "+i+" Delivery Time : ");
            int dTime = scanner.nextInt();
            values.add(new Customer(oTime,dTime,"C"+i));
       }
        daoCustomer.insert(connection,values);
        List<DeliveryBoy> deliveryBoysValues = new ArrayList<>();
        for(int i=1;i<=M;i++){
            deliveryBoysValues.add(new DeliveryBoy("D"+i));
        }
        daoDeliveryBoys.insert(connection,deliveryBoysValues);
        customers = daoCustomer.get(connection);

        for(Customer customer:customers){
            deliveryBoys = daoDeliveryBoys.get(connection);
            boolean assigned = false;
            Collections.sort(deliveryBoys,new OrderByTotalOrders());
            for (DeliveryBoy deliveryBoy:deliveryBoys){
                if(deliveryBoy.getEndTime() <= customer.getOrderTime()){
                    System.out.println(customer.getName()+" - "+deliveryBoy.getName());
                    assigned = true;
                    daoDeliveryBoys.update(connection,new DeliveryBoy(deliveryBoy.getId(),
                            customer.getOrderTime(),
                            customer.getDeliveryTime()+customer.getOrderTime(),
                            deliveryBoy.getTotalOrders()+1,
                                    deliveryBoy.getTotalWorkHours()+ customer.getDeliveryTime()
                            ));
                    break;
                }
            }
            if(!assigned){
                System.out.println(customer.getName()+" - No Food :-(");
            }
        }
    }
}

