package com.example.jukebox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Testo extends AppCompatActivity {
    TextView testo;
    Button indietro2;
    int Numtext;
    final String TAG = "Testo";
    String[] Testi = {
            "testo1.txt",
            "testo2.txt",
            "testo3.txt",
            "testo4.txt",
            "testo5.txt",
            "testo6.txt",
            "testo7.txt",
            "testo8.txt",
            "testo9.txt",
            "testo10.txt",
            "testo11.txt",
            "testo12.txt",
            "testo13.txt",
            "testo14.txt",
            "testo15.txt",
            "testo16.txt"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testo);
        testo = findViewById(R.id.texto);
        Numtext = getIntent().getExtras().getInt("NumeroText");
        indietro2= findViewById(R.id.indietro2);
        testo.setMovementMethod(new ScrollingMovementMethod());
        testo.setText(leggiTesto(Numtext, getApplicationContext()));
    }

    public String leggiTesto(int Numtext, Context c) {
        String text = "";
        AssetManager am = c.getAssets();
        String line;
        try {
            InputStream is = am.open(Testi[Numtext]);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                text += line;
                text += "\n";
            }
        } catch(FileNotFoundException ex) {
            Log.e(TAG, "File non esistente");
            text = "Errore di apertura";
        } catch(IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Errore di lettura");
            text = "Errore di lettura";
        }
        return text;
    }

    public void indietro2(View view) {
        Intent intentIndietro2 = new Intent(getApplicationContext(), Music.class);
        startActivity(intentIndietro2);
    }
}