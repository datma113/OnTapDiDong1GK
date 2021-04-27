package com.example.ontapgk_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    List<Product> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcvProduct);
        list.add(new Product("aaaa",333,"aaa",R.drawable.ic_launcher_background));
        list.add(new Product("bbbb",555,"aaa",R.drawable.ic_launcher_background));
        list.add(new Product("cccc",444,"aaa",R.drawable.ic_launcher_background));
        list.add(new Product("dddd",11,"aaa",R.drawable.ic_launcher_background));

        productAdapter = new ProductAdapter(list, this);

        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }
}