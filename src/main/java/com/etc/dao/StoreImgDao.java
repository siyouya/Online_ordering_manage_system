package com.etc.dao;

import com.etc.entity.Store;
import com.etc.entity.StoreImg;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreImgDao {
    DBUtils dbUtils=new DBUtils();
    public ArrayList<StoreImg>showImg(int sid) throws SQLException {
        ArrayList<StoreImg> list=new ArrayList<StoreImg>();
        ResultSet rs=DBUtils.doQuery("  select suser.*,store_img.imgurl from suser left join store_img on store_img.sid = suser.sid where  suser.sid=?  ; ",sid);
        while (rs.next()){

            Store store=new Store();
            store.setSid(rs.getInt("sid"));
            store.setShopname(rs.getString("shopname"));
            store.setUsername(rs.getString("username"));
            store.setRealname(rs.getString("realname"));
            store.setTelephone(rs.getString("telephone"));
            store.setAddress(rs.getString("address"));
            store.setIntro(rs.getString("intro"));
            store.setState(rs.getInt("state"));
            String imgurl=rs.getString("imgurl");
            list.add(new StoreImg(store,imgurl));

        }
        DBUtils.free(rs);

        return list;

    }

    public int addImg(int sid,String path){
        int state=0;
        int count  =DBUtils.doUpdate("insert into store_img(sid,imgurl)value(?,?)",sid,path);
        return count;
    }

}
