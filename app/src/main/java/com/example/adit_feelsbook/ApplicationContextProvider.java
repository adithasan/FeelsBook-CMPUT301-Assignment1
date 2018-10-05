package com.example.adit_feelsbook;

import android.app.Application;
import android.content.Context;

public class ApplicationContextProvider extends Application
{

    // Acknowledgement:
    // Source: Laura Sicui : myandroidsolutions.com
    // https://www.myandroidsolutions.com/2013/04/27/android-get-application-context/#.W7fMqhNKjVp
    // Accessed: Oct 4, 2018
    // Post last updated: Aug 13, 2018
    /**
     * Keeps a reference of the application context
     */
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

    }

    /**
     * Returns the application context
     *
     * @return application context
     */
    public static Context getContext() {
        return sContext;
    }
}
