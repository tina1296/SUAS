package com.example.plz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class sleep extends AppCompatActivity {
    EditText a;
    EditText b;
    EditText c;
    EditText d;
    int time;
    Button submit;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep);
        //닫기
        Button close=(Button) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        submit=(Button) findViewById(R.id.submit);
        a=(EditText) findViewById(R.id.a);
        b=(EditText) findViewById(R.id.b);
        c=(EditText) findViewById(R.id.c);
        d=(EditText) findViewById(R.id.d);
        //자는 시간을 계산하는 방법
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sa= a.getText().toString();//잔 시간(hour)
                String sb=b.getText().toString();//잔 분(minute)
                String sc=c.getText().toString();//일어난 시간(hour)
                String sd=d.getText().toString();//일어난 분(minute)
                //시간을 모두 string형으로 받았기 때문에 이를 정수로 바꿔주는 소스코드
                int ia=Integer.parseInt(sa);
                int ib=Integer.parseInt(sb);
                int ic=Integer.parseInt(sc);
                int id=Integer.parseInt(sd);

                //예외 처리
                //새벽에 자서 오전중으로 일어날 때 혹은 새벽 중에 자서 오후 중으로 일어날 때( 예를 들어 00시(오전 12시)에 자서 6시(새벽)에 일어날 때)
                if(ia-ic<=0){
                    if(ia>=24||ic>=24){
                        //시간에서 24:00을 넘어가는 시간은 없으며, 혼란의 여지가 있어 새벽 12시(오전12시)는 00시로 입력하라고 알려줌.
                        Toast.makeText(getApplicationContext(),"다시 입력해주세요",Toast.LENGTH_LONG).show();
                    }
                    else{
                        //분은 60이 넘어갈 수 없다.
                        if(ib>=60||id>=60){
                            Toast.makeText(getApplicationContext(),"다시 입력해주세요",Toast.LENGTH_LONG).show();
                        }
                        else{
                            //위의 예외를 모두 통과하였다면,
                            //시간을 먼저 분으로 다 바꿈.
                            time=((60*(ic)+id)-(60*(ia)+ib));
                            //분으로 바뀐 시간을 시,분으로 다시 나눔.
                            int hour=time/60;
                            int min=time%60;
                            //예외처리
                            //6시간 이상 8시간 이하
                            if(hour>=6 && hour<=8)
                                Toast.makeText(getApplicationContext(), hour+"시간"+min+"분 주무셨습니다. 적당한 시간 주무셨습니다. 오늘도 좋은 하루 보내세요.", Toast.LENGTH_LONG).show();
                            //8시간 이상
                            if(hour>8)
                                Toast.makeText(getApplicationContext(), hour+"시간"+min+"분 주무셨습니다.숙면 시간이 과합니다. 과한 숙면 시간 또한 건강에 해롭습니다.", Toast.LENGTH_LONG).show();
                            //6시간 이하
                            if(hour<6)
                                Toast.makeText(getApplicationContext(), hour+"시간"+min+"분 주무셨습니다.숙면 시간이 부족합니다. 최소 6시간은 주무셔야 합니다. 6시간 이상 숙면하지 않으면 식욕을 자극하는 호르몬으로 비만 체형이 되기 윕고 건강에 해롭습니다.", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                //같은 시간에 일어나고 잘때 = 자지 않았을 때
                if(ia-ic==0&&ib-id==0){
                    if(ia>=24||ic>=24){
                        //시간에서 24:00을 넘어가는 시간은 없으며, 혼란의 여지가 있어 새벽 12시(오전12시)는 00시로 입력하라고 알려줌.
                        Toast.makeText(getApplicationContext(),"다시 입력해주세요",Toast.LENGTH_LONG).show();
                    }
                    else{
                        //분은 60이 넘어갈 수 없다.
                        if(ib>=60||id>=60){
                            Toast.makeText(getApplicationContext(),"다시 입력해주세요",Toast.LENGTH_LONG).show();
                        }
                        else{
                            //그럼에도 자지 않으면 안됨.
                            Toast.makeText(getApplicationContext(),"주무시지 않으면 안됩니다. 몸에 좋지 않습니다. 10분이라도 눈을 붙여주세요.", Toast.LENGTH_LONG).show();
                        }
                    }

                }
                //오후(저녁) 중에 자서 오전 중으로 일어났을 때(예를 들어 23시에 자서 새벽 7시에 일어남)
                if(ia-ic>0){
                    if(ia>=24||ic>=24){
                        //시간에서 24:00을 넘어가는 시간은 없으며, 혼란의 여지가 있어 새벽 12시(오전12시)는 00시로 입력하라고 알려줌.
                        Toast.makeText(getApplicationContext(),"다시 입력해주세요",Toast.LENGTH_LONG).show();
                    }
                    else{
                        if(ib>=60||id>=60){
                            //분은 60이 넘어갈 수 없다.
                            Toast.makeText(getApplicationContext(),"다시 입력해주세요",Toast.LENGTH_LONG).show();
                        }
                        else{
                            //위의 예외를 다 통과했다면,
                            //시간을 분으로 계산함.
                            time=((60*(ic+24)+id)-(60*(ia)+ib));
                            //계산된 시간을 시, 분으로 나눔
                            int hour=time/60;
                            int min=time%60;
                            //6시간 이상 8시간 이하 숙면에 취했다면
                            if(hour>=6 && hour<=8)
                                Toast.makeText(getApplicationContext(), hour+"시간"+min+"분 주무셨습니다. 적당한 시간 주무셨습니다. 오늘도 좋은 하루 보내세요.", Toast.LENGTH_LONG).show();
                            //8시간 초과로 숙면에 취했다면
                            if(hour>8)
                                Toast.makeText(getApplicationContext(), hour+"시간"+min+"분 주무셨습니다.숙면 시간이 과합니다. 과한 숙면 시간 또한 건강에 해롭습니다.", Toast.LENGTH_LONG).show();
                            //6시간 미만으로 숙면에 취했다면
                            if(hour<6)
                                Toast.makeText(getApplicationContext(), hour+"시간"+min+"분 주무셨습니다.숙면 시간이 부족합니다. 최소 6시간은 주무셔야 합니다. 6시간 이상 숙면하지 않으면 식욕을 자극하는 호르몬으로 비만 체형이 되기 윕고 건강에 해롭습니다.", Toast.LENGTH_LONG).show();
                        }
                    }

                }
            }
        });
    }
}
