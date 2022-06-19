package com.example.silver_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class User_page extends AppCompatActivity {

    Button user_edit, logout;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        user_edit = findViewById(R.id.user_edit);
        logout = findViewById(R.id.logout);
        tv = findViewById(R.id.user_text);




        SharedPreferences sf=getSharedPreferences("Account Details", Context.MODE_PRIVATE);
        String phone = sf.getString("phone", "");
        String email = sf.getString("email", "");
        String user = sf.getString("user", "");
        String city = sf.getString("city", "");



        String name_sp = sf.getString("Name", user);
        String email_sp = sf.getString("Email", email);
        String phone_sp = sf.getString("Phone", phone);
        String city_sp = sf.getString("City", city);

        String out = "Name :" +name_sp+ "\n" + "Email  :"+ email_sp + "\n" + "Phone No :" + phone_sp + "\n" + "City  :" + city_sp;
        tv.setText(out);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sf = getSharedPreferences("Verify", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sf.edit();
                edit.putBoolean("Register Bool", false);
                edit.apply();
                Intent intent = new Intent(getApplicationContext(), login_page.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                User_page.this.finish();
            }
        });

        user_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u_edit = new Intent(getApplicationContext(), User_edit_page.class);
                startActivity(u_edit);
            }
        });
    }
}