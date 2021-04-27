package com.example.ontapgk_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListProductInCart extends AppCompatActivity {
    RecyclerView recyclerView;
    List<CartItem> list = new ArrayList<>();
    ListProductCartAdapter listProductCartAdapter;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_in_cart);

        recyclerView = findViewById(R.id.rcvItemCart);
        Bundle bundle = getIntent().getExtras();
        CartItem cartItem = (CartItem) bundle.get("item");

         ItemDao dao = ItemDao.getInstance();
         dao.addItem(cartItem);
         list = dao.getList();

         listProductCartAdapter = new ListProductCartAdapter(list, this);
         recyclerView.setAdapter(listProductCartAdapter);
         recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

         btn = findViewById(R.id.backToHome);
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(ListProductInCart.this, MainActivity.class);
                 startActivity(intent);
             }
         });
    }
}