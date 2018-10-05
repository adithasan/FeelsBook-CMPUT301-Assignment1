package com.example.adit_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Map;

public class FeelingStatsActivity extends AppCompatActivity {

    Map<FeelingState, Integer> mFeelingsMap;
    FeelingsManager mFeelingsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling_stats);
        mFeelingsManager = new FeelingsManager();
        mFeelingsMap = mFeelingsManager.LoadFeelingsStats();
    }
}
