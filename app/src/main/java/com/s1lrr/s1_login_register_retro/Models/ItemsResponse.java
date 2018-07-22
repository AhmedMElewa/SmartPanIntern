package com.s1lrr.s1_login_register_retro.Models;

/**
 * Created by Mada on 7/21/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemsResponse {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
