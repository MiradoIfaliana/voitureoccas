package com.dev.models;
import java.sql.Timestamp;
import com.dev.exception.ExceptionCar;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="creditersoldesite")
public class CreditersoldesiteMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idcredit; 
    double montantc; 
    Timestamp datec; 
    int iddebit; 
    int idmotif; 
    int idsoldesite; 

    public CreditersoldesiteMi(){ }
    public CreditersoldesiteMi(int idcredit, double montantc, Timestamp datec, int iddebit, int idmotif, int idsoldesite)throws Exception{
        setIdcredit(idcredit);
        setMontantc(montantc);;
        setDatec(datec);
        setIddebit(iddebit);
        setIdmotif(idmotif);
        setIdsoldesite(idsoldesite);
    }
    
    public int getIdcredit(){
        return this.idcredit;
    }
    public void setIdcredit(int idcredit){
        this.idcredit=idcredit;
    }
    public double getMontantc(){
        return this.montantc;
    }
    public void setMontantc(double montantc)throws Exception{
        if(montantc<=0){ throw new ExceptionCar("montant inferieur ou egal à 0"); }
        this.montantc=montantc;
    }
    public Timestamp getDatec(){
        return this.datec;
    }
    public void setDatec(Timestamp datec){
        this.datec=datec;
    }
    public int getIddebit(){
        return this.iddebit;
    }
    public void setIddebit(int iddebit){
        this.iddebit=iddebit;
    }
    public int getIdmotif(){
        return this.idmotif;
    }
    public void setIdmotif(int idmotif){
        this.idmotif=idmotif;
    }
    public int getIdsoldesite(){
        return this.idsoldesite;
    }
    public void setIdsoldesite(int idsoldesite){
        this.idsoldesite=idsoldesite;
    }

}
