package com.example.plz;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//런닝
public class running extends AppCompatActivity implements View.OnClickListener {

    //타이머 기능을 구현할 수 있는 chronometer
    private Chronometer timer;
    //시작, 멈춤, 리셋 구현.
    private long timestops = 0;
    private boolean stopClicked;
    Button nenter;
    Button attitude;
    Button renter;
    EditText rweight;
    EditText rmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.running);
        //닫기
        Button close=(Button) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        nenter=(Button) findViewById(R.id.enter);
        renter=(Button) findViewById(R.id.renter);
        attitude=(Button) findViewById(R.id.attitude);
        rweight=(EditText) findViewById(R.id.weight);
        rmin=(EditText) findViewById(R.id.count);
        //소비된 칼로리를 알 수 있는 enter 부분-걷기
        nenter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //사용자에게 받은 것은 몸무게, 이를 실수형으로 받음.(몸무게는 소수점이 나올 수 있기 때문에)
                String sa= rweight.getText().toString();
                String sb=rmin.getText().toString();
                double weight=Double.parseDouble(sa);
                int min=Integer.parseInt(sb);
                //소비된 칼로리를 계산하는 방법.
                double cal=min*weight*0.067;
                Toast.makeText(getApplicationContext(), min+"분 운동하셨습니다."+"약"+cal+"kcal 소모하셨습니다. 내일도 만나요.", Toast.LENGTH_LONG).show();
            }
        });
        //소비된 칼로리를 알 수 있는 enter 부분-런닝
        renter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sa= rweight.getText().toString();
                String sb=rmin.getText().toString();
                //사용자에게 몸무게를 받은 것을 실수형으로 바꿔줌, 시간은 정수형으로 유지
                double weight=Double.parseDouble(sa);
                int min=Integer.parseInt(sb);
                //소비된 칼로리를 계산
                double cal=min*weight*0.11;
                Toast.makeText(getApplicationContext(), min+"분 운동하셨습니다."+"약"+cal+"kcal 소모하셨습니다. 내일도 만나요.", Toast.LENGTH_LONG).show();
            }
        });


        //타이머 구현
        timer = (Chronometer) findViewById(R.id.timer);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                //측정된 시간에 따라 시간,분,초를 나눠 계산하고 이를 출력
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


