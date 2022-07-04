package com.dataworld.order;

import com.dataworld.product.Product;
import com.dataworld.user.User;

import java.util.List;

public class Order {
    private User orderUser;
    private List<Product> orderList;

    public Order(User orderUser, List<Product> orderList){
        this.orderUser = orderUser;
        this.orderList = orderList;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public List<Product> getOrderList() {
        return orderList;
    }
}
