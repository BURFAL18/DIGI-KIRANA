package com.example.digikirana;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mcategoryRecyclerView = view.findViewById(R.id.categoryrecyclerview);
        // layout setting for recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mcategoryRecyclerView.setLayoutManager((layoutManager));

        List<categorymodel> categorymodelList = new ArrayList<categorymodel>(); // list
        categorymodelList.add(new categorymodel("link", "Home"));
        categorymodelList.add(new categorymodel("link", "Food"));
        categorymodelList.add(new categorymodel("link", "Stationery"));
        categorymodelList.add(new categorymodel("link", "Vegetables"));
        categorymodelList.add(new categorymodel("link", "Misc"));

        mcategoryadapter = new categoryadapter(categorymodelList);
        mcategoryRecyclerView.setAdapter(mcategoryadapter); // set with recycler view
        mcategoryadapter.notifyDataSetChanged();

        return view;
    }
}

