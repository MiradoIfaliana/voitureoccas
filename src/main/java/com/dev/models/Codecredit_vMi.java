package com.dev.models;
public class Codecredit_vMi{
    int idcodecredit; 
    int code; 
    int etats; 
    int idvaleurcredit; 
    double valeur; 

    public Codecredit_vMi(){ }
    

    
    public Codecredit_vMi(int idcodecredit, int code, int etats, int idvaleurcredit, double valeur) {
        this.idcodecredit = idcodecredit;
        this.code = code;
        this.etats = etats;
        this.idvaleurcredit = idvaleurcredit;
        this.valeur = valeur;
    }



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
    public double getValeur(){
        return this.valeur;
    }
    public void setValeur(double valeur){
        this.valeur=valeur;
    }

}
