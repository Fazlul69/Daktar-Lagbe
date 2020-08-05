package com.example.daktarlagbe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class PhoneActivity extends AppCompatActivity {

    LinearLayout phoneLogoLayout;
    EditText phoneNumber;
    ImageView phoneLogo;
    ImageView previousBtn, nextBtn;
    int logoChangeImage = R.drawable.logonumber;
    int width = 230;
    int height = 230;
    Animation btnMove;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        phoneLogoLayout = findViewById(R.id.phoneLogoLayout);
        phoneNumber = findViewById(R.id.phoneNumber);
        phoneLogo = findViewById(R.id.phoneLogo);

        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);

        btnMove = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.button_move);

        timer = new Timer();

        final LinearLayout.LayoutParams ip =new LinearLayout.LayoutParams(width,height);

        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneLogoLayout.setBackgroundResource(R.drawable.phone_anim);
                phoneNumber.setBackgroundResource(R.drawable.number_background_white);
                phoneLogo.setImageResource(logoChangeImage);
                phoneLogo.setLayoutParams(ip);
            }
        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousBtn.setBackgroundResource(R.drawable.color_arrow);
                Intent preview = new Intent(PhoneActivity.this,LanguageActivity.class);
                startActivity(preview);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextBtn.setBackgroundResource(R.drawable.color_arrow);
                nextBtn.startAnimation(btnMove);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent next = new Intent(PhoneActivity.this,OtpActivity.class);
                        startActivity(next);
                    }
                },4000);
            }
        });
    }
}