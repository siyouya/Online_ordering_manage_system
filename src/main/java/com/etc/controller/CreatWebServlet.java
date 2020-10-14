package com.etc.controller;

import com.etc.dao.OrderDao;
import com.etc.dao.StoreDao;
import com.etc.entity.Order;
import com.etc.entity.Store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/creatweb")
public class CreatWebServlet extends HttpServlet {
    OrderDao orderDao=new OrderDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
       //通过订单查询id;然后创建聊天窗口商家

        OrderDao orderDao=new OrderDao();
        StoreDao storeDao=new StoreDao();

      //  int cid=Integer.parseInt(request.getParameter("cid"));
        int cid=1;
        try {
           List<Order>list= orderDao.querybycid(cid);
           for(Order order :list) {
               //int oid=order.getOid();
               int oid=3;
               request.setAttribute("oid",oid);
               //获取名字列表
               List<Store> slist=storeDao.query(order.getSid());
               for(Store store:slist){
                   String sname=store.getShopname();
                   request.setAttribute("cname",sname);
               }

           }
           request.getRequestDispatcher("storeMange/admin-chat.jsp").forward(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        //查询用户商家骑手名字？

        //转发

    }



}
