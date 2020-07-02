package com.servlet;

import com.service.IAdminService;
import com.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminUserAssignServlet")
public class AdminUserAssignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        IAdminService adminService = new AdminServiceImpl();
        String username = request.getParameter("username");
        String super_id = request.getParameter("super_id");

        adminService.updateUser(username,super_id);

        request.getRequestDispatcher("/adminNoAssignListServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
