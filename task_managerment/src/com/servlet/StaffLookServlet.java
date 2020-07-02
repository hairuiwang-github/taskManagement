package com.servlet;

import com.damain.Plan;
import com.damain.Task;
import com.service.IStaffService;
import com.service.impl.StaffServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/staffLookServlet")
public class StaffLookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String plan_name = request.getParameter("plan_name");
        String task_id = request.getParameter("task_id");
        String feedback = request.getParameter("feedback");

        Map<String,String> map = new HashMap<>();
        map.put("plan_name",plan_name);
        map.put("task_id",task_id);
        map.put("feedback",feedback);



        IStaffService staffService = new StaffServiceImpl();
        List<Plan> planList = staffService.dimLook(map);

        List<Task> taskList = staffService.findAllTask();
        request.setAttribute("taskList",taskList);

        request.setAttribute("planList",planList);
        request.getRequestDispatcher("pages1/staff-plan-look.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
