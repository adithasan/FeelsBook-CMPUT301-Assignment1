package com.example.adit_feelsbook;

import java.util.Date;

public class Feeling
{
    protected String mComment;
    protected Date mTimeStamp;
    protected int mIndex;
    protected FeelingState mFeelingState;

    public Feeling()
    {
        mTimeStamp = new Date();
        mComment = "";
    }

    public Feeling(String comment)
    {
        mTimeStamp = new Date();
        mComment = comment;
    }


    public Date GetTimeStamp()
    {
        return mTimeStamp;
    }

    public void SetTimeStamp(Date timeStamp)
    {
        mTimeStamp = timeStamp;
    }

    public String GetComment()
    {
        return mComment;
    }

    public void SetComment(String comment)
    {
        mComment = comment;
    }

    public void SetIndex(int index)
    {
        mIndex = index;
    }

    public int GetIndex()
    {
        return mIndex;
    }

    public FeelingState GetFeelingName()
    {
        return mFeelingState;
    }
}
