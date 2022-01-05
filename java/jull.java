package com.example.plz;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//줄넘기.
public class jull extends AppCompatActivity implements View.OnClickListener {

    //타이머 기능을 구현할 수 있는 chronometer
    private Chronometer timer;
    //시작, 멈춤, 리셋 구현.
    private long timestops = 0;
    private boolean stopClicked;
    //줄넘기에 맞는 버튼 설정.
    Button jenter;
    Button jattitude;
    EditText jweight;
    EditText jcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jull);
        //닫기 구현.
        Button close=(Button) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        jenter=(Button) findViewById(R.id.enter);
        jattitude=(Button) findViewById(R.id.attitude);
        jweight=(EditText) findViewById(R.id.weight);
        jcount=(EditText) findViewById(R.id.count);
        //소비된 칼로리를 볼 수 있음.
        jenter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //사용자로부터 갖고 온 몸무게(실수형), 시간(정수형)으로 바꿔줌.
                String sa= jweight.getText().toString();
                String sb=jcount.getText().toString();
                double weight=Double.parseDouble(sa);
                int count=Integer.parseInt(sb);
                //칼로리 또한 실수형으로 갖고오며 소비된 칼로리를 계산하여 보여줌.
                double cal=weight*count*0.003;
                Toast.makeText(getApplicationContext(), count+"개 뛰셨습니다."+"약"+cal+"kcal 소모하셨습니다. 내일도 만나요.", Toast.LENGTH_LONG).show();
            }
        });
        //올바른 자세.
        jattitude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "대표적인 유산소 운동인 줄넘기입니다. 줄넘기의 줄을 밟고 섰을 때 손잡이가 자신의 겨드랑이 아래쪽에 위치하도록 합니다. 이후 간단하게 줄을 넘으면 됩니다. 줄넘기를 할 때 다양한 변화를 주면서 하시면 됩니다.", Toast.LENGTH_LONG).show();
            }
        });


        //타이머 구현
        timer = (Chronometer) findViewById(R.id.timer);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //측정된 시간을 밑에와 같은 수식을 이용해 계산하고 시간, 분, 초로 나눠 보여줌.
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
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


