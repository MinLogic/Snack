package com.dataworld.db;

import com.dataworld.order.Order;
import com.dataworld.product.Product;
import com.dataworld.user.User;

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

    // ID 사용해서 상품 1개만 검색
    public Order retrieveOrder(String orderId) {
        Order temp = null;
        for (Order item : orderList) {
            String itemName = item.getOrderId();
            if(itemName.equals(orderId)){
                temp = item;
            }
        }
        if (temp != null) {
            return temp;
        }
        return null;
    }

    // 사용자 ID로 주문 목록 조회
    public ArrayList<Order> searchOrderList(String orderUser){
        ArrayList<Order> retrievedList = new ArrayList<>();
        for(Order item : orderList){
            String orderId = item.getOrderId();
            if(orderId.equals(orderUser)){
                retrievedList.add(item);
            }
        }
        return retrievedList;
    }

    public ArrayList<Order> searchListWithFlag(String orderUser, String searchFlag){
        ArrayList<Order> retrievedList = new ArrayList<>();
        for(Order item : orderList){
            String orderId = item.getOrderId();
            String flag = item.getApprovedFlag();
            if(orderId.equals(orderUser) && searchFlag.equals(flag)){
                retrievedList.add(item);
            }
        }
        return retrievedList;
    }


    public void getApproval(String orderId, String flag) {
        Order temp = retrieveOrder(orderId);
        temp.getApproval(flag);
    }

}
