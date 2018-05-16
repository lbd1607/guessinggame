package com.missouristate.davis916.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Laura Davis
 * 5 March 2018
 *
 * The activity for the answer screen.
 * Populates the TextViews with a win or lose
 * message, the player's guess, and the
 * randomly generated answer.
 */

public class AnswerActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        TextView announceW = (TextView) findViewById(R.id.textView2a);
        TextView announceL = (TextView) findViewById(R.id.textView2b);
        TextView trueAns = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();

        String ans;
        ans = intent.getStringExtra("answer");
        trueAns.setText(ans);
        String w;
        w = intent.getStringExtra("win");
        announceW.setText(w);
        String l;
        l = intent.getStringExtra("lose");
        announceL.setText(l);

        Button playAgain = (Button) findViewById(R.id.playAgainbtn);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchAgain = new Intent(AnswerActivity.this, MainActivity.class);
                startActivity(launchAgain);
            }
        });

    }//end onCreate()

}//end AnswerActivity class
