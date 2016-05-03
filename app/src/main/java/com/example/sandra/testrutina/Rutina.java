package com.example.sandra.testrutina;

import java.util.ArrayList;

/**
 * Created by sandra on 03/05/2016.
 */
public class Rutina {
    private ArrayList <Dia>diaSemana;
    private String tipuRutina;
    private String uidUser;

    public Rutina(){}

    public ArrayList<Dia> getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(ArrayList<Dia> diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getTipuRutina() {
        return tipuRutina;
    }

    public void setTipuRutina(String tipuRutina) {
        this.tipuRutina = tipuRutina;
    }

    public String getUidUser() {
        return uidUser;
    }

    public void setUidUser(String uidUser) {
        this.uidUser = uidUser;
    }
}
