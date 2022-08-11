package com.dataworld.service.db;

import com.dataworld.service.order.Approval;
import com.dataworld.service.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static List<Order> orders = new ArrayList<>();

    public Orders(){ }

    public void addOrderList(Order order){
        orders.add(order);
    }

    public static List<Order> retrieveAllOrder() {
        return orders;
    }

    public Order retrieveOrder(String orderId) {
        Order order = null;
        for (Order item : orders) {
            String itemId = item.getOrderId();
            if(itemId.equals(orderId)){
                order = item;
            }
        }
        if (order != null) {
            return order;
        }
        return null;
    }

    public ArrayList<Order> retrieveOrderList(String orderUserId){
        ArrayList<Order> retrievedList = new ArrayList<>();
        for(Order item : orders){
            String itemUserId = item.getOrderUser()
                                    .getUserId();
            if(itemUserId.equals(orderUserId)){
                retrievedList.add(item);
            }
        }
        return retrievedList;
    }

    public ArrayList<Order> retrieveOrderList(String orderUserId, Approval approvalFlag) {
        ArrayList<Order> retrievedList = new ArrayList<>();
        for (Order item : orders) {
            String itemUserId = item.getOrderUser()
                    .getUserId();
            Approval itemApproval = item.getApproval();
            if (itemUserId.equals(orderUserId) && itemApproval == approvalFlag) {
                retrievedList.add(item);
            }
        }
        return retrievedList;
    }
}
