package com.restaurant;

import com.restaurant.controller.OrderController;
import com.restaurant.database.MenuDao;
import com.restaurant.model.Menu;
import com.restaurant.model.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by khwanchanok on 4/22/2018 AD.
 */
@SpringBootTest
public class OrderControllerTest {

    @Mock
    MenuDao menuDao;

    @InjectMocks
    OrderController orderController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateTotalPriceCorrectly(){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Menu1", 1, new Timestamp(1234566)));
        orders.add(new Order("2", "Menu2", 2, new Timestamp(1234566)));
        orders.add(new Order("3", "Menu3", 3, new Timestamp(1234566)));
        int expectedPrice = 1200;
        Menu menu1 = new Menu("Menu1", "menu", "link", 300);
        Menu menu2 = new Menu("Menu2", "menu", "link", 150);
        Menu menu3 = new Menu("Menu3", "menu", "link", 200);


        Mockito.when(menuDao.getMenuPrice("Menu1")).thenReturn(menu1);
        Mockito.when(menuDao.getMenuPrice("Menu2")).thenReturn(menu2);
        Mockito.when(menuDao.getMenuPrice("Menu3")).thenReturn(menu3);

        int totalPrice = orderController.calculatePrice(orders);

        Assert.assertEquals(expectedPrice, totalPrice);
    }
}
