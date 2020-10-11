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
		
		int sid= Integer.parseInt(request.getParameter("sid"));
		String op = request.getParameter("op");
		StoreDao storeDao=new StoreDao();
		 if ("query".equals(op)) {
			 List<Store> list   = storeDao.query(sid);

			 request.setAttribute("list", list);
			 //request.getRequestDispatcher("admin-admin.html").forward(request, response);
			 response.sendRedirect("../storeMange/admin-user.jsp");
		}

	}

	



	

}
