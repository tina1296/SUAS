package com.example.plz;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        final Dialog loginDialog = new Dialog(this);
        loginDialog.setContentView(R.layout.login);
        loginDialog.setTitle("회원님 어서오세요.");

        final Button login = (Button) loginDialog.findViewById(R.id.join);
        Button cancel = (Button) loginDialog.findViewById(R.id.cancel);
        final EditText name = (EditText) loginDialog.findViewById(R.id.ID);

        //로그인 화면.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().length() > 0) {
                    Intent intent=new Intent(MainActivity.this, menu.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "안녕하세요 회원님.", Toast.LENGTH_LONG).show();
                    loginDialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), "다시 시도하세요.", Toast.LENGTH_LONG).show();
                }
            }
        });
        //로그인 취소.
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });

        loginDialog.show();
    }
}