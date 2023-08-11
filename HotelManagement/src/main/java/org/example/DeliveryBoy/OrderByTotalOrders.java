package org.example.DeliveryBoy;

import java.util.Comparator;

public class OrderByTotalOrders implements Comparator<DeliveryBoy> {
    @Override
    public int compare(DeliveryBoy o1, DeliveryBoy o2) {
        if(o1.getTotalOrders() == 0 && o2.getTotalOrders()==0 ){
            return 0;
        }
        else if(o1.getTotalOrders() == o2.getTotalOrders()){
            return -1;
        }
        return o1.getTotalOrders() - o2.getTotalOrders();
    }
}
