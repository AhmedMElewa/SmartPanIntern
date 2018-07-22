package com.s1lrr.s1_login_register_retro.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fourhcode.forhutils.FUtilsValidation;
import com.s1lrr.s1_login_register_retro.Models.User;
import com.s1lrr.s1_login_register_retro.Presenter.UserPresneter;
import com.s1lrr.s1_login_register_retro.R;
import com.s1lrr.s1_login_register_retro.Views.RegisterView;

public class Register extends AppCompatActivity implements RegisterView {

    UserPresneter userPresenter;
    EditText address,mail,name,phone,password;
    CheckBox maleCheckBox,femaleCheckBox;
    TextView register;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2C3646")));

        address=findViewById(R.id.address);
        mail=findViewById(R.id.mail);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        maleCheckBox = findViewById(R.id.maleCheckBox);
        femaleCheckBox = findViewById(R.id.femaleCheckBox);

        maleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender="0";
                femaleCheckBox.setChecked(false);
            }
        });
        femaleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender="1";
                maleCheckBox.setChecked(false);
            }
        });


        userPresenter=new UserPresneter(this,this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FUtilsValidation.isEmpty(address, "please insert Address");
                FUtilsValidation.isEmpty(mail, "please insert Mail");
                FUtilsValidation.isEmpty(name, "please insert Name");
                FUtilsValidation.isEmpty(phone,"please insert Phone");
                FUtilsValidation.isEmpty(password, "please insert Password");
                FUtilsValidation.isLengthCorrect(password.getText().toString(), 8, 16);

                if (!FUtilsValidation.isLengthCorrect(password.getText().toString(), 8, 16))
                    password.setError("password min 8 char");

                if (!address.getText().toString().equals("") && !mail.getText().toString().equals("") && !name.getText().toString().equals("") && !phone.getText().toString().equals("") &&
                        (maleCheckBox.isChecked() || femaleCheckBox.isChecked())&& FUtilsValidation.isLengthCorrect(password.getText().toString(), 8, 16))
                {
                    User user = new User();
                    user.setAddress(address.getText().toString());
                    user.setMail(mail.getText().toString());
                    user.setName(name.getText().toString());
                    user.setPhone(phone.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.setGender(gender);
                    userPresenter.register(user);
                }
            }
        });

    }

    @Override
    public void openMain() {
        Intent intent=new Intent(Register.this,MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }
}
