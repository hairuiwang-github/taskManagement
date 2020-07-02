package com.servlet;

import com.service.IDeptService;
import com.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//展示跟踪任务列表
@WebServlet("/deptTaskFollowListServlet")
public class DeptTaskFollowListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        IDeptService deptService = new DeptServiceImpl();
        //调用方法
        List<Map<String, String>> taskEmpList = deptService.findTaskEmp();
        //创建集合存储实施中的任务
        List<Map<String, String>> following = new ArrayList<>();
        //循环筛选出未实施的任务
        for (Map<String, String> map : taskEmpList) {

            if (map.get("task_state").equals("实施中")){
                following.add(map);
            }
        }
        //将实施中的任务存到request域中
        request.setAttribute("following",following);
        //转发到制订页面
        request.getRequestDispatcher("/pages1/dept-task-follow.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
