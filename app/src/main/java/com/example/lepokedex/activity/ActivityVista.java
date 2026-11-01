package com.example.lepokedex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lepokedex.R;
import com.example.lepokedex.database.ListaPokemon;
import com.example.lepokedex.databinding.ActivityActivityistaBinding;
import com.example.lepokedex.model.Pokemon;

public class ActivityVista extends AppCompatActivity {

    private ActivityActivityistaBinding binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binder = ActivityActivityistaBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());

        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("POKEMON");

        if (pokemon != null) {
            binder.tvDetailName.setText(pokemon.getNombre());
            binder.tvDetailType.setText("Tipo: " + pokemon.getTipoPokemon().toString());
            binder.tvDetailHp.setText("HP: " + pokemon.getHp());
            binder.tvDetailAttack.setText("Attack: " + pokemon.getAtaque());
            binder.tvDetailDefense.setText("Defense: " + pokemon.getDefensa());
            binder.tvDetailSpeed.setText("Speed: " + pokemon.getVelocidad());
        if (pokemon.getTipoPokemon() != null) {
            switch (pokemon.getTipoPokemon().toString().toLowerCase()) {
                case "electrico":
                    binder.ivDetailImage.setImageResource(R.drawable.img_2);
                    break;
                case "fuego":
                    binder.ivDetailImage.setImageResource(R.drawable.img);
                    break;
                case "agua":
                    binder.ivDetailImage.setImageResource(R.drawable.img_4);
                    break;
                case "planta":
                    binder.ivDetailImage.setImageResource(R.drawable.img_3);
                    break;
                case "tierra":
                    binder.ivDetailImage.setImageResource(R.drawable.img_5);
                    break;
                case "fantasma":
                    binder.ivDetailImage.setImageResource(R.drawable.img_1);
                    break;
            }
        }
            binder.btnBack.setOnClickListener(v -> finish());

            binder.btnDelete.setOnClickListener(v -> {
                    ListaPokemon.eliminarPokemon(pokemon);
                    Toast.makeText(this, "Operación realizada correctamente", Toast.LENGTH_SHORT).show();
                    finish();
                });

            binder.btnEditar.setOnClickListener(v -> {
                Intent intent = new Intent(this, ActivityEditar.class);
                intent.putExtra("pokemon", pokemon);
                startActivity(intent);
            });
        }
    }
}