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

public class QuizPage3 extends AppCompatActivity {

    private static int score3=QuizPage2.getScore2();
    String name=MainActivity.getname();
    TextView textView1,textView2;
    Button btn1,btn2,btn3;
    public static int getScore3(){return score3;}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page3);
        textView1=(TextView) findViewById(R.id.textViewhelloname3);
        textView1.setText(name);
        textView2=(TextView) findViewById(R.id.textViewscorecal3);
        textView2.setText(Integer.toString(score3));
        TextView textView3=(TextView) findViewById(R.id.textViewcorrect3);
        textView3.setVisibility(View.INVISIBLE);
        btn1=(Button) findViewById(R.id.buttonnextquestion3);
        btn2=(Button) findViewById(R.id.buttonQuit3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuizPage3.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton r1=(RadioButton) findViewById(R.id.radioButton3a);
                RadioButton r2=(RadioButton) findViewById(R.id.radioButton3b);
                RadioButton r3=(RadioButton) findViewById(R.id.radioButton3c);
                RadioButton r4=(RadioButton) findViewById(R.id.radioButton3d);

                if(r1.isChecked())
                {
                    textView3.setVisibility(View.VISIBLE);
                    score3=score3+1;
                    textView3.setText("Correct");
                    textView2.setText(Integer.toString(score3));
                }
                else
                {
                    textView3.setVisibility(View.VISIBLE);
                    textView3.setText("Wrong");
                }
                Toast.makeText(getApplicationContext(),"Next question loading",Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent i=new Intent(QuizPage3.this,QuizPage4.class);
                        startActivity(i);
                    }
                }, 2000);
            }
        });

    }
}