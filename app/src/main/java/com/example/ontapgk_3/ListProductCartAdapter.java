package com.example.ontapgk_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListProductCartAdapter extends RecyclerView.Adapter<ListProductCartAdapter.ListProductCartViewHolder> {

    List<CartItem> list = new ArrayList<>();
     LayoutInflater layoutInflater;
     Context context;

    public ListProductCartAdapter(List<CartItem> list, Context context) {
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ListProductCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_cart,parent, false);
        return new ListProductCartViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductCartViewHolder holder, int position) {
        CartItem cartItem = list.get(position);
        holder.tvName.setText(cartItem.getProduct().getName());
        holder.tvPrice.setText(cartItem.getProduct().getPrice() +"");
        holder.img.setImageResource(cartItem.getProduct().getImg());
        holder.tvQuantity.setText(cartItem.getQuantity() + "");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListProductCartViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvPrice;
        private TextView tvQuantity;
        private ImageView img;
        private ListProductCartAdapter listProductCartAdapter;

        public ListProductCartViewHolder(@NonNull View itemView, ListProductCartAdapter listProductCartAdapter) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName_cart);
            tvPrice = itemView.findViewById(R.id.tvPrice_cart);
            tvQuantity = itemView.findViewById(R.id.tvQuantity_cart);
            img = itemView.findViewById(R.id.imageView_cart);
            this.listProductCartAdapter = listProductCartAdapter;

        }
    }
}
