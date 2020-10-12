package com.etc.controller;

import com.etc.dao.RiderDao;
import com.etc.dao.StoreDao;
import com.etc.entity.Rider;
import com.etc.entity.Store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/rider")
public class RiderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int rid=3;
		String op = request.getParameter("op");
		String realname=request.getParameter("realname");
		String telephone=request.getParameter("telephone");

		RiderDao riderDao=new RiderDao();
		HttpSession  session   = request.getSession();
		 if ("query".equals(op)) {
			 List<Rider> list   = riderDao.query(rid);
			 session.setAttribute("list", list);
			 response.sendRedirect("../riderMange/rider-user.jsp");
		}else if("update".equals(op)){
			 int result=riderDao.update(realname,telephone,rid);
			 List<Rider> list   = riderDao.query(rid);
			 session.setAttribute("list", list);
			 response.sendRedirect("../riderMange/rider-user.jsp");


		 }

	}

	



	

}
