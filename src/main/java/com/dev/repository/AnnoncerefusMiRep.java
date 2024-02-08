package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.models.*;;

public interface AnnoncerefusMiRep extends JpaRepository<AnnoncerefusMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    @Query(value = "select * from annoncerefus where idannonce = :idannonce" , nativeQuery = true )
    List <AnnoncerefusMi> getListByIdannonce( @Param("idannonce")int idannonce) ;
}