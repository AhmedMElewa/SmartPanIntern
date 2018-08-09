package com.s1lrr.s1_login_register_retro.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.s1lrr.s1_login_register_retro.Adapter.ItemsAdapter;
import com.s1lrr.s1_login_register_retro.Models.*;
import com.s1lrr.s1_login_register_retro.Models.Cart;
import com.s1lrr.s1_login_register_retro.Presenter.UserPresneter;
import com.s1lrr.s1_login_register_retro.R;
import com.s1lrr.s1_login_register_retro.Views.itemsView;

import java.util.List;

public class Items extends AppCompatActivity implements itemsView {

    private ItemsAdapter itemsAdapter;
    private RecyclerView recyclerItmes;
    private GridLayoutManager gridLayoutManager;
    private UserPresneter userPresneter;
    private TextView cartQ;
    private ItemsAdapter itemsAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Items");
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2C3646")));

        recyclerItmes = findViewById(R.id.recyclerItem);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerItmes.setHasFixedSize(true);
        recyclerItmes.setLayoutManager(gridLayoutManager);
        userPresneter = new UserPresneter(this,this,getIntent().getStringExtra("categoryId"));
        userPresneter.getItems();


        cartQ = (TextView)findViewById(R.id.cartQ);
        cartQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.s1lrr.s1_login_register_retro.Activities.Cart.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showList(List<Item> items) {
        itemsAdapter = new ItemsAdapter(items,getApplicationContext());
        itemsAdapter.kiki(this);

        recyclerItmes.setAdapter(itemsAdapter);
        itemsAdapter.notifyDataSetChanged();

    }

    @Override
    public void cartsize(String counter) {
        cartQ.setText(counter);
    }

    @Override
    public void showListCart(List<Cart> carts) {

    }


}
