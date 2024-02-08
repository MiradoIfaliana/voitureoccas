package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.models.*;;

public interface CodecreditMiRep extends JpaRepository<CodecreditMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // // ---select * from Creditersoldesite where iduser='' and etats=0;-->throw new ExceptionCar("session plus valide");
    @Query(value = "select * from codecredit where code = :code and etats=0" , nativeQuery = true )
    List <CodecreditMi> getByCode(int code);
    //bucket --->fi-stockena.
}