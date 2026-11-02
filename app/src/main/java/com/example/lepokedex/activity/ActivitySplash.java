package com.example.lepokedex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lepokedex.R;

public class ActivitySplash extends AppCompatActivity {

    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        foto = findViewById(R.id.imageView);

        // Pon esto temporalmente para que no dé error:
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(ActivitySplash.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}