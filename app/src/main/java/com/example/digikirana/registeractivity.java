package com.example.digikirana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class registeractivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
        frameLayout=findViewById(R.id.registerframelayout);
        setFragment(new signinfragment());  // fragment to replace is signin

    }


    private void setFragment(Fragment fragment) {
        // to replace fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

}


