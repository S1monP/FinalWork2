package com.example.sandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {


    @Override protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     final TextView text = findViewById(R.id.TextView);
     text.setText("Hello");
    }

    public void AnimeButton(View view) {
        final TextView text = findViewById(R.id.TextView);
        final ImageView foto = findViewById(R.id.imageView);
        text.setText("POPOPOPOPOOPOO");
//        long startTime = 0L;
//        Handler customHandler = new Handler();
//        long timeInMilliseconds = 0L;
//        long timeSwapBuff = 0L;
//        long updatedTime = 0L;
        text.setTextColor(getResources().getColor(R.color.red));
        foto.setImageDrawable(getResources().getDrawable(R.drawable.ball1));
        view.buildDrawingCache();
            long startTime = 0;
            startTime = SystemClock.uptimeMillis();
            do {
                if (SystemClock.uptimeMillis() - startTime  > 2000){
                    text.setTextColor(getResources().getColor(R.color.blue));
                    foto.setImageDrawable(getResources().getDrawable(R.drawable.ball2));
                    view.buildDrawingCache();
                    break;
                }
            }while (SystemClock.uptimeMillis() - startTime  != 2000);
            startTime = SystemClock.uptimeMillis();
        do {
            if (SystemClock.uptimeMillis() - startTime  > 2000){
                text.setTextColor(getResources().getColor(R.color.red));
                foto.setImageDrawable(getResources().getDrawable(R.drawable.ball3));
                view.buildDrawingCache();
                break;
            }
        }while (SystemClock.uptimeMillis() - startTime  != 2000);
        startTime = SystemClock.uptimeMillis();
        do {
            if (SystemClock.uptimeMillis() - startTime  > 2000){
                text.setTextColor(getResources().getColor(R.color.blue));
                foto.setImageDrawable(getResources().getDrawable(R.drawable.ball4));
                view.buildDrawingCache();
                break;
            }
        }while (SystemClock.uptimeMillis() - startTime  != 2000);
        startTime = SystemClock.uptimeMillis();
//            text.setTextColor(getResources().getColor(R.color.red));
//            foto.setImageDrawable(getResources().getDrawable(R.drawable.ball2));
        }
}

