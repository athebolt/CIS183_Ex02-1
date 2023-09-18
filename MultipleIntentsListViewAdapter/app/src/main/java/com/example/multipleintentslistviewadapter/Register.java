package com.example.multipleintentslistviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity
{
    Button btn_v_r_back;
    Intent int_j_welcomeIntent;
    Button btn_j_r_register;
    EditText et_j_r_fName;
    EditText et_j_r_lName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_v_r_back = findViewById(R.id.btn_v_r_back);
        btn_j_r_register = findViewById(R.id.btn_v_r_register);
        et_j_r_fName = findViewById(R.id.et_v_r_fName);
        et_j_r_lName = findViewById(R.id.et_v_r_lName);
        int_j_welcomeIntent = new Intent(Register.this, MainActivity.class);

        //code to get info pass from MainActivity.java
        //get the intent that called me
        Intent cameFrom = getIntent();
        //get the bundle that was to me from "cameFrom" intent
        Bundle infoPassedToMe = cameFrom.getExtras();
        //get the info in the bundle called "InfoPassed" set in MainActivity.java
        String info = infoPassedToMe.getString("InfoPassed");
        //display message passed from MainActivity.java
        Log.d("Info passed from main: ", info);


        backButtonEventHandler();
        registerButtonEventHandler();
    }

    public void backButtonEventHandler()
    {
        btn_v_r_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(int_j_welcomeIntent);
            }
        });
    }

    public void registerButtonEventHandler()
    {
        btn_j_r_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName;

                String fName = et_j_r_fName.getText().toString();
                String lName = et_j_r_lName.getText().toString();

                fullName = fName + " " + lName;
                //Passing info to MainActivity
                //First Value: name of info to pass.
                //Second Value: What you want to pass.
                int_j_welcomeIntent.putExtra("Name",fullName);
                //load the intent
                startActivity(int_j_welcomeIntent);
            }
        });
    }

}