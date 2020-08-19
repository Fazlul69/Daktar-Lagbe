package com.example.daktarlagbe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class OtpActivity extends AppCompatActivity {

    ImageView previousBtn, nextBtn;
    Animation btnMove;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_otp);

        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);

        btnMove = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.button_move);

        timer = new Timer();


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextBtn.startAnimation(btnMove);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                      /*  frameAnimation = (AnimationDrawable)loadingAnim.getDrawable();
                        frameAnimation.start();*/
                        Intent next = new Intent(OtpActivity.this,SignUp.class);
                        startActivity(next);
                    }
                },1500);
            }
        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousBtn.setBackgroundResource(R.drawable.color_arrow);
                Intent preview = new Intent(OtpActivity.this,PhoneActivity.class);
                startActivity(preview);
            }
        });
    }
}