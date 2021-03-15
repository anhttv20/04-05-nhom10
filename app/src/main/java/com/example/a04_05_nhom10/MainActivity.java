package com.example.a04_05_nhom10;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private int[] icon={R.drawable.android_logo,
            R.drawable.ios_logo,
            R.drawable.blackberry_logo,
            R.drawable.windowsmobile_logo};
    private String[] title={"Android","Ios","Blackberry","Window"};
    private String[] sub;
    private String[] content={"Content 1","Content 2","Content 3","Content 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        sub=getResources().getStringArray(R.array.sub);
        final MyListAdapter adapter=new MyListAdapter(this,icon,title,sub,content);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                for(int i=0;i<adapter.getCount();i++){
                    parent.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                parent.getChildAt(position).setBackgroundColor(Color.YELLOW);
                Toast.makeText(MainActivity.this,
                        "select:"+adapter.getTitle(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
