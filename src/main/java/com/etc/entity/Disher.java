package com.etc.entity;

public class Disher {
    private int did;
    private String dishname;
    private int number;
    private  String rmaterial;
    private int price;

    private  int sid;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRmaterial() {
        return rmaterial;
    }

    public void setRmaterial(String rmaterial) {
        this.rmaterial = rmaterial;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
    public Disher() {

    }
    public Disher(int did, String dishname, int number, String rmaterial, int price, int sid) {
        this.did = did;
        this.dishname = dishname;
        this.number = number;
        this.rmaterial = rmaterial;
        this.price = price;
        this.sid = sid;
    }


}
