package com.dev.models;
import java.sql.Timestamp;

import com.dev.exception.ExceptionCar;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="debitersoldeuser")
public class DebitersoldeuserMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int iddebit; 
    double montantd; 
    Timestamp dated; 
    int idmotif; 
    int idsoldeuser; 

    public DebitersoldeuserMi(){ }
    
    public DebitersoldeuserMi(int iddebit, double montantd, Timestamp dated, int idmotif, int idsoldeuser) throws Exception{
        setIddebit(iddebit);
        setMontantd(montantd);
        setDated(dated);
        setIdmotif(idmotif);
        setIdsoldeuser(idsoldeuser);
    }

    public int getIddebit(){
        return this.iddebit;
    }
    public void setIddebit(int iddebit){
        this.iddebit=iddebit;
    }
    public double getMontantd(){
        return this.montantd;
    }
    public void setMontantd(double montantd)throws Exception{
        if(montantd<=0){ throw new ExceptionCar("montant inferieur ou egal à 0"); }
        this.montantd=montantd;
    }
    public Timestamp getDated(){
        return this.dated;
    }
    public void setDated(Timestamp dated){
        this.dated=dated;
    }
    public int getIdmotif(){
        return this.idmotif;
    }
    public void setIdmotif(int idmotif){
        this.idmotif=idmotif;
    }
    public int getIdsoldeuser(){
        return this.idsoldeuser;
    }
    public void setIdsoldeuser(int idsoldeuser){
        this.idsoldeuser=idsoldeuser;
    }

}
