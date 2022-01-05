package com.example.plz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calc extends AppCompatActivity {
    Button me;
    Button fit;
    EditText age;
    EditText height;
    EditText weight;
    TextView text;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        //me: 사용자의 인바디 결과, fit: 표준 인바디 결과
        me=(Button) findViewById(R.id.me);
        fit=(Button) findViewById(R.id.fit);
        //사용자 기입 사항
        age=(EditText) findViewById(R.id.age);
        height=(EditText) findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weight);
        text=(TextView) findViewById(R.id.text);

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //나이를 제외한 키와 몸무게는 소수점으로 반환할 수 있도록 함.
                String sa= age.getText().toString();
                String sb= height.getText().toString();
                String sc= weight.getText().toString();
                int age=Integer.parseInt(sa);
                double height=Double.parseDouble(sb);
                double weight=Double.parseDouble(sc);
                //기초대사량, bmi, 제지방률, 체지방률 모두 소수점으로 결과가 나와야 함. 따라서 소수점으로 반환할 수 있도록 함.
                double base= 66.47+(13.75*weight)+(5*height)-(6.76*age);
                double obesity=(weight*10000)/(height*height);
                double jae=(1.10*weight)-(128*((weight*weight)/(height*height)));
                double chae=weight-jae;
                text.setText("\n\n회원님의 인바디 결과입니다"+"\n 기초 대사량:"+base+"\n 비만율(bmi):"+obesity+"\n 제지방률:"+jae+"\n 체지방률: "+chae+"\n위의 수치는 추정치입니다. 더욱 더 자세한 내용은 가까운 보건소나 헬스장의 인바디 기계를 활용하실 수 있습니다.");
            }
        });
        fit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //표준수치의 지표가 될 수 있는 키와 나이를 사용자로부터 받아옴.
                String sa= age.getText().toString();
                String sb= height.getText().toString();
                int age=Integer.parseInt(sa);
                double height=Double.parseDouble(sb);
                double realweight=(height-100)*0.9;
                //나이에 따라 예외 처리
                if(age>=20&&age<=29)
                    text.setText("\n\n<회원님의 나이, 키에 대한 표준 수치입니다.>"+"\n 몸무게: "+realweight+"\n 기초 대사량: 1728 ± 368.2 kcal"+"\n 비만율(bmi)\n 저체중: ~18.5  \n정상체중:18.5이상 23미만\n 과체중:23이상 25미만 \n비만:경 도 25이상 30미만 중정도 30이상 35미만 고 도 35 이상"+"\n 정상 체지방률: 15~20");
                if(age>=30&&age<=49)
                    text.setText("\n\n<회원님의 나이, 키에 대한 표준 수치입니다.>"+"\n 몸무게: "+realweight+"\n 기초 대사량: 1669.5 ± 302.1kcal"+"\n 비만율(bmi)\n 저체중: ~18.5  \n정상체중:18.5이상 23미만\n 과체중:23이상 25미만 \n비만:경 도 25이상 30미만 중정도 30이상 35미만 고 도 35 이상"+"\n 정상 체지방률: 15~20");
                if(age>=50)
                    text.setText("\n\n<회원님의 나이, 키에 대한 표준 수치입니다.>"+"\n 몸무게: "+realweight+"\n 기초 대사량: 1493.8 ± 315.3 kcal"+"\n 비만율(bmi)\n 저체중: ~18.5  \n정상체중:18.5이상 23미만\n 과체중:23이상 25미만 \n비만:경 도 25이상 30미만 중정도 30이상 35미만 고 도 35 이상"+"\n 정상 체지방률: 15~20");

            }
        });
    }



}
