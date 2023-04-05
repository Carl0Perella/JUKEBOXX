package com.example.jukebox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.Scanner;



public class MainActivity extends AppCompatActivity {
    Button GeneraNumero;
    TextView Numero;
    int numrand;
    int counter=0;
    Button Musica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GeneraNumero= findViewById(R.id.GeneraNumero);
        Numero = findViewById(R.id.Numero);
        Musica = findViewById(R.id.Musica);
    }

    public void Estrazionenumero(View view){
        counter++;
        Random rand = new Random();
        numrand = rand.nextInt(16);
        Numero.setText(Integer.toString(numrand+1));
    }


    public void Activity2(View view){
        Intent Music = new Intent(getApplicationContext(), Music.class);
        Music.putExtra("NumeroRandom", numrand);
        Music.putExtra("click", counter);
        startActivity(Music);

    }
}