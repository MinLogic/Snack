package com.dataworld.user;

import com.dataworld.snackworld.Cart;
import com.dataworld.product.Product;

public class CommonUser extends User {
    Cart cart;

    CommonUser(String userId, String userPw) {
        super(userId, userPw);
        this.cart = new Cart();
    }

    public void addCartList(Product product){
        cart.addCart(product);
    }

    public void getCartList(){
        cart.getCartList();
    }

    public void orderCartAll(){
        cart.orderCartAll(this);
    }

    public void orderCartItem(Product product) {
        cart.orderCartItem(product, this);
    }
}
