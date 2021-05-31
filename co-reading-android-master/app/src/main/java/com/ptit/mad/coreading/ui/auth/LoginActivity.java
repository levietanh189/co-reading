package com.ptit.mad.coreading.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ptit.mad.coreading.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewSignInForm();
        viewSignUpForm();
    }

    private void viewSignInForm(){
        findViewById(R.id.sign_in_view).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this, SignInActivity.class);
                        startActivity(intent);
//                        finish();
                    }
                }
        );
    }

    private void viewSignUpForm(){
        findViewById(R.id.sign_up_view).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this, SignUp.class);
                        startActivity(intent);
//                        finish();
                    }
                }
        );
    }
}