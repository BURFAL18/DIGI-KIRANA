package com.example.digikirana;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {
    private List<WishlistModel> wishlistModelList;

    public WishlistAdapter(List<WishlistModel> wishlistModelList) {
        this.wishlistModelList = wishlistModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layout inflate
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        // set data variable used for binding
        int resource = wishlistModelList.get(position).getXproductImage();
        String title = wishlistModelList.get(position).getXproductTitle();
        String price = wishlistModelList.get(position).getXproductPrice();
        //adapter
        viewholder.setData(resource, title, price);
    }

    @Override
    public int getItemCount() {
        return wishlistModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView xproductImage;
        private TextView xproductTitle;
        private TextView xproductPrice;
        private ImageButton xdeletebtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            xproductImage = itemView.findViewById(R.id.w_product_image);
            xproductTitle = itemView.findViewById(R.id.w_product_title);
            xproductPrice = itemView.findViewById(R.id.w_product_price);
            xdeletebtn = itemView.findViewById(R.id.w_delete_btn);

        }

        //data set
        private void setData(int resource, String title, String price) {
            xproductImage.setImageResource(resource);
            xproductTitle.setText(title);
            xproductPrice.setText(price);
            xdeletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "delete", Toast.LENGTH_SHORT).show(); // temp pop up delete
                }
            });
        }
    }
}
