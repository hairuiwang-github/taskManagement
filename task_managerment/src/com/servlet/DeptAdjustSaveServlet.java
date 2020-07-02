package com.servlet;

import com.service.IDeptService;
import com.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//将调整后的任务信息存入
@WebServlet("/deptAdjustSaveServlet")
public class DeptAdjustSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        //获取从参数值
        String id = request.getParameter("id");
        String task_name = request.getParameter("task_name");
        String name = request.getParameter("name");
        String task_begin_time = request.getParameter("task_begin_time");
        String task_end_time = request.getParameter("task_end_time");
        String task_description = request.getParameter("task_description");
        String task_state = request.getParameter("task_state");


        //获取实施人的编号

        //将获取的值封装为map集合
        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("task_name",task_name);
        map.put("name",name);
        map.put("task_begin_time",task_begin_time);
        map.put("task_end_time",task_end_time);
        map.put("task_description",task_description);
        map.put("task_state",task_state);
        //创建service对象
        IDeptService deptService = new DeptServiceImpl();
        //调用service中的方法，将数据存储进去
        deptService.adjustSave(map);

        request.getRequestDispatcher("deptAdjustListServlet").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
