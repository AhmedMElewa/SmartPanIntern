package com.s1lrr.s1_login_register_retro.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fourhcode.forhutils.FUtilsValidation;
import com.s1lrr.s1_login_register_retro.Models.*;
import com.s1lrr.s1_login_register_retro.Models.City;
import com.s1lrr.s1_login_register_retro.Presenter.UserPresneter;
import com.s1lrr.s1_login_register_retro.R;
import com.s1lrr.s1_login_register_retro.Views.CityView;
import com.s1lrr.s1_login_register_retro.Views.RegisterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Register extends AppCompatActivity implements RegisterView,CityView{

    UserPresneter userPresenter,userPresenter2;
    EditText address,mail,name,phone,password;
    CheckBox maleCheckBox,femaleCheckBox;
    TextView register;
    String gender;
    Spinner spCountry;
    HashMap<Integer,String> spinnerMap = new HashMap<Integer, String>();

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
        register=findViewById(R.id.txtSignUp);
        maleCheckBox = findViewById(R.id.maleCheckBox);
        femaleCheckBox = findViewById(R.id.femaleCheckBox);
        spCountry = findViewById(R.id.spCountry);

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




        userPresenter= new UserPresneter(this, (RegisterView) this);
        userPresenter2 = new UserPresneter(this, (CityView) this);
        userPresenter2.getCities();
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
                    final City city = new City();
                    user.setAddress(address.getText().toString());
                    user.setMail(mail.getText().toString());
                    user.setName(name.getText().toString());
                    user.setPhone(phone.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.setGender(gender);
                    city.setId(Integer.valueOf(spinnerMap.get(spCountry.getSelectedItemPosition())));
                    userPresenter.register(user,city);
                }
            }
        });

    }

    @Override
    public void openMain() {
        Intent intent=new Intent(Register.this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(),error, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showList(List<City> cities) {
        String[] spinnerArray = new String[cities.size()];

        for (int i = 0; i < cities.size(); i++)
        {
            spinnerMap.put(i,cities.get(i).getId().toString());
            spinnerArray[i] = cities.get(i).getEnglishName();
        }

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
