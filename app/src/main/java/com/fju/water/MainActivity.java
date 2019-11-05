package com.fju.water;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView month;
    private TextView next;
    private Button result;
    private double outcome;
    private String title;
    private Double outcome1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        month = findViewById(R.id.month);
        next = findViewById(R.id.next);
        result = findViewById(R.id.summit);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public  void caculate(View view){
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        };
        title = "";
        outcome = 0.0;
        float monthn=Float.parseFloat(month.getText().toString());
        float nextn=Float.parseFloat(next.getText().toString());
        if (!TextUtils.isEmpty(month.getText().toString())){
            if (monthn>=1&&monthn<=10){
                outcome = monthn*7.35f;
            }
            else if (monthn>=11&&monthn<=30){
                outcome =(monthn*9.45f)-21;
            }
            else if (monthn>=31&&monthn<=50){
                outcome =(monthn*11.55f)-84;
            }
            else if (monthn>=51){
                outcome =(monthn*12.075f)-110.25f;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表")
                    .setMessage("費用: "+outcome)
                    .setPositiveButton("ok",null)
                    .show();
        }
        /*else
        if (nextn>=1&&monthn<=20){
            outcome = monthn*7.35;
            title="格月抄表";
        }
        else if (monthn>=21&&monthn<=60){
            outcome =(monthn*9.45)-42;
            title="格月抄表";
        }
        else if (monthn>=61&&monthn<=100){
            outcome =(monthn*11.55)-168;
            title="格月抄表";
        }
        else if (monthn>=101){
            outcome =(monthn*12.075)-220.5;
            title="格月抄表";
        }*/
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
}
