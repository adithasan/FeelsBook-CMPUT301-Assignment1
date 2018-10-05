package com.example.adit_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class HistoryActivity extends AppCompatActivity {

    // TODO: modify this to include the real file name
    public static final String FILE_NAME = "SOME_FILE_NAME";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FeelingsManager mFeelingsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent intent = getIntent();
        String message = intent.getStringExtra(HomeScreen.EXTRA_MESSAGE);
        if (message == "StatsScreen") return;

        mRecyclerView = (RecyclerView) findViewById(R.id.Feelings_RecyclerView);

        mFeelingsManager = new FeelingsManager();

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Feeling> feelings;
        Feeling[] feelingsArray = mFeelingsManager.LoadFeelings();
        feelings = new ArrayList(Arrays.asList(feelingsArray));

        mAdapter = new FeelingEntryRecyclerViewAdapter(feelings);
        mRecyclerView.setAdapter(mAdapter);
        // load data from JSON file and populate the Arraylist of Feelings
    }
}
