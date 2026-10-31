package com.example.lepokedex.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.lepokedex.R;
import com.example.lepokedex.model.Tipo;

import java.util.List;

public class AdapterSpinner extends ArrayAdapter<Tipo> {
    private Context context;
    private List<Tipo> lista;
    private int resource;

    public AdapterSpinner(@NonNull Context context, int resource,List<Tipo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.lista = objects;
    }

    private int obtenerColor(String texto) {
        switch (texto) {
            case "Fuego":
                return ContextCompat.getColor(getContext(), R.color.fuego);
            case "Agua":
                return ContextCompat.getColor(getContext(), R.color.agua);
            case "Tierra":
                return ContextCompat.getColor(getContext(), R.color.tierra);
            case "Fantasma":
                return ContextCompat.getColor(getContext(), R.color.fantasma);
            case "Planta":
                return ContextCompat.getColor(getContext(), R.color.planta);
            case "Electrico":
                return ContextCompat.getColor(getContext(), R.color.electrico);
            default:
                return Color.BLACK;
        }
    }

    private void colorear(TextView vista, String texto) {
        vista.setText(texto);
        vista.setBackgroundColor(obtenerColor(texto));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(android.R.layout.simple_dropdown_item_1line,null);
        }
        TextView vista = (TextView) super.getView(position, convertView, parent);
        String texto = getItem(position).toString();
        if (texto != null) {
            colorear(vista, texto);
        }
        return vista;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView vista = (TextView) super.getDropDownView(position, convertView, parent);
        String texto = getItem(position).toString();
        if (texto != null) {
            colorear(vista, texto);
        }
        return vista;
    }
}
