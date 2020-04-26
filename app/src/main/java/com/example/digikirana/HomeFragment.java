package com.example.digikirana;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView mcategoryRecyclerView;
    private categoryadapter mcategoryadapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    ///horizontal product layout
    private TextView hlayouttitle;
    private Button hviewallbtn;
    private RecyclerView hrecyclerview;

    ///horizontal product layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mcategoryRecyclerView = view.findViewById(R.id.categoryrecyclerview);
        // layout setting for recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mcategoryRecyclerView.setLayoutManager((layoutManager));

        List<categorymodel> categorymodelList = new ArrayList<>(); // list
        categorymodelList.add(new categorymodel("link", "Home"));
        categorymodelList.add(new categorymodel("link", "Food"));
        categorymodelList.add(new categorymodel("link", "Stationery"));
        categorymodelList.add(new categorymodel("link", "Vegetables"));
        categorymodelList.add(new categorymodel("link", "Misc"));

        mcategoryadapter = new categoryadapter(categorymodelList);
        mcategoryRecyclerView.setAdapter(mcategoryadapter); // set with recycler view
        mcategoryadapter.notifyDataSetChanged();
///horizontal product layout assign
        hlayouttitle = view.findViewById(R.id.hsprotitle);
        hviewallbtn = view.findViewById(R.id.hslviewallbtn);
        hrecyclerview = view.findViewById(R.id.hslrecyclerview);
        //list

        List<Horizontalproductmodel> horizontalproductmodelList = new ArrayList<>();
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.atta, "Ashirwad", "Atta", "Rs 365"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.almonds, "ALmonds", "Dry fruit", "Rs 955"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.mask, "N95", "MASK", "Rs 450"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.maggie, "MAGGIE", "NOODLES", "Rs 54"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.detol, "DETTOL", "SANITIZER", "Rs 140"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.potato, "POTATO", "Vegetable", "Rs 45"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.oil, "FORTUNE", "OIL", "Rs 650"));
        horizontalproductmodelList.add(new Horizontalproductmodel(R.mipmap.jam, "KISSAN", "KETCHUP", "Rs 215"));


        //h scroll adapter
        Horizontalproductadpater horizontalproductadpater = new Horizontalproductadpater(horizontalproductmodelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hrecyclerview.setLayoutManager(linearLayoutManager);

        hrecyclerview.setAdapter(horizontalproductadpater);
        horizontalproductadpater.notifyDataSetChanged();
// / horizontal product layout
///tetsing multiple layout
/////////////testing////////////
        RecyclerView testing = view.findViewById(R.id.testing);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<Homepagemodel> homepagemodelList = new ArrayList<>();
        homepagemodelList.add(new Homepagemodel(0, "PRODUCTS AVAILABLE", horizontalproductmodelList));
        homepagemodelList.add(new Homepagemodel(1, " ON DISCOUNT ", horizontalproductmodelList));
        homepagemodelList.add(new Homepagemodel(0, "PRODUCTS AVAILABLE", horizontalproductmodelList));

        // LinearLayoutManager testingLayoutManger; //3.23 youyube 19part

        Homepageadapter adapter = new Homepageadapter(homepagemodelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
}

