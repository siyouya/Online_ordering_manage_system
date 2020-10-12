package com.etc.entity;

public class Store {
    private int sid;
    private String shopname;
    private String username;
    private String password;
    private String realname;
    private String telephone;
    private String address;
    private String intro;
    private int state;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Store() {
        super();
    }

    public Store(int sid, String shopname, String username, String password, String realname, String telephone, String address, String intro, int state) {
        super();
        this.sid = sid;
        this.shopname = shopname;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.telephone = telephone;
        this.address = address;
        this.intro = intro;
        this.state = state;
    }
}
