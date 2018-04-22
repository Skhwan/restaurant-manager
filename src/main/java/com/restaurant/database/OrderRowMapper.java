package com.restaurant.database;

import com.restaurant.model.Order;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by khwanchanok on 4/21/2018 AD.
 */

@Component
public class OrderRowMapper implements RowMapper{
    @Override
    public Order mapRow(ResultSet resultSet, int row) throws SQLException {
        long id = resultSet.getLong("id");
        String billNo = resultSet.getString("bill_no");
        String menu = resultSet.getString("menu");
        int quantity = resultSet.getInt("quantity");
        String orderedTimeStr = resultSet.getString("ordered_time");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date orderedTime;
        Timestamp timestamp = null;
        try {
            orderedTime = df.parse(orderedTimeStr);
            timestamp = new java.sql.Timestamp(orderedTime.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Order order = new Order(billNo, menu, quantity, timestamp);
        order.setId(id);

        return order;
    }
}
