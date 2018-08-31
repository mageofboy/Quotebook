package com.example.leong.randomtweets;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomText extends AppCompatActivity {
    TextView quoteText;
    TextView personText;
    int index = 0;
    PreviousQuote previousQuote = new PreviousQuote();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_text);
        quoteText = (TextView) findViewById(R.id.quote);
        personText = (TextView) findViewById(R.id.person);
        final Button prev = (Button) findViewById(R.id.prev);
        final Button main = (Button) findViewById(R.id.main);
        final Scanner read = new Scanner(getResources().openRawResource(R.raw.text));
        final MediaPlayer music1 =  MediaPlayer.create(this, R.raw.test1);
        music1.start();

        //final Scanner read1 = new Scanner(openFileInput("newQuote.txt"));

        if (read.hasNextLine()) {
            String text = read.nextLine();
            String[] parts = text.split("~");
            String quote = parts[0];
            String person = parts[1];
            previousQuote.addQuote(quote,person);
            setBoth(index);
        }

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (read.hasNextLine()) {
                    String text = read.nextLine();
                    String[] parts = text.split("~");
                    String quote = parts[0];
                    String person = parts[1];

                    previousQuote.addQuote(quote,person);
                    if (index+1 < previousQuote.numberQuotes()) {
                        index++;
                        setBoth(index);
                    }
                } else {
                        if (index +1 < previousQuote.numberQuotes()) {
                            index++;
                            setBoth(index);
                        }   //else if ()

                }
                if (quoteText.getText().toString().contains("REE")) {
                    music1.start();
                }
            }
        });


    }
    public void setBoth(int index) {
        quoteText.setText(previousQuote.getQuote(index));
        personText.setText(previousQuote.getPerson(index));
    }
    public void clickprev(View view) {
        final MediaPlayer music1 =  MediaPlayer.create(this, R.raw.test1);
        if (index > 0) {
            index--;
            setBoth(index);
        }
        if (quoteText.getText().toString().contains("REE")) {
            music1.start();
        }
    }


    public void AddButton(View view) {
        Intent add_quote = new Intent(this,AddQuote.class);
        startActivity(add_quote);
    }
}
