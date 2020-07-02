package com.servlet;

import com.damain.Plan;
import com.service.IStaffService;
import com.service.impl.StaffServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/staffPlanAddServlet")
public class StaffPlanAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        //封装表单数据
        Map<String, String[]> map = request.getParameterMap();

        Plan plan =new Plan();


        //注册转换器，将string类型数据转换为date类型
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class aClass, Object o) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    return formatter.parse(o.toString());
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }

                return new Date();
            }
        }, Date.class);

        try {
            BeanUtils.populate(plan,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service中的方法添加数据
        IStaffService staffService = new StaffServiceImpl();
        System.out.println(plan.getId());
        staffService.addPlan(plan,id);

        //跳转到查询所有计划页面
        request.getRequestDispatcher("staffPlanListServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
