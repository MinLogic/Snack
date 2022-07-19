package com.dataworld.db;

import com.dataworld.user.Admin;
import com.dataworld.user.User;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Getter
public class Users {
    private static final Logger log = LoggerFactory.getLogger(Users.class);

    private static Users instance = new Users();

    // TODO List -> Map
    private ArrayList<User> userList;

    private Users(){
        userList = new ArrayList<>();
        // 임시 계정
        userList.add(new Admin("admin", "admin"));
    }

    public static Users getInstance(){
        return instance;
    }

    public int countUserList(){
        return userList.size();
    }

    // ID 사용해서 유저 하나만 검색
    public User retrieveUser(String Id) {
        User temp = null;
        for (User user : userList) {
            String userId = user.getUserId();
            if(userId.equals(Id)){
                temp = user;
            }
        }

        if (temp != null) {
            if (!isDeleted(temp)) {
                return temp;
            }
        }
        return null;
    }

    public boolean isDeleted(User user) {
        if ("N".equals(user.getDelYn())) {
            return false;
        }
        return true;
    }

    public void regUser(User user) {
        User target = retrieveUser(user.getUserId());
        if(target == null){
            userList.add(user);
            log.info("User registration success");
            log.info("{}", user.getUserId());
            return;
        }
        log.info("User deletion failure");
        log.info("User has already been registered");
    }

    public void delUser(User user) {
        User target = retrieveUser(user.getUserId());
        if(target != null){
            target.setDelYn("Y");
            log.info("User deletion success");
            return;
        }
        log.info("User deletion failure");
        log.info("User has already been deleted or does not exist");
    }

    public void delUser(String userId) {
        User target = retrieveUser(userId);
        if(target != null){
            target.setDelYn("Y");
            log.info("User deletion success");
            return;
        }
        log.info("User deletion failure");
        log.info("User has already been deleted or does not exist");
    }

    public void resetPassword(String userId) {
        User target = retrieveUser(userId);
        target.resetPassword();
        log.info("Password Reset Success");
    }

    public void modPassword(String userId, String pw) {
        User target = retrieveUser(userId);
        target.modPassword(pw);
        log.info("Password Reset Success");
    }
}
