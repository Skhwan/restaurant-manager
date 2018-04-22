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
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        String image = resultSet.getString("image");
        int price = resultSet.getInt("price");

        String[] rawAdditional = resultSet.getString("additional").split(",");
        ArrayList<String> additiontal = new ArrayList<>();
        for (String add: rawAdditional) {
            additiontal.add(add);
        }

        Menu menu = new Menu(name, description, image, price);
        menu.setAdditional(additiontal);

        return menu;
    }
}
