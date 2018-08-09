package com.s1lrr.s1_login_register_retro.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.s1lrr.s1_login_register_retro.Models.Cart;
import com.s1lrr.s1_login_register_retro.Models.Item;
import com.s1lrr.s1_login_register_retro.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mada on 8/4/2018.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.RecyclerViewHolder> {

    private List<Cart> results;
    Context context;


//    public CartAdapter(List<Item> results){
//        this.results = results;
//    }

    public CartAdapter(List<Cart> results, Context context) {
        this.context=context;
        this.results = results;
    }



    @Override
    public CartAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item, viewGroup, false);
        return new CartAdapter.RecyclerViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final CartAdapter.RecyclerViewHolder holder, final int position)  {
        final Cart item = results.get(position);
        holder.catName.setText(item.getName().toString());
        Picasso.get().load(item.getImageUrl().toString()).into(holder.catImage);
        holder.catprice.setText(String.valueOf(item.getPrice()));
        holder.txtquanitiy.setText(String.valueOf(item.getQuantity()));


    }


    @Override
    public int getItemCount() {
        return results.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder  {

        public TextView catName,txtquanitiy,catprice;
        public ImageView catImage;



        public RecyclerViewHolder(View itemView) {
            super(itemView);

            catName = (TextView)itemView.findViewById(R.id.catName);
            txtquanitiy = (TextView)itemView.findViewById(R.id.txtquanitiy);
            catprice = (TextView)itemView.findViewById(R.id.catprice);
            catImage = (ImageView) itemView.findViewById(R.id.catImage);

        }
    }


}
