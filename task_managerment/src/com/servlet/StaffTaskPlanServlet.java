package com.servlet;

import com.damain.Emp;
import com.damain.Plan;
import com.damain.Task;
import com.service.IStaffService;
import com.service.impl.StaffServiceImpl;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/staffTaskPlanServlet")
public class StaffTaskPlanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        ServletContext context = this.getServletContext();
        //获取当前登录员工的员工编号
        Object currentUsero = context.getAttribute("currentUser");
        String currentUser = currentUsero.toString();
        //根据员工编号查询对应的任务信息
        IStaffService staffService = new StaffServiceImpl();
        //先根据员工编号获取到任务id
        Task task = staffService.findTaskIdByUserName(currentUser);
        String task_id = String.valueOf(task.getId());
        //通过task_id查询全部计划
        List<Plan> planList = staffService.findPlanByTaskId(task_id);
        //查询出实施人
        Emp emp = staffService.findUserById(currentUser);
        request.setAttribute("emp",emp);
        //将planList存入request域中
        request.setAttribute("planList",planList);
        //将task存入request域中
        request.setAttribute("task",task);
        //转发到展示页面
        request.getRequestDispatcher("/pages1/staff-task-plan-show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
