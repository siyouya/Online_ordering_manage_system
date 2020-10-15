package com.etc.entity;

import java.util.Date;

public class OrderRider {
    private int oid;
    private Customer cid;
    private Store sid;
    private Rider rid;
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

    public Customer getCid() {
        return cid;
    }

    public void setCid(Customer cid) {
        this.cid = cid;
    }

    public Store getSid() {
        return sid;
    }

    public void setSid(Store sid) {
        this.sid = sid;
    }

    public Rider getRid() {
        return rid;
    }

    public void setRid(Rider rid) {
        this.rid = rid;
    }

    public String getDlist() {
        return dlist;
    }

    public void setDlist(String dlist) {
        this.dlist = dlist;
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

    public OrderRider() {
    }

    public OrderRider(int oid, Customer cid, Store sid, Rider rid, String dlist, Date acceptdate, Date completedate, int state) {
        this.oid = oid;
        this.cid = cid;
        this.sid = sid;
        this.rid = rid;
        this.dlist = dlist;
        this.acceptdate = acceptdate;
        this.completedate = completedate;
        this.state = state;
    }

    public OrderRider(int oid, Customer cid, Store sid ) {
        this.oid = oid;
        this.cid = cid;
        this.sid = sid;
    }
    public OrderRider(int oid,Date acceptdate,Date completedate,int state,Customer cid, Rider rid ) {
        this.oid = oid;
        this.cid = cid;
        this.rid = rid;
        this.acceptdate=acceptdate;
        this.completedate=completedate;
        this.state=state;
    }
    public OrderRider(int oid,Date acceptdate,String dlist,int state,Store sid ,Customer cid) {
        this.oid = oid;
        this.cid = cid;
        this.sid = sid;
        this.acceptdate=acceptdate;
        this.state=state;
        this.dlist=dlist;
    }

}
