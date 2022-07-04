package com.dataworld.db;

import com.dataworld.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static Orders instance = new Orders();
    private List<Order> orderList;

    private Orders(){
        orderList = new ArrayList<>();
    }

    public static Orders getOrderList(){
        return instance;
    }

    public void addOrderList(Order order){
        orderList.add(order);
    }
}
