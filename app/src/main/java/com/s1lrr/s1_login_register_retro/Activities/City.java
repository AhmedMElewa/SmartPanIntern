package com.s1lrr.s1_login_register_retro.Activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.s1lrr.s1_login_register_retro.Adapter.CityAdapter;
import com.s1lrr.s1_login_register_retro.Presenter.UserPresneter;
import com.s1lrr.s1_login_register_retro.R;
import com.s1lrr.s1_login_register_retro.Views.CityView;

import java.util.List;

public class City extends AppCompatActivity implements CityView{

    private CityAdapter cityAdapter;
    private RecyclerView recyclerCity;
    private GridLayoutManager gridLayoutManager;
    private UserPresneter userPresneter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cities");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2C3646")));

        recyclerCity = findViewById(R.id.recyclerCity);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerCity.setHasFixedSize(true);
        recyclerCity.setLayoutManager(gridLayoutManager);
        userPresneter = new UserPresneter(this,this);
        userPresneter.getCities();


    }

    @Override
    public void showList(List<com.s1lrr.s1_login_register_retro.Models.City> cities) {
        cityAdapter = new CityAdapter(cities,getApplicationContext());
        recyclerCity.setAdapter(cityAdapter);
        cityAdapter.notifyDataSetChanged();
    }
}
