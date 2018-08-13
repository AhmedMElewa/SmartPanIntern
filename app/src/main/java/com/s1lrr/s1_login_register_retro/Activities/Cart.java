package com.s1lrr.s1_login_register_retro.Activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.s1lrr.s1_login_register_retro.Adapter.CartAdapter;
import com.s1lrr.s1_login_register_retro.Adapter.ItemsAdapter;
import com.s1lrr.s1_login_register_retro.Models.Item;
import com.s1lrr.s1_login_register_retro.Presenter.UserPresneter;
import com.s1lrr.s1_login_register_retro.R;
import com.s1lrr.s1_login_register_retro.Views.CartView;
import com.s1lrr.s1_login_register_retro.Views.itemsView;
import com.s1lrr.s1_login_register_retro.Views.total;

import java.util.List;

import static com.s1lrr.s1_login_register_retro.Adapter.ItemsAdapter.carts;

public class Cart extends AppCompatActivity implements total {

    private CartAdapter CartAdapter;
    private RecyclerView recyclerCart;
    private GridLayoutManager gridLayoutManager;
    private TextView txtTotal;
    double totalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Cart");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2C3646")));

        recyclerCart = findViewById(R.id.recyclerCart);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerCart.setHasFixedSize(true);
        recyclerCart.setLayoutManager(gridLayoutManager);
        CartAdapter = new CartAdapter(carts,getApplicationContext());
        recyclerCart.setAdapter(CartAdapter);
        CartAdapter.notifyDataSetChanged();
        CartAdapter.intiTotal(this);
        txtTotal = findViewById(R.id.txtTotal);
        for (int i = 0 ;i<carts.size();i++){
            totalk = totalk + (carts.get(i).getQuantity()*carts.get(i).getPrice());

        }
        txtTotal.setText("Total ="+totalk);

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

    @Override
    public void totalall(String total) {
        txtTotal.setText("Total ="+total);
    }
}
