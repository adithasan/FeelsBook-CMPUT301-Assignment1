package com.example.adit_feelsbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FeelingEntryRecyclerViewAdapter extends RecyclerView.Adapter<FeelingEntryRecyclerViewAdapter.FeelingViewHolder> {
    private ArrayList<Feeling> mFeelings;

    public static class FeelingViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mFeelingName;
        public TextView mComment;
        public TextView mTimeStamp;

        public FeelingViewHolder(View itemView)
        {
            super(itemView);
            mFeelingName = (TextView) itemView.findViewById(R.id.feelings_item_Name);
            mComment = (TextView) itemView.findViewById(R.id.feelings_item_Comment);
            mTimeStamp = (TextView) itemView.findViewById(R.id.feelings_item_TimeStamp);
        }
    }

    public FeelingEntryRecyclerViewAdapter(ArrayList<Feeling> feelings) { mFeelings = feelings; }

    // Create new views (invoked by the layout manager)
    @Override
    public FeelingEntryRecyclerViewAdapter.FeelingViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.feelings_list_view_row, parent, false);
        FeelingViewHolder vh = new FeelingViewHolder(v);
        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(FeelingViewHolder holder, int position)
    {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mFeelingName.setText(mFeelings.get(position).GetFeelingName());
        holder.mComment.setText(mFeelings.get(position).GetComment());
        holder.mTimeStamp.setText(mFeelings.get(position).GetTimeStamp().toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount()
    {
        return mFeelings.size();
    }
}
