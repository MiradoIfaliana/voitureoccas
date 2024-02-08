package com.dev.models;

import java.sql.Date;

public class ModelsMi_v {
    int idmarque;
    String nommarque;
    int idmodel;
    String nommodel;
    Date datesortie ;
    double vitesse ;
    int idtransmission;
    String nomtransmission;
    int idcarburant;
    String nomcarburant;
    public ModelsMi_v() {
    }
    public ModelsMi_v(int idmarque, String nommarque, int idmodel, String nommodel, Date datesortie, double vitesse,
            int idtransmission, String nomtransmission, int idcarburant, String nomcarburant) {
        this.idmarque = idmarque;
        this.nommarque = nommarque;
        this.idmodel = idmodel;
        this.nommodel = nommodel;
        this.datesortie = datesortie;
        this.vitesse = vitesse;
        this.idtransmission = idtransmission;
        this.nomtransmission = nomtransmission;
        this.idcarburant = idcarburant;
        this.nomcarburant = nomcarburant;
    }
    public int getIdmarque() {
        return idmarque;
    }
    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }
    public String getNommarque() {
        return nommarque;
    }
    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
    }
    public int getIdmodel() {
        return idmodel;
    }
    public void setIdmodel(int idmodel) {
        this.idmodel = idmodel;
    }
    public String getNommodel() {
        return nommodel;
    }
    public void setNommodel(String nommodel) {
        this.nommodel = nommodel;
    }
    public Date getDatesortie() {
        return datesortie;
    }
    public void setDatesortie(Date datesortie) {
        this.datesortie = datesortie;
    }
    public double getVitesse() {
        return vitesse;
    }
    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }
    public int getIdtransmission() {
        return idtransmission;
    }
    public void setIdtransmission(int idtransmission) {
        this.idtransmission = idtransmission;
    }
    public String getNomtransmission() {
        return nomtransmission;
    }
    public void setNomtransmission(String nomtransmission) {
        this.nomtransmission = nomtransmission;
    }
    public int getIdcarburant() {
        return idcarburant;
    }
    public void setIdcarburant(int idcarburant) {
        this.idcarburant = idcarburant;
    }
    public String getNomcarburant() {
        return nomcarburant;
    }
    public void setNomcarburant(String nomcarburant) {
        this.nomcarburant = nomcarburant;
    }
    

}
