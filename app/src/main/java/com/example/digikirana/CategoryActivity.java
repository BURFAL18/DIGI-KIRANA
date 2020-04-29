package com.example.digikirana;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView mcategoryrecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //

        mcategoryrecyclerview = findViewById(R.id.category_recyclerview);

//list
        List<Horizontalproductmodel> horizontalproductmodelList = new ArrayList<>();
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.atta, "Ashirwad", "Atta", "Rs 365"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.almonds, "ALmonds", "Dry fruit", "Rs 955"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.mask, "N95", "MASK", "Rs 450"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.drawable.lays, "LAYS", "CHIPS", "Rs 25"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.maggie, "MAGGIE", "NOODLES", "Rs 54"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.detol, "DETTOL", "SANITIZER", "Rs 140"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.potato, "POTATO", "Vegetable", "Rs 45"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.oil, "FORTUNE", "OIL", "Rs 650"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.jam, "KISSAN", "KETCHUP", "Rs 215"));

///tetsing multiple layout
/////////////testing////////////


        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mcategoryrecyclerview.setLayoutManager(testingLayoutManager);


        List<Homepagemodel> homepagemodelList = new ArrayList<>();
        homepagemodelList.add(new Homepagemodel(0, R.drawable.strip, "#000000"));
        homepagemodelList.add(new Homepagemodel(1, horizontalproductmodelList));
        homepagemodelList.add(new Homepagemodel(0, R.drawable.stripoffer, "#FFFF00"));

        Homepageadapter adapter = new Homepageadapter(homepagemodelList);
        mcategoryrecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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
        if (id == R.id.mainsearchicon) {
            //todo: searchicon
            return true;
        } else if (id == android.R.id.home) // back key
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
