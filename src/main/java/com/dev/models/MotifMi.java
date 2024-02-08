package com.dev.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="motif")
public class MotifMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmotif; 
    String nommotif; 
    String codemotif; 

    public MotifMi(){ }
    
    public int getIdmotif(){
        return this.idmotif;
    }
    public void setIdmotif(int idmotif){
        this.idmotif=idmotif;
    }
    public String getNommotif(){
        return this.nommotif;
    }
    public void setNommotif(String nommotif){
        this.nommotif=nommotif;
    }
    public String getCodemotif(){
        return this.codemotif;
    }
    public void setCodemotif(String codemotif){
        this.codemotif=codemotif;
    }
    

}
