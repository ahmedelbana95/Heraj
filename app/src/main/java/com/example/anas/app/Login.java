package com.example.anas.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    String phone,password;
    EditText et_password,et_phone;
    TextView tx_forgetPassword,tx_newAccount;
    Button login;

    private CheckBox saveLoginCheckBox;
    private SharedPreferences pref;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView tx_phoneicon = (TextView)findViewById(R.id.phoneIcon);
        TextView tx_passwordicon= (TextView)findViewById(R.id.passwordIcon);

        et_password= (EditText) findViewById(R.id.password_id);
        et_phone= (EditText) findViewById(R.id.Phone_id);
        login = (Button) findViewById(R.id.bt_login);
        tx_forgetPassword= (TextView) findViewById(R.id.forgetpassword_id);
        tx_newAccount= (TextView) findViewById(R.id.tx_newaccount_id);
        saveLoginCheckBox= (CheckBox) findViewById(R.id.check_remember_id);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        tx_phoneicon.setTypeface(font);
        tx_passwordicon.setTypeface(font);


        pref=getSharedPreferences("loginPrefs", MODE_PRIVATE);
        saveLogin=pref.getBoolean("saveLogin", false);
        if (saveLogin==true){

            et_phone.setText(pref.getString("phone", ""));
            et_password.setText(pref.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }
        saveLoginCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                loginPrefsEditor=pref.edit()
                        .putString("phone",et_phone.getText().toString())
                        .putString("password",et_password.getText().toString())
                        .putBoolean("saveLogin",true);
                loginPrefsEditor.commit();


//                if (saveLoginCheckBox.isChecked()) {
//                    loginPrefsEditor.putBoolean("saveLogin", true);
//                    loginPrefsEditor.putString("phone", phone);
//                    loginPrefsEditor.putString("password", password);
//                    loginPrefsEditor.commit();
//                } else {
//                    loginPrefsEditor.clear();
//                    loginPrefsEditor.commit();
//                }
//
//                doSomethingElse();
//
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                password=et_password.getText().toString();
                phone=et_phone.getText().toString();

            }
        });

        tx_newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        tx_forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Login.this,"hhhhhhhhhhh",Toast.LENGTH_LONG).show();
            }
        });
    }

//    public void doSomethingElse() {
//        startActivity(new Intent(Login.this, MainActivity.class));
//        Login.this.finish();
//    }
}
