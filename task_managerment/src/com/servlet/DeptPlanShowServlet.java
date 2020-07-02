package com.servlet;

import com.damain.Plan;
import com.damain.Task;
import com.service.IDeptService;
import com.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//展示计划的详细信息
@WebServlet("/deptPlanShowServlet")
public class DeptPlanShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        IDeptService deptService =  new DeptServiceImpl();
        //获取计划的id值
        String id = request.getParameter("id");

        //调用方法
        Plan plan = deptService.findPlanByPlanId(id);
        //将plan存入request域中
        request.setAttribute("plan",plan);


        //根据id获取所属任务
        Task task =deptService.findTaskByPlanId(plan.getTask_id());
        request.setAttribute("task",task);
        //转发到展示页面
        request.getRequestDispatcher("/pages1/dept-plan-show.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
