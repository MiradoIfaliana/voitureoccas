package com.dev.repository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import com.dev.models.*;;

@Repository
public class ModelsMi_vRep {


    @PersistenceContext
    private EntityManager entityManager;

    public List<ModelsMi_v> executerRequeteNative(String requete) {
        // Utilisation de createNativeQuery sans spécifier explicitement le type
        return (List<ModelsMi_v>)entityManager.createNativeQuery(requete, ModelsMi_v.class).getResultList();
    }
    public List<ModelsMi_v> getAllOrderByIdmarque( ) {
        String query="select * from  models_v order by idmarque";
        return executerRequeteNative(query);
    }
    public List<ModelsMi_v> getAllByIdmarqueOrderByIdmarque(int idmarque ) {
        String query="select * from  models_v where idmarque="+idmarque+" order by idmarque";
        return executerRequeteNative(query);
    }

}
