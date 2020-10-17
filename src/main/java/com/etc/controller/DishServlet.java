package com.etc.controller;

import com.etc.dao.DishDao;
import com.etc.dao.DishImgDao;
import com.etc.entity.DishImg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;



@WebServlet("/dish")
public class DishServlet extends HttpServlet {
    DishDao dishDao =new DishDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {


        request.setCharacterEncoding("utf-8");

        String op = request.getParameter("op");

        if ("select".equals(op)) {
            try {
                showDish(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("del".equals(op)){
            deletedish(request,response);
        }else if ("add".equals(op)){
            try {
                addish(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("update".equals(op)){
            try {
                update(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if ("sellout".equals(op)){
            try {
                sellout(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("mutildel".equals(op)){
            try {
                mutildel(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if ("begindish".equals(op)){
            try {
                beginDish(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("bypage".equals(op)){
            try {
                showDishBypage(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("bypage2".equals(op)){//商家查询用bypage2
            try {
                showDishBypage2(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("keep".equals(op)){
            keep(request,response);
        }else if("add_img".equals(op)){
            addImg(request,response);
        }

    }
    private void addImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();

        int did=Integer.parseInt(session.getAttribute("did").toString());
        String path= (String) request.getAttribute("path");
        System.out.println(path);
        dishDao.addImg(did,path);
        //初始化
        String inidid=null;
        session.setAttribute("did",inidid);
        response.sendRedirect("dish?op=select");

    }



    private void keep(HttpServletRequest request, HttpServletResponse response) throws IOException {
       int did=Integer.parseInt(request.getParameter("did_img"));
       HttpSession session=request.getSession();
       session.setAttribute("did",did);
       System.out.println(did);
       response.sendRedirect("dish?op=select");

    }

    public void showDish(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session   = request.getSession();

        int sid=Integer.valueOf(session.getAttribute("sid").toString());
        int page=1;
        session.setAttribute("sid",sid);
        int pagenum=dishDao.querypagenum(sid);
        session.setAttribute("nowpage",1);
        session.setAttribute("pagenum",pagenum);
        DishImgDao dishImgDao=new DishImgDao();
        ArrayList<DishImg> list= (ArrayList<DishImg>) dishImgDao.showImg(sid,page);
        session.setAttribute("nowpage",page);



        session.setAttribute("list", list);
        System.out.println("查询成功");
        response.sendRedirect("../storeMange/admin-table.jsp");
        //request.getRequestDispatcher().forward(request, response);

    }
    public void beginDish(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session   = request.getSession();

        int sid=Integer.valueOf(request.getParameter("sid"));
        int page=Integer.valueOf(request.getParameter("page"));
        session.setAttribute("sid",sid);
        int pagenum=dishDao.querypagenum(sid);
        session.setAttribute("nowpage",1);
        session.setAttribute("pagenum",pagenum);
        DishImgDao dishImgDao=new DishImgDao();
        ArrayList<DishImg> list= (ArrayList<DishImg>) dishImgDao.showImg(sid,page);
        session.setAttribute("nowpage",page);


        session.setAttribute("list", list);
        System.out.println("查询成功");
        response.sendRedirect("../homepage/products.jsp");
        //request.getRequestDispatcher().forward(request, response);

    }
    public void showDishBypage2(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session   = request.getSession();


        int page=Integer.valueOf(request.getParameter("page"));
        if (page<=0){page=1;}
        int sid=Integer.valueOf(session.getAttribute("sid").toString());
        DishImgDao dishImgDao=new DishImgDao();
        ArrayList<DishImg> list= (ArrayList<DishImg>) dishImgDao.showImg(sid,page);
        session.setAttribute("nowpage",page);


        session.setAttribute("list", list);
        System.out.println("查询成功");
        response.sendRedirect("../storeMange/admin-table.jsp");
        //request.getRequestDispatcher().forward(request, response);

    }
    /**
     *分页查询
     */
    public void showDishBypage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session   = request.getSession();


        int page=Integer.valueOf(request.getParameter("page"));
        if (page<=0){page=1;}
        int sid=Integer.valueOf(session.getAttribute("sid").toString());
        DishImgDao dishImgDao=new DishImgDao();
        ArrayList<DishImg> list= (ArrayList<DishImg>) dishImgDao.showImg(sid,page);
        session.setAttribute("nowpage",page);


        session.setAttribute("list", list);
        System.out.println("查询成功");
        response.sendRedirect("../homepage/products.jsp");
        //request.getRequestDispatcher().forward(request, response);

    }
    public void deletedish(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id=request.getParameter("delid");
        HttpSession  session   = request.getSession();
        int count=dishDao.deldish(id);

        if(count>0){
            session.setAttribute("message", "删除成功");

        }else{
            session.setAttribute("message", "删除失败");

        }
        response.sendRedirect("dish?op=select");




    }

    public void mutildel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String tag=request.getParameter("tag");
        HttpSession  session   = request.getSession();
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                dishDao.deldish(strs[i]);
            } catch (Exception e) {
            }





        }
        response.sendRedirect("dish?op=select");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        HttpSession  session   = request.getSession();
        int did= Integer.parseInt(request.getParameter("did_img"));
        String dishname=request.getParameter("dishname");
        String number=request.getParameter("number");
        String rmaterial=request.getParameter("rmaterial");
        String price=request.getParameter("price");
        String sid=request.getParameter("sid");
        int result=dishDao.update(did,dishname,number,rmaterial,price,sid);
        showDish(request,response);
    }

    public void sellout(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {

        int did= Integer.parseInt(request.getParameter("did"));
        int result=dishDao.sellout(did);
        showDish(request,response);
    }

    public void addish(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        HttpSession  session   = request.getSession();
        request.setCharacterEncoding("utf-8");
        String dishname=request.getParameter("dishname");
        System.out.println(dishname);
        String number=request.getParameter("number");
        String rmaterial=request.getParameter("rmaterial");
        String price=request.getParameter("price");
        String sid=request.getParameter("sid");
        int result=dishDao.adddish(dishname,number,rmaterial,price,sid);
        showDish(request,response);
    }
}
