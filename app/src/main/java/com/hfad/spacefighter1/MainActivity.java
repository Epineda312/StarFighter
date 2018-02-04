package com.hfad.spacefighter1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //image button
    private ImageButton buttonPlay;
    private ImageButton buttonScore;

    //mediaplayer
    MediaPlayer menuSound;
    MediaPlayer gameSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        //getting the button
        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);
        buttonScore = (ImageButton) findViewById(R.id.buttonScore);

        //adding a click listener
        buttonPlay.setOnClickListener(this);
        buttonScore.setOnClickListener(handlerScore);

        //Start Menu Music
        menuSound = MediaPlayer.create(this, R.raw.menumusic);
        menuSound.start();

    }

    @Override
    public void onClick(View v) {
        menuSound.stop();
        //starting game activity
        startActivity(new Intent(this, GameActivity.class));

        //Start Game Music
        gameSound = MediaPlayer.create(this, R.raw.gamemusic);
        gameSound.start();
    }

    View.OnClickListener handlerScore = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Coming soon!!", Toast.LENGTH_SHORT).show();
        }
    };
}

