package com.etc.controller;

import com.etc.dao.CustomerDao;
import com.etc.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user")
public class CustomerServlet extends HttpServlet {

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
				modifypas(request,response);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}else if("ajaxCheckName".equals(op)){

			ajaxCheckName(request, response);

		}else if("modify".equals(op)){

			try {
				modify(request,response);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}


	}



	public void query(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session   = request.getSession();
		CustomerDao customerDao=new CustomerDao();
		int cid=Integer.valueOf(session.getAttribute("cid").toString());
		System.out.println("获取cid");
		List<Customer> list   = customerDao.query(cid);
		session.setAttribute("list", list);
		System.out.println(cid);
		response.sendRedirect("../customerMange/customer-user.jsp");

	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session   = request.getSession();
		CustomerDao customerDao=new CustomerDao();
		int cid=Integer.valueOf(session.getAttribute("cid").toString());
		String username=request.getParameter("username");
		String realname=request.getParameter("realname");
		String telephone=request.getParameter("telephone");
		String address=request.getParameter("address");
		String state=request.getParameter("state");
		int result=customerDao.update(username,realname,telephone,address,state,cid);
		List<Customer> list   = customerDao.query(cid);
		session.setAttribute("list", list);
		session.setAttribute("message", "更新成功");
		response.sendRedirect("../customerMange/customer-user.jsp");



	}
	public void modify(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		response.sendRedirect("../customerMange/customer-modifypas.jsp");

	}

	public void modifypas(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session   = request.getSession();
		CustomerDao customerDao=new CustomerDao();
		int cid=Integer.valueOf(session.getAttribute("cid").toString());

		String password=request.getParameter("password");
		int result=customerDao.modifypas(password,cid);
		List<Customer> list   = customerDao.query(cid);
		session.setAttribute("list", list);
		session.setAttribute("message", "修改成功");
		response.sendRedirect("../customerMange/customer-modifypas.jsp");

	}


	public void ajaxCheckName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ajax 不需要 跳转 只需要将 数据往回传
		String username = request.getParameter("username");

		CustomerDao customerDao = new CustomerDao();
		boolean flag = customerDao.checkName(username);
		System.out.println(username);
		response.getWriter().write(flag + "");

	}





}
