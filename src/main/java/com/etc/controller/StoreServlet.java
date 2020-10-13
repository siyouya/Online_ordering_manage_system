package com.etc.controller;

import com.etc.dao.StoreDao;
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

@WebServlet("/store")
public class StoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");

		 if ("query".equals(op)) {

			 try {
				 query(request,response);
			 } catch (SQLException throwables) {
				 throwables.printStackTrace();
			 }
		}else if("update".equals(op)){
			 try {
				 update(request,response);
			 } catch (SQLException throwables) {
				 throwables.printStackTrace();
			 }

		 }else if("modifypas".equals(op)){

			 try {
				 modify(request,response);
			 } catch (SQLException throwables) {
				 throwables.printStackTrace();
			 }
		 }else if("modifypassword".equals(op)){

			 try {
				 modifypas(request,response);
			 } catch (SQLException throwables) {
				 throwables.printStackTrace();
			 }
		 }

	}

	public void query(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session   = request.getSession();
		StoreDao storeDao=new StoreDao();
		int sid=Integer.valueOf(session.getAttribute("sid").toString());

		List<Store> list   = storeDao.query(sid);
		session.setAttribute("list", list);
		response.sendRedirect("../storeMange/admin-user.jsp");
		//request.getRequestDispatcher("../storeMange/admin-index.jsp").forward(request, response);
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session   = request.getSession();
		StoreDao storeDao=new StoreDao();
		int sid=Integer.valueOf(session.getAttribute("sid").toString());
		String shopname=request.getParameter("shopname");
		String realname=request.getParameter("realname");
		String telephone=request.getParameter("telephone");
		String address=request.getParameter("address");
		String intro=request.getParameter("intro");
		int result=storeDao.update(shopname,realname,telephone,address,intro,sid);
		List<Store> list   = storeDao.query(sid);
		session.setAttribute("list", list);
		response.sendRedirect("../storeMange/admin-user.jsp");
		//request.getRequestDispatcher("../storeMange/admin-user.jsp").forward(request,response);
	}
	public void modify(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		response.sendRedirect("../storeMange/admin-modifypas.jsp");
		//request.getRequestDispatcher("../storeMange/admin-modifypas.jsp").forward(request,response);
	}
	public void modifypas(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session   = request.getSession();
		StoreDao storeDao=new StoreDao();
		int sid=Integer.valueOf(session.getAttribute("sid").toString());
		String newpassword=request.getParameter("newpassword");
		String newpassword2=request.getParameter("newpassword2");
		storeDao.modifypas(newpassword,sid);
		response.sendRedirect("../storeMange/admin-modifypas.jsp");
		//request.getRequestDispatcher("../storeMange/admin-modifypas.jsp").forward(request,response);
	}



	

}
