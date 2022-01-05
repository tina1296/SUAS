package com.example.plz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fcalc extends AppCompatActivity {
    Button me;
    Button fit;
    EditText age;
    EditText height;
    EditText weight;
    TextView text;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //calc과 똑같지만, 여성이기 때문에 계산법이 달라짐.(사실 xml을 같이 써도 무방함.하지만 기능 추가가 될 수 있기 때문에 xml을 분리시킴.)
        setContentView(R.layout.fcalc);
        me=(Button) findViewById(R.id.me);
        fit=(Button) findViewById(R.id.fit);
        age=(EditText) findViewById(R.id.age);
        height=(EditText) findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weight);
        text=(TextView) findViewById(R.id.text);

        //나의 체형 분석.
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //나이, 키, 몸무게를 string 형으로 받았기 때문에 각각 정수, 실수, 실수로 바꿔주는 작업을 함.
                String sa= age.getText().toString();
                String sb= height.getText().toString();
                String sc= weight.getText().toString();
                int age=Integer.parseInt(sa);
                double height=Double.parseDouble(sb);
                double weight=Double.parseDouble(sc);
                //기초대사량, bmi, 제지방량, 체지방량은 모두 실수형으로 받아옴. & 계산을 하는 방법에 따라 구현함.
                double base= 655.1+(9.56*weight)+(1.85*height)-(4.68*age);
                double obesity=(weight*10000)/(height*height);
                double jae=(1.07*weight)-(128*((weight*weight)/(height*height)));
                double chae=weight-jae;
                text.setText("인바디 결과입니다"+"\n 기초 대사량:"+base+"\n 비만율(bmi):"+obesity+"\n 제지방률:"+jae+"\n 체지방률: "+chae+"\n위의 수치는 추정치입니다. 더욱 더 자세한 내용은 가까운 보건소나 헬스장의 인바디 기계를 활용하실 수 있습니다.");
            }
        });

        //이상적인 체형 분석.
        fit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //나이와 키를 string형으로 받았기 때문에 이를 정수, 실수형으로 바꿔주는 작업을 함.
                String sa= age.getText().toString();
                String sb= height.getText().toString();
                int age=Integer.parseInt(sa);
                double height=Double.parseDouble(sb);
                //적절한 방법을 활용해 예외처리를 해줌.
                double realweight=(height-100)*0.9;
                if(age>=20&&age<=29)
                    text.setText("\n\n<회원님의 나이, 키에 대한 표준 수치입니다.>"+"\n 몸무게: "+realweight+"\n 기초 대사량: 1311.5 ± 233.0 kcal"+"\n 비만율(bmi)\n 저체중: ~18.5  \n정상체중:18.5이상 23미만\n 과체중:23이상 25미만 \n비만:경 도 25이상 30미만 중정도 30이상 35미만 고 도 35 이상"+"\n 정상 체지방률: 15~20");
                if(age>=30&&age<=49)
                    text.setText("\n\n<회원님의 나이, 키에 대한 표준 수치입니다.>"+"\n 몸무게: "+realweight+"\n 기초 대사량: 1316.8 ± 225.9 kcal"+"\n 비만율(bmi)\n 저체중: ~18.5  \n정상체중:18.5이상 23미만\n 과체중:23이상 25미만 \n비만:경 도 25이상 30미만 중정도 30이상 35미만 고 도 35 이상"+"\n 정상 체지방률: 15~20");
                if(age>=50)
                    text.setText("\n\n<회원님의 나이, 키에 대한 표준 수치입니다.>"+"\n 몸무게: "+realweight+"\n 기초 대사량: 1252.5 ± 228.6 kcal"+"\n 비만율(bmi)\n 저체중: ~18.5  \n정상체중:18.5이상 23미만\n 과체중:23이상 25미만 \n비만:경 도 25이상 30미만 중정도 30이상 35미만 고 도 35 이상"+"\n 정상 체지방률: 15~20");

            }
        });
    }



}
