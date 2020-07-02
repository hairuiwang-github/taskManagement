package com.service.impl;

import com.damain.Emp;
import com.damain.Plan;
import com.damain.Task;

import com.dao.IDeptDao;
import com.dao.IStaffDao;
import com.dao.impl.DeptDaoImpl;
import com.dao.impl.StaffDaoImpl;
import com.service.IStaffService;

import java.util.List;
import java.util.Map;

public class StaffServiceImpl implements IStaffService {

    private IStaffDao staffDao = new StaffDaoImpl();
    private IDeptDao deptDao = new DeptDaoImpl();

    //根据员工编号获取到任务id
    @Override
    public Task findTaskIdByUserName(String currentUser) {
        return staffDao.findTaskIdByUserName(currentUser);
    }

    @Override
    public List<Plan> findPlanByTaskId(String task_id) {
        return staffDao.findPlanByTaskId(task_id);
    }

    @Override
    public List<Map<String, String>> findTaskById(String currentUser) {
        return deptDao.findTaskEmp();
    }

    @Override
    public Emp findUserById(String currentUser) {
        return deptDao.findUserById(currentUser);
    }

    @Override
    public void deletePlanById(String id) {
        staffDao.deletePlanById(id);
    }

    @Override
    public void addPlan(Plan plan, String id) {
        staffDao.addPlan(plan,id);
    }

    @Override
    public List<Plan> findAllPlan() {
        return staffDao.findAllPlan();
    }

    @Override
    public Plan findPlanByPlanId(String id) {
        return staffDao.findPlanByPlanId(id);
    }

    @Override
    public void updatePlanById(String id,String plan_state, String feedback) {
        staffDao.updatePlanById(id,plan_state,feedback);
    }

    @Override
    public List<Task> findAllTask() {
        return staffDao.findAllTask();
    }

    @Override
    public List<Plan> dimLook(Map<String, String> map) {
        return staffDao.dimLook(map);
    }
}
