package com.dataworld.user;

import com.dataworld.snackworld.Cart;
import com.dataworld.product.Product;
import com.dataworld.snackworld.Standard;

public class CommonUser extends User {
    Cart cart;
    int remainingAmount;

    public CommonUser(String userId, String userPw) {
        super(userId, userPw);
        this.cart = new Cart();
        this.remainingAmount = Standard.getStandard()
                                .getLimitedAmount();
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
