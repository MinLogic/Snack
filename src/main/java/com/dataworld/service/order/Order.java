package com.dataworld.service.order;

import com.dataworld.service.product.Product;
import com.dataworld.service.user.User;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private String orderId;
    private User orderUser;
    private List<Product> orderList;

    private String delYn;
    private Approval approval;

    public Order(User orderUser, List<Product> orderList){
        this.orderUser = orderUser;
        this.orderList = orderList;
        this.orderId = UUID.randomUUID()
                .toString()
                .replace("-", "");
        this.delYn = "N";
        this.approval = Approval.WAITING;
    }

    public void signOff(Approval approval) {
        this.approval = approval;
    }


    public Product retrieveOrderedProduct(String productId) {
        Product target = null;
        for (Product item : orderList) {
            String itemName = item.getProductId();
            if(itemName.equals(productId)){
                target = item;
            }
        }
        // delYn check
        if (target != null && !isDeleted(target)) {
            return target;
        }
        return null;
    }

    public boolean isDeleted(Product item) {
        if ("N".equals(item.getDelYn())) {
            return false;
        }
        return true;
    }

    public void delProduct(String productId) {

    }
}
