package com.etc.dao;

import com.etc.entity.Customer;
import com.etc.entity.Order;
import com.etc.entity.OrderRider;
import com.etc.entity.Store;
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
        rs= DBUtils.doQuery("select * from orderinfo where cid=?",sid);
        }else {
            rs = DBUtils.doQuery("select * from orderinfo where sid=?",sid);}
        while(rs.next()){

            list.add(new Order(rs.getInt("oid"),rs.getInt("cid"),
                    rs.getInt("sid"),rs.getInt("rid"),rs.getString("dlist"),
                    rs.getDate("acceptdate"),rs.getDate("completedate"),rs.getInt("state")));

        }
        DBUtils.free(rs);
        return list;
    }

    public int delorder(String did){
        int id=Integer.parseInt(did);
        int count  = DBUtils.doUpdate("delete from orderinfo where oid =?",id);
        return count;
    }


    public int update(int oid, String dlist,  int state) {
        int count  =DBUtils.doUpdate("update  orderinfo set dlist=?,state=? where oid=?; ",dlist,state,oid);
        return count;
    }
    public int quxiao(int oid) {
        int count  =DBUtils.doUpdate("update  orderinfo set state=0 where oid=?; ",oid);
        System.out.println("订单已完成");
        return count;
    }
    public int addOrder(int cid, int sid, int rid, String dlist, Date acceptdate, Date completedate, int state) {
        int count  =DBUtils.doUpdate("insert into  orderinfo (cid,sid,rid,dlist,acceptdate,completedate,state) values (?,?,?,?,?,?,?); ",cid,sid,rid,dlist,acceptdate,completedate,state);
        return count;
    }

    public List<Order> querybycid(int cid) throws SQLException {
        ResultSet rs=null;
        ArrayList<Order> list=new ArrayList<Order>();
        rs= DBUtils.doQuery("select * from orderinfo where cid=?",cid);
        while(rs.next()){
            list.add(new Order(rs.getInt("oid"),rs.getInt("cid"),
                    rs.getInt("sid"),rs.getInt("rid"),rs.getString("dlist"),
                    rs.getDate("acceptdate"),rs.getDate("completedate"),rs.getInt("state")));
        }
        DBUtils.free(rs);
        return list;
    }

    public List<OrderRider> queryisnullrid() throws SQLException {
        ResultSet rs=null;
        ArrayList<OrderRider> list=new ArrayList<OrderRider>();
        rs= DBUtils.doQuery("select cuser.address,suser.address as shopaddress,suser.shopname,cuser.telephone,orderinfo.oid from cuser,suser,orderinfo where orderinfo.cid=cuser.cid and  orderinfo.sid=suser.sid  and orderinfo.rid is null");
        while(rs.next()){
            int oid=rs.getInt("oid");
            Customer customer=new Customer();
            customer.setAddress(rs.getString("address"));
            customer.setTelepone(rs.getString("telephone"));
            Store store=new Store();
            store.setShopname(rs.getString("shopname"));
            store.setAddress(rs.getString("shopaddress"));
            list.add(new OrderRider(oid, customer,store));
        }
        DBUtils.free(rs);
        return list;
    }
    //添加骑手
    public int rupdate(String oid, int rid,int state) {
        int oid1=Integer.parseInt(oid);
        int count  =DBUtils.doUpdate("update  orderinfo set rid=?,state=? where oid=?; ",rid,state,oid1);
        return count;
    }
    public List<OrderRider> showbyrider(int rid) throws SQLException {
        ResultSet rs=null;
        ArrayList<OrderRider> list=new ArrayList<OrderRider>();
        rs= DBUtils.doQuery("select cuser.address,suser.address as shopaddress,suser.shopname,cuser.telephone,orderinfo.oid from cuser,suser,orderinfo where orderinfo.cid=cuser.cid and  orderinfo.sid=suser.sid  and orderinfo.rid = ? and orderinfo.state=1",rid);
        while(rs.next()){
            int oid=rs.getInt("oid");
            Customer customer=new Customer();
            customer.setAddress(rs.getString("address"));
            customer.setTelepone(rs.getString("telephone"));
            Store store=new Store();
            store.setShopname(rs.getString("shopname"));
            store.setAddress(rs.getString("shopaddress"));
            list.add(new OrderRider(oid, customer,store));
        }
        DBUtils.free(rs);
        return list;
    }

    //修改订单状态 1代表未完成 2代表完成 默认为1
    public int modify_state(int oid) {
        int count  =DBUtils.doUpdate("update  orderinfo set state=2 where oid=?; ",oid);
        return count;
    }



}
