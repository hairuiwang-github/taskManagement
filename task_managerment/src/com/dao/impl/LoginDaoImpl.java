package com.dao.impl;

import com.damain.Emp;
import com.dao.ILoginDao;
import com.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class LoginDaoImpl implements ILoginDao {
    DataSource dataSource;
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSourse());

    @Override
    public Emp verify(String username) {

        String sql = "select * from t_emp where username =?";
        Emp emp = template.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class),username);
        return emp;
    }
}
