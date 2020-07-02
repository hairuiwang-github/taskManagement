package com.servlet;

import com.service.ILoginService;
import com.service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String flag = request.getParameter("flag");

        //调用service层的方法进行判断
        ILoginService loginService = new LoginServiceImpl();
        String verifyMessage = loginService.verify(username, password, flag);

        if (verifyMessage == null){
            //用户名为空
            request.setAttribute("login_msg","用户名为空");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            if(verifyMessage.equals("success")){
                //登录成功,判断以什么身份登录
                //将登录对象存入域中
                ServletContext context = this.getServletContext();
                //先移除对象，防止重复
                context.removeAttribute("currentUser");
                context.setAttribute("currentUser",username);


                if (flag.equals("1")){
                    request.setAttribute("loginName",username);
                    request.getRequestDispatcher("/pages1/admin-main.jsp").forward(request, response);
                }else if (flag.equals("2")){
                    request.setAttribute("loginName",username);

                    request.getRequestDispatcher("/pages1/dept-main.jsp").forward(request, response);
                }else if (flag.equals("3")){
                    request.setAttribute("loginName",username);
                    request.getRequestDispatcher("/pages1/staff-main.jsp").forward(request, response);
                }
            }else if (verifyMessage.equals("身份错误")){
                request.setAttribute("login_msg","身份错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else if (verifyMessage.equals("密码输入错误")){
                request.setAttribute("login_msg","密码输入错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
