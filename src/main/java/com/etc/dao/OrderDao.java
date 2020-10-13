package com.etc.dao;

import com.etc.entity.Disher;
import com.etc.entity.Order;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao {
    public List<Order> query(int sid,String way) throws SQLException {
        ResultSet rs=null;
        ArrayList<Order> list=new ArrayList<Order>();
        if ("customer".equals(way)){
        rs= DBUtils.doQuery("select * from order where sid=?",sid);
        }else {
            rs = DBUtils.doQuery("select * from order where cid=?",sid);}
        while(rs.next()){

            list.add(new Order(rs.getInt("oid"),rs.getInt("cid"),
                    rs.getInt("sid"),rs.getInt("rid"),rs.getString("dlist"),
                    rs.getDate("acceptdata"),rs.getDate("completedate"),rs.getInt("state")));

        }
        return list;
    }

    public int delorder(String did){
        int id=Integer.parseInt(did);
        int count  = DBUtils.doUpdate("delete from order where oid =?",id);
        return count;
    }


    public int update(int oid, String dlist,  int state) {
        int count  =DBUtils.doUpdate("update  order set dlist=?,state=? where oid=?; ",dlist,state,oid);
        return count;
    }
    public int addOrder(int cid, int sid, int rid, String dlist, Date acceptdate, Date completedate, int state) {
        int count  =DBUtils.doUpdate("insert into  order (cid,sid,rid,dlist,acceptdate,completedate,state) values (?,?,?,?,?,?,?); ",cid,sid,rid,dlist,acceptdate,completedate,state);
        return count;
    }

}
