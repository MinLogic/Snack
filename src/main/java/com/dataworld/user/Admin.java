package com.dataworld.user;

import com.dataworld.db.Products;
import com.dataworld.db.Users;
import com.dataworld.product.Product;

public class Admin extends User {
    Users users = Users.getInstance();
    Products products = Products.getInstance();
    Admin(String userId, String userPw) {
        super(userId, userPw);
    }

    public void regUser(User user){
        users.regUser(user);
    }
    public void delUser(User user){
        users.delUser(user);
    }

    public void regProduct(Product product) {
        products.regProduct(product);
    }

    public void delProduct(String productId) {
        products.delProduct(productId);
    }
}
