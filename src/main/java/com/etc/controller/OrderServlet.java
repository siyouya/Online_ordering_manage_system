package com.etc.controller;

import com.etc.dao.DishDao;
import com.etc.dao.OrderDao;
import com.etc.entity.Order;
import com.etc.entity.OrderRider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    OrderDao orderDao=new OrderDao();
    DishDao dishDao=new DishDao();
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
            //显示所有可以接的单子
            try {
                recorder(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if("crecover".equals(op)){
            //更改订单状态添加骑手
            try {
                crecover(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("run_order".equals(op)){
            //显示自己的单子
            try {
                showbyrider(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("com_order".equals(op)){
            //修改状态
            try {
                modifystate(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("addorder".equals(op)){
            //修改状态

                addorder(request,response);

        }

    }

    private void addorder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session   = request.getSession();
        String tag=request.getParameter("tag");
        int sid=Integer.valueOf(session.getAttribute("sid").toString());
        int cid=Integer.valueOf(session.getAttribute("cid").toString());
        Date date = new Date();
        orderDao.addOrder(cid,sid,tag,date);
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                dishDao.sellone(strs[i]);
            } catch (Exception e) {
            }

        }
response.sendRedirect("../homepage/index.jsp");

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
        ArrayList<OrderRider> list = (ArrayList<OrderRider>) orderDao.queryisnullrid();

        session.setAttribute("list",list);
        System.out.println("查询成功");
        response.sendRedirect("../riderMange/rider-table.jsp");
        //request.getRequestDispatcher().forward(request, response);

    }


    public void crecover(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session   = request.getSession();
        OrderDao orderDao=new OrderDao();
        int state=1;
        int rid=Integer.valueOf(session.getAttribute("rid").toString());
        System.out.println(rid);
        String oid=request.getParameter("roid");
        System.out.println(oid);
        orderDao.rupdate(oid,rid,state);
        System.out.println("查询成功");
        response.sendRedirect("order?op=recorder");

    }

    public void showbyrider(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session   = request.getSession();

        //查询骑手自己的订单
        int rid=Integer.valueOf(session.getAttribute("rid").toString());
        ArrayList<OrderRider> list = (ArrayList<OrderRider>) orderDao.showbyrider(rid);
        session.setAttribute("list",list);
        System.out.println("查询成功");
        response.sendRedirect("../riderMange/rider-run_order.jsp");
        //request.getRequestDispatcher().forward(request, response);

    }
    public void modifystate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        //根据订单oid修改订单state
        int oid= Integer.parseInt(request.getParameter("roid"));

        int result=orderDao.modify_state(oid);

        response.sendRedirect("order?op=run_order");
        //request.getRequestDispatcher().forward(request, response);

    }


}
