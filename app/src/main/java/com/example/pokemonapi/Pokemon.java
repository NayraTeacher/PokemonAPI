package com.example.pokemonapi;

import com.google.gson.annotations.SerializedName;


public class Pokemon {
    @SerializedName("base_experience")
    private int baseExperience;
    private String name;
    private int id;
    private int height;
    private int weight;
    private PokemonSprites sprites;

    public Pokemon(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PokemonSprites getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSprites sprites) {
        this.sprites = sprites;
    }

    public Pokemon(int baseExperience, String name, int id, int height, int weight, PokemonSprites sprites) {
        this.baseExperience = baseExperience;
        this.name = name;
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.sprites = sprites;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
