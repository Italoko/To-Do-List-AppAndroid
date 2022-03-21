package com.example.to_do_list;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private Handler handler;
    private Runnable r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.imageView);
        handler = new Handler();
        handler.postDelayed(r = () -> {
            entrar();
        },5000);
        imageView.setOnClickListener(view -> {entrar();});
    }
    private void entrar()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        handler.removeCallbacks(r);
    }
}