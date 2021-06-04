package com.example.e_learningplatform.application;

import android.app.Application;
import android.content.Context;

public class ELearningApplication extends Application {
    public static ELearningApplication instance;

    public static Context getContext(){
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
