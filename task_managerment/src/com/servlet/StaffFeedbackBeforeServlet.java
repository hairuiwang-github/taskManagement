package com.servlet;

import com.damain.Plan;
import com.service.IStaffService;
import com.service.impl.StaffServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//反馈计划页面的数据回显
@WebServlet("/staffFeedbackBeforeServlet")
public class StaffFeedbackBeforeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        //获取计划的id
        String id = request.getParameter("id");
        IStaffService staffService = new StaffServiceImpl();
        Plan plan = staffService.findPlanByPlanId(id);



        request.setAttribute("plan",plan);
        request.getRequestDispatcher("pages1/staff-plan-feedback.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
