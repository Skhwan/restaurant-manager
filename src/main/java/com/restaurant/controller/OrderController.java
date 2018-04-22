package com.restaurant.controller;

import com.restaurant.database.MenuDao;
import com.restaurant.database.OrderDao;
import com.restaurant.model.Menu;
import com.restaurant.model.Order;
import com.restaurant.util.OrderResponseWrapper;
import com.restaurant.util.ResponseConstant;
import com.restaurant.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by khwanchanok on 4/21/2018 AD.
 */
@Controller
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @Autowired
    MenuDao menuDao;

    public ResponseEntity<ResponseWrapper> addOrder(Map<String, String> body) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        try {
            Timestamp timestamp = getCurrentTime();
            Order order = new Order(body.get("billNo"), body.get("menu"), Integer.parseInt(body.get("quantity")), timestamp);
            orderDao.addOrder(order);
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        } catch (ParseException e){
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.FAIL);
            responseWrapper.setResponseStatus(e.getMessage());
        }

        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> removeOrder(int id){

        int result = orderDao.removeOrderById(id);
        ResponseWrapper responseWrapper = new ResponseWrapper();

        if(result > 0) {
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
        } else {
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseStatus(ResponseConstant.FAIL);
            responseWrapper.setResponseDesc("Got Exception While removing order");
        }

        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> getOrder(String billNo){

        List<Order> orders = orderDao.findOrderByBill(billNo);
        int totalPrice = calculatePrice(orders);

        OrderResponseWrapper responseWrapper = new OrderResponseWrapper();
        responseWrapper.setOrders(orders);
        responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
        responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
        responseWrapper.setTotalPrice(totalPrice);

        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> checkOut(String billNo){

        List<Order> orders = orderDao.findOrderByBill(billNo);
        int result = orderDao.checkOutOrderByBillNo(billNo);
        int totalPrice = calculatePrice(orders);

        OrderResponseWrapper responseWrapper = new OrderResponseWrapper();
        if(result > 0) {
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
            responseWrapper.setTotalPrice(totalPrice);
        } else {
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseStatus(ResponseConstant.FAIL);
            responseWrapper.setResponseDesc("Got Exception While checking out orders");
        }

        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public int calculatePrice(List<Order> orders){
        int price = 0;
        for (Order order:orders) {
            Menu menu = menuDao.getMenuPrice(order.getMenu());
            price = price + (menu.getPrice() * order.getQuantity());
        }
        return price;
    }

    public Timestamp getCurrentTime() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = df.format(new Date());
        Date orderedDate = df.parse(dateStr);
        return new java.sql.Timestamp(orderedDate.getTime());
    }
}
