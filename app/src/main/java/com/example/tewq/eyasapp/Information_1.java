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

public class Information_1 extends AppCompatActivity {
    int[] ans;
    int score = 0;
    int t_ans;
    String[] name_arr;
    TextView[] tv_arr;
    ImageView[] image_arr;
    MediaPlayer correct_sound;
    MediaPlayer incorrect_sound;
    int[] img_arr;
    int[] price_arr;
    int[] number_arr;
    int[] difficulty_arr = {1000, 500, 100, 50, 10};
    int[] ran_arr;
    int difficulty = 0;
    int PRODUCT_NUM = 0;
    int QUESTION_NUM = 20;
    int play_num = 0;
    Random random = new Random();
    Button button1, button2, button3, button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
        setContentView(R.layout.activity_information_1);

        tv_arr = new TextView[15];
        tv_arr[0] = (TextView) findViewById(R.id.textView1);
        tv_arr[1] = (TextView) findViewById(R.id.textView2);
        tv_arr[2] = (TextView) findViewById(R.id.textView3);
        tv_arr[3] = (TextView) findViewById(R.id.textView4);
        tv_arr[4] = (TextView) findViewById(R.id.textView5);
        tv_arr[5] = (TextView) findViewById(R.id.textView6);
        tv_arr[6] = (TextView) findViewById(R.id.textView7);
        tv_arr[7] = (TextView) findViewById(R.id.textView8);
        tv_arr[8] = (TextView) findViewById(R.id.textView9);
        tv_arr[9] = (TextView) findViewById(R.id.textView10);
        tv_arr[10] = (TextView) findViewById(R.id.textView11);
        tv_arr[11] = (TextView) findViewById(R.id.textView12);
        tv_arr[12] = (TextView) findViewById(R.id.textView13);
        tv_arr[13] = (TextView) findViewById(R.id.textView14);
        tv_arr[14] = (TextView) findViewById(R.id.textView15);

        image_arr = new ImageView[6];
        image_arr[0] = (ImageView) findViewById((R.id.imageView1));
        image_arr[1] = (ImageView) findViewById((R.id.imageView2));
        image_arr[2] = (ImageView) findViewById((R.id.imageView3));
        image_arr[3] = (ImageView) findViewById((R.id.imageView4));
        image_arr[4] = (ImageView) findViewById((R.id.imageView5));
        image_arr[5] = (ImageView) findViewById((R.id.imageView6));

        name_arr = new String[9];
        img_arr = new int[9];
        price_arr = new int[9];
        number_arr = new int[9];
        ans = new int[4];
        ran_arr = new int[5];

        correct_sound= MediaPlayer.create(this, R.raw.correct);
        incorrect_sound = MediaPlayer.create(this, R.raw.incorrect);

        for (int i = 0; i < 5; i++) {
            ran_arr[i] = 8;
        }

        name_arr[0] = "토마토";
        name_arr[1] = "잼";
        name_arr[2] = "빵";
        name_arr[3] = "귤";
        name_arr[4] = "우유";
        name_arr[5] = "바나나";
        name_arr[6] = "통조림";
        name_arr[7] = "아이스크림";
        name_arr[8] = "";

        img_arr[0] = R.drawable.product1;
        img_arr[1] = R.drawable.product2;
        img_arr[2] = R.drawable.product3;
        img_arr[3] = R.drawable.product4;
        img_arr[4] = R.drawable.product5;
        img_arr[5] = R.drawable.product6;
        img_arr[6] = R.drawable.product7;
        img_arr[7] = R.drawable.product8;
        img_arr[8] = R.drawable.product9;


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        play(true);


    }

    public void play(boolean gamebool)//게임 메인 함수
    {
        for (int i = 0; i < 5; i++) {

            tv_arr[i].setText("");
            image_arr[i].setImageResource(img_arr[8]);
            tv_arr[i + 5].setText("");
            tv_arr[i + 10].setText("");
        }

        PRODUCT_NUM = random.nextInt(4) + 1;
        for (int i = 0; i < PRODUCT_NUM; i++) {
            price_arr[i] = (int) ((int) (random.nextInt(9000) + 1000) / difficulty_arr[difficulty]) * difficulty_arr[difficulty];
            number_arr[i] = (int) (random.nextInt(2) + 1);
        }

        for (int i = 0; i < 5; i++) {
            int ran_temp = (int) (random.nextInt(8));

            for (int j = 0; j < i; j++) {
                if (ran_arr[j] == ran_temp) {
                    ran_temp = (int) (random.nextInt(8));
                    j = -1;
                }
            }
            ran_arr[i] = ran_temp;
        }

        for (int a = 0; a < PRODUCT_NUM; a++) {
            tv_arr[a].setText("" + name_arr[(ran_arr[a])]);
            image_arr[a].setImageResource(img_arr[(ran_arr[a])]);
            tv_arr[a + 5].setText("" + number_arr[a]);
            tv_arr[a + 10].setText("" + price_arr[a]);
        }

        t_ans = 0;
        for (int i = 0; i < PRODUCT_NUM; i++)
            t_ans += price_arr[i] * number_arr[i];

        ans[0] = t_ans;

        for (int i = 1; i < 4; i++) {
            int temp = t_ans + (difficulty_arr[difficulty] * (int) (random.nextInt(10) + 1)) - (difficulty_arr[difficulty] * (int) (random.nextInt(10) + 1));

            if(temp<difficulty_arr[difficulty])
                temp = t_ans + (difficulty_arr[difficulty] * (int) (random.nextInt(10) + 1)) - (difficulty_arr[difficulty] * (int) (random.nextInt(10) + 1));

            for (int j = 0; j < i; j++) {
                if (ans[j] == temp) {
                    temp = t_ans + (difficulty_arr[difficulty] * (int) (random.nextInt(10) + 1)) - (difficulty_arr[difficulty] * (int) (random.nextInt(10) + 1));
                    j = 0;
                }
            }
            ans[i] = temp;
        }
        Arrays.sort(ans);

        button1.setText("" + ans[0]);
        button2.setText("" + ans[1]);
        button3.setText("" + ans[2]);
        button4.setText("" + ans[3]);

    }

    public void btn(View view) {
        switch (view.getId()) {
            case R.id.button1:
                if (ans[0] == t_ans) {//정답
                    score += 5;
                    play_num++;
                    correctF(true);
                } else {//오답
                    play_num++;
                    incorrectF(true);
                }
                if(play_num==QUESTION_NUM)
                    finish();
                break;
            case R.id.button2:
                if (ans[1] == t_ans) {//정답
                    score += 5;
                    play_num++;
                    correctF(true);
                } else {//오답
                    play_num++;
                    incorrectF(true);
                }
                if(play_num==QUESTION_NUM)
                    finish();
                break;
            case R.id.button3:
                if (ans[2] == t_ans) {//정답
                    score += 5;
                    play_num++;
                    correctF(true);
                } else {//오답
                    play_num++;
                    incorrectF(true);
                }
                if(play_num==QUESTION_NUM)
                    finish();
                break;
            case R.id.button4:
                if (ans[3] == t_ans) {//정답
                    score += 5;
                    play_num++;
                    correctF(true);
                } else {//오답
                    play_num++;
                    incorrectF(true);
                }
                if(play_num==QUESTION_NUM)
                    finish();
                break;
        }
    }

    public void correctF(boolean bool) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 correct_sound.start();
            }
        }, 1000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                play(true);
            }
        }, 1000);
    }

    public void incorrectF(boolean bool) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 incorrect_sound.start();
            }
        }, 1000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                play(true);
            }
        }, 1000);
    }
}