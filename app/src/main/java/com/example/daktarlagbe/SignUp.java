package com.example.daktarlagbe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SignUp extends AppCompatActivity {

    EditText userName, age;
    TextView gMale,gFemale;
    ImageView previousBtn, nextBtn;
    Animation btnMove;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        userName = findViewById(R.id.userName);
        age = findViewById(R.id.age);

        gMale = findViewById(R.id.gMale);
        gFemale = findViewById(R.id.gFemale);

        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);

        btnMove = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.button_move);

        timer = new Timer();

        gMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gFemale.setEnabled(false);
                gMale.setBackgroundResource(R.drawable.selected_btn_background);
                gMale.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        gFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gMale.setEnabled(false);
                gFemale.setBackgroundResource(R.drawable.selected_btn_background);
                gFemale.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        /*if(!userName.getText().toString().isEmpty() && !age.getText().toString().isEmpty()){
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nextBtn.startAnimation(btnMove);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent next = new Intent(SignUp.this,SignUpComplete.class);
                            startActivity(next);
                        }
                    },2000);
                }
            });
        }else {
            nextBtn.setEnabled(false);
        }*/

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextBtn.startAnimation(btnMove);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent next = new Intent(SignUp.this,SignUpComplete.class);
                        startActivity(next);
                    }
                },1500);
            }
        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousBtn.setBackgroundResource(R.drawable.color_arrow);
                Intent preview = new Intent(SignUp.this,OtpActivity.class);
                startActivity(preview);
            }
        });
    }
}