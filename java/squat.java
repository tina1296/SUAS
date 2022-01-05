package com.example.plz;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class squat extends AppCompatActivity implements View.OnClickListener {

    //타이머 기능을 구현할 수 있는 chronometer
    private Chronometer timer;
    //시작, 멈춤, 리셋 구현.
    private long timestops = 0;
    private boolean stopClicked;
    Button senter;
    Button attitude;
    EditText sweight;
    EditText smin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.squat);
        //닫기
        Button close=(Button) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });

        senter=(Button) findViewById(R.id.enter);
        attitude=(Button) findViewById(R.id.attitude);
        sweight=(EditText) findViewById(R.id.weight);
        smin=(EditText) findViewById(R.id.count);
        //소비된 칼로리 계산
        senter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //사용자로부터 몸무게와 시간을 입력 받고 이를 실수형, 정수형으로 전환
                String sa= sweight.getText().toString();
                String sb=smin.getText().toString();
                double weight=Double.parseDouble(sa);
                int min=Integer.parseInt(sb);
                //소비된 칼로리를 계산
                double cal=weight*min*0.15;
                Toast.makeText(getApplicationContext(), min+"분 운동하셨습니다."+"약"+cal+"kcal 소모하셨습니다. 내일도 만나요.", Toast.LENGTH_LONG).show();
            }
        });
        //올바른 자세
        attitude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "전문가 없이 하는 스쿼트는 무릎관절에 위험할 수 있습니다. 가장 기본적인 스쿼트인 플리에 스쿼트 자세를 알려드리겠습니다. 어깨너비 정도로 양발을 벌린 자세를 취한 후 발 끝은 45도 정도로 바깥을 위치합니다. 무릎이 최대한 안무너지게, 골반은 당겨진는 느낌으로, 엉덩이는 뒤에 투명한 의자가에 앉듯 뒤로 뺴고 앉습니다.", Toast.LENGTH_LONG).show();
            }
        });

        //타이머 구현
        timer = (Chronometer) findViewById(R.id.timer);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                //측정된 시간을 모두 초로 바꾸고 이를 시, 분, 초로 나눠 보여주게 됨.
                int h = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s = (int)(time - h*3600000- m*60000)/1000 ;
                String t = (h < 10 ? "0"+h: h)+ ":" +(m < 10 ? "0"+m: m)+ ":" + (s < 10 ? "0"+s: s);
                chronometer.setText(t);
            }
        });
        //timer의 시작을 설정.(안드로이드 시간 측정 방법 중 하나)
        timer.setBase(SystemClock.elapsedRealtime());
        timer.setText("00:00:00");

        //버튼 가져오기
        Button start = (Button) findViewById(R.id.start);
        Button pause = (Button) findViewById(R.id.pause);
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
            //시작 버튼을 눌렀을 때
            case R.id.start:
                timer.setBase(SystemClock.elapsedRealtime() + timestops);
                timer.start();
                stopClicked = false;
                break;
            //정지 버튼을 눌렀을 때
            case R.id.pause:
                if (!stopClicked) {
                    timestops = timer.getBase() - SystemClock.elapsedRealtime();
                    timer.stop();
                    stopClicked = true;
                    break;
                }
                //리셋 버튼을 눌렀을 때
            case R.id.reset:
                timer.setBase(SystemClock.elapsedRealtime());
                timer.stop();
                timestops = 0;
                break;
        }

    }

}


