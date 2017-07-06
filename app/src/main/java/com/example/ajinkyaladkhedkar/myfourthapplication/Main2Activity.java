package com.example.ajinkyaladkhedkar.myfourthapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BufferedReader reader = null;
        try{
            FileInputStream noteFile = openFileInput("notesaj");
            reader = new BufferedReader(new InputStreamReader(noteFile));
            String eol = System.getProperty("line.separator");
            String line;
            StringBuilder sb = new StringBuilder();
            TextView tvNotes = (TextView)findViewById(R.id.notes);
            while((line = reader.readLine())!=null)
            {
                sb.append(line).append(eol);
            }
            tvNotes.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        });
    }




}
