package com.example.digikirana;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Homepageadapter extends RecyclerView.Adapter {
    private List<Homepagemodel> homepagemodelList; // constructor

    public Homepageadapter(List<Homepagemodel> homepagemodelList) {
        this.homepagemodelList = homepagemodelList;
    }

    @Override // to know type of layout
    public int getItemViewType(int position) {
        switch (homepagemodelList.get(position).getType()) {
            case 0:
                return Homepagemodel.HORIZONTAL_PRODUCT_VIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case Homepagemodel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalproductview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontalscrolllayout, viewGroup);
                return new mHorizontalProductViewholder(horizontalproductview);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewholder, int position) {
        switch (homepagemodelList.get(position).getType()) {
            case Homepagemodel.HORIZONTAL_PRODUCT_VIEW:
                //acces title and list
                String title = homepagemodelList.get(position).getTitle();
                List<Horizontalproductmodel> horizontalproductmodelList = homepagemodelList.get(position).getHorizontalproductmodelList();
                ((mHorizontalProductViewholder) viewholder).setHorizontalproductlayout(horizontalproductmodelList, title);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class mHorizontalProductViewholder extends RecyclerView.ViewHolder {
        ///horizontal product layout
        private TextView hlayouttitle;
        private Button hviewallbtn;
        private RecyclerView hrecyclerview;

        ///horizontal product layout
        public mHorizontalProductViewholder(@NonNull View itemView) {
            super(itemView);
            // accessing view
            hlayouttitle = itemView.findViewById(R.id.hsprotitle);
            hviewallbtn = itemView.findViewById(R.id.hslviewallbtn);
            hrecyclerview = itemView.findViewById(R.id.hslrecyclerview);

        }

        private void setHorizontalproductlayout(List<Horizontalproductmodel> horizontalproductmodelList, String title) {
            hlayouttitle.setText(title);
            // if items are more than 6 we enable view all btn
            if (horizontalproductmodelList.size() > 6) {
                hviewallbtn.setVisibility(View.VISIBLE);
            } else {
                hviewallbtn.setVisibility(View.INVISIBLE);
            }
            //h scroll adapter
            Horizontalproductadpater horizontalproductadpater = new Horizontalproductadpater(horizontalproductmodelList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            hrecyclerview.setLayoutManager(linearLayoutManager);
            hrecyclerview.setAdapter(horizontalproductadpater);
            horizontalproductadpater.notifyDataSetChanged();
        }
    }
}
