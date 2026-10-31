package com.example.lepokedex.database;

import com.example.lepokedex.model.Pokemon;
import com.example.lepokedex.model.Tipo;

import java.util.ArrayList;

public class ListaPokemon {
    private static ArrayList<Pokemon> listaPokemons = new ArrayList<>();
    private static ArrayList<Tipo>  tiposPokemon = new ArrayList<>();

    public static ArrayList<Pokemon> getListaPokemons() {
        return listaPokemons;
    }

    public static void anadirPokemon(Pokemon pokemon) {
        listaPokemons.add(pokemon);
    }
    public static void eliminarPokemon(Pokemon pokemon){listaPokemons.remove(pokemon);}

    private static void anadirTipoPokemon(){
        tiposPokemon.add(Tipo.Electrico);
        tiposPokemon.add(Tipo.Agua);
        tiposPokemon.add(Tipo.Fuego);
        tiposPokemon.add(Tipo.Fantasma);
        tiposPokemon.add(Tipo.Tierra);
        tiposPokemon.add(Tipo.Planta);
    }
    public static ArrayList<Tipo> getListaTipo(){
        if (!tiposPokemon.contains(Tipo.Electrico)){
            anadirTipoPokemon();
        }
        return tiposPokemon;
    }
}
