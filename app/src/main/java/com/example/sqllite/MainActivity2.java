package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = new Intent();
        MyDatabase mydb = new MyDatabase(this);
        final ListView lv = (ListView) findViewById(R.id.ListP);
        java.util.List<String> fruits_list = new ArrayList<String>();
        ArrayAdapter<String> arrayAdapter ;
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruits_list);
        lv.setAdapter(arrayAdapter);
        mydb.readData(arrayAdapter,fruits_list);
        Button btnfinich = (Button) findViewById(R.id.Return);
        btnfinich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}