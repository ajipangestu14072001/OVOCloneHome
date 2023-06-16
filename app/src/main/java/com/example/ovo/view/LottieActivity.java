package com.example.ovo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ovo.R;
import com.example.ovo.databinding.ActivityLottieBinding;

public class LottieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen.installSplashScreen(this);
        ActivityLottieBinding binding = ActivityLottieBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btnloti.setOnClickListener(it -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}