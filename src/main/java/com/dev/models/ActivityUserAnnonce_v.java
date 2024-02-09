package com.dev.models;

public class ActivityUserAnnonce_v {
    int iduser;
    double nbannonce;
    double nbvendu;
    double nbfavoris;
    
    public ActivityUserAnnonce_v() {
    }
    public ActivityUserAnnonce_v(int iduser, double nbannonce, double nbvendu, double nbfavoris) {
        this.iduser = iduser;
        this.nbannonce = nbannonce;
        this.nbvendu = nbvendu;
        this.nbfavoris = nbfavoris;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public double getNbannonce() {
        return nbannonce;
    }
    public void setNbannonce(double nbannonce) {
        this.nbannonce = nbannonce;
    }
    public double getNbvendu() {
        return nbvendu;
    }
    public void setNbvendu(double nbvendu) {
        this.nbvendu = nbvendu;
    }
    public double getNbfavoris() {
        return nbfavoris;
    }
    public void setNbfavoris(double nbfavoris) {
        this.nbfavoris = nbfavoris;
    }
    
}