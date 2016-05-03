package com.example.sandra.testrutina;

import java.util.ArrayList;

/**
 * Created by sandra on 03/05/2016.
 */
public class Dia {
    private ArrayList <Exercici> exercicis;
    private String diaSemana;

    public Dia(){}

    public ArrayList<Exercici> getExercicis() {
        return exercicis;
    }

    public void setExercicis(ArrayList<Exercici> exercicis) {
        this.exercicis = exercicis;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
}
