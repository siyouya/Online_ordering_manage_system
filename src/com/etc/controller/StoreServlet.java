package com.etc.controller;

import com.etc.dao.CustomerDao;
import com.etc.dao.StoreDao;
import com.etc.entity.Store;
import com.etc.util.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int sid=2;
		String op = request.getParameter("op");
		String shopname=request.getParameter("shopname");
		String realname=request.getParameter("realname");
		String telephone=request.getParameter("telephone");
		String address=request.getParameter("address");
		String intro=request.getParameter("intro");
		StoreDao storeDao=new StoreDao();
		HttpSession  session   = request.getSession();
		 if ("query".equals(op)) {
			 List<Store> list   = storeDao.query(sid);
			 session.setAttribute("list", list);
			 response.sendRedirect("../storeMange/admin-user.jsp");
		}else if("update".equals(op)){
			 int result=storeDao.update(shopname,realname,telephone,address,intro,sid);
			 List<Store> list   = storeDao.query(sid);
			 session.setAttribute("list", list);
			 response.sendRedirect("../storeMange/admin-user.jsp");


		 }

	}

	



	

}
