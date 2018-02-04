package com.hfad.spacefighter1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class game_over extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Intent intent = getIntent();

        int score = intent.getIntExtra("EXTRA_score",0);

        String scores= "Score: " + Integer.toString(score);

        TextView fScore = (TextView)findViewById(R.id.score);

        fScore.setText(scores);

    }
}
