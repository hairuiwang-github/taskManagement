package com.servlet;

import com.damain.Task;
import com.service.IStaffService;
import com.service.impl.StaffServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//提前查询出任务
@WebServlet("/staffLookBeforeServlet")
public class StaffLookBeforeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        IStaffService staffService = new StaffServiceImpl();
        List<Task> taskList = staffService.findAllTask();
        request.setAttribute("taskList",taskList);

        request.getRequestDispatcher("pages1/staff-plan-look.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
