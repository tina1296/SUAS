package com.example.plz;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class dp extends AppCompatActivity {
    //list(어댑터뷰) 구현.
    ListView list;
    //제품들을 보여줌.
    String[] products = {
            "폼롤러"+"\n\n25800원",
            "마사지 볼"+"\n\n3,900원",
            "매트"+"\n\n12,500원",
            "아령 1kg"+"\n\n12,290원",
            "줄넘기"+"\n\n25800원",
            "현미밥상 다이어트 도시락"+"\n\n39,800원",
            "곤약젤리"+"\n\n5,900원",
            "유산균 프로바이오틱스"+"\n\n30,900원",
            "미주라 건강간식"+"\n\n2,300원",
            "푸룬주스"+"\n\n4,000원",
            "인바디 체중계"+"\n\n24,700"
    } ;
    //제품에 대한 이미지를 보여줌.
    Integer[] images = {
            R.drawable.dp1,
            R.drawable.dp2,
            R.drawable.dp3,
            R.drawable.dp4,
            R.drawable.dp5,
            R.drawable.dp6,
            R.drawable.dp7,
            R.drawable.dp8,
            R.drawable.dp9,
            R.drawable.dp10,
            R.drawable.dp11
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dp);
        CustomList adapter = new
                CustomList(dp.this);
        list=(ListView)findViewById(R.id.list);
        //어댑터뷰 구현.
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getBaseContext(), products[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class CustomList extends ArrayAdapter<String> {
        //customlist를 통해 사용자가 직접 상품을 볼 수 있도록 구현.
        private final Activity dietlist;
        public CustomList(Activity context ) {
            super(context, R.layout.listitem, products);
            this.dietlist = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            //xml에서 구현한 listitem을 바탕으로 제품, 가격, 제품 종류에 대해 보여줌.
            LayoutInflater inflater = dietlist.getLayoutInflater();
            View custom= inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = (ImageView) custom.findViewById(R.id.image);
            TextView product = (TextView) custom.findViewById(R.id.product);
            TextView productgenre = (TextView) custom.findViewById(R.id.productgenre);

            //위치에 맞게 저장됨.
            product.setText(products[position]);
            imageView.setImageResource(images[position]);
            productgenre.setText("Diet product");
            return custom;
        }
    }

}
