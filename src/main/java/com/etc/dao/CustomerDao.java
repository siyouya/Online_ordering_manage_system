package com.etc.dao;

import com.etc.entity.Customer;
import com.etc.util.DBUtils;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    DBUtils db=new DBUtils();

    public List<Customer> query() throws SQLException {

        ArrayList list=new ArrayList<Customer>();

        ResultSet rs = DBUtils.doQuery("select * from cuser ");
        while(rs.next()){

            list.add(new Customer(rs.getInt("cid"),rs.getString("username"),
                    rs.getString("password"),rs.getString("realname"),
                    rs.getString("telephone"),rs.getInt("state")));

        }
        return list;
    }

    public int  checklogin(String username,String password){
        int result=0;
        ResultSet rs = DBUtils.doQuery("select cid from cuser where username =? and password =?", username, password);
        try {
            if(rs.next()){
                result=rs.getInt("cid");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;

    }
    public int reg(String username,String password,String realname,String telephone,String address){
        int state=0;
        int count  =DBUtils.doUpdate("insert into cuser(username,password,realname,telephone,address,state)value(?,?,?,?,?,?)",username,password,realname,telephone,address,state);
        return count;
    }

    public List<Customer> querynamebyid(int cid) throws SQLException {

        ArrayList list=new ArrayList<Customer>();

        ResultSet rs = DBUtils.doQuery("select * from cuser where cid=? ",cid);
        while(rs.next()){

            list.add(new Customer(rs.getInt("cid"),rs.getString("username"),
                    rs.getString("password"),rs.getString("realname"),
                    rs.getString("telephone"),rs.getInt("state")));

        }
        return list;
    }


}
