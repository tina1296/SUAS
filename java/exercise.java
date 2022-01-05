package com.example.plz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class exercise extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //exercise xml을 보여줌.
        setContentView(R.layout.exercise);
        //뒤로가기 버튼 구현.
        Button back1=(Button) findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        //스탑워치 구현.
        final Button stop=(Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(exercise.this, stop.class);
                startActivity(intent);
            }
        });
        //스쿼트 카테고리 구현.
        final Button squat=(Button) findViewById(R.id.squat);
        squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(exercise.this, squat.class);
                startActivity(intent);
            }
        });
        //줄넘기 카테고리 구현.
        final Button jull=(Button) findViewById(R.id.jull);
        jull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(exercise.this, jull.class);
                startActivity(intent);
            }
        });
        //플랭크 카테고리 구현.
        final Button flank=(Button) findViewById(R.id.flank);
        flank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(exercise.this, flank.class);
                startActivity(intent);
            }
        });
        //런닝&걷기 카테고리 구현.
        final Button running=(Button) findViewById(R.id.running);
        running.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(exercise.this, running.class);
                startActivity(intent);
            }
        });
    }
}
