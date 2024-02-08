package com.dev.models;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
// ---statusvente : 0 : vendu /10 : non vendu
// ---etat : 0:encour demande / 10 :accepter / 20: refuser
public class AnnonceBodyMi{
    int idannonce; 
    double prixvente; 
    String descriptions; 
    boolean statusvente; //vendu / disponible
    String etat;//valider /refuser/ encours
    Timestamp dateannonce; 
    String dateformaterannonce;
    int idlieu; 
    String nomlieu; 
    int idvoitureinfo; 
    String nomvoiture; 
    int nombreplace; 
    double kilometrage; 
    int idtransmission; 
    String nomtransmission;
    double vitesse; 
    int iduser; 
    String nomuser; 
    String prenomuser; 
    int idcarburant; 
    String nomcarburant; 
    int idmarque; 
    String nommarque; 
    int idmodel; 
    String nommodel; 
    double nbfavoris;
    // int idcategorie; 
    // String nomcategorie; 
    List<Categorie> categories;
    int anneefab;
    Date datevente; //null raha mbola tsy vendu
    Date datemodifstatus; //null reha mbola tsy vendu
    boolean estfavoris;
    List<String> photos;
    //select ad_v.*,af.idannoncefavoris from annnoncedetail_v as left join annoncefavoris as af on (ad_v.idannonce=af.idannonce and af.iduser= 'iduserconnect' ) ;
    public AnnonceBodyMi(){ }//formatTimestamp()
    
    public AnnonceBodyMi(int idannonce, double prixvente, String descriptions, boolean statusvente, String etat,
            Timestamp dateannonce,String dateformaterannonce, int idlieu, String nomlieu, int idvoitureinfo, String nomvoiture,
            int nombreplace, double kilometrage, int idtransmission, String nomtransmission, double vitesse, int iduser, String nomuser,
            String prenomuser, int idcarburant, String nomcarburant, int idmarque, String nommarque, int idmodel,
            String nommodel,double nbfavoris, List<Categorie> categories,int anneefab, Date datevente, Date datemodifstatus, boolean estfavoris,List<String> photos) {
        this.idannonce = idannonce;
        this.prixvente = prixvente;
        this.descriptions = descriptions;
        this.statusvente = statusvente;
        this.etat = etat;
        this.dateannonce = dateannonce;
        this.dateformaterannonce=dateformaterannonce;
        this.idlieu = idlieu;
        this.nomlieu = nomlieu;
        this.idvoitureinfo = idvoitureinfo;
        this.nomvoiture = nomvoiture;
        this.nombreplace = nombreplace;
        this.kilometrage = kilometrage;
        this.idtransmission = idtransmission;
        this.nomtransmission= nomtransmission;
        this.vitesse = vitesse;
        this.iduser = iduser;
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.idcarburant = idcarburant;
        this.nomcarburant = nomcarburant;
        this.idmarque = idmarque;
        this.nommarque = nommarque;
        this.idmodel = idmodel;
        this.nommodel = nommodel;
        this.nbfavoris=nbfavoris;
        this.categories = categories;
        this.anneefab=anneefab;
        this.datevente = datevente;
        this.datemodifstatus = datemodifstatus;
        this.estfavoris = estfavoris;
        this.photos=photos;
    }

