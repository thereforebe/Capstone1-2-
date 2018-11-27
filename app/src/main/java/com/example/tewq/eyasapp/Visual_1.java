package com.example.tewq.eyasapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.Image;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.VisualVoicemailService;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.ArrayList;

public class Visual_1 extends AppCompatActivity {

    ImageView icon_blue, icon_yellow, icon_green, icon_red, icon_purple; // 처음 나오는 풍선
    ImageView bg,explain1;
    TextView string;
    ImageButton[] button;
    ImageButton next1;
    int icon_number;
    int point = 100;
    int x = 0, y = 0; // 좌표, 최대 (1600, 500)
    int count_blue = 0, count_yellow = 0, count_green = 0, count_red =0, count_purple = 0;
    int count_blue1 = 0, count_yellow1 = 0, count_green1 = 0, count_red1 =0, count_purple1 = 0;
    int rand_num, corrent_num; // 랜덤

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
        setContentView(R.layout.activity_visual_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        icon_blue = (ImageView) findViewById(R.id.icon_blue);
        icon_yellow = (ImageView) findViewById(R.id.icon_yellow);
        icon_green = (ImageView) findViewById(R.id.icon_green);
        icon_red = (ImageView) findViewById(R.id.icon_red);
        icon_purple = (ImageView) findViewById(R.id.icon_purple);

        string = (TextView)findViewById(R.id.explain_text);
        explain1 = (ImageView) findViewById(R.id.explain1);
        next1 = (ImageButton) findViewById(R.id.next1);

        button = new ImageButton[20];

        button[0] = (ImageButton) findViewById(R.id.balloon_button_blue);
        button[1] = (ImageButton) findViewById(R.id.balloon_button_blue1);
        button[2] = (ImageButton) findViewById(R.id.balloon_button_blue2);
        button[3] = (ImageButton) findViewById(R.id.balloon_button_blue3);

        button[4] = (ImageButton) findViewById(R.id.balloon_button_yellow);
        button[5] = (ImageButton) findViewById(R.id.balloon_button_yellow1);
        button[6] = (ImageButton) findViewById(R.id.balloon_button_yellow2);
        button[7] = (ImageButton) findViewById(R.id.balloon_button_yellow3);

        button[8] = (ImageButton) findViewById(R.id.balloon_button_purple);
        button[9] = (ImageButton) findViewById(R.id.balloon_button_purple1);
        button[10] = (ImageButton) findViewById(R.id.balloon_button_purple2);
        button[11] = (ImageButton) findViewById(R.id.balloon_button_purple3);

        button[12] = (ImageButton) findViewById(R.id.balloon_button_red);
        button[13] = (ImageButton) findViewById(R.id.balloon_button_red1);
        button[14] = (ImageButton) findViewById(R.id.balloon_button_red2);
        button[15] = (ImageButton) findViewById(R.id.balloon_button_red3);

        button[16] = (ImageButton) findViewById(R.id.balloon_button_green);
        button[17] = (ImageButton) findViewById(R.id.balloon_button_green1);
        button[18] = (ImageButton) findViewById(R.id.balloon_button_green2);
        button[19] = (ImageButton) findViewById(R.id.balloon_button_green3);


        for (int i = 0; i < 4; i++) {
            button[i].setImageResource(R.drawable.balloon_blue0001);
        }
        for (int i = 4; i < 8; i++) {
            button[i].setImageResource(R.drawable.balloon_green0001);
        }
        for (int i = 8; i < 12; i++) {
            button[i].setImageResource(R.drawable.balloon_red0001);
        }
        for (int i = 12; i < 16; i++) {
            button[i].setImageResource(R.drawable.balloon_purple0001);
        }
        for (int i = 16; i < 20; i++) {
            button[i].setImageResource(R.drawable.balloon_yellow0001);
        }



        Random random = new Random();

        bg = (ImageView) findViewById(R.id.play_background); // 배경

        rand_num = random.nextInt(5);
        corrent_num = rand_num;

        explain1.setVisibility(View.VISIBLE);
        string.setVisibility(View.VISIBLE);
        next1.setVisibility(View.VISIBLE);

    }

    public void play_game(int x, int y) { // 좌표별로 표시

        Random random = new Random();
        int rand_num;
        int xx, yy;

        xx = x;
        yy = y;

        for (int i = 0; i < 20; i++) {

            rand_num = random.nextInt(20);

            switch (rand_num) {
                case 0: case 1: case 2: case 3:
                    button[rand_num].setX(xx);
                    button[rand_num].setY(yy);
                    button[rand_num].setVisibility(View.VISIBLE);
                    ++count_blue;
                    break;
                case 4: case 5: case 6: case 7:
                    button[rand_num].setX(xx);
                    button[rand_num].setY(yy);
                    button[rand_num].setVisibility(View.VISIBLE);
                    ++count_yellow;
                    break;
                case 8: case 9: case 10: case 11:
                    button[rand_num].setX(xx);
                    button[rand_num].setY(yy);
                    button[rand_num].setVisibility(View.VISIBLE);
                    ++count_purple;
                    break;
                case 12: case 13: case 14: case 15:
                    button[rand_num].setX(xx);
                    button[rand_num].setY(yy);
                    button[rand_num].setVisibility(View.VISIBLE);
                    ++count_red;
                    break;
                case 16: case 17: case 18: case 19:
                    button[rand_num].setX(xx);
                    button[rand_num].setY(yy);
                    button[rand_num].setVisibility(View.VISIBLE);
                    ++count_green;
                    break;

            }
/*
            rand_button[i].setX(xx);
            rand_button[i].setY(yy);
            rand_button[i].setVisibility(View.VISIBLE);
*/
            xx += 150;
            if (xx > 1600) {
                xx = 0;
                yy += 150;
            }
            if (yy > 500) {
                i = 20;
            }



        }
    }


