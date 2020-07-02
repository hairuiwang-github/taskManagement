package com.servlet;

import com.damain.Plan;
import com.service.IDeptService;
import com.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//查询任务的详细信息以及实施计划
@WebServlet("/deptTaskShowServlet")
public class DeptTaskShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        IDeptService deptService = new DeptServiceImpl();
        //获取jsp页面传递过来的任务id
        String id = request.getParameter("id");
        //调用service中的方法先进行任务查询
        List<Map<String, String>> taskEmpList = deptService.findTaskEmp();
        //遍历找到符合id的任务
        Map<String, String> currentTask = new HashMap<>();
        for (Map<String, String> task : taskEmpList) {
            if (id.equals(task.get("id"))){
                currentTask = task;
                break;
            }
        }

        //将当前任务信息存入request域中
        request.setAttribute("currentTask",currentTask);
        //通过外键查找关联的计划
        List<Plan> planList = deptService.findPlanById(id);


        //将计划存入request域中
        request.setAttribute("planList",planList);
        //转发到展示页面
        request.getRequestDispatcher("/pages1/dept-task-show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
