package com.example.varundavidpulla.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.varundavidpulla.daycareproj.R;

public class plans extends AppCompatActivity {
    public static final String msg="plans";
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_plans);

            ImageButton but1 = (ImageButton) findViewById(R.id.plan1);
            ImageButton but2 = (ImageButton) findViewById(R.id.plan2);
            ImageButton but3 = (ImageButton) findViewById(R.id.plan3);
            ImageButton but4 = (ImageButton) findViewById(R.id.plan4);


            but1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(plans.this, plan.class);
                    intent.putExtra(msg, ("plan1"));
                    startActivity(intent);

                }
            });


            but2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(plans.this, plan2.class);
                    intent.putExtra(msg, ("plan2"));
                    startActivity(intent);

                }
            });
            but3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(plans.this, plan3.class);
                    intent.putExtra(msg, ("plan3"));
                    startActivity(intent);
                }
            });
            but4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(plans.this, plan4.class);
                    intent.putExtra(msg, ("plan4"));
                    startActivity(intent);
                }
            });

        }

    }
