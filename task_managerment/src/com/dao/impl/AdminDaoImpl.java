package com.dao.impl;

import com.damain.Emp;
import com.dao.IAdminDao;
import com.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class AdminDaoImpl implements IAdminDao {

    DataSource dataSource;
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSourse());

    @Override
    public void addUser(Emp emp) {

        String sql = "insert into t_emp (username,name,password,sex,birthday,hire_date,position,qualification,professional,experience,flag)" +
                "values (?,?,?,?,?,?,?,?,?,?,?)";
        template.update(sql,emp.getUsername(),emp.getName(),emp.getPassword(),emp.getSex(),
                emp.getBirthday(),emp.getHire_date(),emp.getPosition(),emp.getQualification(),emp.getProfessional(),emp.getExperience(),emp.getFlag());
    }

    @Override
    public List<Emp> findAll() {
        String sql = "select * from t_emp";
        List<Emp> empList = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        return empList;
    }

    @Override
    public Emp findUserById(String username) {

        String sql = "select * from t_emp where username = ?";
        Emp emp = template.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class),username);
        return emp;
    }

    @Override
    public void deleteUserById(String username) {
        String sql = "delete from t_emp where username = ?";
        template.update(sql,username);
    }

    @Override
    public void updateUser(String username,String super_id) {
        String sql = "update t_emp set super_id = ? where username =?";
        template.update(sql,super_id,username);
    }

}
