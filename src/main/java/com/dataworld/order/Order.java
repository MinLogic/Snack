package com.dataworld.order;

import com.dataworld.product.Product;
import com.dataworld.user.User;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private String orderId;
    private User orderUser;
    private List<Product> orderList;
    private String approvedFlag;  // A : 승인  R : 반려  S : 대기

    public Order(User orderUser, List<Product> orderList){
        this.orderUser = orderUser;
        this.orderList = orderList;
        this.orderId = UUID.randomUUID()
                .toString()
                .replace("-", "");
        this.approvedFlag = "S";
    }

    public void getApproval(String flag){
        this.approvedFlag = flag;
    }
}
