package com.restaurant.database;

import com.restaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by khwanchanok on 4/21/2018 AD.
 */
@Repository
public class OrderDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    OrderRowMapper orderRowMapper;

    public List<Order> findOrderByBill(String billNo) {
        return jdbcTemplate.query("select * from customer_order where bill_no=? and checked_out=?",
                new Object[] {
                billNo, 1
                },
                orderRowMapper);
    }

    public int removeOrderById(long id) {
        return jdbcTemplate.update("delete from customer_order where id=?",
                new Object[] { id });
    }

    public int addOrder(Order order) {
        return jdbcTemplate.update("insert into customer_order (bill_no, menu, quantity, ordered_time, checked_out) " + "values(?, ?, ?, ?, ?)",
            new Object[] {
                    order.getBillNo(), order.getMenu().toUpperCase(), order.getQuantity(), order.getOrderedTime(), 1
            });
    }

    public int checkOutOrderByBillNo(String billNo) {
        return jdbcTemplate.update("update customer_order " + " set checked_out = ? " + " where bill_no = ?",
                new Object[] {
                    0, billNo
                });
    }
}
