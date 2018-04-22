package com.restaurant.util;

import com.restaurant.model.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khwanchanok on 4/22/2018 AD.
 */
public class MenuResponseWrapper extends ResponseWrapper {

    private List<Menu> menus;
    private String previousPage;
    private String nextPage;

    public MenuResponseWrapper(){
        menus = new ArrayList<>();
    }

    public String getPreviousPage() {
        return previousPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public List<Menu> getMenus(){
        return menus;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public void setMenus(ArrayList menus){
        this.menus = menus;
    }

    public void setPreviousPage(String previousPage) {
        this.previousPage = previousPage;
    }

    @Override
    public String toString(){
        return "ResponseWrapper:{" +
                " resultCode=" + getResponseCode() +
                " resultStatus=" + getResponseStatus() +
                " resultDesc=" + getResponseDesc() +
                " orders=" + getMenus() +
                " previousPage=" + getPreviousPage() +
                " nextPage=" + getNextPage() +
                " }";
    }
}
