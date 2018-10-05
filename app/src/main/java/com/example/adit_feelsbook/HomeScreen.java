package com.example.adit_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeScreen extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.adit_feelsbook.MESSAGE";
    private ArrayList<Feeling> mFeelingsList;
    private FeelingsManager mFeelingsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mFeelingsManager = new FeelingsManager();
        mFeelingsList = new ArrayList<>();
        // load all saved emotions
        Feeling[] feelingsArray = mFeelingsManager.LoadFeelings();
        mFeelingsList = new ArrayList(Arrays.asList(feelingsArray));
    }

    // Adding feelings
    public void addLove(View view)       { mFeelingsList.add(new Feeling(FeelingState.Love)); }
    public void addJoy(View view)        { mFeelingsList.add(new Feeling(FeelingState.Joy)); }
    public void addSurprise(View view)   { mFeelingsList.add(new Feeling(FeelingState.Surprise)); }
    public void addAnger(View view)      { mFeelingsList.add(new Feeling(FeelingState.Anger)); }
    public void addSadness(View view)    { mFeelingsList.add(new Feeling(FeelingState.Sadness)); }
    public void addFear(View view)       { mFeelingsList.add(new Feeling(FeelingState.Fear)); }

    @Override
    protected void onPause()
    {
        super.onPause();
        Feeling[] feelings;
        Log.d("Serializer", Integer.toString(mFeelingsList.size()));
        feelings = mFeelingsList.toArray(new Feeling[mFeelingsList.size()]);
        mFeelingsManager.SaveFeelings(feelings);
    }

    public void ShowStats(View view)
    {
        // Navigate to the Stats Screen
        Log.d("DEBUG", "SHOWSTATS ENTERED!");

        Intent intent = new Intent(this, FeelingStatsActivity.class);
        String message = "StatsScreen";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void ShowHistory(View view)
    {
        // Navigate to History Screen
        Log.d("DEBUG", "SHOWHISTORY ENTERED!");
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
}
