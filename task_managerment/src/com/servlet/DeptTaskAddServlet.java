package com.servlet;

import com.damain.Emp;
import com.service.IDeptService;
import com.service.impl.DeptServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//制订任务
@WebServlet("/deptTaskAddServlet")
public class DeptTaskAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取当前登录用户的编号
        ServletContext context = this.getServletContext();
        String currentUser = (String) context.getAttribute("currentUser");


        IDeptService deptService = new DeptServiceImpl();
        //从jsp页面获取数据
        String task_name = request.getParameter("task_name");
        String name = request.getParameter("name");
        String task_end_time = request.getParameter("task_end_time");
        String task_description = request.getParameter("task_description");
        String task_state = request.getParameter("task_state");
        String task_begin_time = request.getParameter("task_begin_time");
        //获取员工编号

        Emp emp = deptService.findUserByName(name);
        String emp_id = emp.getUsername();
        //将获取的值封装为map集合
        Map<String, String> map = new HashMap<>();
        map.put("task_name",task_name);
        map.put("task_end_time",task_end_time);
        map.put("task_description",task_description);
        map.put("task_state",task_state);
        map.put("emp_id",emp_id);
        map.put("task_begin_time",task_begin_time);
        map.put("staff_id",currentUser);
        //调用service中的方法进行添加
        deptService.addTask(map);
        //跳转页面
        request.getRequestDispatcher("/deptTaskListServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
