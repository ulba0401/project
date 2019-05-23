package com.example.networkdic.vos;

import java.io.Serializable;

public class UserVO implements Serializable {
    String id, pw, email, admin, isdel;
    private String result;
    String logintype;

    public UserVO(String id, String pw, String email, String logintype) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.logintype = logintype;
    }

    public UserVO () {}

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
