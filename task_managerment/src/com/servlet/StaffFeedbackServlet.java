package com.servlet;

import com.service.IStaffService;
import com.service.impl.StaffServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//反馈计划
@WebServlet("/staffFeedbackServlet")
public class StaffFeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String plan_state = request.getParameter("plan_state");
        String feedback = request.getParameter("feedback");
        String id = request.getParameter("id");

        IStaffService staffService = new StaffServiceImpl();
        staffService.updatePlanById(id,plan_state,feedback);

        request.getRequestDispatcher("staffPlanListServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
