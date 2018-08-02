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

public class plan2 extends AppCompatActivity {

    public static final String msg="plans";
    Button but2;

    private DatabaseReference mDatabase2,mPlan2;
    TextView speed2,fup2,postfup2,val2,cost2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan2);

        speed2=(TextView) findViewById(R.id.sp2);
        fup2=(TextView) findViewById(R.id.tv_speedlimit2);
        postfup2=(TextView) findViewById(R.id.tv_safup2);
        val2=(TextView) findViewById(R.id.tv_validity2);
        cost2=(TextView) findViewById(R.id.tv_cost2);
        mDatabase2 = FirebaseDatabase.getInstance().getReference();

        mPlan2=mDatabase2.child("Plans").child("plan2");
        mPlan2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String speed22 = dataSnapshot.child("speed").getValue().toString();
                String fup22 = dataSnapshot.child("fup").getValue().toString();
                String postfup22 = dataSnapshot.child("postfup").getValue().toString();
                String val22 = dataSnapshot.child("validity").getValue().toString();
                String cost22 = dataSnapshot.child("cost").getValue().toString();
              //  Toast.makeText(getApplicationContext(), speed22, Toast.LENGTH_SHORT).show();
                speed2.setText(null);
                fup2.setText(null);
                postfup2.setText(null);
                val2.setText(null);
                cost2.setText(null);
                speed2.setText(speed22);
                fup2.setText(fup22);
                postfup2.setText(postfup22);
                val2.setText(val22);
                cost2.setText(cost22);


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        but2=(Button) findViewById(R.id.r1);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(plan2.this,payment.class);
                intent.putExtra(msg,("plan2"));
                startActivity(intent);
            }
        });
    }
}
