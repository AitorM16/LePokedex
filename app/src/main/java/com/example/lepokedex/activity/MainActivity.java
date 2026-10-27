package com.example.lepokedex.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lepokedex.R;
import com.example.lepokedex.adapter.AdapterSpinner;
import com.example.lepokedex.database.ListaPokemon;
import com.example.lepokedex.databinding.ActivityMainBinding;
import com.example.lepokedex.model.Pokemon;
import com.example.lepokedex.model.Tipo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonAnadirPokemon.setOnClickListener(this);
        binding.buttonFiltrar.setOnClickListener(this);

        AdapterSpinner spinnerAdapter = new AdapterSpinner(this, android.R.layout.simple_dropdown_item_1line,ListaPokemon.getListaTipo());
        binding.spinner.setAdapter(spinnerAdapter);


    }

    @Override
    public void onClick(View view) {
        if (binding.buttonAnadirPokemon.isPressed()){
            Intent intent = new Intent(this,ActivityNuevo.class);
            startActivity(intent);
        }

        if (binding.buttonFiltrar.isPressed()){

        }
    }
}