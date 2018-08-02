package com.example.varundavidpulla.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.varundavidpulla.daycareproj.R;

public class payment extends AppCompatActivity {

    EditText Name,cno,cvv,val;

    TextView textViewName,textViewAge,textViewword;

    Button RegistrationButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        RegistrationButton=(Button)findViewById(R.id.pay);

        Name=(EditText)findViewById(R.id.cardname);
        cno=(EditText)findViewById(R.id.cardno);
        val=(EditText)findViewById(R.id.validity);
        cvv=(EditText)findViewById(R.id.cvv);


        RegistrationButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                final String Name1=Name.getText().toString();
                final String cno1=cno.getText().toString();
                final String val1=val.getText().toString();
                final String cvv1=cvv.getText().toString();

                if(Name1.length()==0)

                {
                    Name.requestFocus();
                    Name.setError("FIELD CANNOT BE EMPTY");
                }

                else if(!Name1.matches("[a-zA-Z ]+"))
                {
                    Name.requestFocus();
                    Name.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                if((cno1.length()==0)||(cno1.length()==1)||(cno1.length()==2)||(cno1.length()==3)||(cno1.length()==4)||(cno1.length()==5)||(cno1.length()==6)||(cno1.length()==7)||(cno1.length()==8)||(cno1.length()==9)||(cno1.length()==10)||(cno1.length()==11))

                {
                    cno.requestFocus();
                    cno.setError("FIELD CANNOT BE EMPTY OR FIELD SHOULD CANTAIN 12 DIGITS");
                }

                else if(!cno1.matches("[0-9]+"))
                {
                    cno.requestFocus();
                    cno.setError("ENTER ONLY Numbers");
                }
                if((cvv1.length()==0)||(cvv1.length()==1)||(cvv1.length()==2))

                {
                    cvv.requestFocus();
                    cvv.setError("FIELD CANNOT BE EMPTY OR FIELD SHOULD BE THREE NUMBERS");
                }

                else if(!cvv1.matches("[0-9]+"))
                {
                    cvv.requestFocus();
                    cvv.setError("ENTER ONLY Numbers");
                }

                else
                {
                    Intent intent=new Intent(payment.this,thankpay.class);

                    startActivity(intent);
                }
            }
        });

    }
    }

