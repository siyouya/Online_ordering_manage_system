package com.etc.controller;

import com.etc.dao.DishDao;
import com.etc.entity.Disher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/Dish/Dish")
public class DishServlet extends HttpServlet {
    DishDao dishDao =new DishDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {


        String op = request.getParameter("op");
        if ("select".equals(op)) {
            try {
                showDish(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    public void showDish(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        ArrayList<Disher> list= (ArrayList<Disher>) dishDao.query();
        request.setAttribute("list", list);
		request.getRequestDispatcher("admin-table.jsp").forward(request, response);

    }
}
