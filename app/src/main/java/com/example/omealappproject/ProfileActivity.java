package com.example.omealappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    Button submit, back2Cart;
    public EditText emailP, cNumP, expDateP, cvcP, nameP, countryP, addressP, cityP, zipP, provinceP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    protected void onResume() {
        super.onResume();
        emailP = findViewById(R.id.editTextEmailP);
        cNumP = findViewById(R.id.editTextCNUMP);
        expDateP = findViewById(R.id.editTextDateP);
        cvcP = findViewById(R.id.editTextINUMP);
        nameP = findViewById(R.id.editTextuNameP);
        countryP = findViewById(R.id.editTextCountryP);
        addressP = findViewById(R.id.editTextAddressP);
        cityP = findViewById(R.id.editTextCityP);
        zipP = findViewById(R.id.editTextZIPP);
        provinceP = findViewById(R.id.editTextProvinceP);

        submit = findViewById(R.id.submitButton01);
        submit.setOnClickListener(view -> {
            updateProfile();
        });
        back2Cart = findViewById(R.id.submitButton02);
        back2Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, CartActivity.class));
            }
        });
    }
    private void updateProfile(){
        ProfileDatabase db = Room.databaseBuilder(getApplicationContext(), ProfileDatabase.class,
                "profile.database").allowMainThreadQueries().build();

        String email = emailP.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailP.setError("Email missing");
        }
        String cNum = cNumP.getText().toString();
        if (TextUtils.isEmpty(cNum)) {
            cNumP.setError("Credit card number missing");
        }
        String expDate = expDateP.getText().toString();
        if (TextUtils.isEmpty(expDate)) {
            expDateP.setError("Expiry date missing");
        }
        String cvc = cvcP.getText().toString();
        if (TextUtils.isEmpty(cvc)) {
            cvcP.setError("Institution number missing");
        }
        String name = nameP.getText().toString();
        if (TextUtils.isEmpty(name)) {
            nameP.setError("Name missing");
        }
        String country = countryP.getText().toString();

        String address = addressP.getText().toString();
        if (TextUtils.isEmpty(address)) {
            addressP.setError("Street Address missing");
        }
        String city = cityP.getText().toString();
        if (TextUtils.isEmpty(city)) {
            cityP.setError("City Missing");
        }
        String zip = zipP.getText().toString();
        if (TextUtils.isEmpty(zip)) {
            zipP.setError("Zip Code Missing");
        }
        String province = provinceP.getText().toString();
        if (TextUtils.isEmpty(province)) {
            provinceP.setError("Province missing");
        }
        Profile user = new Profile(email, cNum, expDate, cvc, name, country, address, city,
                zip, province);
        db.profileDao().insertAll(user);
    }
}