package com.dataworld.user;

import com.dataworld.db.Orders;
import com.dataworld.user.User;

public class Approver extends User {
    Approver(String userId, String userPw) {
        super(userId, userPw);
    }

    Orders orders = Orders.getOrderList();

    public void setApproval(String orderId, String flag) {
        orders.getApproval(orderId, flag);
    }
}
