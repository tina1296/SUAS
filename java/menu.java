package com.example.plz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        //사실상 이 앱의 시작이라고 볼 수 있는 메뉴 화면.
        //메모, 칼로리, 웰빙, 쇼핑, 운동의 카테고리에 따라 들어가서 활동을 할 수 있음.
        //설정에 들어가 사용법, 건의사항을 할 수 있음.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        final Button memo=(Button) findViewById(R.id.memo);
        //메모
        memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menu.this, memo.class);
                startActivity(intent);
            }
        });
        //칼로리
        final Button calorie=(Button) findViewById(R.id.calorie);
        calorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menu.this, calorie.class);
                startActivity(intent);
            }
        });
        //웰빙
        Button wellbeing=(Button) findViewById(R.id.wellbeing);
        wellbeing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menu.this, wellbeing.class);
                startActivity(intent);
            }
        });
        //쇼핑
        Button shopping=(Button) findViewById(R.id.shopping);
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menu.this, shopping.class);
                startActivity(intent);
            }
        });
        //운동
        Button exercise=(Button) findViewById(R.id.exercise);
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menu.this, exercise.class);
                startActivity(intent);
            }
        });

    }
    //설정
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }
    //건의사항, 사용법을 볼 수 있는 곳.
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.howtouse:
                Intent intent = new Intent(this, howtouse.class);
                startActivity(intent);
                return true;
            case R.id.request:
                Toast.makeText(this, "더욱 많은 건의 사항이 있다면, tina1296@naver.com에 메일을 보내주세요", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
