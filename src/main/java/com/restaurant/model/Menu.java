package com.restaurant.model;

import java.util.ArrayList;

/**
 * Created by khwanchanok on 4/21/2018 AD.
 */
public class Menu {
    private String name;
    private String description;
    private String image;
    private int price;
    private String[] additional;

    public Menu(){}

    public Menu(String name, String description, String image, int price){
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String[] getAdditional() {
        return additional;
    }

    public void setAdditional(String[] additional) {
        this.additional = additional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Menu [" +
                "name=" + getName() +
                "description=" + getDescription() +
                "image=" + getImage() +
                "price=" + getPrice() +
                "additional=" + getAdditional() +
                "]";
    }
}
