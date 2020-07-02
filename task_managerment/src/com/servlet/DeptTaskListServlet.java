package com.servlet;

import com.service.IDeptService;
import com.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//查看任务和实施人
@WebServlet("/deptTaskListServlet")
public class DeptTaskListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        IDeptService deptService = new DeptServiceImpl();
        //调用service中的方法进行查询
        List<Map<String, String>>taskList = deptService.findTaskEmp();
        //将结果存入request域中
        request.setAttribute("taskList",taskList);
        //转发到指定页面
        request.getRequestDispatcher("/pages1/dept-task-list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
