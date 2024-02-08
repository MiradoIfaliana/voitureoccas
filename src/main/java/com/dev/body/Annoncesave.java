package com.dev.body;

import org.springframework.web.multipart.MultipartFile;

public class Annoncesave {
    int idvoitureinfo;
    int idlieu;
    double prixvente;
    String description;
    MultipartFile[] photofiles;

    public Annoncesave() {
    }

    public Annoncesave(int idvoitureinfo, int idlieu, double prixvente, String description, MultipartFile[] photofiles) {
        setIdvoitureinfo(idvoitureinfo);
        setIdlieu(idlieu);
        setPrixvente(prixvente);
        setDescription(description);
        setPhotofiles(photofiles);
    }
    public int getIdvoitureinfo() {
        return idvoitureinfo;
    }
    public void setIdvoitureinfo(int idvoitureinfo) {
        this.idvoitureinfo = idvoitureinfo;
    }
    public int getIdlieu() {
        return idlieu;
    }
    public void setIdlieu(int idlieu) {
        this.idlieu = idlieu;
    }
    public double getPrixvente() {
        return prixvente;
    }
    public void setPrixvente(double prixvente) {
        this.prixvente = prixvente;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public MultipartFile[] getPhotofiles() {
        return photofiles;
    }
    public void setPhotofiles(MultipartFile[] photofiles) {
        this.photofiles = photofiles;
    }   

}
