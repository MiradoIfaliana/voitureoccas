package com.dev.models;

import java.util.ArrayList;
import java.util.List;

public class MarqueModelsMi {
    int idmarque;
    String nommarque;
    List<ModelsMi_v> models;

    public MarqueModelsMi() {
    }
    public MarqueModelsMi(int idmarque, String nommarque, List<ModelsMi_v> models) {
        this.idmarque = idmarque;
        this.nommarque = nommarque;
        this.models = models;
    }
    public int getIdmarque() {
        return idmarque;
    }
    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }
    public String getNommarque() {
        return nommarque;
    }
    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
    }
    public List<ModelsMi_v> getModels() {
        return models;
    }
    public void setModels(List<ModelsMi_v> models) {
        this.models = models;
    }

    public void addModels(ModelsMi_v modelsMi_v){
        if(models==null){ models=new ArrayList<>(); }
        models.add(modelsMi_v);
    }
    
    
}
