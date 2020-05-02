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


/**
 * A simple {@link Fragment} subclass.
 */
public class Mywishlist extends Fragment {

    private RecyclerView xwishlistrecyclerview;

    public Mywishlist() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mywishlist, container, false);
        xwishlistrecyclerview = view.findViewById(R.id.my_wishlist_recyclerview); // layout link and layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xwishlistrecyclerview.setLayoutManager(linearLayoutManager);
        // list of item in wishlist
        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.maggie1, "Masala Maggie", "Rs350/-"));
        wishlistModelList.add(new WishlistModel(R.drawable.lays, "Lays", "Rs 25/-"));
        wishlistModelList.add(new WishlistModel(R.drawable.almonds, "Almonds", "Rs 800/-"));
        wishlistModelList.add(new WishlistModel(R.drawable.detol, "Sanitizer", "Rs 150/-"));
        //set adapter for wishlist
        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList);
        xwishlistrecyclerview.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();
        return view;

    }
}
