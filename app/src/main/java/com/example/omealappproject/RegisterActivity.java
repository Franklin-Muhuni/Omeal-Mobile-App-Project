package com.example.omealappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText regEmail, regPass;
    TextView logLink;
    Button registerBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();

        regEmail = findViewById(R.id.editTextReg01);
        regPass = findViewById(R.id.editTextReg02);
        logLink = findViewById(R.id.LogText02);
        registerBtn = findViewById(R.id.RegButton01);

        registerBtn.setOnClickListener(view -> {
            createUser();
        });
        logLink.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }
    private void createUser(){
        String email = regEmail.getText().toString();
        String password = regPass.getText().toString();

        if (TextUtils.isEmpty(email)){
            regEmail.setError("Email field cannot be empty");
        }else if (TextUtils.isEmpty(password)){
            regPass.setError("Password field cannot be empty");
        }else{
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}