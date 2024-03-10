package com.example.omealappproject;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> ResList;

    public Adapter (List<ModelClass> restaurants) {
        ResList = restaurants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View recView = inflater.inflate(R.layout.rec_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(recView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass restaurant = ResList.get(position);

        ImageView imageview = holder.newImageView;
        imageview.setImageResource(restaurant.getImageView());
        TextView textview1 = holder.newRName;
        textview1.setText(restaurant.getTextView1());
        TextView textview2 = holder.newRAddress;
        textview2.setText(restaurant.getTextView2());

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuActivity.class);
                intent.putExtra("restaurant",restaurant.getTextView1().toString());
                view.getContext().startActivity(intent);
            }
        });
        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuActivity.class);
                intent.putExtra("restaurant",restaurant.getTextView1().toString());
                view.getContext().startActivity(intent);
            }
        });
        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuActivity.class);
                intent.putExtra("restaurant",restaurant.getTextView1().toString());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ResList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView newImageView;
        public TextView newRName;
        public TextView newRAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            newImageView = (ImageView) itemView.findViewById(R.id.imageView01);
            newRName = (TextView) itemView.findViewById(R.id.textView01);
            newRAddress = (TextView) itemView.findViewById(R.id.textView02);
        }
    }


}
