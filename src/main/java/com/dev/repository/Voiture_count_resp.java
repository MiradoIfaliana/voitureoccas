package com.dev.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dev.models.VoitureCount;

@Repository
public class Voiture_count_resp {
    @PersistenceContext
    private EntityManager entityManager;

    public List<VoitureCount> executerRequeteNative(String requete) {
        return (List<VoitureCount>) entityManager.createNativeQuery(requete, VoitureCount.class)
                .getResultList();
    }

    public List<VoitureCount> getCountVoiture(int annee) {
        String query = "SELECT count(*) as nombre_voiture FROM annonce \r\n" + //
                "            WHERE  Extract(year from dateannonce) = '" + annee + "'";
        System.out.println(query);
        return executerRequeteNative(query);
    }
}