package com.example.e_learningplatform.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.e_learningplatform.R;
import com.example.e_learningplatform.utils.Preferences;

public class BaseActivity extends AppCompatActivity {
    public Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        preferences = Preferences.getInstance(this);
    }
}