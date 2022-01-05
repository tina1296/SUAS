package com.example.plz;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class flank extends AppCompatActivity implements View.OnClickListener {

    //타이머 기능을 구현할 수 있는 chronometer
    private Chronometer timer;
    //시작, 멈춤, 리셋 구현.
    private long timestops = 0;
    private boolean stopClicked;
    Button enter;
    Button attitude;
    //플랭크 관련해서 사용자로부터 받아와야 하는 것.
    EditText fweight;
    EditText fmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flank);
        //닫기 구현.
        Button close=(Button) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        enter=(Button) findViewById(R.id.enter);
        attitude=(Button) findViewById(R.id.attitude);
        fweight=(EditText) findViewById(R.id.weight);
        fmin=(EditText) findViewById(R.id.count);
        //enter을 누르면 칼로리 소모량을 보여줌.
        enter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String sa= fweight.getText().toString();
                String sb=fmin.getText().toString();
                double weight=Double.parseDouble(sa);
                int min=Integer.parseInt(sb);
                double cal=min*20;
                Toast.makeText(getApplicationContext(), min+"분 운동하셨습니다."+"약"+cal+"kcal 소모하셨습니다. 내일도 만나요.", Toast.LENGTH_LONG).show();
            }
        });
        //올바른 자세를 알려줌.
        attitude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "전문가 없이 하는 플랭크는 허리에 위험할 수 있습니다.플랭크는 코어근육을 만들기 위함인데, 자세는 다음과 같습니다. 팔은 지면과 90도 유지하고 어깨와 엉덩이 발끝을 일자로 유지하며 허리가 말려내려가지 않도록 하는 것이 중요합니다. 더 나아가 이를 응용해 플랭크 응용동작도 수행하길 바랍니다.", Toast.LENGTH_LONG).show();
            }
        });

        //타이머 구현
        timer = (Chronometer) findViewById(R.id.timer);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //시간, 분,초로 나눠서 계산 할 수 있도록 함.
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                //측정된 시간을 갖고 시간, 분 초를 밑의 수식에 따라 구할 수 있음.
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


