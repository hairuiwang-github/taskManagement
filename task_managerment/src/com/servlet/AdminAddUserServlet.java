package com.servlet;

import com.damain.Emp;
import com.service.IAdminService;
import com.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.taglibs.standard.extra.spath.ParseException;

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

@WebServlet("/adminAddUserServlet")
public class AdminAddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Emp emp = new Emp();

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

        //获取数据
        Map<String, String[]> map = request.getParameterMap();

        //封装数据

        try {
            BeanUtils.populate(emp, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //调用service添加
        IAdminService adminService = new AdminServiceImpl();
        adminService.addUser(emp);

        //跳到员工列表页面
        request.getRequestDispatcher("/adminUserListServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
