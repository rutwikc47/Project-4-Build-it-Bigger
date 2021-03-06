package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rccorp.p4bibaar.MainlibActivity;
import com.udacity.gradle.jokes.Joker;


public class MainActivity extends ActionBarActivity {

    ImageView joketv;
    String receivedjoke;

    private Context mContext;

    ProgressBar mprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        joketv=(ImageView) findViewById(R.id.joketxt);
        joketv.setBackgroundResource(R.drawable.legen);
        mContext=getApplicationContext();
        mprogressbar=(ProgressBar) findViewById(R.id.loader_joke);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

        mprogressbar.setVisibility(View.VISIBLE);

            new JokeAsyncTask(){

                @Override
                protected void onPostExecute(String s) {
                    if (s == null){
                        Toast.makeText(MainActivity.this, "No Joke received", Toast.LENGTH_SHORT).show();
                        mprogressbar.setVisibility(View.INVISIBLE);
                    }else {
                        startActivity(MainlibActivity.launchIntent(MainActivity.this,s));
                        mprogressbar.setVisibility(View.INVISIBLE);
                    }
                }
            }.execute();
        }
}
