package com.example.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void adminLogin(View view){
        Intent intent = new Intent(this,AdminLogin.class);
        startActivity(intent);

    }

    public void employeeLogin(View view){
        Intent intent = new Intent(this,EmployeeLogin.class);
        startActivity(intent);

    }
}
