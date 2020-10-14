package com.etc.controller;

import com.etc.dao.CustomerDao;
import com.etc.dao.RiderDao;
import com.etc.dao.StoreDao;
import com.etc.entity.Store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login/login")
public class DologinServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String profession=request.getParameter("profession");

		System.out.println(profession);

		HttpSession session = request.getSession();
		 if ("customer".equals(profession)) {
			CustomerDao customerDao=new CustomerDao();
			StoreDao dao=new StoreDao();
			 int result=customerDao.checklogin(username,password);
			 if (result>0){
				 session.setAttribute("msg", "成功");
				 ArrayList<Store> list=new ArrayList<Store>();
				 list= (ArrayList<Store>) dao.query();
				 session.setAttribute("stores",list);
				 session.setAttribute("cid",result);
				 request.getRequestDispatcher("../homepage/index.jsp").forward(request, response);
			 } else{
				 System.out.println(result);
				 session.setAttribute("msg", "");
			 }
		}else if ("store".equals(profession)) {

			 StoreDao storeDao=new StoreDao();

			 int result=storeDao.checklogin(username,password);
			 if (result>0){
				 session.setAttribute("msg", "成功");
				 session.setAttribute("sid", result);
				 request.getRequestDispatcher("../storeMange/admin-index.jsp").forward(request, response);
			 } else{
				 System.out.println(result);
				 session.setAttribute("msg", "成功");
			 }

		}else if ("rider".equals(profession)) {
			 RiderDao riderDao=new RiderDao();
			 int result= riderDao.checklogin(username,password);
			 if (result>0){
				 session.setAttribute("msg", "成功");
				 session.setAttribute("rid", result);
				 request.getRequestDispatcher("../riderMange/rider-index.jsp").forward(request, response);
			 } else{
				 System.out.println(result);
				 session.setAttribute("msg", "成功");
			 }
		}

	}


}
