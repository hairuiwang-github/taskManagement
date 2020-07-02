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
import java.util.Map;

@WebServlet("/deptAdjustServlet")
public class DeptAdjustServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        response.setContentType("text/html; charset=UTF-8");
        IDeptService deptService = new DeptServiceImpl();
        //获取任务名称
        String task_name = request.getParameter("task_name");

        //调用service层的方法进行查询
        List<Map<String, String>> mapList = deptService.findAdjustList();
        //遍历，找到与任务名称相同的map,并存入request域中
        for (Map<String, String> map : mapList) {
            if (task_name.equals(map.get("task_name"))){
                request.setAttribute("map",map);
                break;
            }
        }


        //将所有实施人的信息存入request域中
        List<Emp> emps = deptService.findAll();
        request.setAttribute("emps",emps);

        //跳转页面
        request.getRequestDispatcher("/pages1/dept-task-adjust.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
