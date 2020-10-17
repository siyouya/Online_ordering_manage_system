package com.etc.dao;

import com.etc.entity.Store;
import com.etc.entity.StoreImg;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.etc.dao.MapDistance.getDistanceByAdress;

public class StoreDao {
    public int  checklogin(String username,String password){
        int result=0;
        ResultSet rs = DBUtils.doQuery("select sid from suser where username =? and password =?", username, password);
        try {
            if(rs.next()){
                result=rs.getInt("sid");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;

    }

    public int reg(String shopname,String username,String password,String realname,String telephone,String address){
        int state=0;
        int count  =DBUtils.doUpdate("insert into suser(shopname,username,password,realname,telephone,address,state)value(?,?,?,?,?,?,?)",shopname,username,password,realname,telephone,address,state);
        return count;
    }

    public List<Store> query(int sid){
        ResultSet rs = DBUtils.doQuery("select * from suser where sid=? ",sid);

        List<Store> list   = new ArrayList<Store>();
        try {
            while (rs.next()) {
                list.add(new Store(
                        rs.getInt("sid"),
                        rs.getString("shopname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("realname"),
                        rs.getString("telephone"),
                        rs.getString("address"),
                        rs.getString("intro"),
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
    public List<Store> query(){
        ResultSet rs = DBUtils.doQuery("select * from suser ");

        List<Store> list   = new ArrayList<Store>();
        try {
            while (rs.next()) {
                list.add(new Store(
                                rs.getInt("sid"),
                                rs.getString("shopname"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("realname"),
                                rs.getString("telephone"),
                                rs.getString("address"),
                                rs.getString("intro"),
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

    /**
     * 分页查询
     * @param cid 根据客户id计算距离
     * @param page 页数
     * @return 查询结果
     */
    public List<StoreImg> query(int page, int cid){

        int num=9*(page-1);
        ResultSet rs = DBUtils.doQuery("select * from (select suser.*,store_img.imgurl from suser left join store_img on suser.sid=store_img.store_img_id)as a limit ?,9",num);

        List<StoreImg> list   = new ArrayList<StoreImg>();

        try {
            while (rs.next()) {

                long dis=getDistanceByAdress(getUserAdressById(cid),rs.getString("address"));
                System.out.println(dis);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtils.free(rs);
        }
        return list;
    }
    public List<Store> querynear(int cid){
        ResultSet rs = DBUtils.doQuery("select * from suser ");

        List<Store> list   = new ArrayList<Store>();
        try {
            while (rs.next()) {

                long dis=getDistanceByAdress(getUserAdressById(cid),rs.getString("address"));
                System.out.println(dis);
                list.add(new Store(
                                rs.getInt("sid"),
                                rs.getString("shopname"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("realname"),
                                rs.getString("telephone"),
                                Long.toString(dis),
                                rs.getString("intro"),
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
    public String getUserAdressById(int cid){
        String address="";
        ResultSet rs = DBUtils.doQuery("select address from cuser where cid=?",cid);
        try {while (rs.next()){
          address  =  rs.getString("address");}
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
        return address;
    }
    public int update(String shopname,String realname,String telephone,String address, String intro,int sid){
        int count  =DBUtils.doUpdate("update  suser set shopname=?,realname=?,telephone=?,address=?,intro=? where sid=?; ",shopname,realname,telephone,address,intro,sid);
        return count;
    }

    public int modifypas(String password,int sid){
        int count  =DBUtils.doUpdate("update  suser set password=? where sid=?; ",password,sid);
        return count;
    }




}
