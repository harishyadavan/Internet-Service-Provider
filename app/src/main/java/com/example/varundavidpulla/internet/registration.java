package com.example.varundavidpulla.internet;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.varundavidpulla.daycareproj.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class registration extends AppCompatActivity {

    //we will use these constants later to pass the artist name and id to another activity
    public static final String PARENT_ID = "com.example.varundavidpulla.daycareproj.parentId";
    public static final String PARENT_NAME = "com.example.varundavidpulla.daycareproj.parentName";
    public static final String PARENT_OCCUPATION = "com.example.varundavidpulla.daycareproj.parentOccupation";
    public static final String PARENT_CONTACT = "com.example.varundavidpulla.daycareproj.parentContact";
    public static final String PARENT_DOB = "com.example.varundavidpulla.daycareproj.parentDob";
    public static final String PARENT_ADDRESS = "com.example.varundavidpulla.daycareproj.parentAddress";
    //view objects
    EditText name,address,contact,occupation,dob;
    // Spinner spinnerGenre;
    Button buttonAddArtist;
    ListView listViewArtists;

    //a list to store all the artist from firebase database
    List<Artist> parents;

    //our database reference object
    DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //getting the reference of artists node
        databaseArtists = FirebaseDatabase.getInstance().getReference("parents");

        //getting views
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        contact = (EditText) findViewById(R.id.contact);
        dob = (EditText) findViewById(R.id.dob);
        occupation = (EditText) findViewById(R.id.occupation);

        listViewArtists = (ListView) findViewById(R.id.listViewArtists);

        buttonAddArtist = (Button) findViewById(R.id.buttonSave);

        //list to store artists
        parents = new ArrayList<>();


        //adding an onclicklistener to button
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addArtist();
                onStart();
            }
        });
        listViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected artist
                Artist artist = parents.get(i);

                //creating an intent
                Intent intent = new Intent(getApplicationContext(), ArtistActivity.class);

                //putting artist name and id to intent
                intent.putExtra(PARENT_ID, artist.getparentId());
                intent.putExtra(PARENT_NAME, artist.getparentName());
                intent.putExtra(PARENT_CONTACT, artist.getparentContact());
                intent.putExtra(PARENT_DOB, artist.getparentDob());
                intent.putExtra(PARENT_OCCUPATION, artist.getparentOccupation());
                intent.putExtra(PARENT_ADDRESS, artist.getparentAddress());
                //starting the activity with intent
                startActivity(intent);
            }
        });
        listViewArtists.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Artist artist = parents.get(i);
                showUpdateDeleteDialog(artist.getparentId(), artist.getparentName(),artist.getparentContact(), artist.getparentAddress(),artist.getparentOccupation(),artist.getparentDob());
                return true;
            }
        });
    }
    private boolean deleteArtist(String id) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("parents").child(id);

        //removing artist
        dR.removeValue();

        //getting the tracks reference for the specified artist
        DatabaseReference drTracks = FirebaseDatabase.getInstance().getReference("course").child(id);

        //removing all tracks
        drTracks.removeValue();
        Toast.makeText(getApplicationContext(), "Course Deleted", Toast.LENGTH_LONG).show();

        return true;
    }
    private boolean updateArtist(String id, String PName,String PAddress,String PContact,String POccupation,String PDob) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("parent").child(id);

        //updating artist
        Artist artist = new Artist(id,PName,POccupation,PContact,PDob,PAddress);
        dR.setValue(artist);
        Toast.makeText(getApplicationContext(), "Profile Updated", Toast.LENGTH_LONG).show();
        return true;
    }
    private void showUpdateDeleteDialog(final String parentId, final String parentName , final String parentContact, final String parentAddress, final String parentOccupation, final String parentDob) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.name1);
        final EditText editTextAddress = (EditText) dialogView.findViewById(R.id.address1);
        final EditText editTextOccu = (EditText) dialogView.findViewById(R.id.occupation1);
        final EditText editTextContact = (EditText) dialogView.findViewById(R.id.contact1);
        final EditText editTextDob = (EditText) dialogView.findViewById(R.id.dob1);
        // final Spinner spinnerGenre = (Spinner) dialogView.findViewById(R.id.spinnerGenres);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateArtist);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteArtist);

        dialogBuilder.setTitle(parentName);
        dialogBuilder.setTitle(parentContact);
        dialogBuilder.setTitle(parentAddress);
        dialogBuilder.setTitle(parentOccupation);
        dialogBuilder.setTitle(parentDob);
        final AlertDialog b = dialogBuilder.create();
        b.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PName = editTextName.getText().toString().trim();
                String PAddress = editTextAddress.getText().toString().trim();
                String PContact = editTextContact.getText().toString();
                String POccupation = editTextOccu.getText().toString().trim();
                String PDob = editTextDob.getText().toString().trim();
                if (!TextUtils.isEmpty(PName)) {
                    updateArtist(parentId, PName, PAddress,PContact,POccupation,PDob);
                    b.dismiss();
                }
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteArtist(parentId);
                b.dismiss();
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                * we will code this method to delete the artist
                * */

            }
        });
    }
    /*
    * This method is saving a new artist to the
    * Firebase Realtime Database
    * */
    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                parents.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Artist artist = postSnapshot.getValue(Artist.class);
                    //adding artist to the list
                    parents.add(artist);
                }

                //creating adapter
                ArtistList artistAdapter = new ArtistList(registration.this, parents);
                //attaching adapter to the listview
                listViewArtists.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void addArtist() {
        //getting the values to save
        String PName = name.getText().toString().trim();
        String PAddress = address.getText().toString().trim();
        String PContact = contact.getText().toString();
        String POccupation = occupation.getText().toString().trim();
        String PDob = dob.getText().toString().trim();
        // String pid = id.getText().toString().trim();
        // String genre = spinnerGenre.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(PName)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            Artist artist = new Artist(id,PName,PAddress,PContact,POccupation,PDob);

            //Saving the Artist
            databaseArtists.child(id).setValue(artist);

            //setting edittext to blank again
            // editTextName.setText("");

            //displaying a success toast
            Toast.makeText(this, "Profile added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}

