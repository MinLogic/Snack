package com.dataworld.snackworld;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Goods> cartList = new ArrayList<>();
    OrderList orderList = OrderList.getOrderList();

    public List<Goods> getCartList() {
        return cartList;
    }

    public void addCart(Goods goods){
        cartList.add(goods);
    }

    public void orderCartAll(User user){
        // 기준 검사 해야함

        orderList.addOrderList(new Order(user, this.cartList));
    }

    public void orderCartItem(Goods goods, User user){
        int index = cartList.indexOf(goods);
        if(index == -1){
            System.out.println("메시지");
            return;
        }
        orderList.addOrderList(new Order(user, (List<Goods>) cartList.get(index)));
    }

    public void deleteCartItem(){

    }
}
