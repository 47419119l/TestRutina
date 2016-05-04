package com.example.sandra.testrutina;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsRutina extends AppCompatActivity {
    Firebase ref;
    Firebase  infoGymRef;
    private Rutina item;
    private ImageView imagetoolbar;
    private TextView nivell;
    private TextView temps;
    private TextView descrip;
    private ListView listEx;
    private ArrayList<Integer>exercicis;
    private ArrayList<Exercici>items;
    private CollapsingToolbarLayout toolbar_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_rutina);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Firebase.setAndroidContext(getBaseContext());
        ref = new Firebase("https://testgimmapp.firebaseio.com/");
        infoGymRef = ref.child("Exercicis");
        toolbar_layout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        imagetoolbar = (ImageView)findViewById(R.id.image_appbar);
        items = new ArrayList<>();
        nivell = (TextView)findViewById(R.id.nivelDetailRutina);
        temps = (TextView)findViewById(R.id.tempsRutinaDetail);
        descrip= (TextView)findViewById(R.id.descripRutinaDetail);
        listEx = (ListView)findViewById(R.id.listExerciciDetail);

        /**
         * Agafem el intent
         */
        Intent i = getIntent();
        item = (Rutina) i.getSerializableExtra("item");
        exercicis = item.getExercicis();

        condiguracioDetails();
        configuracioLlista();
    }
    private void condiguracioDetails(){
        toolbar_layout.setTitle("  ");

        Picasso.with(getBaseContext())
                .load(item.getImage())
                .fit()
                .into(imagetoolbar);

        nivell.setText(item.getNivell());

        temps.setText(item.getTemps() + " min");

        descrip.setText(item.getDescripcio());


    }


    private void configuracioLlista(){
        int menu =1;
        for(int i =0; i< exercicis.size();i++) {
            Query queryRef = infoGymRef.orderByChild("id").equalTo(exercicis.get(i));


            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                    Exercici a = snapshot.getValue(Exercici.class);
                    items.add(a);
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
}
