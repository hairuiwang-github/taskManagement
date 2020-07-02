package com.service.impl;

import com.damain.Emp;
import com.dao.IAdminDao;
import com.dao.impl.AdminDaoImpl;
import com.service.IAdminService;

import java.util.List;

public class AdminServiceImpl  implements IAdminService {

    private IAdminDao adminDao = new AdminDaoImpl();

    @Override
    public void addUser(Emp emp) {
        adminDao.addUser(emp);
    }

    @Override
    public List<Emp> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Emp findUserById(String username) {
        return adminDao.findUserById(username);
    }

    @Override
    public void deleteUserById(String username) {
        adminDao.deleteUserById(username);
    }

    @Override
    public void updateUser(String username,String super_id) {
        adminDao.updateUser(username,super_id);
    }


}
