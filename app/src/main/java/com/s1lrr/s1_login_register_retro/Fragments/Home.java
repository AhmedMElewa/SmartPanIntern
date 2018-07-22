package com.s1lrr.s1_login_register_retro.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.s1lrr.s1_login_register_retro.Adapter.CategoryAdapter;
import com.s1lrr.s1_login_register_retro.Adapter.CityAdapter;
import com.s1lrr.s1_login_register_retro.Models.Category;
import com.s1lrr.s1_login_register_retro.Presenter.UserPresneter;
import com.s1lrr.s1_login_register_retro.R;
import com.s1lrr.s1_login_register_retro.Views.CatageoriesView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements CatageoriesView {

    private CategoryAdapter categoryAdapter;
    private RecyclerView recyclerCategory;
    private GridLayoutManager gridLayoutManager;
    private UserPresneter userPresneter;


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerCategory = v.findViewById(R.id.recyclerCategory);
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerCategory.setHasFixedSize(true);
        recyclerCategory.setLayoutManager(gridLayoutManager);
        userPresneter = new UserPresneter(getContext(),this);
        userPresneter.getCategories();

        return v;
    }

    @Override
    public void showList(List<Category> categories) {
        categoryAdapter = new CategoryAdapter(categories,getContext());
        recyclerCategory.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }
}
