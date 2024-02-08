package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.models.*;;

public interface AnnonceMiRep extends JpaRepository<AnnonceMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire

//     ---statusvente : 0 : vendu /10 : non vendu
// ---etat : 0:encour demande / 10 :accepter / 20: refuser
    @Query(value = "select a.* from annonce as a join voitureinfo as vif on a.idvoitureinfo=vif.idvoitureinfo where a.idannonce= :idannonce and vif.iduser= :iduser and a.statusvente=10 and a.etat=10" , nativeQuery = true )
    List <AnnonceMi> getDisponbleToVenduByIdannonceByIduser( @Param("iduser")int iduser,@Param("idannonce")int idannonce) ;
}