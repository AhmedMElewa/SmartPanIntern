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
import com.s1lrr.s1_login_register_retro.Views.total;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.s1lrr.s1_login_register_retro.Adapter.ItemsAdapter.carts;

/**
 * Created by Mada on 8/4/2018.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.RecyclerViewHolder> {

    private List<Cart> results;
    Context context;
    total total;
    double totalk = 0;
//    public CartAdapter(List<Item> results){
//        this.results = results;
//    }

    public CartAdapter(List<Cart> results, Context context) {
        this.context=context;
        this.results = results;

    }

    public void intiTotal(com.s1lrr.s1_login_register_retro.Views.total total) {
        this.total = total;
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
        holder.txtquanitiy.setText(String.valueOf(item.getQuantity().toString()));
        holder.txtquanitiy1.setText(String.valueOf(item.getQuantity().toString()));

        holder.txtplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = Integer.valueOf(holder.txtquanitiy.getText().toString());
                holder.txtquanitiy1.setText(String.valueOf(current+1));
                holder.txtquanitiy.setText( holder.txtquanitiy1.getText());
                carts.get(position).setQuantity(current+1);
                totalk = 0;
                for (int i = 0 ;i<carts.size();i++){
                    totalk = totalk + (carts.get(i).getQuantity()*carts.get(i).getPrice());

                }
                total.totalall(String.valueOf(totalk));
            }
        });


        holder.txtminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = Integer.valueOf(holder.txtquanitiy.getText().toString());
                if (current>1){
                    holder.txtquanitiy1.setText(String.valueOf(current-1));
                    holder.txtquanitiy.setText( holder.txtquanitiy1.getText());
                    carts.get(position).setQuantity(current-1);
                    totalk = 0;
                    for (int i = 0 ;i<carts.size();i++){
                        totalk = totalk + (carts.get(i).getQuantity()*carts.get(i).getPrice());

                    }
                    total.totalall(String.valueOf(totalk));
                }else {
                    holder.txtquanitiy1.setText("1");
                    holder.txtquanitiy.setText( holder.txtquanitiy1.getText());
                    totalk = 0;
                    for (int i = 0 ;i<carts.size();i++){
                        totalk = totalk + (carts.get(i).getQuantity()*carts.get(i).getPrice());

                    }
                    total.totalall(String.valueOf(totalk));
                }

            }
        });


        holder.txtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carts.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, carts.size());
                totalk = 0;
                for (int i = 0 ;i<carts.size();i++){
                    totalk = totalk + (carts.get(i).getQuantity()*carts.get(i).getPrice());

                }
                total.totalall(String.valueOf(totalk));
            }
        });


    }


    @Override
    public int getItemCount() {
        return results.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder  {

        public TextView catName,txtquanitiy,catprice,txtplus,txtquanitiy1,txtminus,txtDelete;
        public ImageView catImage;



        public RecyclerViewHolder(View itemView) {
            super(itemView);
            catName = (TextView)itemView.findViewById(R.id.catName);
            txtquanitiy = (TextView)itemView.findViewById(R.id.txtquanitiy);
            catprice = (TextView)itemView.findViewById(R.id.catprice);
            catImage = (ImageView) itemView.findViewById(R.id.catImage);
            txtplus = (TextView)itemView.findViewById(R.id.txtplus);
            txtquanitiy1 = (TextView)itemView.findViewById(R.id.txtquanitiy1);
            txtminus = (TextView)itemView.findViewById(R.id.txtminus);
            txtDelete = (TextView)itemView.findViewById(R.id.txtDelete);

        }
    }


}
