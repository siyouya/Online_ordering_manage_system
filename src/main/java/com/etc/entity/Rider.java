package com.etc.entity;

public class Rider {
    private int rid;
    private String realname;
    private String username;
    private String password;
    private String telephone;
    private int state;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Rider() {
        super();
    }

    public Rider(int rid, String realname, String username, String password, String telephone, int state) {
        super();
        this.rid = rid;
        this.realname = realname;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.state = state;
    }
}
