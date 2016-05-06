package com.example.sandra.testrutina;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.ArrayList;


public class RutinesPersonalitzades extends Fragment {
    private ListView  listaExercici;
    private ArrayList<RutinesCustomize> rutines;
    private ArrayListAdapterRutines adapter;
    public RutinesPersonalitzades() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_personalitzades, container, false);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabRutinasPerso);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(getContext(),LlistatExercici.class);
                startActivity(i);


            }
        });
        rutines = new ArrayList<>();
        listaExercici = (ListView)rootView.findViewById(R.id.listView2);




        return rootView;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
