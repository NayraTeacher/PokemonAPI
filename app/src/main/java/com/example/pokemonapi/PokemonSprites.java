package com.example.pokemonapi;

import com.google.gson.annotations.SerializedName;

public class PokemonSprites {
    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    @SerializedName("front_default")
    private String frontDefault;

    public PokemonSprites(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public PokemonSprites() {
        }

}
