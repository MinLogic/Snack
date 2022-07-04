package com.dataworld.db;

import com.dataworld.user.User;

import java.util.ArrayList;

public class Users {
    private static Users instance = new Users();
    private ArrayList<User> userList;

    private Users(){
        userList = new ArrayList<>();
    }

    public static Users getInstance(){
        return instance;
    }


    public boolean login(String Id, String Pw){
        for(User item : userList){
            String userId = item.getUserId();
            String userPw = item.getUserPw();

            if((Id.equals(userId)) && (Pw.equals(userPw))){
                return true;
            }
        }
        return false;
    }

    public void regUser(User user) {
        userList.add(user);
    }

    public void delUser(User user) {
        userList.remove(user);
    }


}
