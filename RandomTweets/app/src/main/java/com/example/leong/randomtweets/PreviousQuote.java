package com.example.leong.randomtweets;

import java.util.ArrayList;

public class PreviousQuote {
    ArrayList<String> previous_quote = new ArrayList<String>();
    ArrayList<String> previous_person = new ArrayList<String>();

    public PreviousQuote() {

    }
    public void addQuote(String quote, String person) {
        this.previous_quote.add(quote);
        this.previous_person.add(person);
    }
    public String getPerson(int index) {
        return previous_person.get(index);
    }
    public String getQuote(int index) {
        return previous_quote.get(index);
    }
    public int numberQuotes() {
        return previous_quote.size();
    }
}
