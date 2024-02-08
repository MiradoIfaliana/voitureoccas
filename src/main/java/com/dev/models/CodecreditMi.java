package com.dev.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="codecredit")
public class CodecreditMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idcodecredit; 
    int code; 
    int etats; //--etats:0 disponible / etats:1 plus disponible
    int idvaleurcredit; 

    public CodecreditMi(){ }
    
    public int getIdcodecredit(){
        return this.idcodecredit;
    }
    public void setIdcodecredit(int idcodecredit){
        this.idcodecredit=idcodecredit;
    }
    public int getCode(){
        return this.code;
    }
    public void setCode(int code){
        this.code=code;
    }
    public int getEtats(){
        return this.etats;
    }
    public void setEtats(int etats){
        this.etats=etats;
    }
    public int getIdvaleurcredit(){
        return this.idvaleurcredit;
    }
    public void setIdvaleurcredit(int idvaleurcredit){
        this.idvaleurcredit=idvaleurcredit;
    }

}
