package com.dataworld.webServer.server;

import com.dataworld.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private static Map<String, Controller> controllers = new HashMap<>();

    static {
        controllers.put("/user/create", new CreateUserController());
        controllers.put("/login", new LoginController());
        controllers.put("/login/loginForm", new LoginController());
        controllers.put("/product/regForm", new LoginController());
        controllers.put("/product", new LoginController());
        controllers.put("/api/users", (Controller) new ApiUsersController());
        controllers.put("/home", new HomeController());
    }

    public static Controller getController(String requestUrl) {
        return controllers.get(requestUrl);
    }
}
