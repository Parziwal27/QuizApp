package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizPage extends AppCompatActivity {

    private static int score=0;
    String name=MainActivity.getname();
    TextView textView1,textView2;
    Button btn1,btn2,btn3;
    public static int getscore(){
        return score;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        textView1=(TextView) findViewById(R.id.textViewhelloname);
        textView2=(TextView) findViewById(R.id.textViewscorecal);
        textView1.setText(name);
        textView2.setText(Integer.toString(score));
        btn1=(Button) findViewById(R.id.buttonnextquestion1);
        btn2=(Button) findViewById(R.id.buttonQuit);
        TextView textView3=(TextView) findViewById(R.id.textViewcorrect1);
        textView3.setVisibility(View.INVISIBLE);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuizPage.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton r1=(RadioButton) findViewById(R.id.radioButton);
                RadioButton r2=(RadioButton) findViewById(R.id.radioButton2);
                RadioButton r3=(RadioButton) findViewById(R.id.radioButton3);
                RadioButton r4=(RadioButton) findViewById(R.id.radioButton4);

                if(r2.isChecked())
                {
                    textView3.setVisibility(View.VISIBLE);
                    score=score+1;
                    textView3.setText("Correct");
                    textView2.setText(Integer.toString(score));
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
                        Intent i=new Intent(QuizPage.this,QuizPage2.class);
                        startActivity(i);
                    }
                }, 2000);
            }
        });
    }
}