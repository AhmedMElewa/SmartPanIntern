package com.s1lrr.s1_login_register_retro.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.s1lrr.s1_login_register_retro.Models.City;
import com.s1lrr.s1_login_register_retro.R;
import java.util.ArrayList;
import java.util.List;

public class CityAdapter  extends RecyclerView.Adapter<CityAdapter.RecyclerViewHolder> {

    private List<City> results;
    Context context;


//    public CityAdapter(List<City> results){
//        this.results = results;
//    }

    public CityAdapter(List<City> results, Context context) {
        this.context=context;
        this.results = results;
    }



    @Override
    public CityAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_item, viewGroup, false);
        return new CityAdapter.RecyclerViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final CityAdapter.RecyclerViewHolder holder, final int position)  {
        City city = results.get(position);
        holder.txtCityArabic.setText(city.getArabicName());
        holder.txtCityEnglish.setText(city.getEnglishName());

    }


    @Override
    public int getItemCount() {
        return results.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder  {

        public TextView txtCityArabic;
        public TextView txtCityEnglish;



        public RecyclerViewHolder(View itemView) {
            super(itemView);

            txtCityArabic = (TextView)itemView.findViewById(R.id.txtCityArabic);
            txtCityEnglish = (TextView) itemView.findViewById(R.id.txtCityEnglish);

        }
    }


}
