package com.example.meeteat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper db;
    private Button masuk;
    private Button daftar;
    EditText nama,email,password,passwordcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=new DatabaseHelper(this);
        nama=(EditText) findViewById(R.id.regis_name);
        email=(EditText) findViewById(R.id.regis_email);
        password=(EditText) findViewById(R.id.regis_password);
        passwordcon=(EditText) findViewById(R.id.regis_password2);

        daftar=(Button) findViewById(R.id.tombol_daftar);
        daftar.setOnClickListener(this);

        masuk=(Button) findViewById(R.id.tombol_masuk);
        masuk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.tombol_masuk:
                Intent moveIntent = new Intent(RegisterActivity.this, Login.class);
                startActivity(moveIntent);
                break;
            case R.id.tombol_daftar:
                String strNama = nama.getText().toString();
                String strEmail = email.getText().toString();
                String strPassword = password.getText().toString();
                String strPasswordcon = passwordcon.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (strPassword.equals(strPasswordcon)) {
                    Boolean daftar = db.InsertUser(strEmail, strPassword);
                    if (daftar == true && email.length() != 0 && password.length() != 0 && nama.length() != 0 && passwordcon.length() != 0 && strEmail.matches(emailPattern)) {
                        Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                        Intent moveIntentt = new Intent(RegisterActivity.this, Login.class);
                        startActivity(moveIntentt);
                        finish();
                    }
                    if (!strEmail.matches(emailPattern)) {
                        email.setError("Periksa kembali email anda");
                    }

                    if (daftar == false) {
                        Toast.makeText(getApplicationContext(), "Periksa kembali data yang anda masukkan", Toast.LENGTH_SHORT).show();
                    }
                    if (nama.length() == 0) {
                        nama.setError("Nama Lengkap Tidak Boleh Kosong");
                    }
                    if (email.length() == 0) {
                        email.setError("Email Tidak Boleh Kosong");
                    }
                    if (password.length() == 0) {
                        password.setError("Password Tidak Boleh Kosong");
                    }
                    if (passwordcon.length() == 0) {
                        passwordcon.setError("Konfirmasi Password Tidak Boleh Kosong");
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Periksa kembali password anda", Toast.LENGTH_SHORT).show();
                }
        }

    }
}
