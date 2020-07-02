package com.service.impl;

import com.damain.Emp;
import com.damain.Plan;
import com.damain.Task;
import com.service.IDeptService;

import java.util.List;
import java.util.Map;

public class DeptServiceImpl implements IDeptService {
    private com.dao.IDeptDao deptDao = new com.dao.impl.DeptDaoImpl();

    //查询所有员工
    @Override
    public List<Emp> findAll() {
        return deptDao.findAll();
    }

    //根据员工编号查询员工信息
    @Override
    public Emp findUserById(String username) {
        return deptDao.findUserById(username);
    }

    //多表查询未实施任务信息列表，调整任务模块
    @Override
    public List<Map<String, String>> findAdjustList() {
        return deptDao.findAdjustList();
    }

    //调整任务
    @Override
    public void adjustSave(Map<String, String> map) {
        deptDao.adjustSave(map);
    }

    //制订任务
    @Override
    public void addTask(Map<String, String> map) {
        deptDao.addTask(map);
    }

    //根据员工姓名获取员工信息
    @Override
    public Emp findUserByName(String name) {
        return deptDao.findUserByName(name);
    }

    //查看任务和实施人
    @Override
    public List<Map<String, String>> findTaskEmp() {
        return deptDao.findTaskEmp();
    }

    //通过外键查找关联的计划
    @Override
    public List<Plan> findPlanById(String id) {
        return deptDao.findPlanById(id);
    }

    //通过计划的id查找计划的详细信息
    @Override
    public Plan findPlanByPlanId(String id) {
        return deptDao.findPlanByPlanId(id);
    }

    @Override
    public Task findTaskByPlanId(String task_id) {
        return deptDao.findTaskByPlanId(task_id);
    }

    //根据id修改任务信息
    @Override
    public void updateTaskById(String id, String task_state) {
        deptDao.updateTaskById(id,task_state);
    }

    @Override
    public void deleteTaskByTaskName(String task_name) {
        deptDao.deleteTaskByTaskName(task_name);
    }


}