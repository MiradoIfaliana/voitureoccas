package com.dev.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.dev.models.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//-- idannonce | prixvente | descriptions | statusvente | etat | dateannonce | idlieu | nomlieu | idvoitureinfo | nomvoiture | nombreplace | kilometrage | transmission | vitesse | iduser | nomuser | prenomuser | idcarburant | nomcarburant | idmarque | nommarque | idmodel | nommodel | idcategorie | nomcategorie | datevente | datemodifstatus
@Repository
public class ActivityUserAnnonce_vRep {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ActivityUserAnnonce_v> executerRequeteNative(String requete) {
        // Utilisation de createNativeQuery sans spécifier explicitement le type4
        return (List<ActivityUserAnnonce_v>)entityManager.createNativeQuery(requete, ActivityUserAnnonce_v.class).getResultList();
    }
    public List<ActivityUserAnnonce_v> getByIduser(int iduser) {
        String query="select * from activityuserannonce_v where iduser="+iduser ;
        return executerRequeteNative(query);
    }
}
