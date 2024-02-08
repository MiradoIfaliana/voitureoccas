package com.dev.repository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import com.dev.exception.ExceptionCar;
import com.dev.models.*;

@Repository
public class ModelcategorieMiPersoRep {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ModelcategorieMi> executerRequeteNative(String requete) {
        // Utilisation de createNativeQuery sans spécifier explicitement le type
        return (List<ModelcategorieMi>)entityManager.createNativeQuery(requete, ModelcategorieMi.class).getResultList();
    }
    public List<ModelcategorieMi> getByIdcategoriesByIdmodel(int[] idcategories,int idmodel)throws Exception {
        if(idcategories==null){ throw new ExceptionCar("aucunes id!"); }
        else if(idcategories.length==0){ throw new ExceptionCar("aucunes categories!"); }
        String query="select * from modelcategorie where idmodel="+idmodel+" and idcategorie in( "+idcategories[0];
        for(int i=1;i<idcategories.length;i++){
            query=query+","+idcategories[i];
        }
        query=query+")";
        return executerRequeteNative(query);
    }
    public boolean isCategoriesOfModel(int[] idcategories,int idmodel)throws Exception{
        List<ModelcategorieMi> lm=getByIdcategoriesByIdmodel(idcategories, idmodel);
        if(lm.size()==idcategories.length){ return true; } //raha mitovy le isany donc io categorie rehetra io dia ao @ le model
        return false;
    }   

}