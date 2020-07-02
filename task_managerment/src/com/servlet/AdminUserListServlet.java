package com.servlet;

import com.damain.Emp;
import com.service.IAdminService;
import com.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminUserListServlet")
public class AdminUserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        IAdminService adminService = new AdminServiceImpl();
        //调用service中的方法查询
        List<Emp> empList = adminService.findAll();
        //将数据存入request域中
        request.setAttribute("empList",empList);
        //转发到展示页面
        request.getRequestDispatcher("/pages1/admin-user-list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
