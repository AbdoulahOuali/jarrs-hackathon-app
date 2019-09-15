package com.ingenico.epayments.jarrs.hackaton.oqp.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ingenico.epayments.jarrs.hackaton.oqp.R;

public class LoginActivity extends AppCompatActivity {

    public boolean loggedIn = hasLoggedIn();// may be a blocking operationø

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (loggedIn) {//logged in before
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        } else {// first launch
            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private boolean hasLoggedIn() {
        return true;
    }
}
