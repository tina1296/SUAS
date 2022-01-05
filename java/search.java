package com.example.plz;

import android.app.ListActivity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class search extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //리스트뷰를 활용해 다이어트 중 섭취할 수 음식에 대한 칼로리를 한눈에 볼 수 있도록 만듦.
        super.onCreate(savedInstanceState);
        String[] items = { "오리고기 (100g)/337kcal","채끝살(소고기 100g)/116.6kcal","닭가슴살(100g)/164.9kcal", "고구마(100g)/85.8kcal", "감자(100g)/55kcal","아보카도(100g)/160.1kcal", "바나나(100g)/93kcal",
                "토마토(100g)/17.7kcal", "햇반(오뚜기 210g)/305kcal", "베이글(100g)/250.2kcal", "파스타 면(100g)/325kcal",
                "곤약(100g)/10kcal", "플레인 요거트(100g)/58.8kcal", "양배추(100g)/24.6kcal", "오이(100g)/9kcal", "다크초콜릿(100g)/500kcal",
                "탄산수(100ml)/0kcal", "제로콜라(100ml)/1.2kcal" };

        //어댑터 생성(하나의 텍스트 뷰 사용)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //리스트를 클릭한 것에 대해서 메세지로 한 번 더 알려줌
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item, Toast.LENGTH_LONG).show();
    }

}
