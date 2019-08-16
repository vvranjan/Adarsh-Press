package com.example.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLogin extends AppCompatActivity {

    EditText userName, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        userName= findViewById(R.id.userName);
        password= findViewById(R.id.password);

    }


    private boolean validate()
    {
        String user= userName.getEditText()
    }


    public void login(View view)
    {
        Intent intent = new Intent(this,AdminDashboard.class);
        startActivity(intent);
    }
}
