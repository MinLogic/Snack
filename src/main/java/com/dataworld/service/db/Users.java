package com.dataworld.service.db;

import com.dataworld.service.user.Auth;
import com.dataworld.service.user.User;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
public class Users {
    private static final Logger log = LoggerFactory.getLogger(Users.class);
    // TODO List -> Map
    private static ArrayList<User> users = new ArrayList<>(Arrays.asList(new User("ADMIN", "1234", Auth.ADMIN)));

    public Users(){ }

    public int countUserList(){
        return users.size();
    }

    public ArrayList<User> retrieveAllUsers() {
        return users;
    }

    // ID 사용해서 유저 하나만 검색
    public User retrieveUser(String Id) {
        User temp = null;
        for (User user : users) {
            String userId = user.getUserId();
            if(userId.equals(Id)){
                temp = user;
            }
        }

        // delYn check
        if (temp != null && !isDeleted(temp)) {
            return temp;
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
            users.add(user);
            log.info("User registration success");
            log.info("{}", user.getUserId());
            return;
        }
        log.info("User deletion failure");
        log.info("User has already been registered");
    }

    public void delUser(String userId) {
        User target = retrieveUser(userId);
        if(target != null){
            target.delUser();
            setTargetUser(target);
            log.info("User deletion success");
            return;
        }
        log.info("User deletion failure");
        log.info("User has already been deleted or does not exist");
    }

    public void resetPassword(String userId) {
        User target = retrieveUser(userId);
        target.resetPassword();
        setTargetUser(target);
        log.info("Password Reset Success");
    }

    public void modPassword(String userId, String pw) {
        User target = retrieveUser(userId);
        target.modPassword(pw);
        setTargetUser(target);
        log.info("Password Reset Success");
    }

    private void setTargetUser(User target) {
        int index = users.indexOf(target);
        users.set(index, target);
    }
}
