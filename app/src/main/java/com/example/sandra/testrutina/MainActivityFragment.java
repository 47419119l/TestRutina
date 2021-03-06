package com.example.sandra.testrutina;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sandra.testrutina.Calendari.CalendariActivitats;
import com.example.sandra.testrutina.RutinaPersonalitzada.RutinesPersonalitzades;
import com.example.sandra.testrutina.Standard.RutinesStandard;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ListView listRutina;
    private FragmentTabHost tabHost;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        tabHost= (FragmentTabHost) rootView.findViewById(android.R.id.tabhost);
        tabHost.setup(getActivity(), getFragmentManager(),android.R.id.tabcontent);

        //Creem les pestanyes
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Standard"), RutinesStandard.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Customiza"), RutinesPersonalitzades.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Calendario"), CalendariActivitats.class, null);



        return rootView;
    }


}
