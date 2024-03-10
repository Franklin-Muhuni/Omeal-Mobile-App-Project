package com.example.omealappproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {

    private List<ModelClass2> ResList;
    public static ArrayList<String> items = new ArrayList<String>();
    public static ArrayList<String> items1 = new ArrayList<String>();


    public Adapter2 (List<ModelClass2> restaurants) {
        ResList = restaurants;
    }

    @NonNull
    @Override
    public Adapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View recView = inflater.inflate(R.layout.rec2_items, parent, false);

        Adapter2.ViewHolder viewHolder = new Adapter2.ViewHolder(recView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass2 restaurant = ResList.get(position);

        TextView textview1 = holder.newDName;
        textview1.setText(restaurant.getResName());
        TextView textview2 = holder.newDPrice;
        textview2.setText(restaurant.getResPrice());
        Button addcart = holder.add2Cart;
        Button subcart = holder.sub2Cart;

        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(restaurant.getResName());
                items1.add(restaurant.getResPrice());
                Toast.makeText(view.getContext(), "Item added to cart", Toast.LENGTH_SHORT).show();
                if (view.getContext().toString().contains("CartActivity")) {
                    Intent i = new Intent(view.getContext(), CartActivity.class);
                    view.getContext().startActivity(i);
                    ((CartActivity) view.getContext()).finish();
                }
            }
        });

        subcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(restaurant.getResName());
                items1.remove(restaurant.getResPrice());
                Toast.makeText(view.getContext(), "Item removed from cart", Toast.LENGTH_SHORT).show();
                if (view.getContext().toString().contains("CartActivity")){
                    Intent i = new Intent(view.getContext(), CartActivity.class);
                    view.getContext().startActivity(i);
                    ((CartActivity)view.getContext()).finish();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ResList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView newDName;
        public TextView newDPrice;
        public Button add2Cart, sub2Cart;

        public ViewHolder(View itemView) {
            super(itemView);
            newDName = (TextView) itemView.findViewById(R.id.textView01);
            newDPrice = (TextView) itemView.findViewById(R.id.textView02);
            add2Cart = (Button) itemView.findViewById(R.id.addtoCartbtn01);
            sub2Cart = (Button) itemView.findViewById(R.id.addtoCartbtn02);
        }
    }
}
