package com.example.sandra.testrutina;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.util.Calendar;


public class Tab2 extends Fragment {


    public Tab2() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);
        WebView browser = (WebView) rootView.findViewById(R.id.webview);
        browser.loadUrl("https://calendar.google.com/calendar/htmlembed?src=v79blrrafk3vm80sqmlq61ag80@group.calendar.google.com&ctz=Europe/Madrid&pli=1");
        return rootView;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
