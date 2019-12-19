package com.example.meat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HistoryActivity extends AppCompatActivity {
    private Button detailh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        detailh= (Button) findViewById(R.id.detailh);

        detailh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(HistoryActivity.this, DetailHistoryActivity.class);
                startActivity(a);
            }
        });
    }
}
