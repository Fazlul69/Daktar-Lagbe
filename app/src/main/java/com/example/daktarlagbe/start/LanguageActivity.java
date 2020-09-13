package com.example.daktarlagbe.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.daktarlagbe.R;

public class LanguageActivity extends AppCompatActivity {

    ImageView langiageanim;
    AnimationDrawable frameAnimation;

    Button engBtn, banglgaBtn;
    ImageView previousBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_language);

        langiageanim = findViewById(R.id.languageanim);
        langiageanim.setImageResource(R.drawable.languageanim);
        frameAnimation = (AnimationDrawable)langiageanim.getDrawable();
        frameAnimation.start();

        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);

        engBtn = findViewById(R.id.engBtn);
        banglgaBtn = findViewById(R.id.banglaBtn);

        engBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banglgaBtn.setEnabled(false);
                engBtn.setBackgroundResource(R.drawable.selected_btn_background);
                engBtn.setTextColor(Color.parseColor("#ffffff"));
                nextBtn.setBackgroundResource(R.drawable.color_arrow);
                nextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent next = new Intent(LanguageActivity.this,PhoneActivity.class);
                        startActivity(next);
                    }
                });
            }
        });

        banglgaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engBtn.setEnabled(false);
                banglgaBtn.setBackgroundResource(R.drawable.selected_btn_background);
                banglgaBtn.setTextColor(Color.parseColor("#ffffff"));
                nextBtn.setBackgroundResource(R.drawable.color_arrow);
                nextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent next = new Intent(LanguageActivity.this,PhoneActivity.class);
                        startActivity(next);
                    }
                });
            }
        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousBtn.setBackgroundResource(R.drawable.color_arrow);
                Intent preview = new Intent(LanguageActivity.this,WelcomeActivity.class);
                startActivity(preview);
            }
        });


    }
}