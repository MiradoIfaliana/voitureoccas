package com.dev.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.dev.models.MoneySite;

@Repository
public class MoneyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<MoneySite> executerRequeteNative(String requete) {
        return (List<MoneySite>) entityManager.createNativeQuery(requete, MoneySite.class).getResultList();
    }

    public List<MoneySite> getMoneySite(int annee) {
        String query = "select COALESCE(sum(montantc),0) as montant_site \r\n" + //
                "        from creditersoldesite where \r\n" + //
                "            extract(year from datec) = '" + annee + "';";
        System.out.println(query);
        return executerRequeteNative(query);
    }
}