package com.example.omealappproject;

import java.util.ArrayList;

public class ModelClass {
    private int imageView;
    private String textView1;
    private String textView2;

    public ModelClass(int rImage, String rName, String rAddress) {
        imageView = rImage;
        textView1 = rName;
        textView2 = rAddress;
    }

    public int getImageView(){
        return imageView;
    }
    public String getTextView1(){
        return textView1;
    }
    public String getTextView2(){
        return textView2;
    }

    public static ArrayList<ModelClass> createResList() {
        ArrayList<ModelClass> restaurants = new ArrayList<ModelClass>();
        restaurants.add(new ModelClass(R.drawable.subwaypic, "Subway", "2069 Simcoe Street North"));
        restaurants.add(new ModelClass(R.drawable.burgerfactorypic, "Burger Factory", "53 Conlin Road East"));
        restaurants.add(new ModelClass(R.drawable.osmowspic, "Osmow's Shawarma", "1812 Simcoe Street North"));
        restaurants.add(new ModelClass(R.drawable.lazeezpic, "Lazeez Shawarma", "1812 Simcoe Street North"));
        restaurants.add(new ModelClass(R.drawable.bbburitopic, "Bang Bang Burrito", "1812 Simcoe Street North"));
        restaurants.add(new ModelClass(R.drawable.stlouispic, "St Louis Bar & Grill", "1812 Simcoe Street North"));
        restaurants.add(new ModelClass(R.drawable.cocopics, "CoCo Fresh Tea & Juice", "1800 Simcoe Street North"));
        restaurants.add(new ModelClass(R.drawable.popeyes, "Popeyes Louisiana Chicken", "1800 Simcoe Street North"));
        restaurants.add(new ModelClass(R.drawable.fatburritopic, "Fat Bastard Burrito & Co", "1800 Simcoe Street North"));
        restaurants.add(new ModelClass(R.drawable.mrsubpic, "Mr Sub", "2620 Simcoe Street North"));
        return restaurants;
    }
}
