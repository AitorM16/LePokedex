package com.example.lepokedex.database;

import com.example.lepokedex.model.Pokemon;

import java.util.ArrayList;

public class ListaPokemon {
    private static ArrayList<Pokemon> listaPokemons;

    public static ArrayList<Pokemon> getListaPokemons() {
        return listaPokemons;
    }

    public static void anadirPokemon(Pokemon pokemon) {
        listaPokemons.add(pokemon);
    }
}
