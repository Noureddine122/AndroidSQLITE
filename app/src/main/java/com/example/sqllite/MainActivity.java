package com.example.sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

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

