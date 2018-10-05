package com.example.adit_feelsbook;

import java.util.Date;

public class Feeling
{
    /* This is the class data structure
    used to hold the feelings, they are designed to be
    a data class almost and most operations are done
    by the FeelingsManager class

    Since there is very little deviation between feelings,
    there doesn't seem to exist a good engineering reason
    to split feelings into subclasses until specialized
    behaviour is required.

    It is also safer to deserialize into Feeling objects
    than individual subclasses since this allows us to
    store all the feelings in the same JSON together
     */

    protected String mComment;
    protected Date mTimeStamp;
    protected int mIndex;
    protected FeelingState mFeelingState;

    public Feeling(FeelingState feelingState)
    {
        mFeelingState = feelingState;
        mTimeStamp = new Date();
        mComment = "";
    }

    public Feeling(FeelingState feelingState, String comment)
    {
        mFeelingState = feelingState;
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

    public FeelingState GetFeelingState()
    {
        return mFeelingState;
    }
}
