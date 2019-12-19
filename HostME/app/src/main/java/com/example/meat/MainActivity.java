package com.example.meat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    LinearLayout host,profile,history,payment,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);
        host= (LinearLayout) findViewById(R.id.host);
        profile = (LinearLayout) findViewById(R.id.profile);
        history= (LinearLayout) findViewById(R.id.history);
        payment= (LinearLayout) findViewById(R.id.payment);
        logout= (LinearLayout) findViewById(R.id.logout);

        Boolean checkSession=db.checkSession("ada");
        if(checkSession==false){
            Intent loginIntent= new Intent(MainActivity.this,Login.class);
            startActivity(loginIntent);
            finish();
        }
        host.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(MainActivity.this, EatActivity.class);
                startActivity(a);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(b);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(b);
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(b);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean updateSession=db.upgradeSession("kosong",1);
                if(updateSession==true){
                    Toast.makeText(getApplicationContext(),"Berhasil Keluar",Toast.LENGTH_SHORT).show();
                    Intent loginIntent=new Intent(MainActivity.this,Login.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });
    }
}
