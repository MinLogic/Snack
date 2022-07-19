package com.dataworld.server;

import com.dataworld.controller.ApiUsersController;
import com.dataworld.controller.Controller;
import com.dataworld.controller.CreateUserController;
import com.dataworld.controller.LoginController;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private static Map<String, Controller> controllers = new HashMap<>();

    static {
        controllers.put("/user/create", new CreateUserController());
        controllers.put("/login", new LoginController());
        controllers.put("/login/loginForm", new LoginController());
        controllers.put("/api/users", (Controller) new ApiUsersController());
    }

    public static Controller getController(String requestUrl) {
        return controllers.get(requestUrl);
    }
}
