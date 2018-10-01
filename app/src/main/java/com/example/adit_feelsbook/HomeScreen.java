package com.example.adit_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    private ArrayList<Feeling> mFeelingsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mFeelingsList = new ArrayList<>();
        // load all saved emotions
    }

    // Adding feelings
    public void addLove(View view)       { mFeelingsList.add(new Love()); }
    public void addJoy(View view)        { mFeelingsList.add(new Joy()); }
    public void addSurprise(View view)   { mFeelingsList.add(new Surprise()); }
    public void addAnger(View view)      { mFeelingsList.add(new Anger()); }
    public void addSadness(View view)    { mFeelingsList.add(new Sadness()); }
    public void addFear(View view)       { mFeelingsList.add(new Fear()); }

    public void ShowHistory(View view)
    {
        // Will eventually take you to new activity

        // For now just print to log
        for (Feeling feeling : mFeelingsList)
        {
            String log = "Added " + feeling.GetFeelingName() + " at: " + feeling.mTimeStamp.toString();
            Log.d("History", log);
        }
    }
}
