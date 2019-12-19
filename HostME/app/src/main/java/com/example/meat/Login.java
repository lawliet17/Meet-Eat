package com.example.meat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper db;
    private Button login;
    private Button daftar;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        email = (EditText) findViewById(R.id.login_input_email);
        password = (EditText) findViewById(R.id.login_input_password);

        login = (Button) findViewById(R.id.btn_masuk);
        login.setOnClickListener(this);

        daftar = (Button) findViewById(R.id.btn_daftar);
        daftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_daftar:
                Intent moveIntent = new Intent(Login.this, Register.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_masuk:
                String strEmail = email.getText().toString();
                String strPassword = password.getText().toString();


                Boolean masuk = db.checkLogin(strEmail, strPassword);
                if (masuk == true && email.length() != 0 && password.length() != 0) {
                    Boolean updateSession = db.upgradeSession("ada", 1);
                    if (updateSession == true) {
                        Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                        Intent mainIntent = new Intent(Login.this, MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    }
                }

                if (email.length() == 0) {
                    email.setError("Email Tidak Boleh Kosong");
                }
                if (password.length() == 0) {
                    password.setError("Password Tidak Boleh Kosong");
                }
                if(masuk == false)
                    Toast.makeText(getApplicationContext(), "Periksa kembali email dan password anda", Toast.LENGTH_SHORT).show();
        }
    }
}
