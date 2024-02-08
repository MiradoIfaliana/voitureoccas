package com.dev.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="voitureinfo")
public class VoitureinfoMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idvoitureinfo;
    String nomvoiture;
    int nombreplace;
    double  kilometrage;
    int iduser;
    int idmodel;
    public VoitureinfoMi() { }
    public VoitureinfoMi(int idvoitureinfo,String nomvoiture,int nombreplace,double kilometrage,int iduser,int idmodel){
        setIdvoitureinfo(idvoitureinfo);
        setNomvoiture(nomvoiture);
        setNombreplace(nombreplace);
        setKilometrage(kilometrage);
        setIduser(iduser);
        setIdmodel(idmodel);
    }
    public int getIdvoitureinfo() {
        return idvoitureinfo;
    }
    public void setIdvoitureinfo(int idvoitureinfo) {
        this.idvoitureinfo = idvoitureinfo;
    }
    public String getNomvoiture() {
        return nomvoiture;
    }
    public void setNomvoiture(String nomvoiture) {
        this.nomvoiture = nomvoiture;
    }
    public int getNombreplace() {
        return nombreplace;
    }
    public void setNombreplace(int nombreplace) {
        this.nombreplace = nombreplace;
    }
    public double getKilometrage() {
        return kilometrage;
    }
    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public int getIdmodel() {
        return idmodel;
    }
    public void setIdmodel(int idmodel) {
        this.idmodel = idmodel;
    }
    

}



