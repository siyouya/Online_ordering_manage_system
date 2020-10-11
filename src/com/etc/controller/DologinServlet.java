package com.etc.controller;

import com.etc.dao.CustomerDao;
import com.etc.dao.RiderDao;
import com.etc.dao.StoreDao;
import com.etc.util.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login/login")
public class DologinServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String profession=request.getParameter("profession");
		HttpSession session = request.getSession();
		 if ("customer".equals(profession)) {
			CustomerDao customerDao=new CustomerDao();
			 int result=customerDao.checklogin(username,password);
			 if (result>0){
				 session.setAttribute("msg", "µÇÂ¼³É¹¦");
				 request.getRequestDispatcher("../register.jsp").forward(request, response);
			 } else{
				 System.out.println(result);
				 session.setAttribute("msg", "µÇÂ¼Ê§°Ü£¬ÇëÖØÐÂµÇÂ¼");
			 }
		}else if ("store".equals(profession)) {

			 StoreDao storeDao=new StoreDao();

			 int result=storeDao.checklogin(username,password);
			 if (result>0){
				 session.setAttribute("msg", "µÇÂ¼³É¹¦");
				 session.setAttribute("sid", result);
				 response.sendRedirect("../storeMange/admin-index.html");
				 //request.getRequestDispatcher("../storeMange/admin-index.html").forward(request, response);
			 } else{
				 System.out.println(result);
				 session.setAttribute("msg", "µÇÂ¼Ê§°Ü£¬ÇëÖØÐÂµÇÂ¼");
			 }

		}else if ("rider".equals(profession)) {
			 RiderDao riderDao=new RiderDao();
			 int result= riderDao.checklogin(username,password);
			 if (result>0){
				 session.setAttribute("msg", "µÇÂ¼³É¹¦");
				 request.getRequestDispatcher("../register.jsp").forward(request, response);
			 } else{
				 System.out.println(result);
				 session.setAttribute("msg", "µÇÂ¼Ê§°Ü£¬ÇëÖØÐÂµÇÂ¼");
			 }
		}

	}


}
