package com.restaurant.util;

import com.restaurant.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khwanchanok on 4/22/2018 AD.
 */
public class OrderResponseWrapper extends ResponseWrapper{

    private int totalPrice;
    private List<Order> orders;

    public OrderResponseWrapper(){
        orders = new ArrayList<>();
        totalPrice = 0;
    }

    public void setOrders(List orders){
        this.orders = orders;
    }

    public List<Order> getOrders(){
        return orders;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString(){
        return "ResponseWrapper:{" +
                " resultCode=" + getResponseCode() +
                " resultStatus=" + getResponseStatus() +
                " resultDesc=" + getResponseDesc() +
                " totalPrice=" + getTotalPrice() +
                " orders=" + getOrders() +
                " }";
    }
}
