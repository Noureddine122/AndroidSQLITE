package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDatabase mydb = new MyDatabase(this);


        Button btn = (Button) findViewById(R.id.button);
        Button btnAfficher = (Button)findViewById(R.id.Goafficher);
        TextInputEditText input1 = (TextInputEditText) findViewById(R.id.input);
        TextInputEditText input2 = (TextInputEditText) findViewById(R.id.input2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(input1.getText().toString())||TextUtils.isEmpty(input2.getText().toString())){
                    Toast toasts = Toast.makeText(getApplicationContext(),
                            "Les champs doivent etre tous remplis",
                            Toast.LENGTH_SHORT);
                    toasts.show();
                    return;
                }
                mydb.insertData(input1.getText().toString(),input2.getText().toString());
                Toast toast = Toast.makeText(getApplicationContext(),
                        "The data est bien enregistré",
                        Toast.LENGTH_SHORT);
                input1.setText("");
                input2.setText("");
                toast.show();
            }
        });
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, com.example.sqllite.MainActivity2.class);
                startActivityForResult(i,1);
            }
        });
    }
}

