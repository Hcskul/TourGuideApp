package com.example.lukas.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HighlightAdapter extends ArrayAdapter<Highlight> {

    /**
     * Resource ID for the background color for this list of highlights
     */
    private int mColorResourceId;

    /**
     * Create a new {@link HighlightAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param highlights      is the list of {@link Highlight}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of highlights
     */
    public HighlightAdapter(Context context, ArrayList<Highlight> highlights, int colorResourceId) {
        super(context, 0, highlights);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    /**
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        Highlight currentHighlight = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view
        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        // set this text on the name TextView
        nameTextView.setText(currentHighlight.getNameId());

        // Find the TextView in the list_item.xml layout with the ID location_text_view
        TextView locationTextView = listItemView.findViewById(R.id.location_text_view);
        // set this text on the location TextView
        locationTextView.setText(currentHighlight.getLocationId());

        // Find the TextView in the list_item.xml layout with the ID telephone_text_view
        TextView telephoneTextView = listItemView.findViewById(R.id.telephone_text_view);
        // set this text on the telephone TextView
        telephoneTextView.setText(currentHighlight.getTelephoneId());

        // Find the TextView in the list_item.xml layout with the ID opening_hours_text_view
        ImageView imageView = listItemView.findViewById(R.id.image);
        // set this text on the openingHors TextView
        imageView.setImageResource(currentHighlight.getImageResourceId());

        // Find the TextView in the list_item.xml layout with the ID opening_hours_text_view.
        TextView textView = listItemView.findViewById(R.id.opening_hours_text_view);

        // Check if an opening hour is provided for this highlight or not
        if (currentHighlight.hasOpen()) {
            // If an opening hour is available, display the provided data based on the resource ID
            textView.setText(currentHighlight.getOpenId());
            // Make sure the view is visible
            textView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the TextView (set visibility to GONE)
            textView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
