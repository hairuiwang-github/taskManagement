package com.dao;

import com.damain.Plan;
import com.damain.Task;

import java.util.List;
import java.util.Map;

public interface IStaffDao {
    //根据员工编号获取到任务id
    Task findTaskIdByUserName(String currentUser);

    List<Plan> findPlanByTaskId(String task_id);

    List<Task> findTaskById(String currentUser);

    void deletePlanById(String id);

    void addPlan(Plan plan, String id);

    List<Plan> findAllPlan();

    Plan findPlanByPlanId(String id);

    void updatePlanById(String id,String plan_state,String feedback);

    List<Task> findAllTask();

    List<Plan> dimLook(Map<String, String> map);
}
