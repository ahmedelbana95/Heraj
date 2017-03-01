package com.example.anas.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    TextView tx_userNameIcon,tx_passWordIcon,tx_phoneIcon;
    EditText et_username,et_phone_register,et_password;
    String userName,password,phone;
    Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        et_password= (EditText) findViewById(R.id.id_password_register);
        et_username= (EditText) findViewById(R.id.id_username);
        et_phone_register= (EditText) findViewById(R.id.id_phoneRegister);

        tx_passWordIcon= (TextView) findViewById(R.id.id_passwordIcon_register);
        tx_phoneIcon= (TextView) findViewById(R.id.id_phoneIcon_register);
        tx_userNameIcon= (TextView) findViewById(R.id.id_username_icon);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=et_username.getText().toString();
                password=et_password.getText().toString();
                phone=et_phone_register.getText().toString();


            }
        });
    }

}
