package com.etc.dao;


import com.etc.entity.Disher;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
    public List<Disher> query(int sid) throws SQLException {

        ArrayList<Disher> list=new ArrayList<Disher>();

        ResultSet rs = DBUtils.doQuery("select * from dishes where sid=?",sid);
        while(rs.next()){

            list.add(new Disher(rs.getInt("did"),rs.getString("dishname"),
                    rs.getInt("number"),rs.getString("rmaterial"),
                    rs.getInt("price"),rs.getInt("sid")));

        }
        DBUtils.free(rs);
        return list;
    }

    /**
     * 根据商家id查询菜品总数返回总数/12
     * @param sid 商家id
     */
    public int querypagenum(int sid) throws SQLException {

        int num = 0;

        ResultSet rs = DBUtils.doQuery("SELECT COUNT(*) as num from dishes where sid=?",sid);
        while(rs.next()){

            num=rs.getInt("num");

        }
        num=num/12+1;
        DBUtils.free(rs);
        return num;
    }
    /**
     *
     * @param sid 店家id
     * @param page 分页查询
     * @return
     * @throws SQLException
     */
    public List<Disher> query(int sid,int page) throws SQLException {

        ArrayList<Disher> list=new ArrayList<Disher>();
        page=12*(page-1);
        ResultSet rs = DBUtils.doQuery("select * from(SELECT * from dishes where sid=?) as tep limit ?,12",sid,page);
        while(rs.next()){

            list.add(new Disher(rs.getInt("did"),rs.getString("dishname"),
                    rs.getInt("number"),rs.getString("rmaterial"),
                    rs.getInt("price"),rs.getInt("sid")));

        }
        DBUtils.free(rs);
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
    public int sellout(int did) {
        int count  =DBUtils.doUpdate("update  dishes set number=0 where did=?; ",did);
        return count;
    }
    public int sellone(String dishname, int sid){
        int count =DBUtils.doUpdate("update dishes set number=number-1 WHERE dishname=?",dishname);
        return count;
    }
}
