package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizPage5 extends AppCompatActivity {

    private static int score5=QuizPage4.getScore4();
    String name=MainActivity.getname();
    TextView textView1,textView2;
    Button btn1,btn2,btn3;
    public static int getScore5(){return score5;}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page5);
        textView1=(TextView) findViewById(R.id.textViewhelloname5);
        textView1.setText(name);
        textView2=(TextView) findViewById(R.id.textViewscorecal5);
        textView2.setText(Integer.toString(score5));
        TextView textView3=(TextView) findViewById(R.id.textViewcorrect5);
        textView3.setVisibility(View.INVISIBLE);
        btn1=(Button) findViewById(R.id.buttonnextquestion5);
        btn2=(Button) findViewById(R.id.buttonQuit5);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuizPage5.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton r1=(RadioButton) findViewById(R.id.radioButton5a);
                RadioButton r2=(RadioButton) findViewById(R.id.radioButton5b);
                RadioButton r3=(RadioButton) findViewById(R.id.radioButton5c);
                RadioButton r4=(RadioButton) findViewById(R.id.radioButton5d);

                if(r1.isChecked())
                {
                    textView3.setVisibility(View.VISIBLE);
                    score5=score5+1;
                    textView3.setText("Correct");
                    textView2.setText(Integer.toString(score5));
                }
                else
                {
                    textView3.setVisibility(View.VISIBLE);
                    textView3.setText("Wrong");
                }
                Toast.makeText(getApplicationContext(),"Quiz finished. Calculating Result",Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent i=new Intent(QuizPage5.this,Report.class);
                        startActivity(i);
                    }
                }, 2000);
            }
        });

    }
}