package com.s1lrr.s1_login_register_retro.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mada on 6/30/2018.
 */

public class LoginResponse {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("englishMessage")
    @Expose
    private String englishMessage;
    @SerializedName("arabicMessage")
    @Expose
    private String arabicMessage;
    @SerializedName("userid")
    @Expose
    private Integer userid;
    @SerializedName("arabicName")
    @Expose
    private String arabicName;
    @SerializedName("englishName")
    @Expose
    private Object englishName;
    @SerializedName("pic")
    @Expose
    private String pic;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public Object getEnglishName() {
        return englishName;
    }

    public void setEnglishName(Object englishName) {
        this.englishName = englishName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}