package com.example.e_learningplatform.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("data")
    String loginToken;
    @SerializedName("message")
    String message;
    @SerializedName("success")
    Boolean success;

    public String getLoginToken(){
        return loginToken;
    }

    public void setLoginToken(String loginToken){
        this.loginToken = loginToken;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public boolean getSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }
}
