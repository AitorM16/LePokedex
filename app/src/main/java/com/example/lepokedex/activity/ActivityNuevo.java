package com.example.lepokedex.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lepokedex.adapter.AdapterSpinner;
import com.example.lepokedex.database.ListaPokemon;
import com.example.lepokedex.databinding.ActivityNuevoBinding;
import com.example.lepokedex.model.Pokemon;
import com.example.lepokedex.model.Tipo;

public class ActivityNuevo extends AppCompatActivity {

    private ActivityNuevoBinding binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityNuevoBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());

        binder.etNombre.setText("");
        binder.etHp.setText("");
        binder.etAtaque.setText("");
        binder.etDefensa.setText("");
        binder.etVelocidad.setText("");

        AdapterSpinner spinnerAdapter = new AdapterSpinner(this, android.R.layout.simple_dropdown_item_1line, ListaPokemon.getListaTipo());
        binder.spinnerTipo.setAdapter(spinnerAdapter);

        binder.btnGuardar.setOnClickListener(v -> {
            String nombre = binder.etNombre.getText().toString().trim();
            String hpStr = binder.etHp.getText().toString().trim();
            String ataqueStr = binder.etAtaque.getText().toString().trim();
            String defensaStr = binder.etDefensa.getText().toString().trim();
            String velocidadStr = binder.etVelocidad.getText().toString().trim();
            Tipo tipoSeleccionado = (Tipo) binder.spinnerTipo.getSelectedItem();

            if (nombre.isEmpty() || hpStr.isEmpty() || ataqueStr.isEmpty() || defensaStr.isEmpty() || velocidadStr.isEmpty()) {
                Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Try para asegurar de que se pasen numeros en las estádisticas
            try {
                int hp = Integer.parseInt(hpStr);
                int ataque = Integer.parseInt(ataqueStr);
                int defensa = Integer.parseInt(defensaStr);
                int velocidad = Integer.parseInt(velocidadStr);

                Pokemon nuevoPokemon = new Pokemon(nombre, hp, ataque, defensa, velocidad, tipoSeleccionado);
                ListaPokemon.anadirPokemon(nuevoPokemon);

                Toast.makeText(this, "¡Pokémon añadido con éxito!", Toast.LENGTH_SHORT).show();
                finish();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Los campos de estadísticas deben ser numéricos", Toast.LENGTH_SHORT).show();
            }
        });

        binder.btnVolver.setOnClickListener(v -> finish());
    }
}