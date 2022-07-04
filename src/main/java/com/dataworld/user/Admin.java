package com.dataworld.user;

import com.dataworld.db.Users;

public class Admin extends User {
    Users users = Users.getInstance();
    Admin(String userId, String userPw) {
        super(userId, userPw);
    }

    public void regUser(User user){
        users.regUser(user);
    }

    public void delUser(User user){
        users.delUser(user);
    }
}
