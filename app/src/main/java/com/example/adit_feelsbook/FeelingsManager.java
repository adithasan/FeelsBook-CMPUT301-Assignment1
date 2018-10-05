package com.example.adit_feelsbook;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FeelingsManager
{
    // This class will handle all operations on and by feelings
    // This will involve but not be limited to:
    // Serializing/Deserializing from JSON file
    // Saving/Loading
    // Editing, Deleting
    // Stat calculation

    private static final String fileName = "FeelingsData.dat";

    public void SaveFeelings(Feeling[] feelings)
    {
        String fileContents = Serialize(feelings);
        SaveToFile(fileContents);
    }

    public Feeling[] LoadFeelings()
    {
        String fileContents = LoadFromFile();
        return  Deserialize(fileContents);
    }

    private Feeling[] Deserialize(String fileContents)
    {
        Gson gson = new Gson();
        Feeling [] feelings;
        feelings = gson.fromJson(fileContents, Feeling[].class);
        return feelings;
    }

    private String Serialize(Feeling[] feelings)
    {
        Gson gson = new Gson();
        String fileContents = new String();
        fileContents = gson.toJson(feelings);
        return fileContents;
    }

    // Acknowledgement
    // Source: Arslan : StackOverflow user
    // https://stackoverflow.com/a/9095665
    // Accessed: Oct 4, 2018
    // Post created: Feb 1, 2012
    private String LoadFromFile()
    {
        StringBuffer datax = new StringBuffer("");
        try {
            FileInputStream inputStream = ApplicationContextProvider.getContext().openFileInput ( fileName) ;
            InputStreamReader streamReader = new InputStreamReader ( inputStream ) ;
            BufferedReader bufferReader = new BufferedReader( streamReader ) ;

            String readString = bufferReader.readLine();
            while ( readString != null ) {
                datax.append(readString);
                readString = bufferReader.readLine ( ) ;
            }

            inputStream.close ( ) ;
        } catch ( IOException ioe ) {
            ioe.printStackTrace ( ) ;
        }
        return datax.toString() ;
    }

    private void SaveToFile(String fileContents)
    {
        FileOutputStream outputStream;

        try {
            outputStream = ApplicationContextProvider.getContext().openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<FeelingState, Integer> LoadFeelingStats()
    {
        Map<FeelingState, Integer> feelingsMap = new HashMap<>();
        Feeling[] feelings = LoadFeelings();

        for (Feeling feeling : feelings)
        {
            Integer count = feelingsMap.containsKey(feeling.mFeelingState) ? feelingsMap.get(feeling.mFeelingState) : 0;
            feelingsMap.put(feeling.mFeelingState, count + 1);
        }
        return feelingsMap;
    }
}
