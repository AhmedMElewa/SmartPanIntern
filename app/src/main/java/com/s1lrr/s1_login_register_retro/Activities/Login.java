package com.s1lrr.s1_login_register_retro.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.s1lrr.s1_login_register_retro.Models.User;
import com.s1lrr.s1_login_register_retro.Presenter.LoginPresenter;
import com.s1lrr.s1_login_register_retro.R;
import com.s1lrr.s1_login_register_retro.Views.LoginView;

public class Login extends AppCompatActivity implements LoginView {

    private TextView txtlogin,create;
    private EditText etxtEmail,etxtPassword;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2C3646")));

        etxtEmail = findViewById(R.id.etxtEmail);
        etxtPassword =findViewById(R.id.etxtPassword);
        create = findViewById(R.id.create);
        loginPresenter = new LoginPresenter(this,this);

        txtlogin = findViewById(R.id.txtlogin);
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(etxtEmail.getText().toString().trim(),etxtPassword.getText().toString().trim());
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(),Register.class);
                 startActivity(intent);
            }
        });
    }

    @Override
    public void OpenMain(User user) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void ErrorMessage() {
        Toast.makeText(getApplicationContext(),"error", Toast.LENGTH_LONG).show();
    }


}
