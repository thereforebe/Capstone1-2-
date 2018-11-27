package com.example.tewq.eyasapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;

public class Information extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
        setContentView(R.layout.activity_information);
    }

    public void main_btn(View view) {
        switch (view.getId()) {
            case R.id.content1:
                Intent info_1 = new Intent(this, Information_1.class);
                startActivity(info_1);
                break;
            case R.id.content2:
                Intent info_2 = new Intent(this, Information_2.class);
                startActivity(info_2);
                break;
        }
    }
}
