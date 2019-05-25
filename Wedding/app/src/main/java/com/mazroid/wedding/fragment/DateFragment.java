package com.mazroid.wedding.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.mazroid.wedding.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DateFragment extends Fragment {

WebView webview;
    public DateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_date, container, false);

//        webview = rootView.findViewById(R.id.webview);


        return rootView;
    }

}
