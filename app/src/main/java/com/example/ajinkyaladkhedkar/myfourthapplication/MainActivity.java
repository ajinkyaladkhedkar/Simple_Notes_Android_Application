package com.example.ajinkyaladkhedkar.myfourthapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static com.example.ajinkyaladkhedkar.myfourthapplication.R.id.editText1;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText1 = (EditText)findViewById(R.id.editText1);
        Button save = (Button) findViewById(R.id.button1);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BufferedWriter writer = null;
                FileOutputStream openedFile = null;
                String message = editText1.getText().toString();
                String eol = System.getProperty("line.separator");
                try {
                    openedFile = openFileOutput("notesaj", MODE_APPEND);
                    writer = new BufferedWriter(new OutputStreamWriter(openedFile));
                    Log.d("myapp", String.valueOf(getFileStreamPath("notesaj")));
                    writer.append(message+eol);
                    writer.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gotoRead();
            }
        });

    }

    private void gotoRead() {
        finish();
        Intent i = new Intent(this, Main2Activity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }


}


    
    


