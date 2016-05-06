package com.example.sandra.testrutina;

import android.content.Context;

import com.firebase.client.Firebase;

/**
 * Created by sandra on 06/05/2016.
 */
public class FireBaseConfiguracio {
    private String bbdd= "https://testgimmapp.firebaseio.com/";
    public void configFirebase(Context context){
        Firebase.setAndroidContext(context);
    }


}
