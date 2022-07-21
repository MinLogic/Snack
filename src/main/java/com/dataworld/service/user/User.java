package com.dataworld.service.user;

import lombok.Getter;

@Getter
public class User {
    private String userId;
    private String userPw;

    private String delYn;

    public User(String userId, String userPw){
        this.userId = userId;
        this.userPw = userPw;
        this.delYn = "N";
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public void resetPassword() {
        this.userPw = "1q2w3e4r!";
    }

    public void modPassword(String userPw){
        this.userPw = userPw;
    }

    public boolean login(String userPw) {
        return this.userPw.equals(userPw);
    }

}
