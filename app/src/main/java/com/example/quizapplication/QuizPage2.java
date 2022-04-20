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

public class QuizPage2 extends AppCompatActivity {
    private static int score2=QuizPage.getscore();
    String name=MainActivity.getname();
    TextView textView1,textView2;
    Button btn1,btn2,btn3;
    public static int getScore2(){return score2;}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page2);
        textView1=(TextView) findViewById(R.id.textViewhelloname2);
        textView1.setText(name);
        textView2=(TextView) findViewById(R.id.textViewscorecal2);
        textView2.setText(Integer.toString(score2));
        TextView textView3=(TextView) findViewById(R.id.textViewcorrect2);
        textView3.setVisibility(View.INVISIBLE);
        btn1=(Button) findViewById(R.id.buttonnextquestion2);
        btn2=(Button) findViewById(R.id.buttonQuit2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuizPage2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton r1=(RadioButton) findViewById(R.id.radioButton2a);
                RadioButton r2=(RadioButton) findViewById(R.id.radioButton2b);
                RadioButton r3=(RadioButton) findViewById(R.id.radioButton2c);
                RadioButton r4=(RadioButton) findViewById(R.id.radioButton2d);

                if(r2.isChecked())
                {
                    textView3.setVisibility(View.VISIBLE);
                    score2=score2+1;
                    textView3.setText("Correct");
                    textView2.setText(Integer.toString(score2));
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
                        Intent i=new Intent(QuizPage2.this,QuizPage3.class);
                        startActivity(i);
                    }
                }, 2000);
            }
        });

    }

}