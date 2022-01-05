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

public class mp extends AppCompatActivity {
    ListView list;
    //리스트뷰(어댑터뷰)
    String[] products = {
            "푸쉬업 키트"+"\n\n24900원",
            "풀업바 턱걸이 기구"+"\n\n28,600원",
            "덤벨(6kg,7kg,8kg,9kg,10kg)"+"\n\n15,500원",
            "바벨(20kg)"+"\n\n13,500원",
            "벤치프레스"+"\n\n114,600원",
            "스텝박스"+"\n\n16,560원",
            "마사지건"+"\n\n39,900원",
            "마이프로틴 프로틴쉐이크"+"\n\n12,900원",
            "커틀랜드 단백질바(20개)"+"\n\n33,200원",
            "휘트니스 루프"+"\n\n4,000원",
            "헬스 장갑"+"\n\n15,000원"
    } ;
    //사용자에게 이미지를 보여줌
    Integer[] images = {
            R.drawable.mp1,
            R.drawable.mp2,
            R.drawable.mp3,
            R.drawable.mp4,
            R.drawable.mp5,
            R.drawable.mp6,
            R.drawable.mp7,
            R.drawable.mp8,
            R.drawable.mp9,
            R.drawable.mp10,
            R.drawable.mp11
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp);
        //어댑터 뷰의 활용
        CustomList adapter = new CustomList(mp.this);
        list=(ListView)findViewById(R.id.list);
        //리스트 어댑터뷰
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
        //사용자가 만든 어댑터뷰
        private final Activity musclelist;
        public CustomList(Activity context ) {
            super(context, R.layout.listitem2, products);
            this.musclelist = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            //사용자가 원하는대로 이미지, 제품, 제품가격, 이름 등을 넣음.
            LayoutInflater inflater = musclelist.getLayoutInflater();
            View custom= inflater.inflate(R.layout.listitem2, null, true);
            ImageView imageView = (ImageView) custom.findViewById(R.id.image);
            TextView product = (TextView) custom.findViewById(R.id.product);
            TextView productgenre = (TextView) custom.findViewById(R.id.productgenre);
            //위치에 맞게 저장됨.
            product.setText(products[position]);
            imageView.setImageResource(images[position]);
            productgenre.setText("Muscle product");
            return custom;
        }
    }

}
