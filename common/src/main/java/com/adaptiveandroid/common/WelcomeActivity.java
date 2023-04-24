package com.adaptiveandroid.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {
    private Button home_BTN_start;
    private TextView home_TV_MOBADS_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViews();
        initVars();
    }

    private void findViews() {
        home_TV_MOBADS_ID = findViewById(R.id.home_TV_MOBADS_ID);
        home_BTN_start = findViewById(R.id.home_BTN_start);
    }

    private void initVars() {
        home_TV_MOBADS_ID.setText(App_Parent.getMobAdsId());
        home_BTN_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            }
        });
    }
}