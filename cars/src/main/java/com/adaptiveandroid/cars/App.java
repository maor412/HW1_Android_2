package com.adaptiveandroid.cars;

import com.adaptiveandroid.common.App_Parent;
import com.adaptiveandroid.common.Question;

public class App extends App_Parent {

    @Override
    protected void setMOB_ADS_ID() {
        MOB_ADS_ID = BuildConfig.MOBAD_ID;
    }

    @Override
    protected void CreateQuestionsList() {
        questionsList = Question.generateQuestions(this, "cars.json");
    }
}
