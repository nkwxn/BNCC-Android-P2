package com.nicholas.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etUsername;
    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                Bundle b = new Bundle();
                b.putString("username", username);
                b.putString("password", password);
                i.putExtra("bundleUserData", b);
                startActivity(i);
            }
        });
    }

    private void initView() {
        etUsername = findViewById(R.id.etxUsername);
        etPassword = findViewById(R.id.etxPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
}