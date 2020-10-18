package com.etc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class VisitFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String path = req.getRequestURI();
        String url = req.getServletPath();
        String op = servletRequest.getParameter("op");

        if ("ajaxCheckName".equals(op)) {
            System.out.println("ajax运行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;

        }

        if (url.contains("/login.jsp") || url.contains("/register.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if ((url.contains("/css") || url.contains("/js") || url.contains("/images"))) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;

        }

        if (url.contains("/login/login") || url.contains("/reg/reg")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (session.getAttribute("cid") != null || session.getAttribute("rid") != null || session.getAttribute("sid") != null) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            session.setAttribute("msg", "请先登录");
            res.sendRedirect("../login.jsp");
        }

    }


    @Override
    public void destroy() {

    }
}
