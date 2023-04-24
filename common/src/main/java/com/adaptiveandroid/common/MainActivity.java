package com.adaptiveandroid.common;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private ImageView main_IV_questionImage;
    private Button main_BTN_option1, main_BTN_option2, main_BTN_option3, main_BTN_option4;
    private int questionNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initVars();
    }

    private void initVars() {
        setQuestion();

        main_BTN_option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextQuestion(main_BTN_option1.getText().toString());
            }
        });

        main_BTN_option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextQuestion(main_BTN_option2.getText().toString());
            }
        });

        main_BTN_option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextQuestion(main_BTN_option3.getText().toString());
            }
        });

        main_BTN_option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextQuestion(main_BTN_option4.getText().toString());
            }
        });
    }

    private void findViews() {
        main_IV_questionImage = findViewById(R.id.main_IV_questionImage);
        main_BTN_option1 = findViewById(R.id.main_BTN_option1);
        main_BTN_option2 = findViewById(R.id.main_BTN_option2);
        main_BTN_option3 = findViewById(R.id.main_BTN_option3);
        main_BTN_option4 = findViewById(R.id.main_BTN_option4);
    }

    public void setNextQuestion(String answer){
        Question q = App_Parent.getQuestionsList()[questionNum];
        if(q.getAnswer().equals(answer)){
            Toast.makeText(this, "Correct answer!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Wrong answer!, correct answer is: " + q.getAnswer(), Toast.LENGTH_LONG).show();
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                questionNum ++;
                setQuestion();
            }
        }, 500);
    }

    public void setQuestion(){
        if(questionNum >= App_Parent.getQuestionsList().length){
            finish();
            return;
        }

        Question q = App_Parent.getQuestionsList()[questionNum];
        Glide
            .with(this)
            .load(q.getImage())
            .into(main_IV_questionImage);

        main_BTN_option1.setText(q.getOptions()[0]);
        main_BTN_option2.setText(q.getOptions()[1]);
        main_BTN_option3.setText(q.getOptions()[2]);
        main_BTN_option4.setText(q.getOptions()[3]);
    }
}