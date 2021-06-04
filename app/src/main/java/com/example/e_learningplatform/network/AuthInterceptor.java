package com.example.e_learningplatform.network;

import android.text.TextUtils;

import com.example.e_learningplatform.application.ELearningApplication;
import com.example.e_learningplatform.utils.Preferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

//A class that makes sure the user token is properly sent as a header to the backend
public class AuthInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request chainRequest = chain.request();
        Request.Builder builder = chainRequest.newBuilder();

        String accessToken = Preferences.getToken(ELearningApplication.getContext());

        if (!TextUtils.isEmpty(accessToken)) {
            builder.header("Authorization", "Bearer "+ accessToken);
        }

        Request request = builder.build();
        return chain.proceed(request);
    }
}
