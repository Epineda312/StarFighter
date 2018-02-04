package com.hfad.spacefighter1;

import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    //declaring GameView
    private GameView gameView;
    MediaPlayer menuSound;
    MediaPlayer gameSound;

    //creating a way to end game
    int seconds= 0;
    Timer myTimer = new Timer();
    TimerTask task =new TimerTask() {
        @Override
        public void run() {
            seconds++;
            if(seconds==20)
                gameOver();


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Getting display object
        Display display = getWindowManager().getDefaultDisplay();

        //Getting the screen resolution into point object
        Point size = new Point();
        display.getSize(size);

        //Initializing game view object
        //this time we are also passing the screen size to the GameView constructor
        gameView = new GameView(this, size.x, size.y);

        //adding it to contentview
        setContentView(gameView);

        start(); // start timer for game to end


    }

    public void gameOver()
    {
        Intent intent = new Intent(this, game_over.class);
        intent.putExtra("EXTRA_score",GameView.score);
        startActivity(intent);

    }
    public void start()
    {
        myTimer.scheduleAtFixedRate(task,1000,1000);





    }

    //pausing the game when activity is paused
    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    //running the game when activity is resumed
    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
    @Override
    public void onBackPressed() {
        //End current activity
        this.finish();

        //Set to menu
        setContentView(R.layout.activity_main);
        //Start Menu Music
        menuSound = MediaPlayer.create(this, R.raw.menumusic);
        menuSound.start();

        GameView.score =0;

    }
}