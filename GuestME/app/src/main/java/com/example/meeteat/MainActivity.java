package com.example.meeteat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button logout;
    private Button searchh,profil,booking,payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);
        logout=(Button)findViewById(R.id.btn_logout);
        searchh=(Button)findViewById(R.id.search);
        profil=(Button)findViewById(R.id.profil);
        booking=(Button)findViewById(R.id.booking);
        payment=(Button)findViewById(R.id.payment);
        Boolean checkSession=db.checkSession("ada");
        if(checkSession==false){
            Intent loginIntent= new Intent(MainActivity.this,Login.class);
            startActivity(loginIntent);
            finish();
        }

        //logout
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

        //search fitur
        searchh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent SearchIntenttt=new Intent(MainActivity.this,SearchActivity.class);
                    startActivity(SearchIntenttt);

                }
        });
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntenttt=new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(ProfileIntenttt);

            }
        });
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntenttt=new Intent(MainActivity.this,BookingActivity.class);
                startActivity(ProfileIntenttt);

            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntenttt=new Intent(MainActivity.this,PaymentActivity.class);
                startActivity(ProfileIntenttt);

            }
        });
    }
}
