package com.example.lepokedex.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lepokedex.adapter.AdapterSpinner;
import com.example.lepokedex.database.ListaPokemon;
import com.example.lepokedex.databinding.ActivityEditarBinding;
import com.example.lepokedex.model.Pokemon;
import com.example.lepokedex.model.Tipo;

public class ActivityEditar extends AppCompatActivity {

    private ActivityEditarBinding binder;
    private Pokemon pokemonEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityEditarBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());

        AdapterSpinner spinnerAdapter = new AdapterSpinner(this, android.R.layout.simple_dropdown_item_1line, ListaPokemon.getListaTipo());
        binder.spinnerTipo.setAdapter(spinnerAdapter);

        if (getIntent() != null && getIntent().hasExtra("pokemon")) {
            pokemonEditar = (Pokemon) getIntent().getSerializableExtra("pokemon");

            if (pokemonEditar != null) {

                binder.etNombre.setText(pokemonEditar.getNombre());
                binder.etHp.setText(String.valueOf(pokemonEditar.getHp()));
                binder.etAtaque.setText(String.valueOf(pokemonEditar.getAtaque()));
                binder.etDefensa.setText(String.valueOf(pokemonEditar.getDefensa()));
                binder.etVelocidad.setText(String.valueOf(pokemonEditar.getVelocidad()));
                binder.spinnerTipo.setSelection(spinnerAdapter.getPosition(pokemonEditar.getTipoPokemon()));
            }
        }
        binder.btnGuardar.setOnClickListener(v -> {
            String nombre = binder.etNombre.getText().toString().trim();
            String hpStr = binder.etHp.getText().toString().trim();
            String ataqueStr = binder.etAtaque.getText().toString().trim();
            String defensaStr = binder.etDefensa.getText().toString().trim();
            String velocidadStr = binder.etVelocidad.getText().toString().trim();
            Tipo tipoSeleccionado = (Tipo) binder.spinnerTipo.getSelectedItem();

            // Validación de campos vacíos
            if (nombre.isEmpty() || hpStr.isEmpty() || ataqueStr.isEmpty() || defensaStr.isEmpty() || velocidadStr.isEmpty()) {
                Toast.makeText(this, "Atención: Todos los campos deben estar completados", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int hp = Integer.parseInt(hpStr);
                int ataque = Integer.parseInt(ataqueStr);
                int defensa = Integer.parseInt(defensaStr);
                int velocidad = Integer.parseInt(velocidadStr);

                if (pokemonEditar != null) {
                    pokemonEditar.setNombre(nombre);
                    pokemonEditar.setHp(hp);
                    pokemonEditar.setAtaque(ataque);
                    pokemonEditar.setDefensa(defensa);
                    pokemonEditar.setVelocidad(velocidad);
                    pokemonEditar.setTipoPokemon(tipoSeleccionado);



                    Toast.makeText(this, "Proceso realizado correctamente", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Error: Las estadísticas deben ser numéricas", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón Cancelar / Volver
        binder.btnVolver.setOnClickListener(v -> {
            Toast.makeText(this, "Operación cancelada", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}