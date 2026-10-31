package com.example.lepokedex.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.lepokedex.R;
import com.example.lepokedex.model.Pokemon;

import java.util.List;

public class AdapterListView extends ArrayAdapter<Pokemon>   {

    private Context context;
    private List<Pokemon> lista;
    private int resource;

    public AdapterListView(@NonNull Context context, List<Pokemon> objects) {
        super(context, 0, objects);
        this.context = context;
        this.resource = 0;
        this.lista = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pokemon, parent, false);
        }

        Pokemon p = getItem(position);
        LinearLayout rowBackground = convertView.findViewById(R.id.rowBackground);

        ((TextView) convertView.findViewById(R.id.tvName)).setText(p.getNombre());
        ((TextView) convertView.findViewById(R.id.tvHp)).setText("HP\n" + p.getHp());
        ((TextView) convertView.findViewById(R.id.tvAttack)).setText("Attack\n" + p.getAtaque());
        ((TextView) convertView.findViewById(R.id.tvDefense)).setText("Defense\n" + p.getDefensa());
        ((TextView) convertView.findViewById(R.id.tvSpeed)).setText("Speed\n" + p.getVelocidad());

        // Cambiar color de fondo según el tipo
        switch (p.getTipoPokemon().toString().toLowerCase()) {
            case "electrico":
                rowBackground.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.electrico)); // Amarillo
                break;
            case "fuego":
                rowBackground.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.fuego)); // Amarillo
                break;
            case "agua":
                rowBackground.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.agua)); // Amarillo
                break;
            case "planta":
                rowBackground.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.planta)); // Amarillo
                break;
            case "tierra":
                rowBackground.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.tierra)); // Amarillo
                break;
            case "fantasma":
                rowBackground.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.fantasma)); // Amarillo
                break;
            default:
                rowBackground.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }
}
