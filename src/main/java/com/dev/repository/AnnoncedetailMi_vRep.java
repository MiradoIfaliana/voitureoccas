package com.dev.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.dev.models.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//-- idannonce | prixvente | descriptions | statusvente | etat | dateannonce | idlieu | nomlieu | idvoitureinfo | nomvoiture | nombreplace | kilometrage | transmission | vitesse | iduser | nomuser | prenomuser | idcarburant | nomcarburant | idmarque | nommarque | idmodel | nommodel | idcategorie | nomcategorie | datevente | datemodifstatus
@Repository
public class AnnoncedetailMi_vRep  {
//idannoncefavoris
// ---statusvente : 0 : vendu /10 : non vendu
// ---etat : 0:encour demande / 10 :accepter / 20: refuser
    @PersistenceContext
    private EntityManager entityManager;

    public List<AnnoncedetailMi_v> executerRequeteNative(String requete) {
        // Utilisation de createNativeQuery sans spécifier explicitement le type4
        return (List<AnnoncedetailMi_v>)entityManager.createNativeQuery(requete, AnnoncedetailMi_v.class).getResultList();
    }
    public List<AnnoncedetailMi_v> getByNotIduser(int iduser, int nbaffiche, int numlineBeforeFirst) {
        String query="select ad_v.*, COALESCE(af.idannoncefavoris,0) as idannoncefavoris from annoncedetail_v as ad_v "+ 
        "left join annoncefavoris as af on (ad_v.idannonce=af.idannonce and af.iduser= "+iduser+") "+
        "join (select * from annoncenbrepeat_v where iduser!= "+iduser+" and statusvente=10 and etat=10  LIMIT "+nbaffiche+" OFFSET "+numlineBeforeFirst+") as ar_v on ad_v.idannonce=ar_v.idannonce "+
        "order by ad_v.idannonce ASC,ad_v.idcategorie ASC,ad_v.idannoncephoto ASC,ad_v.dateannonce ASC "
        ;
        return executerRequeteNative(query);
    }
    public List<AnnoncedetailMi_v> getByIduser(int iduser, int nbaffiche, int numlineBeforeFirst) {
        String query="select ad_v.*, COALESCE(af.idannoncefavoris,0) as idannoncefavoris from annoncedetail_v as ad_v "+
        "left join annoncefavoris as af on (ad_v.idannonce=af.idannonce and af.iduser= "+iduser+") "+
        "join (select * from annoncenbrepeat_v where iduser= "+iduser+" LIMIT "+nbaffiche+" OFFSET "+numlineBeforeFirst+") as ar_v on ad_v.idannonce=ar_v.idannonce "+
        "order by ad_v.idannonce ASC,ad_v.idcategorie ASC,ad_v.idannoncephoto ASC,ad_v.dateannonce ASC ";
        return executerRequeteNative(query);
    }
    public List<AnnoncedetailMi_v> getFavorisByIduser(int iduser, int nbaffiche, int numlineBeforeFirst) {
        String query="select ad_v.*, ar_v.idannoncefavoris from annoncedetail_v as ad_v "+
        "join (select * from annoncefavoris where iduser="+iduser+" LIMIT "+nbaffiche+" OFFSET "+numlineBeforeFirst+") as ar_v on ad_v.idannonce=ar_v.idannonce "+
        "order by ad_v.idannonce ASC,ad_v.idcategorie ASC,ad_v.idannoncephoto ASC,ad_v.dateannonce ASC";
        return executerRequeteNative(query);
    }
    public List<AnnoncedetailMi_v> getEncours(int nbaffiche, int numlineBeforeFirst) {
        String query="select ad_v.*,0 as idannoncefavoris from annoncedetail_v as ad_v "+ 
        "join (select * from annoncenbrepeat_v where etat=0 LIMIT "+nbaffiche+" OFFSET "+numlineBeforeFirst+") as ar_v on ad_v.idannonce=ar_v.idannonce "+
        " order by ad_v.idannonce ASC,ad_v.idcategorie ASC,ad_v.idannoncephoto ASC,ad_v.dateannonce ASC ";
        return executerRequeteNative(query);
    }


    public AnnonceBodyMi getByIdannonce(int iduser,int idannonce) {
        String query="select ad_v.*, COALESCE(af.idannoncefavoris,0) as idannoncefavoris from annoncedetail_v as ad_v "+ 
        "left join annoncefavoris as af on (ad_v.idannonce=af.idannonce and af.iduser= "+iduser+") where ad_v.idannonce="+idannonce+" "+
        "order by ad_v.idannonce ASC,ad_v.idcategorie ASC,ad_v.idannoncephoto ASC,ad_v.dateannonce ASC ";
        List<AnnoncedetailMi_v> list=executerRequeteNative(query);
        List<AnnonceBodyMi> lstB=new AnnonceBodyMi().createListByListAnnoncedetailMi_v(list);
        if(lstB==null){ return null; }
        else if(lstB.isEmpty()==true){ return null; }
        return lstB.get(0);

    }

}