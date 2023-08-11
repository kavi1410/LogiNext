package org.example.DeliveryBoy;


public class DeliveryBoy{
    private int id;
    private String Name;
    private int startTime;
    private int endTime;
    private int totalOrders;
    private int totalWorkHours;


    public DeliveryBoy(String name, int startTime, int endTime, int totalOrders, int totalWorkHours) {
        this.Name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalOrders = totalOrders;
        this.totalWorkHours = totalWorkHours;

    }

    public DeliveryBoy(int id ,int startTime, int endTime, int totalOrders, int totalWorkHours) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalOrders = totalOrders;
        this.totalWorkHours = totalWorkHours;
    }

    public DeliveryBoy(int id, String name, int startTime, int endTime, int totalOrders, int totalWorkHours) {
        this.id = id;
        Name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalOrders = totalOrders;
        this.totalWorkHours = totalWorkHours;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getTotalWorkHours() {
        return totalWorkHours;
    }

    public void setTotalWorkHours(int totalWorkHours) {
        this.totalWorkHours = totalWorkHours;
    }

    public String getName() {
        return Name;
    }
    public DeliveryBoy(String name) {
        this.Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
