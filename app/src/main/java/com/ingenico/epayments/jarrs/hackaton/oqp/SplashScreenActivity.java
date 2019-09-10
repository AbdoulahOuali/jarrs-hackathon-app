package com.ingenico.epayments.jarrs.hackaton.oqp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen configSplash = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withHeaderText("NFC-based Offline Payments")
                .withFooterText("JARRS Hackaton team 2019" + "\u00A9")
                .withBeforeLogoText("Powered by")
                .withAfterLogoText("Shaping the Future of Payments")
                .withLogo(R.drawable.ic_brand_logo)
                .withBackgroundResource(android.R.color.background_light);

        configSplash.getHeaderTextView().setTextSize(36);
        configSplash.getHeaderTextView().setGravity(Gravity.TOP | Gravity.CENTER);
        configSplash.getHeaderTextView().setPadding(24, 200, 24, 24);
        configSplash.getFooterTextView().setPadding(24, 24, 24, 100);
        configSplash.getHeaderTextView().setTextColor(getResources().getColor(R.color.ingenicoBlue));
        configSplash.getFooterTextView().setTextColor(getResources().getColor(R.color.ingenicoBlue));
        configSplash.getBeforeLogoTextView().setTextColor(getResources().getColor(R.color.ingenicoBlue));
        configSplash.getBeforeLogoTextView().setPadding(0, 0, 0, 24);
        configSplash.getAfterLogoTextView().setTextColor(getResources().getColor(R.color.ingenicoBlue));
        configSplash.getAfterLogoTextView().setPadding(0, 24, 0, 0);
        configSplash.getHeaderTextView().setTextColor(getResources().getColor(R.color.ingenicoBlue));

        View easySplashScreen = configSplash.create();
        setContentView(easySplashScreen);
    }
}
