package com.example.omealappproject;

import android.widget.Button;

import java.util.ArrayList;

public class ModelClass2 {
    String dName;
    String dPrice;

    public ModelClass2 (String dishName, String dishPrice){
        dName = dishName;
        dPrice = dishPrice;
    }

    public String getResName() {
        return dName;
    }
    public String getResPrice() {
        return dPrice;
    }

    public static ArrayList<ModelClass2> createDishList(ArrayList<String> name, ArrayList<String> price) {
        ArrayList<ModelClass2> dishData = new ArrayList<>();
        for (int i = 0; i < name.size(); i++){
            dishData.add(new ModelClass2(name.get(i), price.get(i)));
        }
        return dishData;
    }
}
