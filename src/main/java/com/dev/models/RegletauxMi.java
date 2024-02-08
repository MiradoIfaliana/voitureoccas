package com.dev.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.dev.exception.ExceptionCar;

import jakarta.persistence.Entity;
@Entity
@Table(name="regletaux")
public class RegletauxMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idregletaux; 
    String coderegle; 
    String nomregle; 
    float tauxpourcent; 

    public RegletauxMi(){ }
    public RegletauxMi(int idregletaux, String coderegle, String nomregle, float tauxpourcent)throws Exception{
        setIdregletaux(idregletaux);
        setCoderegle(coderegle);
        setNomregle(nomregle);
        setTauxpourcent(tauxpourcent);
    }
    public int getIdregletaux(){
        return this.idregletaux;
    }
    public void setIdregletaux(int idregletaux){
        this.idregletaux=idregletaux;
    }
    public String getCoderegle(){
        return this.coderegle;
    }
    public void setCoderegle(String coderegle){
        this.coderegle=coderegle;
    }
    public String getNomregle(){
        return this.nomregle;
    }
    public void setNomregle(String nomregle){
        this.nomregle=nomregle;
    }
    public float getTauxpourcent(){
        return this.tauxpourcent;
    }
    public void setTauxpourcent(float tauxpourcent)throws Exception{
        if(tauxpourcent<0){ throw new ExceptionCar("taux pourcentage inferieur à 0"); }
        this.tauxpourcent=tauxpourcent;
    }

}
