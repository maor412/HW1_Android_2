package com.adaptiveandroid.common;

import android.app.Application;

public abstract class App_Parent extends Application {

    protected static Question[] questionsList;
    protected static String MOB_ADS_ID;

    protected abstract void setMOB_ADS_ID();
    protected abstract void CreateQuestionsList();

    @Override
    public void onCreate(){
        super.onCreate();

        setMOB_ADS_ID();
        CreateQuestionsList();
    }

    public static String getMobAdsId(){
        return MOB_ADS_ID;
    }

    public static Question[] getQuestionsList(){
        return questionsList;
    }
}
