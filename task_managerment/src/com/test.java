package com;

import com.damain.Plan;

import com.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class test {
    public static void main(String[] args) {
        DataSource dataSource;
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSourse());

        Map<String,String> map = new HashMap<>();



    }
}
