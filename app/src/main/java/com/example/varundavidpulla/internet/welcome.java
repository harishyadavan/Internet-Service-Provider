package com.example.varundavidpulla.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.varundavidpulla.daycareproj.R;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
    public  void onclick(View view)
    {
        startActivity(new Intent(welcome.this, MainActivity.class));
    }
}
