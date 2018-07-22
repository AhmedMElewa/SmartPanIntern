package com.s1lrr.s1_login_register_retro.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponce {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("englishMessage")
    @Expose
    private String englishMessage;
    @SerializedName("arabicMessage")
    @Expose
    private String arabicMessage;
    @SerializedName("CustomerID")
    @Expose
    private Integer customerID;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("Image")
    @Expose
    private String image;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getEnglishMessage() {
        return englishMessage;
    }

    public void setEnglishMessage(String englishMessage) {
        this.englishMessage = englishMessage;
    }

    public String getArabicMessage() {
        return arabicMessage;
    }

    public void setArabicMessage(String arabicMessage) {
        this.arabicMessage = arabicMessage;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}