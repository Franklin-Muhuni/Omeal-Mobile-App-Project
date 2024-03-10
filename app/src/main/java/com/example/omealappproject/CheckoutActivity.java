package com.example.omealappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    EditText emailC, cNumC, expDateC, cvcC, nameC, countryC, addressC, cityC, zipC, provinceC;
    Button buyBtn;
    String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        emailC = findViewById(R.id.editTextEmail);
        cNumC = findViewById(R.id.editTextCNUM);
        expDateC = findViewById(R.id.editTextDate);
        cvcC = findViewById(R.id.editTextINUM);
        nameC = findViewById(R.id.editTextuName);
        countryC = findViewById(R.id.editTextCountry);
        addressC = findViewById(R.id.editTextAddress);
        cityC = findViewById(R.id.editTextCity);
        zipC = findViewById(R.id.editTextZIP);
        provinceC = findViewById(R.id.editTextProvince);
        buyBtn = findViewById(R.id.payButton01);

        amount = CartActivity.totalNum;
        buyBtn.setText("Pay $" + amount);

        ProfileDatabase db = Room.databaseBuilder(getApplicationContext(), ProfileDatabase.class,
                "profile.database").allowMainThreadQueries().build();

        List<Profile> profileList = db.profileDao().getAllProfiles();
        for (Profile list: profileList) {
            emailC.setText(list.email);
            cNumC.setText(list.cardNum);
            expDateC.setText(list.expDate);
            cvcC.setText(list.cvc);
            nameC.setText(list.name);
            countryC.setText(list.country);
            addressC.setText(list.address);
            cityC.setText(list.city);
            zipC.setText(list.zip);
            provinceC.setText(list.province);
        }
    }
}