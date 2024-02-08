package com.dev.models;

public class ActivityUserAnnonce_v {
    int iduser;
    int nbannonce;
    int nbvendu;
    int nbfavoris;
    
    public ActivityUserAnnonce_v() {
    }
    public ActivityUserAnnonce_v(int iduser, int nbannonce, int nbvendu, int nbfavoris) {
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
    public int getNbannonce() {
        return nbannonce;
    }
    public void setNbannonce(int nbannonce) {
        this.nbannonce = nbannonce;
    }
    public int getNbvendu() {
        return nbvendu;
    }
    public void setNbvendu(int nbvendu) {
        this.nbvendu = nbvendu;
    }
    public int getNbfavoris() {
        return nbfavoris;
    }
    public void setNbfavoris(int nbfavoris) {
        this.nbfavoris = nbfavoris;
    }
    
}
