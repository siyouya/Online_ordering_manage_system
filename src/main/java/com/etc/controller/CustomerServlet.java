package com.etc.controller;

import com.etc.dao.CustomerDao;
import com.etc.util.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/user")
public class CustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String op = request.getParameter("op");
		 if ("login".equals(op)) {
			 login(request, response);
		}else if ("reg".equals(op)) {
			 reg(request, response);
		}else if ("showUser".equals(op)) {
			showUser(request, response);
		}else if("delete".equals(op)){
			deleteUser(request, response);
		}

	}

	


	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		CustomerDao customerDao=new CustomerDao();
		HttpSession session = request.getSession();
		int result=customerDao.checklogin(username,password);
		System.out.println(username);
		System.out.println(password);
		System.out.println(result);
		if (result>0){
			System.out.println(result);
			session.setAttribute("msg", "cg");
			request.getRequestDispatcher("../register.jsp").forward(request, response);
			} else{
			System.out.println(result);
			session.setAttribute("msg", "cg");
			//response.sendRedirect("../login.jsp");
		}

	}
	
	
	
	public void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
//		ResultSet rs = DBUtils.doQuery("select * from t_user ");
//		List<User> list   = new ArrayList<User>();
//		try {
//			while (rs.next()) {
//				list.add(new User(
//						rs.getInt("userid"),
//						rs.getString("username"),
//						rs.getString("password"),
//						rs.getString("sex"),
//						rs.getString("birthday"),
//						rs.getString("hobby"),
//						rs.getString("city"),
//						rs.getString("info")));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			DBUtils.free(rs);
//
//		}
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("showUser.jsp").forward(request, response);
	}
	
	
	public void reg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String[] hobby = request.getParameterValues("hobby");
		String hobbyStr   ="";
		if(hobby!=null){
			for(String str:hobby){
				hobbyStr+=(str+",");
			}
		}
		
		String city = request.getParameter("city");
		String info = request.getParameter("info");
		HttpSession  session   = request.getSession();
		
		int count  =DBUtils.doUpdate("insert into t_user(username,password,sex,birthday,hobby,city,info)value(?,?,?,?,?,?,?)",username,password,sex,birthday,hobbyStr,city,info );
		if(count>0){
			session.setAttribute("msg", "cg");
			response.sendRedirect("login.jsp");
		}else{
			session.setAttribute("msg", "cg");
			response.sendRedirect("reg.jsp");
		}
		
		
		
		
		
	}
	
	
	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid  =request.getParameter("userid");
		HttpSession  session   = request.getSession();
		int count  =DBUtils.doUpdate("delete from t_user where userid =?", userid);
		if(count>0){
			session.setAttribute("message", "cg");
			response.sendRedirect("user?op=showUser");
		}else{
			session.setAttribute("message", "cg");
			response.sendRedirect("user?op=showUser");
		}
		
		
		
		
		
	}
	

}
