package com.example.varundavidpulla.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.varundavidpulla.daycareproj.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class plan3 extends AppCompatActivity {
    public static final String msg="plans";
    Button but1;
    Button but2;
    Button but3;
    Button but4;
    private DatabaseReference mDatabase,mPlan,mPlan2,mPlan3,mPlan4;
    TextView speed1,fup1,postfup1,val1,cost1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan3);
        speed1=(TextView) findViewById(R.id.sp);
        fup1=(TextView) findViewById(R.id.tv_speedlimit);
        postfup1=(TextView) findViewById(R.id.tv_safup);
        val1=(TextView) findViewById(R.id.tv_validity);
        cost1=(TextView) findViewById(R.id.tv_cost);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mPlan3=mDatabase.child("Plans").child("plan3");
        mPlan3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String speed = dataSnapshot.child("speed").getValue().toString();
                String fup = dataSnapshot.child("fup").getValue().toString();
                String postfup = dataSnapshot.child("postfup").getValue().toString();
                String val = dataSnapshot.child("validity").getValue().toString();
                String cost = dataSnapshot.child("cost").getValue().toString();
                // Toast.makeText(getApplicationContext(), speed, Toast.LENGTH_SHORT).show();
                speed1.setText(speed);
                fup1.setText(fup);
                postfup1.setText(postfup);
                val1.setText(val);
                cost1.setText(cost);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        but3=(Button) findViewById(R.id.r1);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(plan3.this,payment.class);
                intent.putExtra(msg,("plan3"));
                startActivity(intent);
            }
        });
    }
}
