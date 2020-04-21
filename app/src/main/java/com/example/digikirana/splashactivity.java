package com.example.digikirana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

       SystemClock.sleep(2000);
       Intent loginintent = new Intent(splashactivity.this ,registeractivity.class);
       startActivity(loginintent); finish();
    }
}
