package com.dao;

import com.damain.Emp;
import com.damain.Plan;
import com.damain.Task;

import java.util.List;
import java.util.Map;

public interface IDeptDao {
    //查询所有员工
    List<Emp> findAll();

    //根据员工编号查询员工信息
    Emp findUserById(String username);

    //多表查询未实施任务信息列表，调整任务
    List<Map<String, String>> findAdjustList();

    //将调整后的任务信息存入
    void adjustSave(Map<String, String> map);

    //制订任务
    void addTask(Map<String, String> map);

    //根据员工姓名获取员工信息
    Emp findUserByName(String name);

    //查看任务和实施人
    List<Map<String, String>> findTaskEmp();

    //通过外键查找关联的计划
    List<Plan> findPlanById(String id);

    //通过计划的id查找关联的计划
    Plan findPlanByPlanId(String id);

    //根据id获取所属任务
    Task findTaskByPlanId(String task_id);

    //根据id修改任务信息
    void updateTaskById(String id, String task_state);

    void deleteTaskByTaskName(String task_name);
}
