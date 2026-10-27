package com.example.lepokedex.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lepokedex.R;
import com.example.lepokedex.databinding.ActivityNuevoBinding;

public class ActivityNuevo extends AppCompatActivity {

    private ActivityNuevoBinding binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binder = ActivityNuevoBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());

        binder.btnVolver.setOnClickListener(v->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}