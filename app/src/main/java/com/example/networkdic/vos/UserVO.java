package com.example.networkdic.vos;

import java.io.Serializable;

public class UserVO implements Serializable {
    String id, pw, email, admin, isdel, name;
    Boolean Logintype;
    private String result;

    public UserVO(String id, String pw, String name, String email, String admin) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.admin = admin;
    }

    public UserVO () {}

    public Boolean getLogintype() {
        return Logintype;
    }

    public void setLogintype(Boolean logintype) {
        Logintype = logintype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
