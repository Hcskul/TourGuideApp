package com.example.lukas.tourguideapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CultureFragment extends Fragment {


    public CultureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.highlight_list, container, false);

        // Create a list of highlights
        final ArrayList<Highlight> highlights = new ArrayList<>();
        highlights.add(new Highlight(R.string.gewand_name, R.string.gewand_location,
                R.string.gewand_telephone, R.drawable.gewand_image));
        highlights.add(new Highlight(R.string.oper_name, R.string.oper_location,
                R.string.oper_telephone, R.drawable.oper_image));

        // Create an {@link HighlightAdapter}, whose data source is a list of {@link highlights}s. The
        // adapter knows how to create list items for each item in the list.
        HighlightAdapter adapter = new HighlightAdapter(getActivity(), highlights, R.color.category_culture);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // highlight_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link HighlightAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Highlight} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Highlight} object at the given position the user clicked on
                Highlight pos = highlights.get(position);

                //send an intent to call the number
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", getString(pos.getTelephoneId()), null));
                startActivity(intent);

            }
        });

        return rootView;
    }
}
