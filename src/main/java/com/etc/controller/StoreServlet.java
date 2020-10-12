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
import java.util.List;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession  session   = request.getSession();

		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		StoreDao storeDao=new StoreDao();

		 if ("query".equals(op)) {

			 int sid=Integer.parseInt( session.getAttribute("sid").toString());

			 List<Store> list   = storeDao.query(sid);
			 session.setAttribute("list", list);
			 response.sendRedirect("../storeMange/admin-user.jsp");
		}else if("update".equals(op)){

			 int sid=Integer.parseInt(session.getAttribute("sid").toString());

			 String shopname=request.getParameter("shopname");
			 String realname=request.getParameter("realname");
			 String telephone=request.getParameter("telephone");
			 String address=request.getParameter("address");
			 String intro=request.getParameter("intro");
			 int result=storeDao.update(shopname,realname,telephone,address,intro,sid);
			 List<Store> list   = storeDao.query(sid);
			 session.setAttribute("list", list);
			 response.sendRedirect("../storeMange/admin-user.jsp");
		 }else if("modifypas".equals(op)){
			 int sid=Integer.parseInt(session.getAttribute("sid").toString());
			 response.sendRedirect("../storeMange/admin-modifypas.jsp");
		 }else if("modifypassword".equals(op)){
			 int sid=Integer.parseInt(session.getAttribute("sid").toString());
			 String newpassword=request.getParameter("newpassword");
			 String newpassword2=request.getParameter("newpassword2");
			 storeDao.modifypas(newpassword,sid);
			 response.sendRedirect("../storeMange/admin-modifypas.jsp");
		 }

	}

	



	

}
