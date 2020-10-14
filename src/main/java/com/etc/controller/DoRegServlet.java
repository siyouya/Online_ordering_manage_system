package com.etc.controller;

import com.etc.dao.CustomerDao;
import com.etc.dao.RiderDao;
import com.etc.dao.StoreDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reg/reg")
public class DoRegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String profession=request.getParameter("profession");
		String telephone=request.getParameter("telephone");
		String address=request.getParameter("address");
		String shopname=request.getParameter("shopname");

		HttpSession session = request.getSession();
		if ("customer".equals(profession)) {
			CustomerDao customerDao=new CustomerDao();
			int result=customerDao.reg(username,password,realname,telephone,address);
			if (result>0){
				session.setAttribute("msg", "注册成功");
				response.sendRedirect("../login.jsp");
			} else{
				System.out.println(result);
				session.setAttribute("msg", "cg");
			}
		}else if ("store".equals(profession)) {

			StoreDao storeDao=new StoreDao();

			int result=storeDao.reg(shopname,username,password,realname,telephone,address);
			if (result>0){
				session.setAttribute("msg", "cg");
				request.getRequestDispatcher("../register.jsp").forward(request, response);
			} else{
				System.out.println(result);
				session.setAttribute("msg", "cg");
			}

		}else if ("rider".equals(profession)) {
			RiderDao riderDao=new RiderDao();
			int result= riderDao.reg(username,password,realname,telephone);
			if (result>0){
				session.setAttribute("msg", "cg");
				request.getRequestDispatcher("../register.jsp").forward(request, response);
			} else{
				System.out.println(result);
				session.setAttribute("msg", "cg");
			}
		}

	}


}
