package com.restaurant.model;

import java.sql.Timestamp;

/**
 * Created by khwanchanok on 4/21/2018 AD.
 */
public class Order {

    private long id;
    private String billNo;
    private String menu;
    private int quantity;
    private String orderedTime;

    public Order(String billNo, String menu, int quantity, Timestamp orderedTime) {
        this.billNo = billNo;
        this.menu = menu;
        this.quantity = quantity;
        this.orderedTime = orderedTime.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Timestamp orderedTime) {
        this.orderedTime = orderedTime.toString();
    }

    @Override
    public String toString(){
        return "Order[" +
                "billNo=" + getBillNo() +
                "menu=" + getMenu() +
                "quantity=" + getQuantity() +
                "orderedTime=" + getOrderedTime() +
                "]";
    }

}
