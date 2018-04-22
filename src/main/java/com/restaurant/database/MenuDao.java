package com.restaurant.database;

import com.restaurant.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

    public int addMenu(Menu menu) {
        int result;
        result = jdbcTemplate.update("merge into menu(menu_name, description, image, price, additional) key(menu_name) " + "select ?, ?, ?, ?, ? from dual",
                new Object[]{
                        menu.getName().toUpperCase(), menu.getDescription(), menu.getImage(), menu.getPrice(), String.join(",", menu.getAdditional())
                });

        return result;
    }

    public int removeMenu(String name) {
        return jdbcTemplate.update("delete from menu where upper(menu_name)=?",
                new Object[] { name.toUpperCase() });
    }

    public Menu getMenuPrice(String name) {
        return jdbcTemplate.queryForObject("select * from menu where upper(menu_name)=?",
                new Object[] { name.toUpperCase() },
                new BeanPropertyRowMapper<>(Menu.class));
    }

    public List<Menu> searchMenu(String keyword, int limit, int offset){
        return jdbcTemplate.query("select * from menu where upper(menu_name) like '%"+ keyword.toUpperCase() +"%' or " +
                        "upper(description) like '%" + keyword.toUpperCase() + "%' or " +
                        "upper(additional) like '%" + keyword.toUpperCase() + "%' " +
                        "limit ? offset ?",
                new Object[] { limit, offset },
                menuRowMapper);
    }

    public List<Menu> getAllMenu(int limit, int offset){
        return jdbcTemplate.query("select * from menu limit ? offset ?",
                new Object[] { limit, offset },
                menuRowMapper);
    }

    public boolean hasNextPageForKeyword(String keyword, int offset){
        int rowCount = jdbcTemplate.queryForObject("select count(*) from menu where upper(menu_name) like '%"+ keyword.toUpperCase() +"%' or " +
                        "upper(description) like '%" + keyword.toUpperCase() + "%' or " +
                        "upper(additional) like '%" + keyword.toUpperCase() + "%'",
                new Object[] {},
                int.class);

        if (offset < rowCount){
            return true;
        }
        return false;
    }

    public boolean hasNextPage(int offset){
        int rowCount = jdbcTemplate.queryForObject("select count(*) from menu", new Object[]{}, int.class);

        if (offset < rowCount){
            return true;
        }
        return false;
    }
}
