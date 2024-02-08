package com.dev.models;

public class LieuStat {
    int idlieu;
    double vendue;
    String nomlieu;

    public LieuStat() {
    }

    public LieuStat(int idlieu, double vendue, String nomlieu) {
        this.idlieu = idlieu;
        this.vendue = vendue;
        this.nomlieu = nomlieu;
    }

    public String getNomlieu() {
        return nomlieu;
    }

    public void setNomlieu(String nomlieu) {
        this.nomlieu = nomlieu;
    }

    public int getIdlieu() {
        return idlieu;
    }

    public void setIdlieu(int idlieu) {
        this.idlieu = idlieu;
    }

    public double getVendue() {
        return vendue;
    }

    public void setVendue(double vendue) {
        this.vendue = vendue;
    }

}
