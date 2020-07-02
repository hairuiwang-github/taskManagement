package com.dao.impl;

import com.damain.Plan;
import com.damain.Task;
import com.dao.IStaffDao;
import com.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StaffDaoImpl implements IStaffDao {

    DataSource dataSource;
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSourse());

    //根据员工编号获取到任务id
    @Override
    public Task findTaskIdByUserName(String currentUser) {
        String sql = "select * from t_task where emp_id = ?";
        Task task = template.queryForObject(sql, new BeanPropertyRowMapper<>(Task.class), currentUser);
        return task;
    }

    @Override
    public List<Plan> findPlanByTaskId(String task_id) {
        String sql = "select * from t_plan where task_id = ?";
        List<Plan> list = template.query(sql, new BeanPropertyRowMapper<>(Plan.class), task_id);
        return list;
    }

    @Override
    public List<Task> findTaskById(String currentUser) {
        String sql = "select * from t_task where staff_id = ?";
        List<Task> taskList = template.query(sql, new BeanPropertyRowMapper<>(Task.class));
        return taskList;
    }

    @Override
    public void deletePlanById(String id) {
        String sql = "delete from t_plan where id = ?";
        template.update(sql,id);
    }

    @Override
    public void addPlan(Plan plan, String id) {
        String sql = "insert into t_plan (plan_name,plan_state,feedback,plan_begin_date,plan_end_date,plan_description,task_id) " +
                "values(?,?,?,?,?,?,?)";
        System.out.println(id+"1r1");
        int id1 = Integer.parseInt(id);

        template.update(sql,plan.getPlan_name(),plan.getPlan_state(),plan.getFeedback(),plan.getPlan_begin_date(),plan.getPlan_end_date(),plan.getPlan_description(),id1);
    }

    @Override
    public List<Plan> findAllPlan() {
        String sql = "select * from t_plan";
        List<Plan> planList = template.query(sql, new BeanPropertyRowMapper<>(Plan.class));
        return planList;
    }

    @Override
    public Plan findPlanByPlanId(String id) {
        String sql = "select * from t_plan where id = ?";
        Plan plan = template.queryForObject(sql, new BeanPropertyRowMapper<>(Plan.class), id);
        return plan;
    }

    @Override
    public void updatePlanById(String id,String plan_state, String feedback) {
        String sql = "update t_plan set plan_state=?,feedback=? where id =?";
        template.update(sql,plan_state,feedback,id);
    }

    @Override
    public List<Task> findAllTask() {
        String sql = "select * from t_task";
        List<Task> taskList = template.query(sql, new BeanPropertyRowMapper<>(Task.class));
        return taskList;
    }

    @Override
    public List<Plan> dimLook(Map<String, String> map) {
        String sql = "select * from t_plan where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //定义参数集合
        List<String> params = new ArrayList<String>();
        //遍历map，动态拼接sql
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            if (value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");//参数
                params.add("%"+value+"%");//参数的值
            }
        }

        List<Plan> planList = template.query(sb.toString(), new BeanPropertyRowMapper<>(Plan.class), params.toArray());
        return planList;
    }
}
