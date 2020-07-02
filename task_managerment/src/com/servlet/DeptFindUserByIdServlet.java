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

//根据员工编号获取员工信息
@WebServlet("/deptFindUserByIdServlet")
public class DeptFindUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        response.setContentType("text/html; charset=UTF-8");
        IDeptService deptService = new DeptServiceImpl();
        //获取员工编号
        String username = request.getParameter("username");
        //调用service中的方法查询

        Emp emp = deptService.findUserById(username);
        //将员工信息存入request域中
        request.setAttribute("emp",emp);
        //跳转到dept-user-show.jsp
        request.getRequestDispatcher("/pages1/dept-user-show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
