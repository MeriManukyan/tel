package com.example.meri.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    String s;String t;  EditText et,et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
     et =findViewById(R.id.editText);
        et1=findViewById(R.id.editText2);

        Button b=findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=et.getText().toString();
                t= et1.getText().toString();
                DB db=new DB(getApplication());
                db.open();
                db.add(s,t);
                finish();
            }
        });
    }
}
