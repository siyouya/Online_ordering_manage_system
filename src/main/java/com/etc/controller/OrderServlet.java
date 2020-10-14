package com.etc.controller;

import com.etc.dao.OrderDao;
import com.etc.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    OrderDao orderDao=new OrderDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {


        request.setCharacterEncoding("utf-8");

        String op = request.getParameter("op");
        if ("selbyshop".equals(op)) {
            try {
                showorderByshop(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("selbycustomer".equals(op)){
            try {
                showorderBycus(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("quxiao".equals(op)){
            try {
                quxiao(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("recorder".equals(op)){
            try {
                recorder(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }
    public void showorderByshop(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session   = request.getSession();
        ArrayList<Order> list=new ArrayList<Order>();
        int sid=Integer.valueOf(session.getAttribute("sid").toString());
        list= (ArrayList<Order>) orderDao.query(sid,"else");

        session.setAttribute("list", list);
        System.out.println("查询成功");
        response.sendRedirect("../storeMange/admin-ordertable.jsp");
        //request.getRequestDispatcher().forward(request, response);

    }
    public void showorderBycus(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session   = request.getSession();
        ArrayList<Order> list=new ArrayList<Order>();
        int cid=Integer.valueOf(session.getAttribute("cid").toString());
        list= (ArrayList<Order>) orderDao.query(cid,"customer");


        session.setAttribute("list", list);
        System.out.println("查询成功");
        response.sendRedirect("../storeMange/admin-ordertable.jsp");
        //request.getRequestDispatcher().forward(request, response);

    }
    public void quxiao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {

        int did= Integer.parseInt(request.getParameter("oid"));
        int result=orderDao.quxiao(did);
        response.sendRedirect("../storeMange/admin-ordertable.jsp");
    }

    public void recorder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session   = request.getSession();
        ArrayList<Order> list=new ArrayList<Order>();

        list= (ArrayList<Order>) orderDao.queryisnullrid();

        session.setAttribute("list", list);
        System.out.println("查询成功");
        response.sendRedirect("../riderMange/rider-table.jsp");
        //request.getRequestDispatcher().forward(request, response);

    }


}
