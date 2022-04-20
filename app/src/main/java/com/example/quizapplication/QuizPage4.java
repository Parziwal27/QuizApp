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

public class QuizPage4 extends AppCompatActivity {

    private static int score4=QuizPage3.getScore3();
    String name=MainActivity.getname();
    TextView textView1,textView2;
    Button btn1,btn2,btn3;
    public static int getScore4(){return score4;}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page4);
        textView1=(TextView) findViewById(R.id.textViewhelloname4);
        textView1.setText(name);
        textView2=(TextView) findViewById(R.id.textViewscorecal4);
        textView2.setText(Integer.toString(score4));
        TextView textView3=(TextView) findViewById(R.id.textViewcorrect4);
        textView3.setVisibility(View.INVISIBLE);
        btn1=(Button) findViewById(R.id.buttonnextquestion4);
        btn2=(Button) findViewById(R.id.buttonQuit4);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuizPage4.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton r1=(RadioButton) findViewById(R.id.radioButton4a);
                RadioButton r2=(RadioButton) findViewById(R.id.radioButton4b);
                RadioButton r3=(RadioButton) findViewById(R.id.radioButton4c);
                RadioButton r4=(RadioButton) findViewById(R.id.radioButton4d)   ;

                if(r2.isChecked())
                {
                    textView3.setVisibility(View.VISIBLE);
                    score4=score4+1;
                    textView3.setText("Correct");
                    textView2.setText(Integer.toString(score4));
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
                        Intent i=new Intent(QuizPage4.this,QuizPage5.class);
                        startActivity(i);
                    }
                }, 2000);
            }
        });

    }
}