package com.missouristate.davis916.guessinggame;

/**
 * Laura Davis
 * 5 March 2018
 *
 * Data model for the guessing game
 */

public class Data {

    private int mRandNum;
    private int mGuess;
    private String rw;

    public void setRandNum(int randNum){
        mRandNum = randNum;
    }

    public void setGuess(int guess){
        mGuess = guess;
    }

    public String check(){

        if(mGuess == mRandNum) {
            rw = "WIN! ";
        }
        else{
            rw = "lose. ";
        }
        return rw;
    }

    public int getRandNum(){
        return mRandNum;
    }

    public int getGuess(){
        return mGuess;
    }

}//end data class


