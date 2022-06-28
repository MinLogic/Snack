package com.dataworld.snackworld;

import java.util.ArrayList;

public class UserList {
    private static UserList instance = new UserList();
    private ArrayList<User> userList;

    private UserList(){
        userList = new ArrayList<>();
    }

    public static UserList getInstance(){
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

    
}
