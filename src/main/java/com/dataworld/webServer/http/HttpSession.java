package com.dataworld.webServer.http;

import com.dataworld.service.user.Auth;
import com.dataworld.service.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HttpSession {
    private static Map<String, Object> sessions = new HashMap<>();


    private static String newSessionId() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "");
    }

    public static String makeNewSession(User user) {
        String sessionId = newSessionId();
        Map<String, Object> userSession = new HashMap<>();

        userSession.put("ID", user.getUserId());
        userSession.put("AUTH", user.getAuth());

        sessions.put(sessionId, userSession);

        return sessionId;
    }

    private static Map<String, Object> getSession(String sessionId) {
        return (Map<String, Object>) sessions.get(sessionId);
    }

    public static Auth getUserAuth(String sessionId) {
        return (Auth) getSession(sessionId).get("AUTH");
    }

    public static String getUserId(String sessionId) {
        return (String) getSession(sessionId).get("ID");
    }

    public static boolean isExist(String sessionId) {
        Object obj = sessions.get(sessionId);
        if (obj == null) {
            return false;
        }
        return true;
    }
}
