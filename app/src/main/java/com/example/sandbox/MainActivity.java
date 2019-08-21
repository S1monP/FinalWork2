package com.example.sandbox;


import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;


public class MainActivity extends AppCompatActivity implements SensorEventListener {


    AnimationDrawable anim;
 //   ImageView foto;
    ImageView imageView;
    TextView answer;
    private SensorManager sensorManager;
    private Sensor move;

    @Override protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        move = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void AnimeButton(View view) {
        imageView = findViewById(R.id.imageView);
        final AnswerData answerData = new AnswerData();
        answer = findViewById(R.id.textView);
        // foto  = findViewById(R.id.imageView);
        answer.setText("");
        if(imageView == null) throw new AssertionError();
        imageView.setBackgroundResource(R.drawable.ball_anim);
        anim = (AnimationDrawable)imageView.getBackground();
        anim.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                anim.stop();
                answer.setText(answerData.getAnswer());
            }
        }, 1100);

    }


    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }


    @Override
    public void onSensorChanged (SensorEvent event){
        Sensor mySensor = event.sensor;
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float mov = event.values[0];
            if (mov > 4.0){
                imageView = findViewById(R.id.imageView);
                final AnswerData answerData = new AnswerData();
                answer = findViewById(R.id.textView);
                // foto  = findViewById(R.id.imageView);
                answer.setText("");
                if(imageView == null) throw new AssertionError();
                imageView.setBackgroundResource(R.drawable.ball_anim);
                anim = (AnimationDrawable)imageView.getBackground();
                anim.start();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim.stop();
                        answer.setText(answerData.getAnswer());
                    }
                }, 1100);
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, move, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}

