package com.nicholas.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    View fragment;
    Button btnFrag1, btnFrag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();

        Bundle bl = getIntent().getBundleExtra("bundleUserData");

        String strUsername = bl.getString("username");
        String strPassword = bl.getString("password");

        String strIntentData = "Username: " + strUsername +
                "\nPassword: " + strPassword;
        textView.setText(strIntentData);

        btnFrag1.setOnClickListener(this);
        btnFrag2.setOnClickListener(this);
    }

    private void initView() {
        textView = findViewById(R.id.txtData);
        fragment = findViewById(R.id.fragment1);
        btnFrag1 = findViewById(R.id.btnFrag1);
        btnFrag2 = findViewById(R.id.btnFrag2);
    }

    @Override
    public void onClick(View view) {
        FragmentManager fm;
        FragmentTransaction ft;
        switch (view.getId()) {
            case R.id.btnFrag1:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment1, new Fragment1());
                ft.commit();
                break;
            case R.id.btnFrag2:
                // Untuk menambahkan fragment
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment1, new Fragment2());
                ft.commit();
                break;
        }
    }
}