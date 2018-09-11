package com.me.theofrancisco.BostonTour;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends Fragment {

    public CityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);


        final ArrayList<Place> places = Utils.getPlaces("city");

        // setting up the array adapter
        PlaceAdapter itemsAdapter = new PlaceAdapter(getActivity(), places);

        // finding the listView and setting the adapter to it
        final ListView listView = rootView.findViewById(R.id.place_list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = places.get(position);
                //https://developers.google.com/maps/documentation/urls/android-intents
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + place.getAddress());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
                    getContext().startActivity(mapIntent);
                } else {
                    String msg = getContext().getString(R.string.noMapFound);
                    Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootView;
    }
}
