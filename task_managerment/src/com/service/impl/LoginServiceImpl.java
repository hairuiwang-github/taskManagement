package com.service.impl;

import com.damain.Emp;
import com.dao.ILoginDao;
import com.dao.impl.LoginDaoImpl;
import com.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
    private ILoginDao loginDao = new LoginDaoImpl();
    @Override
    public String verify(String username, String password, String flag) {
        if (username == null){
            return null;//此处判断防止空指针异常
        }
        Emp emp = loginDao.verify(username);
        if (username.equals(emp.getUsername())&&password.equals(emp.getPassword())){
            //账号密码正确，判断登录身份
            if (flag.equals(emp.getFlag())){

                return "success";
            }else {
                return "身份错误";
            }
        }else {
            return "密码输入错误";
        }
    }
}
