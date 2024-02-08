package com.dev.models;
import java.sql.Date;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import com.dev.exception.ExceptionCar;
@Entity
@Table(name="annoncevalidation")
public class AnnoncevalidationMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idannoncevalidation; 
    Date datevalide; 
    int idadmins; 
    int idannonce; 

    public AnnoncevalidationMi(){ }
    
    public AnnoncevalidationMi(int idannoncevalidation, Date datevalide, int idadmins, int idannonce) {
        setIdannoncevalidation(idannoncevalidation);
        setDatevalide(datevalide);
        setIdadmins(idadmins);
        setIdannonce(idannonce);
    }
    public AnnoncevalidationMi(int idannoncevalidation, String datevalide, int idadmins, int idannonce)throws Exception {
        setIdannoncevalidation(idannoncevalidation);
        setDatevalide(datevalide);
        setIdadmins(idadmins);
        setIdannonce(idannonce);
    }

    public int getIdannoncevalidation(){
        return this.idannoncevalidation;
    }
    public void setIdannoncevalidation(int idannoncevalidation){
        this.idannoncevalidation=idannoncevalidation;
    }
    public Date getDatevalide(){
        return this.datevalide;
    }
    public void setDatevalide(Date datevalide){
        this.datevalide=datevalide;
    }
    public void setDatevalide(String datevalide)throws Exception{
        try{
            Date.valueOf(datevalide);
        }catch(Exception e){ throw new ExceptionCar("date "+datevalide+" invalide"); }
        setDatevalide(Date.valueOf(datevalide));
    }
    public int getIdadmins(){
        return this.idadmins;
    }
    public void setIdadmins(int idadmins){
        this.idadmins=idadmins;
    }
    public int getIdannonce(){
        return this.idannonce;
    }
    public void setIdannonce(int idannonce){
        this.idannonce=idannonce;
    }

}
