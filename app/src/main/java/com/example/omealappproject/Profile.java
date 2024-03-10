package com.example.omealappproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity
public class Profile {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "cardNum")
    public String cardNum;

    @ColumnInfo(name = "expDate")
    public String expDate;

    @ColumnInfo(name = "CVC")
    public String cvc;

    @ColumnInfo(name = "fullName")
    public String name;

    @ColumnInfo(name = "country")
    public String country;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "zip")
    public String zip;

    @ColumnInfo(name = "province")
    public String province;

    public Profile(String email, String cardNum, String expDate, String cvc, String name,
                   String country, String address, String city, String zip, String province){
        this.email = email;
        this.cardNum = cardNum;
        this.expDate = expDate;
        this.cvc = cvc;
        this.name = name;
        this.country = country;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.province = province;
    }
}
