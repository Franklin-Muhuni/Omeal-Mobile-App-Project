package com.example.omealappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuActivity extends AppCompatActivity {

    public ArrayList<String> dishName = new ArrayList<>();
    public ArrayList<String> dishPrice = new ArrayList<>();
    public ArrayList<ModelClass2> dishes;
    Button go2Cart, go2restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intnet = getIntent();
        String restaurant = intnet.getStringExtra("restaurant");

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://omeal-app-project-default-rtdb.firebaseio.com");
        DatabaseReference ref = database.getReference("Food/" + restaurant);
        setContentView(R.layout.activity_menu);

        go2Cart = findViewById(R.id.gotoCart01);
        go2Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CartActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        go2restaurants = findViewById(R.id.returnShop01);
        go2restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String, Object> Food = (HashMap<String, Object>) snapshot.getValue();
                for (Map.Entry<String, Object> Rest: Food.entrySet()){
                    dishName.add(Rest.getKey());
                    dishPrice.add(Rest.getValue().toString());
                }
                RecyclerView recView = (RecyclerView) findViewById(R.id.MenuRec01);
                dishes = ModelClass2.createDishList(dishName, dishPrice);
                Adapter2 adapter = new Adapter2(dishes);
                recView.setAdapter(adapter);
                recView.setLayoutManager(new LinearLayoutManager(MenuActivity.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}