package com.example.varundavidpulla.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.varundavidpulla.daycareproj.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {

    EditText name,mb,msg;
    Button submit,but2;
    DatabaseReference rootRef, demoRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        name = (EditText) findViewById(R.id.editText);
        mb = (EditText) findViewById(R.id.editText2);
        msg = (EditText) findViewById(R.id.editText3);
        submit = (Button) findViewById(R.id.button4);
        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node
        demoRef = rootRef.child("feedback");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String mb1 = mb.getText().toString();
                String msg1 = msg.getText().toString();
                //push creates a unique id in database
                demoRef.push().setValue(name1);
                demoRef.push().setValue(mb1);
                demoRef.push().setValue(msg1);
                Intent intent=new Intent(feedback.this,thankfeed.class);
                startActivity(intent);
            }
        });
        but2=(Button) findViewById(R.id.button5);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(feedback.this, admin.class);

                    startActivity(intent);
            }
        });

    }
}





