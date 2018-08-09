package com.s1lrr.s1_login_register_retro.Presenter;

import android.content.Context;
import android.util.Log;

import com.s1lrr.s1_login_register_retro.Adapter.CityAdapter;
import com.s1lrr.s1_login_register_retro.Models.CategoriesResponse;
import com.s1lrr.s1_login_register_retro.Models.City;
import com.s1lrr.s1_login_register_retro.Models.CityResponce;
import com.s1lrr.s1_login_register_retro.Models.ItemsResponse;
import com.s1lrr.s1_login_register_retro.Models.LoginResponse;
import com.s1lrr.s1_login_register_retro.Models.RegisterResponce;
import com.s1lrr.s1_login_register_retro.Models.User;
import com.s1lrr.s1_login_register_retro.Rerofit.ApiClient;
import com.s1lrr.s1_login_register_retro.Rerofit.ApiInterface;
import com.s1lrr.s1_login_register_retro.Views.CatageoriesView;
import com.s1lrr.s1_login_register_retro.Views.CityView;
import com.s1lrr.s1_login_register_retro.Views.LoginView;
import com.s1lrr.s1_login_register_retro.Views.RegisterView;
import com.s1lrr.s1_login_register_retro.Views.itemsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mada on 7/8/2018.
 */

public class UserPresneter {

    ArrayList<City> cities;
    CityAdapter cityAdapter;
    CityView cityView;
    RegisterView registerView;
    CatageoriesView CatageoriesView;
    itemsView itemsView;
    String categoryId;

    Context context;

    public UserPresneter(Context context,CityView cityView)
    {
        this.cityView=cityView;
        this.context=context;

    }

    public UserPresneter(Context context,RegisterView registerView)
    {
        this.registerView=registerView;
        this.context=context;

    }


    public UserPresneter(Context context,CatageoriesView CatageoriesView)
    {
        this.CatageoriesView=CatageoriesView;
        this.context=context;

    }

    public UserPresneter(Context context,itemsView itemsView ,String categoryId)
    {
        this.itemsView=itemsView;
        this.context=context;
        this.categoryId=categoryId;

    }

    public void getCities() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CityResponce> call = apiInterface.getCities();
        call.enqueue(new Callback<CityResponce>() {
            @Override
            public void onResponse(Call<CityResponce> call, Response<CityResponce> response) {
                Log.e("CityResponse", response.raw().request().toString());

                if (response.isSuccessful())
                {
                    cityView.showList(response.body().getCities());
                }

            }

            @Override
            public void onFailure(Call<CityResponce> call, Throwable t) {

                Log.e("CityFailure", call.request().toString());


            }
        });


    }


    public void getCategories() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("restaurantid", "1");

        Call<CategoriesResponse> call = apiInterface.getCatageories(queryMap);
        call.enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {

                if (response.isSuccessful())
                {
                    CatageoriesView.showList(response.body().getCategories());

                }

            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {

                Log.e("CategoryFailure", call.request().toString());


            }
        });


    }


    public void getItems() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("restaurantid", "1");
        queryMap.put("categoryId",categoryId);

        Call<ItemsResponse> call = apiInterface.getItems(queryMap);
        call.enqueue(new Callback<ItemsResponse>() {
            @Override
            public void onResponse(Call<ItemsResponse> call, Response<ItemsResponse> response) {

                if (response.isSuccessful())
                {
                    itemsView.showList(response.body().getItems());

                }

            }

            @Override
            public void onFailure(Call<ItemsResponse> call, Throwable t) {

                Log.e("ItemsFailure", call.request().toString());


            }
        });


    }




    public void register(User user,City city) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("name", user.getName());
        queryMap.put("password",user.getPassword() );
        queryMap.put("mail", user.getMail());
        queryMap.put("gender", user.getGender());
        queryMap.put("cityId", city.getId().toString());
        queryMap.put("districtId","1" );
        queryMap.put("address",user.getAddress() );
        queryMap.put("phone", user.getPhone());

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);


        Call<RegisterResponce> call = apiInterface.register(queryMap);
        call.enqueue(new Callback<RegisterResponce>() {
            @Override
            public void onResponse(Call<RegisterResponce> call, Response<RegisterResponce> response) {

                if (response.isSuccessful()) {
                    if (response.body().getSuccess().equals("ok")) {
                        registerView.openMain();
                    } else {
                        registerView.showError("error");
                    }
                }else {
                    registerView.showError("error");
                }
            }


            @Override
            public void onFailure(Call<RegisterResponce> call, Throwable t) {
                registerView.showError("error");

            }
        });
    }

}
