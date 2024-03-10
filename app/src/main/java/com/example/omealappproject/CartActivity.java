package com.example.omealappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    public ArrayList<String> dishName = new ArrayList<>();
    public ArrayList<String> dishPrice = new ArrayList<>();
    public ArrayList<ModelClass2> dishes;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    public static String totalNum;
    public TextView totalView1, tax, totalView2;
    String taxNum, cartNum;
    double cartTotal, taxTotal, subTotal;
    Button orderBtn, profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        dishName.addAll(Adapter2.items);
        dishPrice.addAll(Adapter2.items1);

        for(int i =0; i < dishPrice.size(); i++){
            String addToTotal = dishPrice.get(i).replace("$", "");
            cartTotal += Double.parseDouble(addToTotal);
            taxTotal = cartTotal * 0.13;
            subTotal = cartTotal + taxTotal;
        }

        RecyclerView recView = (RecyclerView) findViewById(R.id.CartRec01);
        dishes = ModelClass2.createDishList(dishName, dishPrice);
        Adapter2 adapter = new Adapter2(dishes);
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(CartActivity.this));

        totalView1 = findViewById(R.id.textView03);
        tax = findViewById(R.id.textView05);
        totalView2 = findViewById(R.id.textView07);

        cartNum = decfor.format(cartTotal);
        totalView1.setText(cartNum);

        taxNum = decfor.format(taxTotal);
        //tax.setText(Double.toString(taxTotal));
        tax.setText(taxNum);

        totalNum = decfor.format(subTotal);
        //totalNum = Double.toString(subTotal);
        totalView2.setText(totalNum);

        orderBtn = findViewById(R.id.orderButton01);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, CheckoutActivity.class));
            }
        });
        profileBtn = findViewById(R.id.profileButton01);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, ProfileActivity.class));
            }
        });
    }
}