package com.dataworld.service.user;

import com.dataworld.service.db.Products;
import com.dataworld.service.db.Users;
import com.dataworld.service.product.Product;
import com.dataworld.service.snackworld.Standard;

public class Admin extends User {
    Users users = Users.getInstance();
    Products products = Products.getInstance();

    Standard standard = Standard.getStandard();
    public Admin(String userId, String userPw) {
        super(userId, userPw);
    }

    public void regUser(User user){
        users.regUser(user);
    }
    public void delUser(User user){
        users.delUser(user);
    }
    public void delUser(String userId){
        users.delUser(userId);
    }

    public void regProduct(Product product) {
        products.regProduct(product);
    }

    public void delProduct(String productId) {
        products.delProduct(productId);
    }

    public void setStandard(Integer startDate, Integer endDate, Integer limitAmount){
        standard.setStandard(startDate, endDate, limitAmount);
    }
}
