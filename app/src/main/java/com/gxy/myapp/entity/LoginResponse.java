package com.gxy.myapp.entity;

/**
 * @author GUO
 * @Classname LoginResponse
 * @Description TODO
 * @Date 2020/10/20 19:37
 */

public class LoginResponse {

    /**
     * msg : success
     * code : 0
     * expire : 604800
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMCIsImlhdCI6MTYwMzE5MzA4NSwiZXhwIjoxNjAzNzk3ODg1fQ.yr1EmqLHYjLUypNNuMhP1GgEwwW0MCdFzN8wpo6EFYoh0wmLmWRPrPiRbW-d4wQnv-O_UO46u7cO1ELPD8j9qQ
     */

    private String msg;
    private int code;
    private int expire;
    private String token;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
