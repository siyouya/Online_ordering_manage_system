package com.etc.dao;

import com.etc.entity.DishImg;
import com.etc.entity.Disher;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DishImgDao {
    DBUtils db=new DBUtils();
    public ArrayList<DishImg> showImg(int sid,int page) throws SQLException {
        ArrayList<DishImg> list=new ArrayList<DishImg>();
        page=6*(page-1);
        ResultSet rs = DBUtils.doQuery("select * from(select a.did,dishname,number,price,rmaterial,imgurl  from  (select  dishes.did,dishes.dishname,dishes.number,dishes.price,dishes.rmaterial from " +
                " dishes,suser where dishes.sid=suser.sid and suser.sid=?) as a  " +
                " left outer  join dish_img on a.did=dish_img.did)as " +
                " tep limit ?,6",sid,page);
        while(rs.next()){
            Disher disher=new Disher();
            disher.setDid(rs.getInt("did"));
            disher.setDishname(rs.getString("dishname"));
            disher.setNumber(rs.getInt("number"));
            disher.setPrice(rs.getInt("price"));
            disher.setRmaterial(rs.getString("rmaterial"));
            String imgurl=rs.getString("imgurl");
            list.add(new DishImg(disher,imgurl));
        }
        DBUtils.free(rs);
        return list;
    }

    public int deldish(String did){
        int id=Integer.parseInt(did);
        int count  = DBUtils.doUpdate("delete from dish_img where did =?",id);
        return count;
    }
}
