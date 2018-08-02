package com.example.varundavidpulla.internet;

/**
 * Created by Varun David Pulla on 17-Dec-17.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.varundavidpulla.daycareproj.R;

import java.util.List;

/**
 * Created by Belal on 2/26/2017.
 */

public class ArtistList extends ArrayAdapter<Artist> {
    private Activity context;
    List<Artist> parents;

    public ArtistList(Activity context, List<Artist> parents) {
        super(context, R.layout.layout_artist_list, parents);
        this.context = context;
        this.parents = parents;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_artist_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.name);
        TextView textViewAddress = (TextView) listViewItem.findViewById(R.id.address);
        TextView textViewContact = (TextView) listViewItem.findViewById(R.id.contact);
        TextView textViewDob = (TextView) listViewItem.findViewById(R.id.dob);
        TextView textViewOccu = (TextView) listViewItem.findViewById(R.id.occupation);


        Artist artist = parents.get(position);
        textViewName.setText(artist.getparentName());
        textViewAddress.setText(artist.getparentAddress());
        textViewContact.setText(artist.getparentContact());
        textViewOccu.setText(artist.getparentOccupation());
        textViewDob.setText(artist.getparentDob());

        return listViewItem;
    }
}
