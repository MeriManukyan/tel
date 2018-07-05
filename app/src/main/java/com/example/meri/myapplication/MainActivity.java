package com.example.meri.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
DB db;ListView l;
Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });
       l =findViewById(R.id.lv);
        db=new DB(this);
        db.open();
        cursor=db.getAllData();
        String from[]={DB.name,DB.phone};
        int to[]={R.id.textView,R.id.textView2};
        SimpleCursorAdapter c=new SimpleCursorAdapter(this,R.layout.mm,cursor,from,to);
        l.setAdapter(c);
       l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String number=((TextView)view.findViewById(R.id.textView2)).getText().toString();
               Intent intent=new Intent(Intent.ACTION_DIAL);
               intent.setData(Uri.parse("tel:"+number));
               startActivity(intent);
           }
       });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        db=new DB(this);
        db.open();
        cursor=db.getAllData();
        String from[]={DB.name,DB.phone};
        int to[]={R.id.textView,R.id.textView2};
        SimpleCursorAdapter c=new SimpleCursorAdapter(this,R.layout.mm,cursor,from,to);
        l.setAdapter(c);
    }

}
