package com.example.tewq.eyasapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class Visual_2 extends AppCompatActivity {
    ImageButton button[];
    ImageButton next;
    ImageView back1, back2, back3;
    ImageView image[];
    ImageView image2[];
    ImageView background;
    ImageView explain2;

    int icon_number = 0;
    int count_blue = 1, count_yellow = 1, count_green = 1, count_red =1, count_bora = 1;
    int count_num = 0; // 최대 클릭 수
    int rand_num, corrent_num; // 랜덤
    int point=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
        setContentView(R.layout.activity_visual_2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        button = new ImageButton[6];

        button[0] = (ImageButton)findViewById(R.id.image_buuton_0);
        button[1] = (ImageButton)findViewById(R.id.image_buuton_1);
        button[2] = (ImageButton)findViewById(R.id.image_buuton_2);
        button[3] = (ImageButton)findViewById(R.id.image_buuton_3);
        button[4] = (ImageButton)findViewById(R.id.image_buuton_4);
        button[5] = (ImageButton)findViewById(R.id.image_buuton_5);
        next =  (ImageButton)findViewById(R.id.next2);

        image = new ImageView[5];

        image[0] = (ImageView)findViewById(R.id.icon_blue_1);
        image[1] = (ImageView)findViewById(R.id.icon_red_1);
        image[2] = (ImageView)findViewById(R.id.icon_green_1);
        image[3] = (ImageView)findViewById(R.id.icon_bora_1);
        image[4] = (ImageView)findViewById(R.id.icon_yellow_1);

        explain2 = (ImageView)findViewById(R.id.explain2);
        background = (ImageView)findViewById(R.id.back);

        image2 = new ImageView[5];

        image2[0] = (ImageView)findViewById(R.id.icon_blue_5);
        image2[1] = (ImageView)findViewById(R.id.icon_red_5);
        image2[2] = (ImageView)findViewById(R.id.icon_green_5);
        image2[3] = (ImageView)findViewById(R.id.icon_bora_5);
        image2[4] = (ImageView)findViewById(R.id.icon_yellow_5);

        back1 = (ImageView)findViewById(R.id.first_back);
        back2 = (ImageView)findViewById(R.id.final_back);



        back1.setImageResource(R.drawable.my_back2_first); // 처음
        back2.setImageResource(R.drawable.my_back_final); // 나중

        //  Handler delay = new Handler();

        explain2.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);

        // back1.setVisibility(View.INVISIBLE);
        back2.setVisibility(View.INVISIBLE);




    }

    public void play_game_2(){ // 게임

        Random random1 = new Random();
        // int count = random1.nextInt(500);
        int cr;
        //for(int i=0; i<count; i++) {
        Random random = new Random();
        cr = random.nextInt(5);
        switch (cr) {
            case 0:

                image[0].setImageResource(R.drawable.icon_blue_1);
                Handler delayHandler = new Handler();
                image[0].bringToFront();
                image[0].setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image[0].setVisibility(View.INVISIBLE);
                        //   image[0].setImageResource(R.drawable.icon_blue_1);
                        count_blue++;
                    }
                }, 5000);
                break;
            case 1:

                image[1].setImageResource(R.drawable.icon_red_1);
                image[1].bringToFront();
                Handler delayHandler1 = new Handler();
                image[1].setVisibility(View.VISIBLE);
                delayHandler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image[1].setVisibility(View.INVISIBLE);
                        //image[1].setImageResource(R.drawable.icon_red_1);
                        count_red++;
                    }
                }, 5000);
                break;
            case 2:

                image[2].setImageResource(R.drawable.icon_green_1);
                image[2].bringToFront();
                Handler delayHandler2 = new Handler();
                image[2].setVisibility(View.VISIBLE);
                delayHandler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image[2].setVisibility(View.INVISIBLE);
                        // image[2].setImageResource(R.drawable.icon_green_1);
                        count_green++;
                    }
                }, 5000);
                break;
            case 3:

                image[3].setImageResource(R.drawable.icon_bora_1);
                image[3].bringToFront();
                Handler delayHandler3 = new Handler();
                image[3].setVisibility(View.VISIBLE);
                delayHandler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image[3].setVisibility(View.INVISIBLE);
                        // image[3].setImageResource(R.drawable.icon_bora_1);
                        count_bora++;
                    }
                }, 5000);
                break;
            case 4:

                image[4].setImageResource(R.drawable.icon_yellow_1);
                Handler delayHandler4 = new Handler();
                image[4].bringToFront();
                image[4].setVisibility(View.VISIBLE);
                delayHandler4.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image[4].setVisibility(View.INVISIBLE);
                        // image[4].setImageResource(R.drawable.icon_yellow_1);
                        count_yellow++;
                    }
                }, 5000);
                break;
        }

        // }

    }



    public void Corrent_color(int cr){ // 옷 색

        back1.setVisibility(View.VISIBLE);
        Handler delayHandler = new Handler();
        switch (cr) {

            case 0:
                icon_number = 0;
                image2[0].setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image2[0].setVisibility(View.INVISIBLE);
                        back1.setVisibility(View.INVISIBLE);
                    }
                }, 4000);
                break;
            case 1:
                icon_number = 1;
                image2[1].setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image2[1].setVisibility(View.INVISIBLE);
                        back1.setVisibility(View.INVISIBLE);
                    }
                }, 4000);
                break;
            case 2:
                icon_number = 2;
                image2[2].setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image2[2].setVisibility(View.INVISIBLE);
                        back1.setVisibility(View.INVISIBLE);
                    }
                }, 4000);
                break;
            case 3:
                icon_number = 3;
                image2[3].setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image2[3].setVisibility(View.INVISIBLE);
                        back1.setVisibility(View.INVISIBLE);
                    }
                }, 4000);
                break;
            case 4:
                icon_number = 4;
                image2[4].setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image2[4].setVisibility(View.INVISIBLE);
                        back1.setVisibility(View.INVISIBLE);
                    }
                }, 4000);
                break;
        }

    }
    public void onClickButton(View v) {

        switch (v.getId()) {
            case R.id.next2:
                Random random = new Random();
                rand_num = random.nextInt(5);

                explain2.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                Corrent_color(rand_num);
                Handler gameHandler2 = new Handler();
                gameHandler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        background.setVisibility(View.VISIBLE);
                    }
                }, 5000);

                Handler gameHandler = new Handler();
                gameHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Handler gameHandler1 = new Handler();

                        for (int i = 5000; i <= 30000; i += 5000) {
                            gameHandler1.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if (icon_number == 2) {
                                        count_green++;
                                    }
                                    play_game_2();
                                    count_num++;
                                    if(count_num == 6){
                                        background.setVisibility(View.INVISIBLE);
                                        choice();
                                    }
                                }

                            }, i);


                        }
                    }

                }, 5000);

            case R.id.image_buuton_0:
                if (icon_number == 0 && count_blue !=1) {
                    point -= 10;
                }
                else if (icon_number == 0 && count_blue == 1) {
                    Intent intent1 = new Intent(this, VisualActivity.class);
                    startActivity(intent1);
                    finish();
                }
                else
                    point -= 10;

                break;
            case R.id.image_buuton_1:
                if (icon_number == 1 && count_blue !=1) {
                    point -= 10;
                }
                else if (icon_number == 1 && count_blue == 1) {
                    Intent intent1 = new Intent(this, VisualActivity.class);
                    startActivity(intent1);
                    finish();
                }
                else
                    point -= 10;

                break;
            case R.id.image_buuton_2:
                if (icon_number == 2 && count_blue !=1) {
                    point -= 10;
                }
                else if (icon_number == 2 && count_blue == 1) {
                    Intent intent1 = new Intent(this, VisualActivity.class);
                    startActivity(intent1);
                    finish();
                }
                else
                    point -= 10;

                break;
            case R.id.image_buuton_3:
                if (icon_number == 3 && count_blue !=1) {
                    point -= 10;
                }
                else if (icon_number == 3 && count_blue == 1) {
                    Intent intent1 = new Intent(this, VisualActivity.class);
                    startActivity(intent1);
                    finish();
                }
                else
                    point -= 10;

                break;
            case R.id.image_buuton_4:
                if (icon_number == 4 && count_blue !=1) {
                    point -= 10;
                }
                else if (icon_number == 4 && count_blue == 1) {
                    Intent intent1 = new Intent(this, VisualActivity.class);
                    startActivity(intent1);
                    finish();
                }
                else
                    point -= 10;

                break;
        }
    }

    public void choice(){

        back2.setVisibility(View.VISIBLE);
        for(int i=0; i<6; i++) {
            button[i].setVisibility(View.VISIBLE);
        }

    }
}

