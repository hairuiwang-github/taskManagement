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
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/adminUserAssignBeforeServlet")
public class AdminUserAssignBeforeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");

        IAdminService adminService = new AdminServiceImpl();
        Emp emp = adminService.findUserById(username);

        //查询主管信息
        List<Emp> deptList = new ArrayList<>();
        List<Emp> empList = adminService.findAll();
        for (Emp emp1 : empList) {
            if (emp1.getFlag().equals("2")){

                deptList.add(emp1);
            }
        }
        request.setAttribute("deptList",deptList);
        request.setAttribute("emp",emp);
        request.getRequestDispatcher("/pages1/admin-user-assign.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
