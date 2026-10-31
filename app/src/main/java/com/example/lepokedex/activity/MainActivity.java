package com.example.lepokedex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lepokedex.adapter.AdapterListView;
import com.example.lepokedex.adapter.AdapterSpinner;
import com.example.lepokedex.database.ListaPokemon;
import com.example.lepokedex.databinding.ActivityMainBinding;
import com.example.lepokedex.model.Pokemon;
import com.example.lepokedex.model.Tipo;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private AdapterListView spinnerListView;

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

        binding.buttonLimpiar.setOnClickListener(v -> {
            AdapterListView adaptadorCompleto = new AdapterListView(this, ListaPokemon.getListaPokemons());
            binding.listView.setAdapter(adaptadorCompleto);
        });


        binding.listView.setOnItemClickListener((parent, view, position, id) -> {
            Pokemon pokemonSeleccionado = (Pokemon) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ActivityVista.class);
            intent.putExtra("POKEMON", pokemonSeleccionado);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        spinnerListView = new AdapterListView(this,ListaPokemon.getListaPokemons());
        binding.listView.setAdapter(spinnerListView);
    }

    @Override
    public void onClick(View view) {
        if (binding.buttonAnadirPokemon.isPressed()){
            Intent intent = new Intent(this,ActivityNuevo.class);
            startActivity(intent);
        }

        if (binding.buttonFiltrar.isPressed()) {
            Tipo tipoSeleccionado = (Tipo) binding.spinner.getSelectedItem();
            List<Pokemon> listaFiltrada = new ArrayList<>();

            for (Pokemon p : ListaPokemon.getListaPokemons()) {
                if (p.getTipoPokemon().toString().equals(tipoSeleccionado.toString())) {
                    listaFiltrada.add(p);
                }
            }

            // Actualizar el adaptador con la nueva lista filtrada
            AdapterListView adaptadorFiltrado = new AdapterListView(this, listaFiltrada);
            binding.listView.setAdapter(adaptadorFiltrado);
        }
    }
}