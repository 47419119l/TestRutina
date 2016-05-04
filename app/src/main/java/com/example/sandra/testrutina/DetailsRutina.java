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
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsRutina extends AppCompatActivity {
    private Rutina item;
    private ImageView imagetoolbar;
    private TextView nivell;
    private TextView temps;
    private TextView descrip;
    private ArrayList<Integer>exercicis;
    private CollapsingToolbarLayout toolbar_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_rutina);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar_layout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        imagetoolbar = (ImageView)findViewById(R.id.image_appbar);
        nivell = (TextView)findViewById(R.id.nivelDetailRutina);
        temps = (TextView)findViewById(R.id.tempsRutinaDetail);
        descrip= (TextView)findViewById(R.id.descripRutinaDetail);

        /**
         * Agafem el intent
         */
        Intent i = getIntent();
        item = (Rutina) i.getSerializableExtra("item");
        exercicis = item.getExercicis();

        condiguracioDetails();
    }
    private void condiguracioDetails(){
        toolbar_layout.setTitle("");

        Picasso.with(getBaseContext())
                .load(item.getImage())
                .fit()
                .into(imagetoolbar);

        nivell.setText(item.getNivell());

        temps.setText(item.getTemps()+" min");

        descrip.setText(item.getDescripcio());


    }
}
