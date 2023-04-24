package com.adaptiveandroid.common;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {
    private String image;
    private String[] options;
    private String answer;

    public Question(){}

    public String getImage() {
        return image;
    }

    public Question setImage(String image) {
        this.image = image;
        return this;
    }

    public String[] getOptions() {
        return options;
    }

    public Question setOptions(String[] options) {
        this.options = options;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Question setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public static Question[] generateQuestions(Context context, String jsonFile){
        Gson gson = new Gson();
        try {
            InputStream inputStream = context.getAssets().open(jsonFile);
            Reader reader = new InputStreamReader(inputStream);
            Question[] questions = gson.fromJson(reader, Question[].class);
            for(int i = 0; i < questions.length; i++){
                List<String> options = Arrays.asList(questions[i].getOptions());
                Collections.shuffle(options);
                questions[i].setOptions(options.toArray(questions[i].getOptions()));
            }
            reader.close();
            inputStream.close();
            return questions;
        } catch (IOException e) {
            e.printStackTrace();
            return new Question[0];
        }
    }
}
