package com.dev.models;
import java.sql.Timestamp;

import com.dev.exception.ExceptionCar;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="creditersoldeuser")
public class CreditersoldeuserMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idcredit; 
    double montantc; 
    Timestamp datec; 
    int idcodecredit; 
    int idsoldeuser; 

    public CreditersoldeuserMi(){ }
    
    public CreditersoldeuserMi(int idcredit, double montantc, Timestamp datec, int idcodecredit, int idsoldeuser)throws Exception {
        setIdcredit(idcredit);
        setMontantc(montantc);
        setDatec(datec);
        setIdcodecredit(idcodecredit);
        setIdsoldeuser(idsoldeuser);
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
    public int getIdcodecredit(){
        return this.idcodecredit;
    }
    public void setIdcodecredit(int idcodecredit){
        this.idcodecredit=idcodecredit;
    }
    public int getIdsoldeuser(){
        return this.idsoldeuser;
    }
    public void setIdsoldeuser(int idsoldeuser){
        this.idsoldeuser=idsoldeuser;
    }

}
