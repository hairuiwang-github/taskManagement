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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/adminNoAssignListServlet")
public class AdminNoAssignListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        IAdminService adminService = new AdminServiceImpl();
        List<Emp> noAssignList = new ArrayList<Emp>();

        List<Emp> empList = adminService.findAll();
        for (Emp emp : empList) {

            if (null == emp.getSuper_id()){
                noAssignList.add(emp);
            }
        }

        request.setAttribute("noAssignList",noAssignList);
        request.getRequestDispatcher("/pages1/admin-user-assign-list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
