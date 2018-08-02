package com.example.varundavidpulla.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.varundavidpulla.daycareproj.R;

public class thankpay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankpay);
        ImageButton but1 = (ImageButton) findViewById(R.id.imageButton2);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thankpay.this, admin.class);
                startActivity(intent);

            }
        });
    }
}
