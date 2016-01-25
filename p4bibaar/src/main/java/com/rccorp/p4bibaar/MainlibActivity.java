package com.rccorp.p4bibaar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainlibActivity extends AppCompatActivity {

    private static final String JOKE = "joke";

    TextView joketv;

    String intentjoke;

    public static Intent launchIntent(Context context, String joke) {
        Intent intent = new Intent(context, MainlibActivity.class);
        intent.putExtra(JOKE, joke);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlib);
        joketv=(TextView) findViewById(R.id.jokeaartv);
        intentjoke=getIntent().getStringExtra(JOKE);

        if (intentjoke == null){
            joketv.setText("NO JOKE RECEIVED");
        }else{
            joketv.setText(intentjoke);
        }


    }



}
