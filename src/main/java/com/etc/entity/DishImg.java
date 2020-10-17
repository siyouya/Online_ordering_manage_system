package com.etc.entity;

public class DishImg {
    private int dish_img_id;
    private Disher did;
    private String imgurl;

    public int getDish_img_id() {
        return dish_img_id;
    }

    public void setDish_img_id(int dish_img_id) {
        this.dish_img_id = dish_img_id;
    }

    public Disher getDid() {
        return did;
    }

    public void setDid(Disher did) {
        this.did = did;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public DishImg() {
        super();
    }

    public DishImg(int dish_img_id, Disher did, String imgurl) {
        this.dish_img_id = dish_img_id;
        this.did = did;
        this.imgurl = imgurl;
    }
    public DishImg( Disher did, String imgurl) {
        this.did = did;
        this.imgurl = imgurl;
    }

}
