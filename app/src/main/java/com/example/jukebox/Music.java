package com.example.jukebox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Handler;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Music extends AppCompatActivity {
    ImageView image;
    Button youtube;
    Button Indietro;
    Button Avanti;
    Button Notifica;
    int Randomnum;
    TextView musicasual;
    int clicks;
    MediaPlayer player;
    Handler handler = new Handler();
    double startTime = 0;
    SeekBar musicbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Button youtube= findViewById(R.id.Youtube);
        Button Indietro= findViewById(R.id.Indietro);
        Button Artista= findViewById(R.id.Artisti);
        Button Notifica= findViewById(R.id.Notifica);
        musicbar =(SeekBar) findViewById(R.id.bar);
        Button Pause= findViewById(R.id.Pause);
        Button Testo= findViewById(R.id.Testo);
        Button Play= findViewById(R.id.Play);
        image= findViewById(R.id.imageview);
        clicks = getIntent().getExtras().getInt("click");
        Randomnum = getIntent().getExtras().getInt("NumeroRandom");
        musicasual = findViewById(R.id.Canzone);
        image.setImageResource(Immagini[Randomnum]);
        musicasual.setText(Musica[Randomnum]);
        player = MediaPlayer.create(this, Audio[Randomnum]);
        if ( clicks >= 7){
            Notifica.setVisibility(View.VISIBLE);
        };
    }
    private Runnable updateBar = new Runnable() {
        public void run()
        {
            startTime = player.getCurrentPosition();
            musicbar.setProgress((int)startTime);
            handler.postDelayed(this, 100);
        }
    };
    public void play(View v)
    {
        player.start();
        musicbar.setMax((int) player.getDuration());
        handler.postDelayed(updateBar,100);
    }
    public void pause(View v)
    {
        player.pause();
    }
    public void Testo(View v)
    {
        Intent Testo = new Intent(getApplicationContext(), Testo.class);
        Testo.putExtra("clickText", clicks);
        Testo.putExtra("NumeroText", Randomnum);
        startActivity(Testo);
    }





    String[] Musica = {
            "Jackie Chan",
            "That's What I like",
            "Eye of the Tiger",
            "Car’s Outside",
            "All Stars",
            "Paranoid",
            "Back In Black",
            "Out Of My League",
            "Fearless",
            "Gipsy Woman",
            "Snap",
            "Hero",
            "Get Lucky",
            "As It Was",
            "Safe And Sound",
            "Tous le Memes"
    };
    int[] Audio = {
            R.raw.music1,
            R.raw.music2,
            R.raw.music3,
            R.raw.music4,
            R.raw.music5,
            R.raw.music6,
            R.raw.music7,
            R.raw.music8,
            R.raw.music9,
            R.raw.music10,
            R.raw.music11,
            R.raw.music12,
            R.raw.music13,
            R.raw.music14,
            R.raw.music15,
            R.raw.music16
    };
    int[] Immagini = {
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
            R.drawable.img_10,
            R.drawable.img_11,
            R.drawable.img_12,
            R.drawable.img_13,
            R.drawable.img_14,
            R.drawable.img_15,
            R.drawable.img_16
    };

    String[] link = {
            "https://youtu.be/x09D_WCmEY0",
            "https://youtu.be/b64jBOht8MU",
            "https://youtu.be/_qDML_BCju8",
            "https://youtu.be/BxPaGW55PUo",
            "https://youtu.be/aT5JaB5agSE",
            "https://youtu.be/0qanF-91aJo",
            "https://youtu.be/pAgnJDJN4VA",
            "https://youtu.be/I-QmZpLWjHc",
            "https://youtu.be/S19UcWdOA-I",
            "https://youtu.be/_KztNIg4cvE",
            "https://youtu.be/--eH76tgoNw",
            "https://youtu.be/ONJ2Cr8h6A8",
            "https://youtu.be/4D7u5KF7SP8",
            "https://youtu.be/Qfm6nfz1QNQ",
            "https://youtu.be/jR-OsKMD80c",
            "https://youtu.be/P5yUiK2qNdg"
    };

    String[] Artista= {
            "Tiësto & Dzeko",
            "Bruno Mars",
            "Survivor",
            "James arthur",
            "Smash Mouth",
            "Black Sabbath",
            "AC DC",
            "Fits and the tantrums",
            "Lost sky",
            "Crystals Waters",
            "Rosa linn",
            "Martin Garrix e JVKE",
            "Daft punk",
            "Harry styles",
            "Capital cities",
            "Stromae"
    };
    public void indietro(View view) {
        player.pause();
        Intent Activityindietro = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(Activityindietro);

    }

    public void Youtube(View view){
        player.pause();
        Intent youTube = new Intent(Intent.ACTION_VIEW, Uri.parse(link[Randomnum]));
        startActivity(youTube);
    }
    public void Nomeartista(View view){
        Toast Messaggio = Toast.makeText(this, Artista[Randomnum],
                Toast.LENGTH_SHORT);
        Messaggio.show();
    }
    public void notifica(View v) {


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "notifica")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("ALLERTA ASSALTO NUCLEARE")
                .setContentText("HAI 20 SECONDI PRIMA DELL ESPLOSIONE")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel("notifica", "nome", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("descrizione");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationManagerCompat notifiManager = NotificationManagerCompat.from(this);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        notifiManager.notify(1, builder.build());


    }




}