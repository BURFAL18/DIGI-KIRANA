package com.example.digikirana;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Homepageadapter extends RecyclerView.Adapter {

    private List<Homepagemodel> homepagemodelList; // constructor
    private RecyclerView.RecycledViewPool recycledViewPool;

    public Homepageadapter(List<Homepagemodel> homepagemodelList) {
        this.homepagemodelList = homepagemodelList;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public int getItemViewType(int position) {
        switch (homepagemodelList.get(position).getType()) {
            case 0:
                return Homepagemodel.STRIP_AD_BANNER;
            case 1:
                return Homepagemodel.HORIZONTAL_PRODUCT_VIEW;

            default:
                return -1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case Homepagemodel.STRIP_AD_BANNER:
                View stripadview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stripadlayout, viewGroup, false);
                return new StripAdBannerViewholder(stripadview);
            case Homepagemodel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalProductview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontalscrolllayout, viewGroup, false);
                return new HorizontalProductViewHolder(horizontalProductview);
            default:
                return null;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (homepagemodelList.get(position).getType()) {
            case Homepagemodel.STRIP_AD_BANNER:
                int resource = homepagemodelList.get(position).getResource();
                String color = homepagemodelList.get(position).getBackgroundcolor();
                ((StripAdBannerViewholder) viewHolder).setStripAd(resource, color);
                break;
            case Homepagemodel.HORIZONTAL_PRODUCT_VIEW:
                //access list and title
                List<Horizontalproductmodel> horizontalproductmodelList = homepagemodelList.get(position).getHorizontalproductmodelList();
                //casting calling viewholder class and parameters
                ((HorizontalProductViewHolder) viewHolder).setHorizontalproductlayout(horizontalproductmodelList);
                break;
            default:
                return;
        }
    }


    @Override
    public int getItemCount() {
        return homepagemodelList.size();
    }

    //classs
    public class StripAdBannerViewholder extends RecyclerView.ViewHolder {
        private ImageView stripAdImage;
        private ConstraintLayout stripAdContainer;

        public StripAdBannerViewholder(@NonNull View itemView) {
            super(itemView);
            stripAdImage = itemView.findViewById(R.id.stripadimage);
            stripAdContainer = itemView.findViewById(R.id.stripadcontainer);
        }

        private void setStripAd(int resource, String color) {
            stripAdImage.setImageResource(resource);
            stripAdContainer.setBackgroundColor(Color.parseColor(color));
        }
    }

    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder {
        private TextView hlayouttitle;
        private Button hviewallbtn;
        private RecyclerView hrecyclerview;

        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);
            // accessing view
            hlayouttitle = itemView.findViewById(R.id.hsprotitle);
            hviewallbtn = itemView.findViewById(R.id.hslviewallbtn);
            hrecyclerview = itemView.findViewById(R.id.hslrecyclerview);
            hrecyclerview.setRecycledViewPool(recycledViewPool);
            // deals with lag in scrolling due to creation instead of recycle
        }

        private void setHorizontalproductlayout(List<Horizontalproductmodel> horizontalproductmodelList) {

            if (horizontalproductmodelList.size() > 8) {
                hviewallbtn.setVisibility(View.VISIBLE);
            } else {
                hviewallbtn.setVisibility(View.INVISIBLE);
            }
            Horizontalproductadpater horizontalproductadpater = new Horizontalproductadpater(horizontalproductmodelList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            hrecyclerview.setLayoutManager(linearLayoutManager);

            hrecyclerview.setAdapter(horizontalproductadpater);
            horizontalproductadpater.notifyDataSetChanged();


        }

    }
}
