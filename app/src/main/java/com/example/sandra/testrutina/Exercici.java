package com.example.sandra.testrutina;

/**
 * Created by sandra on 03/05/2016.
 */
public class Exercici {

    private String nomEx;
    private String descrip;
    private String maquinaNom;
    private boolean isMaquina;
    private int nRepeticions;
    private int set;
    private boolean realitzat;
    private String foto;

    public Exercici (){}

    public String getNomEx() {
        return nomEx;
    }

    public void setNomEx(String nomEx) {
        this.nomEx = nomEx;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getMaquinaNom() {
        return maquinaNom;
    }

    public void setMaquinaNom(String maquinaNom) {
        this.maquinaNom = maquinaNom;
    }

    public boolean isMaquina() {
        return isMaquina;
    }

    public void setIsMaquina(boolean isMaquina) {
        this.isMaquina = isMaquina;
    }

    public boolean isRealitzat() {
        return realitzat;
    }

    public void setRealitzat(boolean realitzat) {
        this.realitzat = realitzat;
    }

    public int getnRepeticions() {
        return nRepeticions;
    }

    public void setnRepeticions(int nRepeticions) {
        this.nRepeticions = nRepeticions;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }
}
