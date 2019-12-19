package com.example.meeteat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {
    private Button detail1;
    private Button detail2;
    private Button detail3;
    private Button detail4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        detail1 = (Button) findViewById(R.id.button1);
        detail2 = (Button) findViewById(R.id.button2);
        detail3 = (Button) findViewById(R.id.button3);
        detail4 = (Button) findViewById(R.id.button4);

        //detail1 fitur
        detail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail1ac = new Intent(SearchActivity.this, Detail1Activity.class);
                startActivity(detail1ac);

            }
        });
        detail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail1ac = new Intent(SearchActivity.this, Detail2Activity.class);
                startActivity(detail1ac);

            }
        });
        detail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail1ac = new Intent(SearchActivity.this, Detail3Activity.class);
                startActivity(detail1ac);

            }
        });
        detail4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail1ac = new Intent(SearchActivity.this, Detail4Activity.class);
                startActivity(detail1ac);

            }
        });
    }
}
