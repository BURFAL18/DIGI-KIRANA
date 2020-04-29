package com.example.digikirana;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView testing;
    private RecyclerView xcategoryRecyclerView;
    private categoryadapter xcategoryadapter;

    /*
        ////////strip ad layout //////////////
        private ImageView stripAdImage;
        private ConstraintLayout stripAdContainer;
    ////////strip ad layout//////////////
    ////////horizontal product layout.//////////
        private TextView hlayouttitle;
        private Button hviewallbtn;
        private RecyclerView hrecyclerview;
        ////////horizontal product layout.//////////
    */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //  View view=  super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.xfragment_home, container, false);
        xcategoryRecyclerView = view.findViewById(R.id.xcategory_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        xcategoryRecyclerView.setLayoutManager(layoutManager);
        List<categorymodel> categorymodelList = new ArrayList<>(); // list
        categorymodelList.add(new categorymodel("link", "Home"));
        categorymodelList.add(new categorymodel("link", "Food"));
        categorymodelList.add(new categorymodel("link", "Grocery"));
        categorymodelList.add(new categorymodel("link", "Fruits"));
        categorymodelList.add(new categorymodel("link", "Misc"));
        categorymodelList.add(new categorymodel("link", "DAILY"));
        categorymodelList.add(new categorymodel("link", "BASIC"));
        categorymodelList.add(new categorymodel("link", "CLOTHES"));
        categorymodelList.add(new categorymodel("link", "WORK"));

        xcategoryadapter = new categoryadapter(categorymodelList);
        xcategoryRecyclerView.setAdapter(xcategoryadapter);
        xcategoryadapter.notifyDataSetChanged();
/*
        ////////strip ad layout assign //////////////
        stripAdImage=view.findViewById(R.id.stripadimage);
        stripAdContainer=view.findViewById(R.id.stripadcontainer);

        stripAdImage.setImageResource(R.drawable.strip);
        stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));
        ////////strip ad layout //////////////

        ////////horizontal product layout.//////////

        hlayouttitle = view.findViewById(R.id.hsprotitle);
        hviewallbtn = view.findViewById(R.id.hslviewallbtn);

       hrecyclerview = view.findViewById(R.id.hslrecyclerview);

 */
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

        //h scroll adapter
/*
        Horizontalproductadpater horizontalproductadpater = new Horizontalproductadpater(horizontalproductmodelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hrecyclerview.setLayoutManager(linearLayoutManager);

        hrecyclerview.setAdapter(horizontalproductadpater);
        horizontalproductadpater.notifyDataSetChanged();
  */      ////////horizontal product layout.//////////
        /////////////////testing//////////////////////////
        RecyclerView testing = view.findViewById(R.id.testing);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);


        List<Homepagemodel> homepagemodelList = new ArrayList<>();
        homepagemodelList.add(new Homepagemodel(0, R.drawable.strip, "#000000"));
        homepagemodelList.add(new Homepagemodel(1, horizontalproductmodelList));
        homepagemodelList.add(new Homepagemodel(0, R.drawable.stripoffer, "#000000"));
        homepagemodelList.add(new Homepagemodel(1, horizontalproductmodelList));
        homepagemodelList.add(new Homepagemodel(0, R.drawable.striphealth, "#FFFFFF"));



        Homepageadapter adapter = new Homepageadapter(homepagemodelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        /////////////////testing//////////////////////////
        return view;
        // return super.onCreateView(inflater, container, savedInstanceState);

    }
}