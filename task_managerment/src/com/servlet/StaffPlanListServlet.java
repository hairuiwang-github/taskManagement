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
import java.util.List;
import java.util.Map;

//查询所有计划
@WebServlet("/staffPlanListServlet")
public class StaffPlanListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        IStaffService staffService = new StaffServiceImpl();
        List<Plan> planList = staffService.findAllPlan();
        request.setAttribute("planList",planList);
        request.getRequestDispatcher("pages1/staff-plan-list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
