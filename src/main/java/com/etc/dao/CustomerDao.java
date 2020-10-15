package com.etc.dao;

import com.etc.entity.Customer;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    DBUtils db=new DBUtils();

    public List<Customer> query(int cid){
        ResultSet rs = DBUtils.doQuery("select * from cuser where cid=? ",cid);

        List<Customer> list   = new ArrayList<Customer>();
        try {
            while (rs.next()) {
                list.add(new Customer(
                                rs.getInt("cid"),

                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("realname"),
                                rs.getString("telephone"),
                                rs.getString("address"),

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

    public int update(String username,String realname,String telephone,String address, String state,int cid){
        int count  =DBUtils.doUpdate("update  cuser set username=?,realname=?,telephone=?,address=?,state=? where cid=?; ",username,realname,telephone,address,state,cid);
        return count;
    }





    public int modifypas(String password,int cid){
        int count  =DBUtils.doUpdate("update  cuser set password=? where cid=?; ",password,cid);
        return count;
    }
    public boolean checkName(String username) {
        ResultSet rs = DBUtils.doQuery("select cid from cuser where username =?", username);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Customer> querynamebyid(int cid) throws SQLException {

        ArrayList list=new ArrayList<Customer>();

        ResultSet rs = DBUtils.doQuery("select * from cuser where cid=? ",cid);
        while(rs.next()){

            list.add(new Customer(rs.getInt("cid"),rs.getString("username"),
                    rs.getString("password"),rs.getString("realname"),
                    rs.getString("telephone"),rs.getString("address"),rs.getInt("state")));

        }
        DBUtils.free(rs);
        return list;
    }



}
