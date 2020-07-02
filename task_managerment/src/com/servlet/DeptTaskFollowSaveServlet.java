package com.servlet;

import com.service.IDeptService;
import com.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//将跟踪任务中修改后的信息提交
@WebServlet("/deptTaskFollowSaveServlet")
public class DeptTaskFollowSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取数据
        String id = request.getParameter("id");
        String task_state = request.getParameter("task_state");
        IDeptService deptService = new DeptServiceImpl();
        deptService.updateTaskById(id,task_state);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
