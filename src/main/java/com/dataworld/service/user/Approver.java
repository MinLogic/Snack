package com.dataworld.service.user;

import com.dataworld.service.db.Orders;

public class Approver extends User {
    Approver(String userId, String userPw) {
        super(userId, userPw);
    }

    Orders orders = Orders.getOrderList();

    public void setApproval(String orderId, String flag) {
        orders.getApproval(orderId, flag);
    }
}
