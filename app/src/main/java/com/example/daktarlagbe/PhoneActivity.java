package com.example.daktarlagbe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PhoneActivity extends AppCompatActivity {

    LinearLayout phoneLogoLayout, layoutBtnForNext;
    EditText phoneNumber;
    ImageView phoneLogo;
    ImageView previousBtn, nextBtn;
    int logoChangeImage = R.drawable.logonumber;
    int width = 230;
    int height = 230;
    Animation btnMove;
    Timer timer;
    TextView warning;
/*    ImageView loadingAnim;
    AnimationDrawable frameAnimation;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phone);

        phoneLogoLayout = findViewById(R.id.phoneLogoLayout);
        phoneNumber = findViewById(R.id.phoneNumber);
        phoneLogo = findViewById(R.id.phoneLogo);

        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);
        layoutBtnForNext = findViewById(R.id.layoutBtn);
        warning = findViewById(R.id.warning);

        btnMove = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.button_move);

        timer = new Timer();

/*        loadingAnim = findViewById(R.id.loadingAnim);
        loadingAnim.setImageResource(R.drawable.update_anim);*/

        final LinearLayout.LayoutParams ip =new LinearLayout.LayoutParams(width,height);

        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneLogoLayout.setBackgroundResource(R.drawable.phone_anim);
                phoneNumber.setBackgroundResource(R.drawable.number_background_white);
                phoneLogo.setImageResource(logoChangeImage);
                phoneLogo.setLayoutParams(ip);

                if (phoneNumber.getText().toString().isEmpty()) {
                    warning.setVisibility(View.VISIBLE);
                } else {
                    warning.setVisibility(View.GONE);
                    nextBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            nextBtn.startAnimation(btnMove);
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    Intent next = new Intent(PhoneActivity.this,OtpActivity.class);
                                    startActivity(next);
                                }
                            },1500);
                        }
                    });
                }
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


    }

}