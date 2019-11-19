package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent =getIntent();
        double outcome =intent.getDoubleExtra("fee",-1);
        Log.d("ResultActivity",outcome+"");
        TextView textfee =findViewById(R.id.fee);
        int n =(int) (outcome+0.5);
        textfee.setText(n+"");
    }
}
