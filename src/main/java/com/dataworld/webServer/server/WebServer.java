package com.dataworld.webServer.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static final Logger log = LoggerFactory.getLogger(WebServer.class);
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = 0;
        if (args == null || args.length == 0) {
            port = DEFAULT_PORT;
        } else {
            port = Integer.parseInt(args[0]);
        }

        try (ServerSocket listenSocket = new ServerSocket(port)) {
            log.info("Web Application Server started {} port", port); // 가능하면 {} 포맷을 사용하는것을 추천

            Socket connection;
            while((connection = listenSocket.accept()) != null){
                RequestHandler requestHandler = new RequestHandler(connection);
                requestHandler.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
