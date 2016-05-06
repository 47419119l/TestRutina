package com.example.sandra.testrutina.RutinaPersonalitzada;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.arasthel.asyncjob.AsyncJob;
import com.example.sandra.testrutina.Adapter.ArrayListAdapterRutines;
import com.example.sandra.testrutina.R;
import com.example.sandra.testrutina.javaClass.RutinaCustomize;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.ArrayList;


public class RutinesPersonalitzades extends Fragment {
    private ListView  listaExercici;
    private ArrayList<RutinaCustomize> rutines;
    private ArrayListAdapterRutines adapter;
    private Firebase ref;
    private ArrayListAdapterRutines itemsAdapter;
    private Firebase  infoGymRef;
    private String uidUser ="19dba67c-d8f0-4d7c-afc4-aebe236f84a4";
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
        Firebase.setAndroidContext(getContext());

        ref = new Firebase("https://testgimmapp.firebaseio.com/");
        infoGymRef = ref.child("RutinasCustomizadas");
        configurarLlista();

        return rootView;
    }

    private void configurarLlista(){

        new AsyncJob.AsyncJobBuilder<Boolean>()
                .doInBackground(new AsyncJob.AsyncAction<Boolean>() {
                    @Override
                    public Boolean doAsync() {
                        queryExercicis();
                        return true;
                    }
                })
                .doWhenFinished(new AsyncJob.AsyncResultAction() {
                    @Override
                    public void onResult(Object o) {
                    }
                }).create().start();

        itemsAdapter = new ArrayListAdapterRutines(getContext(), R.layout.list_exercici_rutina, rutines);
        listaExercici.setAdapter(itemsAdapter);
    }

    private void queryExercicis(){

            Query queryRef = infoGymRef.orderByChild("uidUser").equalTo(uidUser);

            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                    RutinaCustomize a = snapshot.getValue( RutinaCustomize.class);
                    rutines.add(a);
                    itemsAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }


            });
    }
}
