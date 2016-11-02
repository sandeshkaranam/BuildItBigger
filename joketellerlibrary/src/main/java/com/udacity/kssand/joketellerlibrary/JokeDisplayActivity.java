package com.udacity.kssand.joketellerlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        String jokeString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                jokeString= null;
            } else {
                jokeString= extras.getString("JOKE");
            }
        } else {
            jokeString= (String) savedInstanceState.getSerializable("JOKE");
        }
        TextView textView = (TextView)this.findViewById(R.id.jokeText);
        if(textView != null) {
            textView.setText(jokeString);
        }
    }
}
