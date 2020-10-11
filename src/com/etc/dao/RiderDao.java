package com.etc.dao;

import com.etc.util.DBUtils;

import java.sql.ResultSet;

public class RiderDao {
    public int  checklogin(String username,String password){
        int result=0;
        ResultSet rs = DBUtils.doQuery("select rid from ruser where username =? and password =?", username, password);
        try {
            if(rs.next()){
                result=rs.getInt("rid");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;

    }

    public int reg(String username,String password,String realname,String telephone){
        int state=0;
        int count  =DBUtils.doUpdate("insert into ruser(username,password,realname,telephone,state)value(?,?,?,?,?)",username,password,realname,telephone,state);
        return count;
    }
}
