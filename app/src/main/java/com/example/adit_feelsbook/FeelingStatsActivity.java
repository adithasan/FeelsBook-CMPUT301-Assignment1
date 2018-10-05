package com.example.adit_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Map;

public class FeelingStatsActivity extends AppCompatActivity {

    Map<FeelingState, Integer> mFeelingsMap;
    FeelingsManager mFeelingsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling_stats);
        // load the stats from the saved feelings
        mFeelingsManager = new FeelingsManager();
        mFeelingsMap = mFeelingsManager.LoadFeelingStats();

        // Set the appropriate text boxes to display the values
        Integer numJoy = mFeelingsMap.containsKey(FeelingState.Joy) ? mFeelingsMap.get(FeelingState.Joy) : 0;
        TextView numJoyView = (TextView) findViewById(R.id.numJoy);
        numJoyView.setText(numJoy.toString());

        Integer numSadness = mFeelingsMap.containsKey(FeelingState.Sadness) ? mFeelingsMap.get(FeelingState.Sadness) : 0;
        TextView numSadnessView = (TextView) findViewById(R.id.numSadness);
        numSadnessView.setText(numSadness.toString());

        Integer numAnger = mFeelingsMap.containsKey(FeelingState.Anger) ? mFeelingsMap.get(FeelingState.Anger) : 0;
        TextView numAngerView = (TextView) findViewById(R.id.numAnger);
        numAngerView.setText(numAnger.toString());

        Integer numSurprise = mFeelingsMap.containsKey(FeelingState.Surprise) ? mFeelingsMap.get(FeelingState.Surprise) : 0;
        TextView numSurpriseView = (TextView) findViewById(R.id.numSurprise);
        numSurpriseView.setText(numSurprise.toString());

        Integer numFear = mFeelingsMap.containsKey(FeelingState.Fear) ? mFeelingsMap.get(FeelingState.Fear) : 0;
        TextView numFearView = (TextView) findViewById(R.id.numFear);
        numFearView.setText(numFear.toString());

        Integer numLove = mFeelingsMap.containsKey(FeelingState.Love) ? mFeelingsMap.get(FeelingState.Love) : 0;
        TextView numLoveView = (TextView) findViewById(R.id.numLove);
        numLoveView.setText(numLove.toString());
    }
}
