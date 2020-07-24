package com.example.daktarlagbe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class LanguageActivity extends AppCompatActivity {

    ImageView langiageanim;
    AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        langiageanim = findViewById(R.id.languageanim);
        langiageanim.setImageResource(R.drawable.languageanim);
        frameAnimation = (AnimationDrawable)langiageanim.getDrawable();
        frameAnimation.start();
    }
}