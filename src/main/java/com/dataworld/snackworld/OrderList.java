package com.dataworld.snackworld;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static OrderList instance = new OrderList();
    private List<Order> orderList;

    private OrderList(){
        orderList = new ArrayList<>();
    }

    public static OrderList getOrderList(){
        return instance;
    }

    public void addOrderList(Order order){
        orderList.add(order);
    }
}
