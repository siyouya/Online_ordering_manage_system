package com.etc.controller;

import com.etc.dao.RiderDao;
import com.etc.entity.Rider;

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
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		int rid=  Integer.parseInt( session.getAttribute("rid").toString());
		String op = request.getParameter("op");
		RiderDao riderDao=new RiderDao();
		 if ("query".equals(op)) {
			 List<Rider> list   = riderDao.query(rid);
			 session.setAttribute("list", list);
			 response.sendRedirect("../riderMange/rider-user.jsp");
		}else if("update".equals(op)){
			 String realname=request.getParameter("realname");
			 String telephone=request.getParameter("telephone");
			 int result=riderDao.update(realname,telephone,rid);
			 List<Rider> list   = riderDao.query(rid);
			 session.setAttribute("list", list);
			 response.sendRedirect("../riderMange/rider-user.jsp");
		 }else if ("modifypas".equals(op)){
			 response.sendRedirect("../riderMange/rider-modifypas.jsp");
		 }else if ("modifypassword".equals(op)){
			 String newpassword=request.getParameter("newpassword");
			 String newpassword2=request.getParameter("newpassword2");
			 riderDao.modifypas(newpassword,rid);
			 response.sendRedirect("../riderMange/rider-modifypas.jsp");
		 }

	}

	



	

}
