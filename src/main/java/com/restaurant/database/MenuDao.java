package com.restaurant.database;

import com.restaurant.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khwanchanok on 4/22/2018 AD.
 */
@Repository
public class MenuDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MenuRowMapper menuRowMapper;

    public Menu getMenuPrice(String name) {
        return jdbcTemplate.queryForObject("select * from menu where name=?",
                new Object[] { name },
                new BeanPropertyRowMapper<>(Menu.class));
    }
}
