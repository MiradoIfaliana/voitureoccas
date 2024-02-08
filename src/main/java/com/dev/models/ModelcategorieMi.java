package com.dev.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="modelcategorie")
public class ModelcategorieMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmodelcategorie; 
    int idmodel; 
    int idcategorie; 

    public ModelcategorieMi(){ }
    
    public int getIdmodelcategorie(){
        return this.idmodelcategorie;
    }
    public void setIdmodelcategorie(int idmodelcategorie){
        this.idmodelcategorie=idmodelcategorie;
    }
    public int getIdmodel(){
        return this.idmodel;
    }
    public void setIdmodel(int idmodel){
        this.idmodel=idmodel;
    }
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }

}
