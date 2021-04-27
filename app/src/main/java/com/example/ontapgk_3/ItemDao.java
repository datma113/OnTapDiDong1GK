package com.example.ontapgk_3;

import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private static ItemDao instance = null;
    private List<CartItem> list;

    public ItemDao() {
        list = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        list.add(item);
    }

    public static ItemDao getInstance() {
        if(instance == null)
            instance = new ItemDao();
        return instance;
    }

    public List<CartItem> getList() {
        return list;
    }
}
