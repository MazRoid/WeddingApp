package com.mazroid.wedding.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mazroid.wedding.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_map, container, false);

        View myLayout = rootView.findViewById( R.id.cell1 ); // root View id from that link
        ImageView img = myLayout.findViewById(R.id.mazImage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://maps.google.com/maps?f=d&daddr=" + "18.9578394,72.8370138&dirflg=d&layer=t";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);

            }
        });

        return rootView;
    }

}
