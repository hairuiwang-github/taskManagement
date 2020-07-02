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

@WebServlet("/deptAdjustListServlet")
public class DeptAdjustListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        response.setContentType("text/html; charset=UTF-8");
        IDeptService deptService = new DeptServiceImpl();
        //调用service层的方法
        List<Map<String, String>> mapList = deptService.findAdjustList();
        //存入request域中
        request.setAttribute("mapList",mapList);
        //转发到指定页面
        request.getRequestDispatcher("/pages1/dept-task-adjust-list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
