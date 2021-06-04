package com.example.e_learningplatform.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_learningplatform.R;
import com.example.e_learningplatform.models.LoginResponse;
import com.example.e_learningplatform.models.User;
import com.example.e_learningplatform.network.ApiManager;
import com.example.e_learningplatform.network.Services;
import com.example.e_learningplatform.utils.GeneralUtils;
import com.example.e_learningplatform.utils.Preferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    private ApiManager apiManager;
    private CompositeDisposable disposable = new CompositeDisposable();
    private Services apiService;
    private Context context;
    private String username;
    private String password;

    @BindView(R.id.usernameEditText)
    EditText usernameEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.loginButton)
    Button loginButton;
    @BindView(R.id.registerButton)
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        apiService = ApiManager.getClient(getApplicationContext()).create(Services.class);
        setupOnClickListeners();
    }

    private void setupOnClickListeners(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();
                loginUser(username, password);
            }
        });
    }

    private void loginUser(String username, String password) {
        disposable.add(apiService
                .login(new User(username, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<LoginResponse>() {

                    @Override
                    public void onNext(@NonNull LoginResponse loginResponse) {
                        Preferences.setToken(context, loginResponse.getLoginToken());
                        GeneralUtils.logDebugEvent("Login was a success! Token is " + Preferences.getToken(context));
                        Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, HomeActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        GeneralUtils.logDebugEvent(e.toString());
                        Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}