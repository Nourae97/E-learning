package com.example.e_learningplatform.network;

import com.example.e_learningplatform.models.LoginResponse;
import com.example.e_learningplatform.models.RegisterResponse;
import com.example.e_learningplatform.models.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Services {
//    @GET("Character/getAll")
//    Observable<RpgWrapper> getAllCharacters();

    @POST("Auth/login")
    Observable<LoginResponse> login(@Body User user);

    @POST("Auth/register")
    Observable<RegisterResponse> register(@Body User user);
}
