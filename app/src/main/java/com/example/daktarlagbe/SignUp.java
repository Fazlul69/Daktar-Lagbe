package com.example.daktarlagbe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SignUp extends AppCompatActivity {

    TextView gMale,gFemale;
    ImageView previousBtn, nextBtn;
    Animation btnMove;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

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
                gMale.setBackgroundResource(R.drawable.selected_btn_background);
                gMale.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        gFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gFemale.setBackgroundResource(R.drawable.selected_btn_background);
                gFemale.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextBtn.startAnimation(btnMove);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                      /*  frameAnimation = (AnimationDrawable)loadingAnim.getDrawable();
                        frameAnimation.start();*/
                        Intent next = new Intent(SignUp.this,SignUpComplete.class);
                        startActivity(next);
                    }
                },2000);
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