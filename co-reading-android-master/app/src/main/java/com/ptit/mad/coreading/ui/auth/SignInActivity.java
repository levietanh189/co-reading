package com.ptit.mad.coreading.ui.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ptit.mad.coreading.MainActivity;
import com.ptit.mad.coreading.R;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private final String TAG = "co-reading";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();

        ((EditText)findViewById(R.id.username)).setText("canh@gmail.com");
        ((EditText)findViewById(R.id.password)).setText("123456");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
        findViewById(R.id.sign_in).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final String email = ((TextView) findViewById(R.id.username)).getText().toString();
                        final String password = ((TextView) findViewById(R.id.password)).getText().toString();

                        if ((!email.isEmpty()) && (!password.isEmpty())){
                            signIn(email, password);
                        }
                        else {
                            Toast.makeText(SignInActivity.this, "Username and password cant not be null.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        redirectToSignUpView();
    }


    private void signIn(String email, String password) {
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END sign_in_with_email]
    }

    private void updateUI(FirebaseUser user) {
        if (user != null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void redirectToSignUpView(){
        findViewById(R.id.sign_in_to_sign_up_view).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SignInActivity.this, SignUp.class);
                        startActivity(intent);
                    }
                }
        );
    }
}