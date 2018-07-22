package com.s1lrr.s1_login_register_retro.Activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.s1lrr.s1_login_register_retro.Adapter.CategoryAdapter;
import com.s1lrr.s1_login_register_retro.Adapter.CityAdapter;
import com.s1lrr.s1_login_register_retro.Adapter.ItemsAdapter;
import com.s1lrr.s1_login_register_retro.Models.Item;
import com.s1lrr.s1_login_register_retro.Presenter.UserPresneter;
import com.s1lrr.s1_login_register_retro.R;
import com.s1lrr.s1_login_register_retro.Views.itemsView;

import java.util.List;

public class Items extends AppCompatActivity implements itemsView {

    private ItemsAdapter itemsAdapter;
    private RecyclerView recyclerItmes;
    private GridLayoutManager gridLayoutManager;
    private UserPresneter userPresneter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Items");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2C3646")));

        recyclerItmes = findViewById(R.id.recyclerItem);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerItmes.setHasFixedSize(true);
        recyclerItmes.setLayoutManager(gridLayoutManager);
        userPresneter = new UserPresneter(this,this,getIntent().getStringExtra("categoryId"));
        userPresneter.getItems();
    }

    @Override
    public void showList(List<Item> items) {
        itemsAdapter = new ItemsAdapter(items,getApplicationContext());
        recyclerItmes.setAdapter(itemsAdapter);
        itemsAdapter.notifyDataSetChanged();
    }
}
