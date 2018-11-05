package com.example.home.mathgamev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton = (Button) findViewById(R.id.startButton);


        if (getIntent().hasExtra("winState"))
        {   TextView score = (TextView) findViewById(R.id.scoreTextView);
            TextView txt1 = (TextView) findViewById(R.id.textView);
            String txt = getIntent().getExtras().getString("winState");
            int gameScore = getIntent().getExtras().getInt("Score");
            score.setText("Score: "+ gameScore);
            txt1.setText(txt);
//aaaaaaagagagaCHANGERIGHTNOW
        }
        if (getIntent().hasExtra("newGame"))
        {

            String txt = getIntent().getExtras().getString("newGame");
            startButton.setText(txt);

        }


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(startIntent);
            }
        });




    }
}
