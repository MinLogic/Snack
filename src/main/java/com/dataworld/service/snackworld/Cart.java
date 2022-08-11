package com.dataworld.service.snackworld;

import com.dataworld.service.db.Orders;
import com.dataworld.service.order.Order;
import com.dataworld.service.product.Product;
import com.dataworld.service.user.User;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartList = new ArrayList<>();
    Orders orders = new Orders();

    public List<Product> getCartList() {
        return cartList;
    }

    public void addCart(Product product){
        cartList.add(product);
    }

    public void orderCartAll(User user){
        // 기준 검사 해야함

        orders.addOrderList(new Order(user, this.cartList));
    }

    public void orderCartItem(Product product, User user){
        int index = cartList.indexOf(product);
        if(index == -1){
            System.out.println("메시지");
            return;
        }
        orders.addOrderList(new Order(user, (List<Product>) cartList.get(index)));
    }

    public void deleteCartItem(){

    }
}
