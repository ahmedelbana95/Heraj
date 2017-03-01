package com.example.anas.app;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton bt_myaccount,bt_menu,bt_msg,bt_add,bt_favourite;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_myaccount= (ImageButton) findViewById(R.id.bt_myaccount);
        bt_add= (ImageButton) findViewById(R.id.bt_add_ads);
        bt_favourite= (ImageButton) findViewById(R.id.bt_favourite);
        bt_menu= (ImageButton) findViewById(R.id.bt_menu);
        bt_msg= (ImageButton) findViewById(R.id.bt_msg);

        bt_myaccount.setOnClickListener(this);
        bt_menu.setOnClickListener(this);

        fragmentManager=getFragmentManager();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bt_menu :
                FragmentTransaction tr =fragmentManager.beginTransaction();
                tr.add(R.id.framlayout_main , new Categories());
                tr.commit();
                break;
            case R.id.bt_myaccount :
                FragmentTransaction tr1 =fragmentManager.beginTransaction();
                tr1.replace(R.id.framlayout_main , new Hesaby());
                tr1.commit();
                break;


        }
    }
}
