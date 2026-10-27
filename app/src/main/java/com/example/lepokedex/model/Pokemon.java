package com.example.lepokedex.model;

public class Pokemon {

    private String nombre;

    private int hp;
    private int ataque;
    private int defensa;
    private int velocidad;

    private Tipo tipoPokemon;

    public Pokemon(String nombre, int hp, int ataque, int defensa, int velocidad, Tipo tipoPokemon) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipoPokemon = tipoPokemon;
    }

    public Pokemon() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public Tipo getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(Tipo tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }
}
