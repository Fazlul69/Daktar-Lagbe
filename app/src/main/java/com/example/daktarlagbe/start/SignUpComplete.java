package com.example.daktarlagbe.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daktarlagbe.MapsActivity;
import com.example.daktarlagbe.R;

public class SignUpComplete extends AppCompatActivity {

    private static int SPLASH_SCREEN =2000;
    Animation left_anim, right_anim, text_one_anim,text_two_anim;
    ImageView leftAnimImage,rightAnimImage;
    TextView textOneAnim;
    LinearLayout textTwoAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_complete);

        left_anim = AnimationUtils.loadAnimation(this,R.anim.left_anim);
        right_anim = AnimationUtils.loadAnimation(this,R.anim.right_anim);
        text_one_anim = AnimationUtils.loadAnimation(this,R.anim.text_one_anim);
        text_two_anim = AnimationUtils.loadAnimation(this,R.anim.text_two_anim);

        leftAnimImage = findViewById(R.id.leftAnimImage);
        rightAnimImage = findViewById(R.id.rightAnimImage);

        textOneAnim = findViewById(R.id.textOneAnim);
        textTwoAnim = findViewById(R.id.textTwoAnim);

        textOneAnim.setAnimation(text_one_anim);
        leftAnimImage.setAnimation(left_anim);
        rightAnimImage.setAnimation(right_anim);
        textTwoAnim.setAnimation(text_two_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SignUpComplete.this, MapsActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}