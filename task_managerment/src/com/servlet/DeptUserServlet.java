package com.servlet;

import com.damain.Emp;
import com.service.IDeptService;
import com.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//主管页面的查询员工
@WebServlet("/deptUserServlet")
public class DeptUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        response.setContentType("text/html; charset=UTF-8");
        IDeptService deptService = new DeptServiceImpl();
        
        //调用service中的方法查询
        List<Emp> empList = deptService.findAll();
        //将查询结果存入request域中
        request.setAttribute("empList",empList);
        //转发到list.jsp
        request.getRequestDispatcher("/pages1/dept-user-list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
