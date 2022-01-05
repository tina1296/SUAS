package com.example.plz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class form extends AppCompatActivity {
    Button male;
    Button female;
    //남성인지 여성인지에 따라 계산 하는 방법이 다르기 때문에 다음과 같이 구현함.
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //female or male의 줄임말인 form xml을 구현.
        setContentView(R.layout.form);
        male=(Button) findViewById(R.id.male);
        female=(Button) findViewById(R.id.female);
        //남성일 때,
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(form.this, calc.class);
                startActivity(intent);
            }
        });
        //여성일때,
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(form.this, fcalc.class);
                startActivity(intent);
            }
        });
    }
}