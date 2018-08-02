package com.example.varundavidpulla.internet;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.varundavidpulla.daycareproj.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class admin extends AppCompatActivity  {
    private DrawerLayout dl;
    private ActionBarDrawerToggle toggle;
    private FirebaseAuth firebaseAuth;

    //view objects
  //  private TextView textViewUserEmail;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin);
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, log.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
       TextView textViewUserEmail = (TextView) findViewById(R.id.userRey);
      // buttonLogout = (Button) findViewById(R.id.buttonLogout);

        //displaying logged in user name
        textViewUserEmail.setText(user.getEmail());

        //adding listener to button
      //  buttonLogout.setOnClickListener(this);
        dl = (DrawerLayout) findViewById(R.id.dd);
        toggle=new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);

        dl.addDrawerListener(toggle);
        NavigationView nvDrawer=(NavigationView) findViewById(R.id.nv);
       toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       setupDrawerContent(nvDrawer);


    }


    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.drawermenu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            call();
            Intent in = new Intent(admin.this, log.class);
            startActivity(in);
            return false;
        }

        return  super.onOptionsItemSelected(item);

    }
    public void call()
    {
        firebaseAuth.signOut();
        //closing activity
        finish();
    }
    public void selectItemDrawer(MenuItem menuItem)
    {
        Fragment myFragment=null;
        Class fragmentClass;
        switch (menuItem.getItemId())
        {


            case R.id.home:
                Intent in3 = new Intent(admin.this, home.class);
                startActivity(in3);
                break;
            case R.id.vp:
                Intent in1 = new Intent(admin.this, plans.class);
                startActivity(in1);
                break;

            case R.id.reg:
                Intent in9 = new Intent(admin.this, registration.class);
                startActivity(in9);
                break;
            case R.id.contactus:
                Intent in6 = new Intent(admin.this, contactus.class);
                startActivity(in6);
                break;
            case R.id.fbb:
                Intent in2 = new Intent(admin.this, feedback.class);
                startActivity(in2);
                break;
            case R.id.logout:
                Intent in8 = new Intent(admin.this, log.class);
                startActivity(in8);
                break;

            default:
                Intent in7 = new Intent(admin.this, log.class);
                startActivity(in7);
                break;

        }

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        dl.closeDrawers();



    }
    private  void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                selectItemDrawer(item);
                return true;
            }
        });
    }



}

