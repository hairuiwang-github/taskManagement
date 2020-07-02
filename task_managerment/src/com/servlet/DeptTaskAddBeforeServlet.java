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

//因为制订任务的页面中需要有全部员工的姓名信息，故此servlet负责提前查询出员工姓名信息
@WebServlet("/deptTaskAddBeforeServlet")
public class DeptTaskAddBeforeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        IDeptService deptService = new DeptServiceImpl();
        //调用service中的方法进行查询
        List<Emp> staffNameList = deptService.findAll();
        //将信息存入request域中
        request.setAttribute("staffNameList",staffNameList);
        //转发到制订任务界面
        request.getRequestDispatcher("/pages1/dept-task-add.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
