package com.missouristate.davis916.guessinggame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.Resources;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Laura Davis
 * 5 March 2018
 *
 * This is a simple guessing game in which
 * the player can chooses a number between
 * 1 and 10 and their guess is checked against
 * a random number.
 *
 */

public class MainActivity extends AppCompatActivity {

    //Declare variables
    String answer;
    String winLose;
    String myGuess;
    String win;
    String lose;
    int randNum;
    Random rand = new Random();

    private TextView guess;
    Data mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guess = (TextView) findViewById(R.id.textView0);
        randNum = rand.nextInt(10) + 1;
        mData = new Data();

        Button guessbutton = (Button) findViewById(R.id.guessbtn);
        guessbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collectData();
                build();

                Intent launchNow = new Intent(MainActivity.this, AnswerActivity.class);

                launchNow.putExtra("answer", answer);
                launchNow.putExtra("win", win);
                launchNow.putExtra("lose", lose);

                startActivity(launchNow);
            }//end onClick()
        });

    }//end onCreate()

    public void showNum(View view){
        String val = (String) guess.getText();
        String mNum = (String) view.getContentDescription();
        if(val.charAt(0) == '0')
            guess.setText(mNum);
        else
            guess.setText((String) guess.getText() + mNum.charAt(0));
    }//end showNum()

    private void collectData(){
        mData.setGuess((int)Integer.valueOf(guess.getText().toString()));
        mData.setRandNum((int)Integer.valueOf(randNum));
        mData.check();

    }//end collectData()

    private void build(){
        Resources res = getResources();
        winLose = mData.check();
        if(winLose == "WIN! "){
            winLose = win;
            win = res.getString(R.string.msg) + " " + mData.check();
        }
        else{
            winLose = lose;
            lose = res.getString(R.string.msg) + " " + mData.check();
        }
        answer = res.getString(R.string.answer) + " " + mData.getRandNum();
        myGuess = Integer.toString(mData.getGuess());
    }//end build()

}//end MainActivity class
