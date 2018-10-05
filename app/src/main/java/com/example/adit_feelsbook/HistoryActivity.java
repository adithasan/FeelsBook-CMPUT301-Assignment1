package com.example.adit_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/*
    This activity class holds a scrollable and selectable
    list of feelings that have been saved
 */
public class HistoryActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FeelingsManager mFeelingsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mRecyclerView = (RecyclerView) findViewById(R.id.Feelings_RecyclerView);

        mFeelingsManager = new FeelingsManager();

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // load data from JSON file and populate the Arraylist of Feelings
        ArrayList<Feeling> feelings;
        Feeling[] feelingsArray = mFeelingsManager.LoadFeelings();
        feelings = new ArrayList(Arrays.asList(feelingsArray));

        mAdapter = new FeelingEntryRecyclerViewAdapter(feelings);
        mRecyclerView.setAdapter(mAdapter);
    }
}
