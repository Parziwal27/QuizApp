package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Report extends AppCompatActivity {
    int score=QuizPage5.getScore5();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        TextView textView=(TextView) findViewById(R.id.textViewtotalcorrectscore);
        textView.setText(Integer.toString(score));
        TextView textView2=(TextView) findViewById(R.id.textViewtotalwrongscore);
        textView2.setText(Integer.toString(5-score));
        Button btn=(Button) findViewById(R.id.buttonRestart);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Report.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}