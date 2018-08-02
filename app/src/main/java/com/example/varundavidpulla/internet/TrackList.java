package com.example.varundavidpulla.internet;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.varundavidpulla.daycareproj.R;

import java.util.List;


public class TrackList extends ArrayAdapter<Track> {
    private Activity context;
    List<Track> course;

    public TrackList(Activity context, List<Track> course) {
        super(context, R.layout.layout_artist_list, course);
        this.context = context;
        this.course = course;
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

        Track track = course.get(position);
        textViewName.setText(track.getClassName());
        textViewAddress.setText(track.getCourseCost());
        textViewAddress.setText(track.getClassId());
       // textViewRating.setText(String.valueOf(track.getRating()));

        return listViewItem;
    }
}
