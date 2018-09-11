package com.me.theofrancisco.BostonTour;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Place place_item;
    private Context context;

    PlaceAdapter(Activity context, ArrayList<Place> places) {
        super(context, 0, places);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // check if the current view is reused else inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //get the object located at position
        place_item = getItem(position);

        //find the textview in list_item with id default_text_view
        TextView tvPhotoName = listItemView.findViewById(R.id.tvPhotoName);
        try {
            tvPhotoName.setText(place_item.getName());

            //find the image view with id image
            ImageView mImageView = listItemView.findViewById(R.id.image);
            mImageView.setImageResource(place_item.getImageResourceId());
        }
        catch (NullPointerException e){
            Log.e("myApp","PlaceAdapter.getView() "+e.getMessage());
        }
        // set its backgroung resource to the mColorResourceId
        //textContainer.setBackgroundResource(mColorResourceId);

        return listItemView;
    }
}
