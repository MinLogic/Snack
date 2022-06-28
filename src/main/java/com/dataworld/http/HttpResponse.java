package com.dataworld.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private static final Logger log = LoggerFactory.getLogger(HttpResponse.class);

    private DataOutputStream dos = null;
    private Map<String, String> header = new HashMap<>();

    public HttpResponse(OutputStream out) {
        this.dos = new DataOutputStream(out);
    }

    public void addHeader(String key, String value) {
        header.put(key, value);
    }

    public void forward(String url) {
//        try {
//
//        } catch (IOException e) {
//
//        }
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


}
