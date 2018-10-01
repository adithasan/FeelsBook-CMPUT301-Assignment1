package com.example.adit_feelsbook;

import java.util.Date;

public abstract class Feeling
{
    protected String mComment;
    protected Date mTimeStamp;

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

    public abstract String GetFeelingName();
}
