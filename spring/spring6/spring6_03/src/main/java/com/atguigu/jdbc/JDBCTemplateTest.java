package com.atguigu.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {
    // 虽然会提示出错，但能运行
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        String sql1 = "insert into userinfo values(?,?,?)";
        int rows = jdbcTemplate.update(sql1, "003", "王五", "广东");
        jdbcTemplate.update(sql1, "004", "赵六", "北京");
        System.out.println(rows);
    }

    @Test
    public void testSelect() {
        String sql = "select * from userinfo where address=?";
        List<User> userlist = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), "北京");
        System.out.println(userlist);
    }
}
