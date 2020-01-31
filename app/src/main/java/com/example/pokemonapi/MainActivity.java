package com.example.pokemonapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String URL_BASE = "https://pokeapi.co/api/v2/";
    private EditText pokemon_buscar;
    private TextView nombre,expbase,altura,peso;
    private ImageView sprite;

    private PokemonAPI pokemonAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=findViewById(R.id.name);
        expbase=findViewById(R.id.baseexp);
        altura=findViewById(R.id.altura);
        peso=findViewById(R.id.peso);
        sprite=findViewById(R.id.imageView);
        pokemon_buscar=findViewById(R.id.pokemon);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pokemonAPI = retrofit.create(PokemonAPI.class);
    }

    public void buscar(View v){
        Call<Pokemon> call = pokemonAPI.getPokemonById(pokemon_buscar.getText().toString());
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if(response.isSuccessful()){
                    loadPokemon(response.body());
                } else {
                    Log.e("error", "Hubo un error inesperado!");
                }
            }
            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("on_failure error", t.getMessage());
            }
        });
    }

    private void loadPokemon(Pokemon p){
        nombre.setText(p.getName());
        expbase.setText(String.valueOf(p.getBaseExperience()));
        altura.setText(String.valueOf(p.getHeight()));
        peso.setText(String.valueOf(p.getWeight()));
        Picasso.get().load(p.getSprites().getFrontDefault()).into(sprite);
    }

}
