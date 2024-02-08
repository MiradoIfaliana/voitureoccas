package com.dev.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.models.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class Codecredit_vMiRep {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Codecredit_vMi> executerRequeteNative(String requete) {
        // Utilisation de createNativeQuery sans spécifier explicitement le type
        return (List<Codecredit_vMi>)entityManager.createNativeQuery(requete, Codecredit_vMi.class).getResultList();
    }

    public List<Codecredit_vMi> getByCodeCredit(int code) {
        String query="select * from codecredit_v where code = "+code+" and etats=0";
        return executerRequeteNative(query);
    }
}