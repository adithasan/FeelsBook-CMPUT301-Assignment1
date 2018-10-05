package com.example.adit_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    // TODO: modify this to include the real file name
    public static final String FILE_NAME = "SOME_FILE_NAME";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public void LoadFeelings(ArrayList<Feeling> feelings)
    {
        // TODO: move this function to a class to be used everywhere
        feelings.add(new Joy("This is the first joy feeling"));
        feelings.add(new Love("Love feeling added!"));
        feelings.add(new Anger());
        feelings.add(new Sadness("Added sadness"));
        feelings.add(new Joy("This is the first joy feeling"));
        feelings.add(new Love("Love feeling added!"));
        feelings.add(new Anger());
        feelings.add(new Sadness("Added sadness"));
        feelings.add(new Joy("This is the first joy feeling"));
        feelings.add(new Love("Love feeling added!"));
        feelings.add(new Anger());
        feelings.add(new Sadness("Added sadness"));
        feelings.add(new Joy("This is the first joy feeling"));
        feelings.add(new Love("Love feeling added!"));
        feelings.add(new Anger());
        feelings.add(new Sadness("Added sadness"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mRecyclerView = (RecyclerView) findViewById(R.id.Feelings_RecyclerView);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Feeling> feelings = new ArrayList<>();
        LoadFeelings(feelings);

        mAdapter = new FeelingEntryRecyclerViewAdapter(feelings);
        mRecyclerView.setAdapter(mAdapter);
        // load data from JSON file and populate the Arraylist of Feelings
    }
}
