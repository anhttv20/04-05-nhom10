package com.example.a04_05_nhom10;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyListAdapter extends ArrayAdapter<String > {
    private Activity context;
    private int[] icon;
    private String[] title;
    private String[] subtitle;
    private String[] content;

    public MyListAdapter(@NonNull Activity context, int[] icon,String[] title,
                         String[] subtitle,String[] content) {
        super(context, R.layout.list_item,title);
        this.context=context;
        this.title=title;
        this.icon=icon;
        this.subtitle=subtitle;
        this.content=content;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view,
                        @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_item,null,true);
        //gan View
        ImageView i=v.findViewById(R.id.icon);
        TextView tt=v.findViewById(R.id.title);
        TextView st=v.findViewById(R.id.subtitle);
        TextView ct=v.findViewById(R.id.content);

        i.setImageResource(icon[position]);
        tt.setText(title[position]);
        st.setText(subtitle[position]);
        ct.setText(content[position]);

        return v;
    }
    public String getTitle(int pos){
        return  title[pos];
    }
}
