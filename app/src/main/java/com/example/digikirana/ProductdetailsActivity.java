package com.example.digikirana;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductdetailsActivity extends AppCompatActivity {
    private static boolean xALREADY_ADDED_TO_WISHLIST = false;
    //variables
    private ViewPager xproductImagesViewpager;
    private TabLayout xviewpagerIndicator;
    private FloatingActionButton xaddtowishlistbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false); // remove default title for custom logo show
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // back button
        //view defined
        xproductImagesViewpager = findViewById(R.id.product_image_viewpager);
        xviewpagerIndicator = findViewById(R.id.viewpager_indicator);
        xaddtowishlistbtn = findViewById(R.id.floatingActionButton);
        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.maggie1);
        productImages.add(R.drawable.maggie2);
        productImages.add(R.drawable.maggie3);
        productImages.add(R.drawable.maggie4);

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        xproductImagesViewpager.setAdapter(productImagesAdapter);

        xviewpagerIndicator.setupWithViewPager(xproductImagesViewpager, true);
        // click on click listener btn wishlist
        xaddtowishlistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (xALREADY_ADDED_TO_WISHLIST) {
                    xALREADY_ADDED_TO_WISHLIST = false; // false not added and grey star
                    xaddtowishlistbtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#FF706E60")));
                } else {
                    xALREADY_ADDED_TO_WISHLIST = true; // and set color yellow star
                    xaddtowishlistbtn.setSupportImageTintList(getResources().getColorStateList(R.color.yellow));

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.searchicon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handles action bar item clicks
        int id = item.getItemId();
        if (id == android.R.id.home) {
            //todo: home
            finish();
            return true;
        } else if (id == R.id.mainsearchicon) {
            //todo:searchicon
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
