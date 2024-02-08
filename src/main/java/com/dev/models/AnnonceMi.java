package com.dev.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.dev.exception.ExceptionCar;
import java.sql.Timestamp;


import jakarta.persistence.Entity;
@Entity
@Table(name="annonce")
public class AnnonceMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idannonce; 
    double prixvente; 
    String descriptions; 
    int statusvente; 
    int etat; 
    int idlieu; 
    int idvoitureinfo; 
    Timestamp dateannonce;

    public AnnonceMi(){ }
    public AnnonceMi(int idannonce,double prixvente,String descriptions,int statusvente,int etat,int idlieu,int idvoitureinfo,Timestamp dateannonce)throws Exception{
        setIdannonce(idannonce);
        setPrixvente(prixvente);
        setDescriptions(descriptions);
        setStatusvente(statusvente);
        setEtat(etat);
        setIdlieu(idlieu);
        setIdvoitureinfo(idvoitureinfo);
        setDateannonce(dateannonce);
    }
    
    public int getIdannonce(){
        return this.idannonce;
    }
    public void setIdannonce(int idannonce){
        this.idannonce=idannonce;
    }
    public double getPrixvente(){
        return this.prixvente;
    }
    public void setPrixvente(double prixvente)throws Exception{
        if(prixvente<=0){ throw new ExceptionCar(" prix de vente inferieur ou egale à 0 "); }
        this.prixvente=prixvente;
    }
    public String getDescriptions(){
        return this.descriptions;
    }
    public void setDescriptions(String descriptions){
        this.descriptions=descriptions;
    }
    public int getStatusvente(){
        return this.statusvente;
    }
    public void setStatusvente(int statusvente){
        this.statusvente=statusvente;
    }
    public int getEtat(){
        return this.etat;
    }
    public void setEtat(int etat){
        this.etat=etat;
    }
    public int getIdlieu(){
        return this.idlieu;
    }
    public void setIdlieu(int idlieu){
        this.idlieu=idlieu;
    }
    public int getIdvoitureinfo(){
        return this.idvoitureinfo;
    }
    public void setIdvoitureinfo(int idvoitureinfo){
        this.idvoitureinfo=idvoitureinfo;
    }

    public boolean estEncours(){
        if(this.etat==0){
            return true;
        } return false;
    }
    public void setEtatToValide(){
        this.etat=10;
    }
    public boolean estValide(){
        if(this.etat==10){
            return true;
        } return false;
    }
    public boolean estRefus(){
        if(this.etat==20){
            return true;
        } return false;
    }
    public void setEtatToRefus(){
        this.etat=20;
    }
    public Timestamp getDateannonce() {
        return dateannonce;
    }
    public void setDateannonce(Timestamp dateannonce) {
        this.dateannonce = dateannonce;
    }
    

}
