package com.etc.dao;

import com.etc.entity.Rider;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Rider> query(int rid){
        ResultSet rs = DBUtils.doQuery("select * from ruser where rid=? ",rid);

        List<Rider> list   = new ArrayList<Rider>();
        try {
            while (rs.next()) {
                list.add(new Rider(
                                rs.getInt("rid"),
                                rs.getString("realname"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("telephone"),
                                rs.getInt("state")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtils.free(rs);
        }
        return list;
    }
    public int update(String realname,String telephone,int rid){
        int count  =DBUtils.doUpdate("update  ruser set realname=?,telephone=? where rid=?; ",realname,telephone,rid);
        return count;
    }

   public int  modifypas(String password,int rid){
        int count=DBUtils.doUpdate("update  ruser set password=? where rid=?;",password,rid);
        return count;
   }

}
