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
import com.s1lrr.s1_login_register_retro.Views.CartView;
import com.s1lrr.s1_login_register_retro.Views.itemsView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mada on 7/21/2018.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.RecyclerViewHolder> {

    private List<Item> results;
    Context context;
    public static List<Cart> carts =new ArrayList<>() ;
    com.s1lrr.s1_login_register_retro.Models.Cart cart;
//    CartView cartView ;
    itemsView itemsView;
    int id = 0;
//    public ItemsAdapter(List<Item> results){
//        this.results = results;
//    }


    public void kiki(com.s1lrr.s1_login_register_retro.Views.itemsView itemsView) {
        this.itemsView = itemsView;
    }

//    public void kiki2(CartView cartView) {
//        this.cartView = cartView;
//    }

    public ItemsAdapter(List<Item> results, Context context) {
        this.context=context;
        this.results = results;
    }



    @Override
    public ItemsAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_item, viewGroup, false);
        return new ItemsAdapter.RecyclerViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final ItemsAdapter.RecyclerViewHolder holder, final int position)  {
        final Item item = results.get(position);
        holder.catName.setText(item.getEnglishName());
        Picasso.get().load(item.getImageUrl()).into(holder.catImage);
        holder.catprice.setText(String.valueOf(item.getPrice()));
        carts = new ArrayList<>();

        holder.txtplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = Integer.valueOf(holder.txtquanitiy.getText().toString());
                holder.txtquanitiy.setText(String.valueOf(current+1));
            }
        });


        holder.txtminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = Integer.valueOf(holder.txtquanitiy.getText().toString());
                if (current>1){
                    holder.txtquanitiy.setText(String.valueOf(current-1));
                }else {
                    holder.txtquanitiy.setText("1");
                }

            }
        });

        holder.txtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart = new com.s1lrr.s1_login_register_retro.Models.Cart(Double.parseDouble(holder.catprice.getText().toString()),
                        java.lang.Integer.parseInt(holder.txtquanitiy.getText().toString()),holder.catName.getText().toString(),
                        item.getImageUrl(),id);
                id =id+1;
                carts.add(cart);
                itemsView.cartsize(String.valueOf(carts.size()));
                itemsView.showListCart(carts);
                holder.txtquanitiy.setText("1");
//                cartView.showList(carts);
            }
        });


    }


    @Override
    public int getItemCount() {
        return results.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder  {

        public TextView catName,txtplus,txtquanitiy,txtminus,txtAdd,catprice;
        public ImageView catImage;



        public RecyclerViewHolder(View itemView) {
            super(itemView);

            catName = (TextView)itemView.findViewById(R.id.catName);
            txtplus = (TextView)itemView.findViewById(R.id.txtplus);
            txtquanitiy = (TextView)itemView.findViewById(R.id.txtquanitiy);
            txtminus = (TextView)itemView.findViewById(R.id.txtminus);
            txtAdd = (TextView)itemView.findViewById(R.id.txtAdd);
            catprice = (TextView)itemView.findViewById(R.id.catprice);
            catImage = (ImageView) itemView.findViewById(R.id.catImage);

        }
    }


}
