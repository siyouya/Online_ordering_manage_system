package com.etc.entity;

public class Customer {
    private int cid;
    private String username;
    private String password;
    private String realname;
    private String telepone;
    private String address;
    private int    state;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTelepone() {
        return telepone;
    }

    public void setTelepone(String telepone) {
        this.telepone = telepone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Customer() {
        super();
    }

    public Customer(int cid, String username, String password, String realname, String telepone, String address, int state) {
        super();
        this.cid = cid;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.telepone = telepone;
        this.address = address;
        this.state = state;
    }
}
