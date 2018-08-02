package com.example.varundavidpulla.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.varundavidpulla.daycareproj.R;

public class thankfeed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankfeed);
        ImageButton but1 = (ImageButton) findViewById(R.id.thankfeed);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thankfeed.this, admin.class);
                startActivity(intent);

            }
        });
    }
}
