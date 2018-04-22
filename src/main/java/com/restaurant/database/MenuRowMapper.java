package com.restaurant.database;

import com.restaurant.model.Menu;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by khwanchanok on 4/21/2018 AD.
 */
@Component
public class MenuRowMapper implements RowMapper {
    @Override
    public Menu mapRow(ResultSet resultSet, int row) throws SQLException {
        String name = resultSet.getString("menu_name");
        String description = resultSet.getString("description");
        String image = resultSet.getString("image");
        int price = resultSet.getInt("price");
        String[] additional = resultSet.getString("additional").split(",");

        Menu menu = new Menu(name, description, image, price);
        menu.setAdditional(additional);

        return menu;
    }
}
