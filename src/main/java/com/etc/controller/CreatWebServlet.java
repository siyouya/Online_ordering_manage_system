package com.etc.controller;

import com.etc.dao.CustomerDao;
import com.etc.dao.OrderDao;
import com.etc.dao.RiderDao;
import com.etc.dao.StoreDao;
import com.etc.entity.Customer;
import com.etc.entity.Order;
import com.etc.entity.Rider;
import com.etc.entity.Store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        request.setCharacterEncoding("utf-8");
        String op=request.getParameter("op");
        if("store_create_chat".equals(op)){
            store_create_chat(request,response);
        }else if("rider_create_chat".equals(op)){
            rider_create_chat(request,response);
        }else if("customer_create_chat".equals(op)){
            try {
                customer_create_chat(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    public void store_create_chat(HttpServletRequest request, HttpServletResponse response) {

        OrderDao orderDao = new OrderDao();
        StoreDao storeDao = new StoreDao();

        //  int cid=Integer.parseInt(request.getParameter("cid"));
        int cid = 1;
        try {
            List<Order> list = orderDao.querybycid(cid);
            for (Order order : list) {
                //int oid=order.getOid();
                int oid= Integer.parseInt(request.getParameter("oid"));
                request.setAttribute("oid", oid);
                //获取名字列表
                List<Store> slist = storeDao.query(order.getSid());
                for (Store store : slist) {
                    String sname = store.getShopname();
                    request.setAttribute("sname", sname);
                }

            }
            request.getRequestDispatcher("storeMange/admin-chat.jsp").forward(request, response);

        } catch (
                SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }


        //查询用户商家骑手名字？

        //转发
    }

    public void rider_create_chat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession();
        //骑手点击联系创建聊天窗口根据订单编号，房间号oid

        int oid= Integer.parseInt(request.getParameter("roid"));
        System.out.println(oid);
        //获取骑手的名字，先获取rid;
        request.setAttribute("oid",oid);
        int rid=Integer.parseInt(session.getAttribute("rid").toString());
        System.out.println(rid);
        RiderDao riderDao=new RiderDao();
        List<Rider> list=riderDao.query(rid);
        for(Rider rider:list){
            //存好oid
            request.setAttribute("ridername",rider.getRealname());
        }
        //转发
        request.getRequestDispatcher("riderMange/rider-chat.jsp").forward(request, response);

        //骑手已经在订单编号为房间的房间中可以聊天

        //获取用户和商家的id，通过id获取名字获取聊天框显示？还是1-1聊天/联系商家和联系顾客分开？



    }
    public void customer_create_chat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {


        HttpSession session=request.getSession();
        //顾客点击联系创建聊天窗口根据订单编号，房间号oid，
        int oid=Integer.parseInt(request.getParameter("oid"));
        System.out.println(oid);
        //获取顾客的名字，先获取id;
        request.setAttribute("oid",oid);
        int cid=Integer.parseInt(session.getAttribute("cid").toString());
        CustomerDao customerDao=new CustomerDao();
        List<Customer> list=customerDao.querynamebyid(cid);
        for(Customer customer:list){
            //存好cid
            request.setAttribute("customername",customer.getRealname());
        }
        //转发
        request.getRequestDispatcher("customerMange/customer-chat.jsp").forward(request, response);

        //骑手已经在订单编号为房间的房间中可以聊天

    }
}
