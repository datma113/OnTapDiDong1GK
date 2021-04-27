package com.example.ontapgk_3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> list = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public ProductAdapter(List<Product> list, Context context) {
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list, parent,false);
        return new ProductViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product product = list.get(position);
        holder.tvName.setText(product.getName());
        holder.price.setText(product.getPrice() + "$");
        holder.img.setImageResource(product.getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetails.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable("product", product);
                intent.putExtras(bundle);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ProductAdapter productAdapter;
        private TextView tvName;
        private TextView price;
        private ImageView img;
        public ProductViewHolder(@NonNull View itemView, ProductAdapter productAdapter) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.price = itemView.findViewById(R.id.tvPrice);
            this.img = itemView.findViewById(R.id.imgView);
            this.productAdapter = productAdapter;
        }
    }
}
