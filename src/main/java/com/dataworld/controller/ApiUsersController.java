package com.dataworld.controller;

import com.dataworld.db.Users;
import com.dataworld.http.HttpRequest;
import com.dataworld.http.HttpResponse;
import com.dataworld.user.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ApiUsersController implements Controller {
    @Override
    public void service(HttpRequest request, HttpResponse response) {
        try {
            PrintWriter out = response.getWriter();
            response.addHeader("Content-type", "application/json");
            out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//        extends AbstractController {
//    @Override
//public void doGet(HttpRequest request, HttpResponse response) {
//        JSONArray jsonArray = makeJsonArray();
//
//    }
//
//    public JSONArray makeJsonArray() {
//
//        Users users = Users.getInstance();
//        List<User> userList = users.getUserList();
//
//        JSONArray jsonArray = new JSONArray();
//        for (User user : userList) {
//            JSONObject jsonObject = new JSONObject();
//
//            jsonObject.put("userId", user.getUserId());
//            jsonObject.put("userPw", user.getUserPw());
//            jsonObject.put("delYn", user.getDelYn());
//
//            jsonArray.add(jsonObject);
//        }
//
//        return jsonArray;
//    }
//}
