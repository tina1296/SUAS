package com.example.plz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class calorie extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie);
        Button back2=(Button) findViewById(R.id.back2);
        Button form=(Button) findViewById(R.id.form);
        Button search=(Button) findViewById(R.id.search);
        //intent를 활용해 닫기를 누르면 끝냄.
        back2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        //female or male의 줄임말의 form, 자신의 몸 상태를 알 수 있는 카테고리.
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(calorie.this, form.class);
                startActivity(intent);
            }
        });
        //칼로리 탐색할 수 있는 카테고리.
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(calorie.this, search.class);
                startActivity(intent);
            }
        });
    }


}
