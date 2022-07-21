package com.dataworld.webServer.http;

import com.dataworld.service.user.User;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class HttpSession {
    private static Map<String, Object> sessions = new HashMap<>();


    public static String newSession(User user){
        Map<String, String> userMap = new HashMap<>();
        String sessionId = UUID.randomUUID()
                .toString()
                .replace("-", "");

        sessions.put(sessionId, userMap);
        return sessionId;
    }
}
