package com.servlet;

import com.service.IStaffService;
import com.service.impl.StaffServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/staffTaskListServlet")
public class StaffTaskListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        ServletContext context = this.getServletContext();
        //获取当前登录员工的员工编号
        Object currentUsero = context.getAttribute("currentUser");
        String currentUser = currentUsero.toString();
        //根据员工编号查询对应的任务信息
        IStaffService staffService = new StaffServiceImpl();
        List<Map<String, String>> mapList1 = staffService.findTaskById(currentUser);

        //筛选出符合当前用户的任务
        List<Map<String, String>> mapList = new ArrayList<>();
        for (Map<String, String> map : mapList1) {
            if(map.get("username").equals(currentUser)){
                mapList.add(map);
            }
        }
        //将任务信息存入request域中
        request.setAttribute("mapList",mapList);
        request.getRequestDispatcher("pages1/staff-task-list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
