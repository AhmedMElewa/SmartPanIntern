package com.s1lrr.s1_login_register_retro.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.s1lrr.s1_login_register_retro.Models.LoginResponse;
import com.s1lrr.s1_login_register_retro.Models.User;
import com.s1lrr.s1_login_register_retro.Rerofit.ApiClient;
import com.s1lrr.s1_login_register_retro.Rerofit.ApiInterface;
import com.s1lrr.s1_login_register_retro.Views.LoginView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mada on 6/30/2018.
 */

public class LoginPresenter {
    LoginView loginView;
    Context context;

    public LoginPresenter(Context context,LoginView loginView)
    {
        this.loginView=loginView;
        this.context=context;

    }

    public void login(String name, String password) {

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("emailOrPhone", name);
        queryMap.put("password", password);
        queryMap.put("token", "1");

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call = apiInterface.login(queryMap);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("LoginResponse", response.raw().request().toString());

                if (response.isSuccessful())
                {
                    if(response.body().getSuccess().equals("ok")) {
                        User user = new User();
                        user.setName(response.body().getArabicName());
                        user.setUrl(response.body().getPic());
                        user.setId(response.body().getUserid());
                        loginView.OpenMain(user);
                    }
                    else
                    {
                        loginView.ErrorMessage();

                    }

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Log.e("LoginFailure", call.request().toString());


            }
        });
    }
}