package com.etc.entity;

import java.util.Date;

public class Order {
    private int oid;
    private int uid;
    private int sid;
    private int rid;
    private String dlist;
    private Date acceptdate;
    private Date completedate;
    private int state;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Date getAcceptdate() {
        return acceptdate;
    }

    public void setAcceptdate(Date acceptdate) {
        this.acceptdate = acceptdate;
    }

    public Date getCompletedate() {
        return completedate;
    }

    public void setCompletedate(Date completedate) {
        this.completedate = completedate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDlist() {
        return dlist;
    }

    public void setDlist(String dlist) {
        this.dlist = dlist;
    }

    public Order() {
    }

    public Order(int oid, int uid, int sid, int rid, String dlist, Date acceptdate, Date completedate, int state) {
        this.oid = oid;
        this.uid = uid;
        this.sid = sid;
        this.rid = rid;
        this.dlist = dlist;
        this.acceptdate = acceptdate;
        this.completedate = completedate;
        this.state = state;
    }
}
