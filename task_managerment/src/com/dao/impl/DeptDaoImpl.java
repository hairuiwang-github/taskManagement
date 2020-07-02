package com.dao.impl;

import com.damain.Emp;
import com.damain.Plan;
import com.damain.Task;
import com.dao.IDeptDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeptDaoImpl implements IDeptDao {

    private JdbcTemplate template = new JdbcTemplate(com.util.JdbcUtils.getDataSourse());

    //查找所有员工
    @Override
    public List<Emp> findAll() {
        String sql = "select * from t_emp";
        List<Emp> empList = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        return empList;
    }

    //根据员工编号查询员工信息
    @Override
    public Emp findUserById(String username) {
        String sql = "select * from t_emp where username =?";
        Emp emp = template.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class), username);
        return emp;
    }

    //多表查询未实施任务信息列表，调整任务
    @Override
    public List<Map<String, String>> findAdjustList() {
        String sql = "SELECT * FROM t_emp e,t_task t WHERE  t.emp_id = e.username AND t.task_state = '未实施'";
        List<Map<String, String>> mapList = template.query(sql, new RowMapper<Map<String, String>>() {
            @Override
            public Map<String, String> mapRow(ResultSet rs, int i) throws SQLException {
                Map mp = new HashMap();
                mp.put("id",rs.getString("id"));
                mp.put("task_name",rs.getString("task_name"));
                mp.put("name",rs.getString("name"));
                mp.put("task_begin_time",rs.getString("task_begin_time"));
                mp.put("task_end_time",rs.getString("task_end_time"));
                mp.put("task_state",rs.getString("task_state"));
                mp.put("task_description",rs.getString("task_description"));//用于调整任务界面

                return mp;
            }
        });
        return mapList;
    }

    //调整任务
    @Override
    public void adjustSave(Map<String, String> map) {
        //通过名字得到t_task表对应的外键值
        String sql1 = "select * from t_emp where name = ?";

        Emp emp = template.queryForObject(sql1, new BeanPropertyRowMapper<Emp>(Emp.class),map.get("name"));
        String emp_id = emp.getUsername();
        //先修改任务表中的其他字段，再修改外键id
        String sql2 = "update t_task set task_name = ?,task_begin_time=?,task_end_time=?,task_description=?,task_state=?,emp_id= ? where id=?";
        template.update(sql2,map.get("task_name"),map.get("task_begin_time"),map.get("task_end_time"),map.get("task_description"),map.get("task_state"),emp_id,map.get("id"));
    }


    //制订任务
    @Override
    public void addTask(Map<String, String> map) {
        String sql = "insert into t_task (task_name,task_begin_time,task_end_time,task_description,task_state,staff_id,emp_id)values (?,?,?,?,?,?,?)";
        template.update(sql,map.get("task_name"),map.get("task_begin_time"),map.get("task_end_time"),map.get("task_description"),map.get("task_state"),map.get("staff_id"),map.get("emp_id"));
    }

    //根据员工姓名获取员工信息
    @Override
    public Emp findUserByName(String name) {
        String sql = "select * from t_emp where name =?";
        Emp emp = template.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class), name);
        return emp;
    }


    //查看任务和实施人
    @Override
    public List<Map<String, String>> findTaskEmp() {
        String sql = "select * from t_emp e,t_task t where t.emp_id=e.username";
        List<Map<String, String>> list = template.query(sql, new RowMapper<Map<String, String>>() {
            @Override
            public Map<String, String> mapRow(ResultSet rs, int i) throws SQLException {
                Map<String, String> mp = new HashMap<>();
                mp.put("task_name", rs.getString("task_name"));
                mp.put("name", rs.getString("name"));
                mp.put("task_end_time", rs.getString("task_end_time"));
                mp.put("task_state", rs.getString("task_state"));
                mp.put("task_begin_time", rs.getString("task_begin_time"));
                mp.put("id",rs.getString("id"));
                mp.put("username",rs.getString("username"));
                return mp;
            }
        });
        return list;
    }

    //通过外键查找关联的计划
    @Override
    public List<Plan> findPlanById(String id) {
        String sql = "select * from t_plan where task_id = ?";
        List<Plan> planList = template.query(sql, new BeanPropertyRowMapper<Plan>(Plan.class),id);
        return planList;
    }


    //通过计划的id查找计划的详细信息
    @Override
    public Plan findPlanByPlanId(String id) {
        String sql = "select * from t_plan where id = ?";
        Plan plan = template.queryForObject(sql, new BeanPropertyRowMapper<Plan>(Plan.class),id);
        return plan;
    }


    @Override
    public Task findTaskByPlanId(String task_id) {

        String sql = "select * from t_task where id = ?";
        Task task = template.queryForObject(sql, new BeanPropertyRowMapper<Task>(Task.class), task_id);
        return task;
    }


    //根据id修改任务信息
    @Override
    public void updateTaskById(String id, String task_state) {
        String sql = "update t_task set task_state=? where id =?";
        template.update(sql,task_state,id);
    }

    @Override
    public void deleteTaskByTaskName(String task_name) {
        String sql = "delete from t_task where task_name = ?";
        template.update(sql,task_name);
    }
}
