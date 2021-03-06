package com.example.digikirana;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Horizontalproductadpater extends RecyclerView.Adapter<Horizontalproductadpater.ViewHolder> {
    private List<Horizontalproductmodel> horizontalproductmodelList;

    public Horizontalproductadpater(List<Horizontalproductmodel> horizontalproductmodelList) {
        this.horizontalproductmodelList = horizontalproductmodelList;
    }

    @NonNull
    @Override
    public Horizontalproductadpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontalscrollitemlayout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Horizontalproductadpater.ViewHolder viewHolder, int position) {
//data bind
// extract data from list by getters

        int resource = horizontalproductmodelList.get(position).getProductimage();
        String title = horizontalproductmodelList.get(position).getProducttitle();
        String description = horizontalproductmodelList.get(position).getProductdescription();
        String price = horizontalproductmodelList.get(position).getProductprice();
        // set vlaue from view and setter
        viewHolder.setProductimage(resource);
        viewHolder.setProducttitle(title);
        viewHolder.setProductdescription(description);
        viewHolder.setProductprice(price);
    }

    @Override
    public int getItemCount() {
        // if items are more than 8 we enable view all btn by displaying only 6 items
        if (horizontalproductmodelList.size() > 8) {
            return 8;
        } else {
            //return size of list
            return horizontalproductmodelList.size();
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        // all variables
        private ImageView productimage;
        private TextView producttitle;
        private TextView productdescription;
        private TextView productprice;

        public ViewHolder(@NonNull final View itemView) {
            // assign variables
            super(itemView);
            productimage = itemView.findViewById(R.id.hsproimage);
            producttitle = itemView.findViewById(R.id.hsprotitle);
            productdescription = itemView.findViewById(R.id.hsprodescription);
            productprice = itemView.findViewById(R.id.hsproprice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(), ProductdetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
        }

        // methods
        private void setProductimage(int resource) {
            productimage.setImageResource(resource);
        }

        private void setProducttitle(String title) {
            producttitle.setText(title);
        }

        private void setProductdescription(String description) {
            productdescription.setText(description);
        }

        private void setProductprice(String price) {
            productprice.setText(price);
        }

    }
}
