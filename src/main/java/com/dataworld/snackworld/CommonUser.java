package com.dataworld.snackworld;

public class CommonUser extends User{
    Cart cart = new Cart();

    CommonUser(String userId, String userPw) {
        super(userId, userPw);
    }

    public void addGoods(Goods goods){
        cart.addCart(goods);
    }

    public void getCartList(){
        cart.getCartList();
    }

    public void orderCartAll(){
        cart.orderCartAll(this);
    }

    public void orderCartItem(Goods goods) {
        cart.orderCartItem(goods, this);
    }
}
