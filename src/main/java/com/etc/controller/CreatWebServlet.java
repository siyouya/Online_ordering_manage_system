package com.etc.controller;

import com.etc.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/creatweb")
public class CreatWebServlet extends HttpServlet {
    OrderDao orderDao=new OrderDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
       //通过订单查询id;然后创建聊天窗口

        int cid=0;
        int oid=0;
        int sid=0;
        int rid=0;
        //查询用户商家骑手名字？
        //转发
          //取值？初始化，创建web

    }



}