    public int getIdannonce() {
        return idannonce;
    }
    public void setIdannonce(int idannonce) {
        this.idannonce = idannonce;
    }
    public double getPrixvente() {
        return prixvente;
    }
    public void setPrixvente(double prixvente) {
        this.prixvente = prixvente;
    }
    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public boolean getStatusvente() {
        return statusvente;
    }
    public void setStatusvente(boolean statusvente) {
        this.statusvente = statusvente;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public Timestamp getDateannonce() {
        return dateannonce;
    }
    public void setDateannonce(Timestamp dateannonce) {
        this.dateannonce = dateannonce;
    }
    public int getIdlieu() {
        return idlieu;
    }
    public void setIdlieu(int idlieu) {
        this.idlieu = idlieu;
    }
    public String getNomlieu() {
        return nomlieu;
    }
    public void setNomlieu(String nomlieu) {
        this.nomlieu = nomlieu;
    }
    public int getIdvoitureinfo() {
        return idvoitureinfo;
    }
    public void setIdvoitureinfo(int idvoitureinfo) {
        this.idvoitureinfo = idvoitureinfo;
    }
    public String getNomvoiture() {
        return nomvoiture;
    }
    public void setNomvoiture(String nomvoiture) {
        this.nomvoiture = nomvoiture;
    }
    public int getNombreplace() {
        return nombreplace;
    }
    public void setNombreplace(int nombreplace) {
        this.nombreplace = nombreplace;
    }
    public double getKilometrage() {
        return kilometrage;
    }
    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }
    public int getIdtransmission() {
        return idtransmission;
    }
    public void setIdtransmission(int idtransmission) {
        this.idtransmission = idtransmission;
    }
    public String getNomtransmission() {
        return nomtransmission;
    }
    public void setNomtransmission(String nomtransmission) {
        this.nomtransmission = nomtransmission;
    }
    public double getVitesse() {
        return vitesse;
    }
    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public String getNomuser() {
        return nomuser;
    }
    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }
    public String getPrenomuser() {
        return prenomuser;
    }
    public void setPrenomuser(String prenomuser) {
        this.prenomuser = prenomuser;
    }
    public int getIdcarburant() {
        return idcarburant;
    }
    public void setIdcarburant(int idcarburant) {
        this.idcarburant = idcarburant;
    }
    public String getNomcarburant() {
        return nomcarburant;
    }
    public void setNomcarburant(String nomcarburant) {
        this.nomcarburant = nomcarburant;
    }
    public int getIdmarque() {
        return idmarque;
    }
    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }
    public String getNommarque() {
        return nommarque;
    }
    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
    }
    public int getIdmodel() {
        return idmodel;
    }
    public void setIdmodel(int idmodel) {
        this.idmodel = idmodel;
    }
    public String getNommodel() {
        return nommodel;
    }
    public void setNommodel(String nommodel) {
        this.nommodel = nommodel;
    }
    public double getNbfavoris() {
        return nbfavoris;
    }

    public void setNbfavoris(double nbfavoris) {
        this.nbfavoris = nbfavoris;
    }
    public List<Categorie> getCategories() {
        return categories;
    }
    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
    public int getAnneefab() {
        return anneefab;
    }
    public void setAnneefab(int anneefab) {
        this.anneefab = anneefab;
    }
    public Date getDatevente() {
        return datevente;
    }
    public void setDatevente(Date datevente) {
        this.datevente = datevente;
    }
    public Date getDatemodifstatus() {
        return datemodifstatus;
    }
    public void setDatemodifstatus(Date datemodifstatus) {
        this.datemodifstatus = datemodifstatus;
    }
    public boolean isEstfavoris() {
        return estfavoris;
    }
    public void setEstfavoris(boolean estfavoris) {
        this.estfavoris = estfavoris;
    }
    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    
    public List<AnnonceBodyMi> createListByListAnnoncedetailMi_v(List<AnnoncedetailMi_v> lista){
        if(lista==null){ return null; }
        if(lista.isEmpty()==true){ return null; }
        List<AnnonceBodyMi> lstab=new ArrayList<AnnonceBodyMi>();
        AnnoncedetailMi_v adtemp=null;
        AnnonceBodyMi abtemp=null;
        int idaNow=0;
        int idcNow=0;
        List<Categorie> lc=new ArrayList<Categorie>();
        List<String> lph=new ArrayList<String>();
        int p=0;
        for(int i=0;i<lista.size();i++){
            adtemp=lista.get(i);
            if(i==0){   //init
                idaNow=adtemp.getIdannonce();
                idcNow=adtemp.getIdcategorie();
                abtemp=new AnnonceBodyMi(
                    adtemp.getIdannonce(), adtemp.getPrixvente(), adtemp.getDescriptions(), adtemp.getStatusventeBoolean(), adtemp.getEtatString(), adtemp.getDateannonce(),adtemp.formatTimestamp(),
                    adtemp.getIdlieu(), adtemp.getNomlieu(), adtemp.getIdvoitureinfo(), adtemp.getNomvoiture(), adtemp.getNombreplace(), adtemp.getKilometrage(), adtemp.getIdtransmission(),adtemp.getNomtransmission(),
                    adtemp.getVitesse(), adtemp.getIduser(), adtemp.getNomuser(), adtemp.getPrenomuser(), adtemp.getIdcarburant(), adtemp.getNomcarburant(), adtemp.getIdmarque(), adtemp.getNommarque(), 
                    adtemp.getIdmodel(), adtemp.getNommodel(),adtemp.getNbfavoris(),null,adtemp.getAnneefab(),  adtemp.getDatevente(), adtemp.getDatemodifstatus(), adtemp.estfavoris(),null
                    );
                lc.add( new Categorie(adtemp.getIdcategorie(), adtemp.getNomcategorie()) );
            }
            if(idaNow==adtemp.getIdannonce()){ //raha mbola mitovy le annonce
                if(idcNow!=adtemp.getIdcategorie()){ 
                    lc.add( new Categorie(adtemp.getIdcategorie(), adtemp.getNomcategorie()) );
                    idcNow=adtemp.getIdcategorie();
                    p=1;
                }
                if(p==0){//le vo manomboka @ idannonce de ampidirina aloha le voalohany
                    lph.add(adtemp.getPhoto());                    
                }
            }else{
                p=0;
                abtemp.setCategories(lc); //apidirina ao @ zay le categorie avy nangonona
                abtemp.setPhotos(lph);  //apidirina ao @ zay le photo avy nangonona
                lstab.add(abtemp); //atsofoka ao @ le liste AnnonceBodyMi amzay
                lc=new ArrayList<Categorie>(); //de creerna ndray ny categorie asina an'le categorie an'le annonce manaraka
                lph=new ArrayList<String>(); //de creerna ndray ny photo asina an'le photo an'le annonce manaraka
                abtemp=new AnnonceBodyMi(
                    adtemp.getIdannonce(), adtemp.getPrixvente(), adtemp.getDescriptions(), adtemp.getStatusventeBoolean(), adtemp.getEtatString(), adtemp.getDateannonce(),adtemp.formatTimestamp(),
                    adtemp.getIdlieu(), adtemp.getNomlieu(), adtemp.getIdvoitureinfo(), adtemp.getNomvoiture(), adtemp.getNombreplace(), adtemp.getKilometrage(), adtemp.getIdtransmission(),adtemp.getNomtransmission(),
                    adtemp.getVitesse(), adtemp.getIduser(), adtemp.getNomuser(), adtemp.getPrenomuser(), adtemp.getIdcarburant(), adtemp.getNomcarburant(), adtemp.getIdmarque(), adtemp.getNommarque(), 
                    adtemp.getIdmodel(), adtemp.getNommodel(),adtemp.getNbfavoris(),null,  adtemp.getAnneefab(),adtemp.getDatevente(), adtemp.getDatemodifstatus(), adtemp.estfavoris(),null
                    );
                lc.add( new Categorie(adtemp.getIdcategorie(), adtemp.getNomcategorie()) );
                lph.add(adtemp.getPhoto()); 
                idaNow=adtemp.getIdannonce();
                idcNow=adtemp.getIdcategorie();
            }
        }
        abtemp.setCategories(lc); //apidirina ao @ zay le categorie avy nangonona
        abtemp.setPhotos(lph);  //apidirina ao @ zay le photo avy nangonona
        lstab.add(abtemp); //atsofoka ao @ le liste AnnonceBodyMi amzay
        return lstab;
    }

    public String getDateformaterannonce() {
        return dateformaterannonce;
    }

    public void setDateformaterannonce(String dateformaterannonce) {
        this.dateformaterannonce = dateformaterannonce;
    }


    
    
}
