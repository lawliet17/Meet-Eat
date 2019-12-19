package com.example.meeteat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Detail1Activity extends AppCompatActivity {
    private Button kontak1;
    private Button lokasi1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        kontak1 = (Button) findViewById(R.id.btn_kontak1);
        lokasi1 = (Button) findViewById(R.id.btn_lokasi1);

        //kontak1 fitur
        kontak1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber ="082256006914";
                Intent dialPhoneIntent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +phoneNumber));
                startActivity(dialPhoneIntent);
            }
        });

        //lokasi1 fitur
        lokasi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc = "Sepakat 2";
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });
    }
}
