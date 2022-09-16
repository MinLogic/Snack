package com.dataworld.service.user;

import com.dataworld.service.product.Product;
import com.dataworld.service.snackworld.Cart;
import com.dataworld.service.snackworld.Standard;
import lombok.Getter;

@Getter
public class User {
    private final String userId;
    private String userPw;
    private Auth auth;
    private String delYn;

    Cart cart;
    int remainingAmount;
    Standard standard = Standard.getStandard();

    public User(String userId, String userPw, Auth auth){
        this.userId = userId;
        this.userPw = userPw;
        this.auth = auth;
        this.delYn = "N";
    }

    // Delete Item
    // 단순히 값 변경하는 함수인데 setter를 사용하는것과 무엇이 다른지
    public void delUser(){
        this.delYn = "Y";
    }

    // Item Modification
    public void resetPassword() {
        this.userPw = "1q2w3e4r!";
    } // Every User

    public void modPassword(String userPw){
        this.userPw = userPw;
    } // Every User

    public boolean login(String userPw) {
        return this.userPw.equals(userPw);
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
