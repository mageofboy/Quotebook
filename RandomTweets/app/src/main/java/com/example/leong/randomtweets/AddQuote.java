package com.example.leong.randomtweets;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.File;
import java.util.logging.FileHandler;

public class AddQuote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);


    }

    public void addquote(View view) {
        EditText newquote = findViewById(R.id.newquote);
        EditText newperson = findViewById(R.id.newperson);
        String new_quote = "\"\"" + newquote.getText().toString()+ "\"\"";
        String new_person = "-" +newperson.getText().toString();

        finish();
    }

}
