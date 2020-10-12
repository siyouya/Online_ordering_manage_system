package com.etc.dao;


import com.etc.entity.Disher;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
    public List<Disher> query() throws SQLException {

        ArrayList<Disher> list=new ArrayList<Disher>();

        ResultSet rs = DBUtils.doQuery("select * from dishes ");
        while(rs.next()){

            list.add(new Disher(rs.getInt("did"),rs.getString("dishname"),
                    rs.getInt("number"),rs.getString("rmaterial"),
                    rs.getInt("price"),rs.getInt("sid")));

        }
        return list;
    }

    public int deldish(String did){
        int id=Integer.parseInt(did);
        int count  = DBUtils.doUpdate("delete from dishes where did =?",id);
        return count;
    }


    public int update(int did, String dishname, String number, String rmaterial, String price, String sid) {
        int count  =DBUtils.doUpdate("update  dishes set dishname=?,number=?,rmaterial=?,price=?,sid=? where did=?; ",dishname,number,rmaterial,price,sid,did);
        return count;
    }
    public int adddish( String dishname, String number, String rmaterial, String price, String sid) {
        int count  =DBUtils.doUpdate("insert into  dishes (dishname,number,rmaterial,price,sid) values (?,?,?,?,?); ",dishname,number,rmaterial,price,sid);
        return count;
    }
}
