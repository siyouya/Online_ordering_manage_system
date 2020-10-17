package com.etc.entity;

public class StoreImg {
    private int img_sid;
    private Store sid;
    private String imgurl;

    public int getImg_sid() {
        return img_sid;
    }

    public void setImg_sid(int img_sid) {
        this.img_sid = img_sid;
    }

    public Store getSid() {
        return sid;
    }

    public void setSid(Store sid) {
        this.sid = sid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public StoreImg() {
        super();
    }

    public StoreImg(int img_sid, Store sid, String imgurl) {
        super();
        this.img_sid = img_sid;
        this.sid = sid;
        this.imgurl = imgurl;
    }
    public StoreImg( Store sid, String imgurl) {
        super();
        this.sid = sid;
        this.imgurl = imgurl;
    }
}
