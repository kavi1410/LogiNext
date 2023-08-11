package org.example.Customer;

public class Customer {

    private String Name;
    private int orderTime;
    private int deliveryTime;

    public Customer(int orderTime, int deliveryTime, String name) {
        this.orderTime = orderTime;
        this.deliveryTime = deliveryTime;
        this.Name = name;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getName() {
        return Name;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }


}