    public void Corrent_color(int cr){ // 처음에 나오는 공 색
        bg.setVisibility(View.VISIBLE);
        Handler delayHandler = new Handler();
        switch (cr) {
            case 0:
                icon_number = 0;
                icon_blue.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_blue.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
                break;
            case 1:
                icon_number = 1;
                icon_yellow.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_yellow.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
                break;
            case 2:
                icon_number = 2;
                icon_green.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_green.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
                break;
            case 3:
                icon_number = 3;
                icon_red.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_red.setVisibility(View.INVISIBLE);
                    }
                }, 3000);

                break;
            case 4:
                icon_number = 4;
                icon_purple.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_purple.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
                break;
        }

    }
//if (count_num == count_blue || count_num == count_yellow || count_num == count_green || count_num == count_purple || count_num == count_red) {
    public void onClickButton(View v) {

        if (point > 60) {
                switch (v.getId()) {
                    case R.id.next1:
                        explain1.setVisibility(View.INVISIBLE);
                        next1.setVisibility(View.INVISIBLE);
                        string.setVisibility(View.INVISIBLE);
                        Corrent_color(corrent_num);  // 처음 표시하는 풍선 색

                        Handler gameHandler = new Handler();

                        gameHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                y = 350;
                                play_game(x, y);
                            }
                        }, 3000);


                    case R.id.balloon_button_blue:
                        if (icon_number != 0) {
                            point -= 10;
                        }
                        ++count_blue1;
                        button[0].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_blue1:
                        if (icon_number != 0) {
                            point -= 10;
                        }
                        ++count_blue1;
                        button[1].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_blue2:
                        if (icon_number != 0) {
                            point -= 10;
                        }
                        ++count_blue1;
                        button[2].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_blue3:
                        if (icon_number != 0) {
                            point -= 10;
                        }
                        ++count_blue1;
                        button[3].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_yellow:
                        if (icon_number != 1) {
                            point -= 10;
                        }
                        ++count_yellow1;
                        button[4].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_yellow1:
                        if (icon_number != 1) {
                            point -= 10;
                        }
                        ++count_yellow1;
                        button[5].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_yellow2:
                        if (icon_number != 1) {
                            point -= 10;
                        }
                        ++count_yellow1;
                        button[6].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_yellow3:
                        if (icon_number != 1) {
                            point -= 10;
                        }
                        ++count_yellow1;
                        button[7].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_purple:
                        if (icon_number != 4) {
                            point -= 10;
                        }
                        ++count_purple1;
                        button[8].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_purple1:
                        if (icon_number != 4) {
                            point -= 10;
                        }
                        ++count_purple1;
                        button[9].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_purple2:
                        if (icon_number != 4) {
                            point -= 10;
                        }
                        ++count_purple1;
                        button[10].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_purple3:
                        if (icon_number != 4) {
                            point -= 10;
                        }
                        ++count_purple1;
                        button[11].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_red:
                        if (icon_number != 3) {
                            point -= 10;
                        }
                        ++count_red1;
                        button[12].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_red1:
                        if (icon_number != 3) {
                            point -= 10;
                        }
                        ++count_red1;
                        button[13].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_red2:
                        if (icon_number != 3) {
                            point -= 10;
                        }
                        ++count_red1;
                        button[14].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_red3:
                        if (icon_number != 3) {
                            point -= 10;
                        }
                        ++count_red1;
                        button[15].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_green:
                        if (icon_number != 2) {
                            point -= 10;
                        }
                        ++count_green1;
                        button[16].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_green1:
                        if (icon_number != 2) {
                            point -= 10;
                        }
                        ++count_green1;
                        button[17].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_green2:
                        if (icon_number != 2) {
                            point -= 10;
                        }
                        ++count_green1;
                        button[18].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.balloon_button_green3:
                        if (icon_number != 2) {
                            point -= 10;
                        }
                        ++count_green1;
                        button[19].setVisibility(View.INVISIBLE);
                        break;
                }

            } else
                point = 0;

        if(count_green1 == count_green){
            Intent intent1 = new Intent(this, VisualActivity.class);
            startActivity(intent1);
            finish();
        }
        else if(count_red1 == count_red){
            Intent intent1 = new Intent(this, VisualActivity.class);
            startActivity(intent1);
            finish();
        }
        else if(count_purple1 == count_purple){
            Intent intent1 = new Intent(this, VisualActivity.class);
            startActivity(intent1);
            finish();
        }
        else if(count_yellow1 == count_yellow){
            Intent intent1 = new Intent(this, VisualActivity.class);
            startActivity(intent1);
            finish();
        }
        else if(count_blue1 == count_blue){
            Intent intent1 = new Intent(this, VisualActivity.class);
            startActivity(intent1);
            finish();
        }
        }
}





