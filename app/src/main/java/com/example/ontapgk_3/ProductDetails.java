
package com.example.ontapgk_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    TextView tvName, tvPrice, tvDetails, tvQuantity;
    ImageButton ibtnAdd, ibtnRemove;
    Button addToCart;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Bundle bundle = getIntent().getExtras();
        Product product = (Product) bundle.getSerializable("product");

        tvName = findViewById(R.id.tvName_pd);
        tvPrice = findViewById(R.id.tvPrice_pd);
        tvDetails = findViewById(R.id.tv_details_pd);
        tvQuantity = findViewById(R.id.tvQuantity_pd);
        ibtnRemove = findViewById(R.id.ibtnRemove);
        ibtnAdd = findViewById(R.id.ibtnAdd);
        img = findViewById(R.id.imageView_pd);

        img.setImageResource(product.getImg());
        tvName.setText(product.getName());
        tvPrice.setText(product.getPrice() +"");
        tvDetails.setText(product.getDetail());
        tvQuantity.setText("1");

        ibtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tvQuantity.getText().toString());
                i++;
                tvQuantity.setText(i+ "");
            }
        });

        ibtnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tvQuantity.getText().toString());
                if( i > 1) {
                    i--;
                }
                tvQuantity.setText(i+ "");
            }
        });


        addToCart = findViewById(R.id.addToCart);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, ListProductInCart.class);
                Bundle bundle = new Bundle();
                CartItem cartItem = new CartItem(product, Integer.parseInt(tvQuantity.getText().toString()));
                bundle.putSerializable("item", cartItem);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}