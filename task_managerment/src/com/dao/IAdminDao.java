package com.dao;

import com.damain.Emp;

import java.util.List;

public interface IAdminDao {
    void addUser(Emp emp);

    List<Emp> findAll();

    Emp findUserById(String username);

    void deleteUserById(String username);


    void updateUser(String username,String super_id);
}
