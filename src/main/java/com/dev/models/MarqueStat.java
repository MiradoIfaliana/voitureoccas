package com.dev.models;

public class MarqueStat {
    int idmarque;
    double vendue;
    String nommarque;

    public MarqueStat() {
    }
    public MarqueStat(int idmarque, double vendue, String nommarque) {
        this.idmarque = idmarque;
        this.vendue = vendue;
        this.nommarque = nommarque;
    }

    public int getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }

    public double getVendue() {
        return vendue;
    }

    public void setVendue(double vendue) {
        this.vendue = vendue;
    }

    public String getNommarque() {
        return nommarque;
    }

    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
    }


}
