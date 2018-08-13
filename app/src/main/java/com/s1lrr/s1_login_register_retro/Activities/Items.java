package com.s1lrr.s1_login_register_retro.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.s1lrr.s1_login_register_retro.Adapter.ItemsAdapter;
import com.s1lrr.s1_login_register_retro.Models.*;
import com.s1lrr.s1_login_register_retro.Models.Cart;
import com.s1lrr.s1_login_register_retro.Presenter.UserPresneter;
import com.s1lrr.s1_login_register_retro.R;
import com.s1lrr.s1_login_register_retro.Views.itemsView;

import java.util.List;

import static com.s1lrr.s1_login_register_retro.Adapter.ItemsAdapter.carts;

public class Items extends AppCompatActivity implements itemsView {

    private ItemsAdapter itemsAdapter;
    private RecyclerView recyclerItmes;
    private GridLayoutManager gridLayoutManager;
    private UserPresneter userPresneter;
    private android.support.v7.widget.Toolbar cartQ;
    private ItemsAdapter itemsAdapter2;
    private TextView CartQQ;

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


        cartQ = (android.support.v7.widget.Toolbar) findViewById(R.id.cartQ);
        CartQQ = (TextView)findViewById(R.id.CartQQ);

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
        CartQQ.setText(counter);
    }

    @Override
    public void showListCart(List<Cart> carts) {

    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        CartQQ.setText(String.valueOf(carts.size()));
    }
}
