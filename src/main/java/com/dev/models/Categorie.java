package com.dev.models;

public class Categorie{

    int idcategorie; 
    String nomcategorie; 

    public Categorie(){ }
    public Categorie(int idcategorie,String nomcategorie){
        setIdcategorie(idcategorie);
        setNomcategorie(nomcategorie);
    }
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }
    public String getNomcategorie(){
        return this.nomcategorie;
    }
    public void setNomcategorie(String nomcategorie){
        this.nomcategorie=nomcategorie;
    }

}
