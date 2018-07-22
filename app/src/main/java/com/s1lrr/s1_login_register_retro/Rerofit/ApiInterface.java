package com.s1lrr.s1_login_register_retro.Rerofit;

import com.s1lrr.s1_login_register_retro.Models.CategoriesResponse;
import com.s1lrr.s1_login_register_retro.Models.City;
import com.s1lrr.s1_login_register_retro.Models.CityResponce;
import com.s1lrr.s1_login_register_retro.Models.ItemsResponse;
import com.s1lrr.s1_login_register_retro.Models.LoginResponse;
import com.s1lrr.s1_login_register_retro.Models.RegisterResponce;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Mada on 6/30/2018.
 */

public interface ApiInterface {

    @GET("getCities")
    Call<CityResponce> getCities();

    @POST("Login")
    Call<LoginResponse> login(@QueryMap Map<String ,  String> queryMap);

    @POST ("Register")
    Call<RegisterResponce> register(@QueryMap Map<String,String> queryMab);


    @GET("getCatagories")
    Call<CategoriesResponse> getCatageories(@QueryMap Map<String,String> stringMap);

    @POST("GetcategoryItems")
    Call<ItemsResponse> getItems(@QueryMap Map<String,String> stringMap);
}
