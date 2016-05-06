package com.example.sandra.testrutina;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sandra on 05/05/2016.
 */
public class ArrayListAdapterRutines extends ArrayAdapter<RutinesCustomize> {


    public ArrayListAdapterRutines(Context context, int resource, ArrayList<RutinesCustomize> items) {
        super(context, resource, items);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_exercici, parent, false);
        }
        TextView nom = (TextView)convertView.findViewById(R.id.nomRutina);
        TextView temps = (TextView)convertView.findViewById(R.id.tempsRutina);
        TextView nivell = (TextView)convertView.findViewById(R.id.nivelRutina);
        ImageView fotorutina = (ImageView)convertView.findViewById(R.id.imageView);
        RutinesCustomize info = getItem(position);

        nom.setText(info.getNom());
        temps.setText(info.getTemps()+" min");
        nivell.setText(info.getNivell());

        Picasso.with(getContext())
                .load(info.getImage())
                .fit()
                .into(fotorutina);


        return convertView;
    }


}