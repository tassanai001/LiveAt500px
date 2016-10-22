package com.example.tassanai.onlinecourse.liveat500px;

import android.app.Application;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;


/**
 * Created by Tassanai on 10/9/2016.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //init here(s) here
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
