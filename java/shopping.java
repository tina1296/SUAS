package com.example.plz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class shopping extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);
        //닫기
        Button back3=(Button) findViewById(R.id.back3);
        Button dp=(Button) findViewById(R.id.dp);
        Button mp=(Button) findViewById(R.id.mp);
        back3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        //다이어트 제품
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(shopping.this, dp.class);
                startActivity(intent);
            }
        });
        //근육 관련 제품
        mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(shopping.this, mp.class);
                startActivity(intent);
            }
        });
    }
}
