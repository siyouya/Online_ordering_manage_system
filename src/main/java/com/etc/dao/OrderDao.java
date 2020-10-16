package com.etc.dao;

import com.etc.entity.*;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao {
    public List<OrderRider> query(int sid,String way) throws SQLException {
        ResultSet rs=null;
        ArrayList<OrderRider> list=new ArrayList<OrderRider>();
        if ("customer".equals(way)){
        rs= DBUtils.doQuery("select * from orderinfo where cid=?",sid);
        }else {
            rs = DBUtils.doQuery("select orderinfo.oid,orderinfo.state,orderinfo.acceptdate,orderinfo.completedate,cuser.realname,cuser.telephone,cuser.address,ruser.realname as riderrealname,ruser.telephone as ridertelephone from cuser,ruser,orderinfo where    orderinfo.cid=cuser.cid and orderinfo.rid=ruser.rid  and orderinfo.sid=?  order by orderinfo.oid desc ",sid);}
        while(rs.next()){
            int oid=rs.getInt("oid");
            int state=rs.getInt("state");
            Date acceptdate=rs.getDate("acceptdate");
            Date completedate=rs.getDate("completedate");
            Customer customer=new Customer();
            customer.setRealname(rs.getString("realname"));
            customer.setAddress(rs.getString("address"));
            customer.setTelepone(rs.getString("telephone"));
            Rider rider=new Rider();
            rider.setRealname(rs.getString("riderrealname"));
            rider.setTelephone(rs.getString("ridertelephone"));
            list.add(new OrderRider(oid,acceptdate,completedate,state,customer,rider));

        }
        DBUtils.free(rs);
        return list;
    }



    public List<OrderRider> querynorider(int sid) throws SQLException {
        ResultSet rs=null;
        ArrayList<OrderRider> list=new ArrayList<OrderRider>();
            rs = DBUtils.doQuery("select orderinfo.oid,orderinfo.state,orderinfo.acceptdate,cuser.realname,cuser.telephone,cuser.address  from cuser,orderinfo where    orderinfo.cid=cuser.cid and orderinfo.rid is null and orderinfo.sid=? order by orderinfo.oid desc",sid);
        while(rs.next()){
            int oid=rs.getInt("oid");
            int state=rs.getInt("state");
            Date acceptdate=rs.getDate("acceptdate");
            Customer customer=new Customer();
            customer.setRealname(rs.getString("realname"));
            customer.setAddress(rs.getString("address"));
            customer.setTelepone(rs.getString("telephone"));
            list.add(new OrderRider(oid,acceptdate,state,customer));
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
    public int addOrder(int cid, int sid, String dlist, Date acceptdate) {
        int count  =DBUtils.doUpdate("insert into  orderinfo (cid,sid,dlist,acceptdate,state) values (?,?,?,?,1); ",cid,sid,dlist,acceptdate);
        return count;
    }

    public List<OrderRider> querybycid2(int cid) throws SQLException {
        ResultSet rs=null;
        ArrayList<OrderRider> list=new ArrayList<OrderRider>();
        rs= DBUtils.doQuery("select suser.shopname,cuser.realname,orderinfo.state,cuser.telephone,cuser.address,orderinfo.oid,orderinfo.acceptdate,orderinfo.dlist  from orderinfo  ,suser,cuser where orderinfo.sid=suser.sid and  orderinfo.cid=cuser.cid and  orderinfo.cid=?  order by orderinfo.oid desc ",cid);
        while(rs.next()){
            int oid=rs.getInt("oid");
            Date acceptdate=rs.getDate("acceptdate");
            int state=rs.getInt("state");
            String dlist=rs.getString("dlist");

            Store store=new Store();
            store.setShopname(rs.getString("shopname"));

            Customer customer=new Customer();

            customer.setRealname(rs.getString("realname"));
            customer.setAddress(rs.getString("address"));
            customer.setTelepone(rs.getString("telephone"));

            list.add(new OrderRider(oid,acceptdate,dlist,state,store,customer));
        }
        DBUtils.free(rs);
        return list;
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
