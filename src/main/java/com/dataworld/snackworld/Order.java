package com.dataworld.snackworld;

import java.util.List;

public class Order {
    private User orderUser;
    private List<Goods> orderList;

    public Order(User orderUser, List<Goods> orderList){
        this.orderUser = orderUser;
        this.orderList = orderList;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public List<Goods> getOrderList() {
        return orderList;
    }
}
