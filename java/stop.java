package com.example.plz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class stop extends AppCompatActivity implements View.OnClickListener {

    //타이머 기능을 구현할 수 있는 chronometer
    private Chronometer timer;
    //시작, 멈춤, 리셋 구현.
    private long timestops = 0;
    private boolean stopClicked;
    private static final String TAG = "MusicService";
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop);
        //음악과 연결 시킴.(버튼 가져옴)
        start = (Button) findViewById(R.id.music_start);
        stop = (Button) findViewById(R.id.music_stop);

        //버튼 이벤트 연결.
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        timer = (Chronometer) findViewById(R.id.timer);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                //측정된 시간을 초로 바꾸고 이를 시, 분, 초로 바꿈.
                int h = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s = (int)(time - h*3600000- m*60000)/1000 ;
                String t = (h < 10 ? "0"+h: h)+ ":" +(m < 10 ? "0"+m: m)+ ":" + (s < 10 ? "0"+s: s);
                chronometer.setText(t);
            }
        });
        timer.setBase(SystemClock.elapsedRealtime());
        timer.setText("00:00:00");

        //버튼 가져오기
        Button start = (Button) findViewById(R.id.start);
        Button pause= (Button) findViewById(R.id.pause);
        Button reset = (Button) findViewById(R.id.reset);

        //버튼 이벤트 연결
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //버튼 이벤트 처리
        switch (v.getId()){
            //타이머 시작
            case R.id.start:
                timer.setBase(SystemClock.elapsedRealtime() + timestops);
                //타이머가 시간 측정을 시작함.
                timer.start();
                stopClicked = false;
                break;

            case R.id.pause:
                //타이머 중단
                if (!stopClicked) {
                    timestops = timer.getBase() - SystemClock.elapsedRealtime();
                    timer.stop();
                    stopClicked = true;
                    break;
                }

            case R.id.reset:
                //타이머 리셋
                timer.setBase(SystemClock.elapsedRealtime());
                timer.stop();
                timestops = 0;
                break;

                //음악을 연동하는 것 시작-music.class와 연동
            case R.id.music_start:
                Log.d(TAG, "onClick() start ");
                startService(new Intent(this, music.class));
                break;

                //음악을 연동하는 것 중단-music.class와 연동
            case R.id.music_stop:
                Log.d(TAG, "onClick() stop");
                stopService(new Intent(this, music.class));
                break;
        }

    }

}
