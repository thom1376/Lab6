package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Get the {@link EaerthquakeReport} object located at this position in the list
        Earthquake currentReport = getItem(position);

        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude);
        // Get the magnitude from the Earthquake object and set this text on the magnitude TextView
        magnitudeTextView.setText(currentReport.getMagnitude());

        TextView locationTextView = listItemView.findViewById(R.id.location);
        // Get the location from the Earthquake object and set this text on the location TextView
        locationTextView.setText(currentReport.getLocation());

        TextView dateTextView = listItemView.findViewById(R.id.date);
        // Get the date from the Earthquake object and set this text on the date TextView
        Date date = new Date(currentReport.getDate());
        dateTextView.setText(formatDate(date));

        TextView timeTextView = listItemView.findViewById(R.id.time);
        // Get the date from the Earthquake object and set this text on the time TextView
        timeTextView.setText(formatTime(date));

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
