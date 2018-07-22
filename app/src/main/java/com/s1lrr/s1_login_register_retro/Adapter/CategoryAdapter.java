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
import com.s1lrr.s1_login_register_retro.Models.City;
import com.s1lrr.s1_login_register_retro.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mada on 7/21/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.RecyclerViewHolder> {

    private List<Category> results;
    Context context;


//    public CategoryAdapter(List<Category> results){
//        this.results = results;
//    }

    public CategoryAdapter(List<Category> results, Context context) {
        this.context=context;
        this.results = results;
    }



    @Override
    public CategoryAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.catageories_item, viewGroup, false);
        return new CategoryAdapter.RecyclerViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final CategoryAdapter.RecyclerViewHolder holder, final int position)  {
        final Category category = results.get(position);
        holder.catName.setText(category.getEnglishName());
        Picasso.get().load(category.getImage()).into(holder.catImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Items.class);
                intent.putExtra("categoryId",category.getCategoryId().toString());
                context.startActivity(intent);
            }
        });


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
