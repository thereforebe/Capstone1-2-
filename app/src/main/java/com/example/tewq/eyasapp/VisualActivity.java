package com.example.tewq.eyasapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class VisualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
        setContentView(R.layout.activity_visual);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

      //  final ImageButton Image_start = (ImageButton) findViewById(R.id.balloon_start_Button);

    }

        public void onClickButton(View v){
            switch (v.getId()) {
                case R.id.balloon_start_Button:
                    Intent intent1 = new Intent(VisualActivity.this, Visual_1.class);
                    startActivity(intent1);
                    finish();
                case R.id.cl_start_Button:
                    Intent intent2 = new Intent(VisualActivity.this, Visual_2.class);
                    startActivity(intent2);
                    finish();
            }
        }

    @Override
    protected void onStop(){

        super.onStop();
    }


}
