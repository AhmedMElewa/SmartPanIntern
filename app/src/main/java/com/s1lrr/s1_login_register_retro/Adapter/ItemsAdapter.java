package com.s1lrr.s1_login_register_retro.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.s1lrr.s1_login_register_retro.Activities.Items;
import com.s1lrr.s1_login_register_retro.Models.Category;
import com.s1lrr.s1_login_register_retro.Models.Item;
import com.s1lrr.s1_login_register_retro.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mada on 7/21/2018.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.RecyclerViewHolder> {

    private List<Item> results;
    Context context;


//    public ItemsAdapter(List<Item> results){
//        this.results = results;
//    }

    public ItemsAdapter(List<Item> results, Context context) {
        this.context=context;
        this.results = results;
    }



    @Override
    public ItemsAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.catageories_item, viewGroup, false);
        return new ItemsAdapter.RecyclerViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final ItemsAdapter.RecyclerViewHolder holder, final int position)  {
        final Item item = results.get(position);
        holder.catName.setText(item.getEnglishName());
        Picasso.get().load(item.getImageUrl()).into(holder.catImage);




    }


    @Override
    public int getItemCount() {
        return results.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder  {

        public TextView catName;
        public ImageView catImage;



        public RecyclerViewHolder(View itemView) {
            super(itemView);

            catName = (TextView)itemView.findViewById(R.id.catName);
            catImage = (ImageView) itemView.findViewById(R.id.catImage);

        }
    }


}
