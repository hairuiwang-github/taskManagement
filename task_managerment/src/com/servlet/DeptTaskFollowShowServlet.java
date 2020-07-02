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
import java.util.List;

@WebServlet("/deptTaskFollowShowServlet")
public class DeptTaskFollowShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        //创建对象
        IDeptService deptService = new DeptServiceImpl();
        //获取任务的id
        String id = request.getParameter("id");
        //调用service中的方法进行查询任务信息
        Task task = deptService.findTaskByPlanId(id);
        //根据任务的外键查询任务所对应的计划信息
        String task_id = String.valueOf(task.getId());
        List<Plan> planList = deptService.findPlanById(task_id);
        //将任务信息和计划信息存入request域中
        request.setAttribute("task",task);
        request.setAttribute("planList",planList);
        //转发到指定页面
        request.getRequestDispatcher("/pages1/dept-follow-show.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
