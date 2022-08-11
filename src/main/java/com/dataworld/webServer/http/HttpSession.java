package com.dataworld.webServer.http;

import com.dataworld.service.user.User;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class HttpSession {
    private static Map<String, Object> sessions = new HashMap<>();


    private static String newSessionId() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "");
    }

//    public static String setSession(User user){
//        String sessionId = newSessionId();
//        Map<String, String> userMap = new HashMap<>();
//            userMap.put("id", user.getUserId());
//        userMap.put("auth", user.getAuth());
//        sessions.put(sessionId, userMap);
//        return sessionId;
//    }

    public static boolean isExist(String sessionId) {
        Object obj = sessions.get(sessionId);
        if (obj == null) {
            return false;
        }
        return true;
    }
}
