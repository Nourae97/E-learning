package com.example.e_learningplatform.models;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("data")
    int userId;
    @SerializedName("message")
    String message;
    @SerializedName("success")
    Boolean success;

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
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
