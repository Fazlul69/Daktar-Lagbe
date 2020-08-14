package com.example.daktarlagbe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView logo;
    AnimationDrawable frameAnimation;
    ImageView getStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        logo = findViewById(R.id.logo);
        getStarted = findViewById(R.id.getStarted);
        logo.setImageResource(R.drawable.logoanim);

        frameAnimation = (AnimationDrawable)logo.getDrawable();
        frameAnimation.start();

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getstartedIntend = new Intent(WelcomeActivity.this, LanguageActivity.class);
                startActivity(getstartedIntend);
            }
        });

    }
}