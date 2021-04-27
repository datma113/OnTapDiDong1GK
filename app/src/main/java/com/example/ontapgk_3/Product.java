package com.example.ontapgk_3;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private int price;
    private String detail;
    private int img;

    public Product(String name, int price, String detail, int img) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
