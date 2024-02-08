package com.dev.models;
import java.sql.Date;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import com.dev.exception.ExceptionCar;

@Entity
@Table(name="vendu")
public class VenduMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idvendu; 
    Date datevente; 
    Date datemodifstatus;
    int idannonce; 

    public VenduMi(){ }
    
    public VenduMi(int idvendu, Date datevente, Date datemodifstatus, int idannonce) {
        setIdvendu(idvendu);
        setDatevente(datevente);
        setDatemodifstatus(datemodifstatus);
        setIdannonce(idannonce);
    }

    public int getIdvendu(){
        return this.idvendu;
    }
    public void setIdvendu(int idvendu){
        this.idvendu=idvendu;
    }
    public Date getDatevente(){
        return this.datevente;
    }
    public void setDatevente(Date datevente){
        this.datevente=datevente;
    }
    public void setDatevente(String datevente)throws Exception{
        try{
            Date.valueOf(datevente);
        }catch(Exception ex){
            throw new ExceptionCar("date vente :"+datevente+" invalide");
        }
        setDatevente(Date.valueOf(datevente));
    }
    public Date getDatemodifstatus(){
        return this.datemodifstatus;
    }
    public void setDatemodifstatus(Date datemodifstatus){
        this.datemodifstatus=datemodifstatus;
    }
    public int getIdannonce(){
        return this.idannonce;
    }
    public void setIdannonce(int idannonce){
        this.idannonce=idannonce;
    }

}
