package com.s1lrr.s1_login_register_retro.Models;

/**
 * Created by Mada on 7/21/2018.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesResponse {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("Categories")
    @Expose
    private List<Category> categories = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}