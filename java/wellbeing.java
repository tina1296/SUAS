package com.example.plz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class wellbeing extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellbeing);
        //닫기
        Button back4=(Button) findViewById(R.id.back4);
        final Button minding=(Button) findViewById(R.id.minding);
        final Button sleep=(Button) findViewById(R.id.sleep);
        //마음가짐-mind와 연결
        minding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(wellbeing.this, mind.class);
                startActivity(intent);
            }
        });

        //숙면-숙면(sleep)과 연결
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(wellbeing.this, sleep.class);
                startActivity(intent);
            }
        });
        back4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });

    }
}
