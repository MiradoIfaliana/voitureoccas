package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.dev.models.*;

public interface ModelcategorieMiRep extends JpaRepository<ModelcategorieMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // ---select * from Motif where iduser='' and etats=0;-->throw new ExceptionCar("session plus valide");
    @Query(value = "select * from modelcategorie where idcategorie= :idcategorie and idmodel= :idmodel" , nativeQuery = true )
    List <ModelcategorieMi> getByIdcategorieByIdmodel(int idcategorie,int idmodel) ;
}