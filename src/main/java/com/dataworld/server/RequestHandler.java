package com.dataworld.server;

import com.dataworld.controller.Controller;
import com.dataworld.http.HttpRequest;
import com.dataworld.http.HttpResponse;
import com.dataworld.product.Product;
import com.dataworld.db.Products;
import com.dataworld.user.User;
import com.dataworld.db.Users;
import com.dataworld.util.HttpRequestUtils;
import com.dataworld.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Map;
import java.util.Objects;

public class RequestHandler extends Thread{
    private Logger log = LoggerFactory.getLogger(RequestHandler.class);
    private Socket connection;

    public RequestHandler(Socket socket){
        this.connection = socket;
    }

    @Override
    public void run() {
        log.debug("New Client Connect! Connect IP: {}, Port: {}", connection.getInetAddress(), connection.getPort());

        try (InputStream in = connection.getInputStream();
             OutputStream out = connection.getOutputStream()) {
            //TODO 사용자 요청에 대한 처리는 이 곳에 구현하면 된다.
            HttpRequest httpRequest = new HttpRequest(in); // 이거 하나로 퉁칠수 있게 만들것
            HttpResponse httpResponse = new HttpResponse(out);
            String url = getDefaultPath(httpRequest.getPath());  //-> 인덱스로 가는 거

            Controller controller = RequestMapping.getController(url);
            if (Objects.isNull(controller)) {
                String path = getDefaultPath(url);
            } else {
                controller.service(httpRequest, httpResponse);
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html; charset=utf-8 \r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("Sek-Cookie: logined=true; Path=/ \r\n"); // 쿠키담는거
            dos.writeBytes( "\r\n");

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response302Header(DataOutputStream dos) {
        try {
            dos.writeBytes("HTTP/1.1 302 OK \r\n");
            dos.writeBytes("Location: /index.html \r\n"); // redirect 해줄 페이지 주소
            dos.writeBytes( "\r\n");

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.writeBytes( "\r\n");
            dos.flush();

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    private String postHandler(BufferedReader br){
        StringBuilder sb = new StringBuilder();
        try{
           while(br.ready()){
               String line = br.readLine();
               log.debug("content : {}", line);
               sb.append(line);
               sb.append("&");
           }
       } catch (IOException e) {
           log.error(e.getMessage());
       }
        return sb.toString();
    }

    private String getDefaultPath(String path) {
        if (path.equals("/")) {
            return "/index.html";
        }
        return path;
    }
}
