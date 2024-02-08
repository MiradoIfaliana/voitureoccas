package com.dev.models;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.sql.Date;
public class AnnoncedetailMi_v{
    int idannonce; 
    double prixvente; 
    String descriptions; 
    int statusvente; 
    int etat; 
    Timestamp dateannonce; 
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
    int idcategorie; 
    String nomcategorie; 
    int anneefab;
    Date datevente; 
    Date datemodifstatus;
    int idannoncephoto;
    String photo;
    int idannoncefavoris; //0 raha tsy favoriany io
    //select ad_v.*,af.idannoncefavoris from annnoncedetail_v as left join annoncefavoris as af on (ad_v.idannonce=af.idannonce and af.iduser= 'iduserconnect' ) ;
    public AnnoncedetailMi_v(){ }
    //t.nomtransmission
    public AnnoncedetailMi_v(int idannonce, double prixvente, String descriptions, int statusvente, int etat,
            Timestamp dateannonce, int idlieu, String nomlieu, int idvoitureinfo, String nomvoiture,
            int nombreplace, double kilometrage, int transmission, String nomtransmission, double vitesse, int iduser, String nomuser,
            String prenomuser, int idcarburant, String nomcarburant, int idmarque, String nommarque, int idmodel,
            String nommodel,double nbfavoris, int idcategorie, String nomcategorie,int anneefab, Date datevente, Date datemodifstatus,
            int idannoncephoto, String photo, int idannoncefavoris) {
        this.idannonce = idannonce;
        this.prixvente = prixvente;
        this.descriptions = descriptions;
        this.statusvente = statusvente;
        this.etat = etat;
        this.dateannonce = dateannonce;
        this.idlieu = idlieu;
        this.nomlieu = nomlieu;
        this.idvoitureinfo = idvoitureinfo;
        this.nomvoiture = nomvoiture;
        this.nombreplace = nombreplace;
        this.kilometrage = kilometrage;
        this.idtransmission = transmission;
        this.nomtransmission=nomtransmission;
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
        this.idcategorie = idcategorie;
        this.nomcategorie = nomcategorie;
        this.anneefab=anneefab;
        this.datevente = datevente;
        this.datemodifstatus = datemodifstatus;
        this.idannoncephoto = idannoncephoto;
        this.photo = photo;
        this.idannoncefavoris = idannoncefavoris;
    }

    public int getIdannonce(){
        return this.idannonce;
    }
    public void setIdannonce(int idannonce){
        this.idannonce=idannonce;
    }
    public double getPrixvente(){
        return this.prixvente;
    }
    public void setPrixvente(double prixvente){
        this.prixvente=prixvente;
    }
    public String getDescriptions(){
        return this.descriptions;
    }
    public void setDescriptions(String descriptions){
        this.descriptions=descriptions;
    }
    public int getStatusvente(){
        return this.statusvente;
    }
    public void setStatusvente(int statusvente){
        this.statusvente=statusvente;
    }
            // ---statusvente : 0 : vendu /10 : non vendu
    // ---etat : 0:encour demande / 10 :accepter / 20: refuser
    public String getStatusventeString(){
        if(this.statusvente==0){
            return "vendu";
        }else if(this.statusvente==10){
            return "disponible";
        }else{ return ""; }
    }
    public int getEtat(){
        return this.etat;
    }
    public void setEtat(int etat){
        this.etat=etat;
    }
    public boolean getStatusventeBoolean(){
        if(this.statusvente==0){
            return true;
        }else if(this.statusvente==10){
            return false;
        }else{ return false; }
    }
    // ---statusvente : 0 : vendu /10 : non vendu
// ---etat : 0:encour demande / 10 :accepter / 20: refuser
    public String getEtatString(){
        if(this.etat==0){
            return "encour de demande";
        }else if(this.etat==10){
            return "acceptée";
        }else if(this.etat==20){
            return "refusée";
        }else{ return ""; }
    }
    public Timestamp getDateannonce(){
        return this.dateannonce;
    }
    public void setDateannonce(Timestamp dateannonce){
        this.dateannonce=dateannonce;
    }
    public int getIdlieu(){
        return this.idlieu;
    }
    public void setIdlieu(int idlieu){
        this.idlieu=idlieu;
    }
    public String getNomlieu(){
        return this.nomlieu;
    }
    public void setNomlieu(String nomlieu){
        this.nomlieu=nomlieu;
    }
    public int getIdvoitureinfo(){
        return this.idvoitureinfo;
    }
    public void setIdvoitureinfo(int idvoitureinfo){
        this.idvoitureinfo=idvoitureinfo;
    }
    public String getNomvoiture(){
        return this.nomvoiture;
    }
    public void setNomvoiture(String nomvoiture){
        this.nomvoiture=nomvoiture;
    }
    public int getNombreplace(){
        return this.nombreplace;
    }
    public void setNombreplace(int nombreplace){
        this.nombreplace=nombreplace;
    }
    public double getKilometrage(){
        return this.kilometrage;
    }
    public void setKilometrage(double kilometrage){
        this.kilometrage=kilometrage;
    }
    public int getIdtransmission(){
        return this.idtransmission;
    }
    public void setIdtransmission(int idtransmission){
        this.idtransmission=idtransmission;
    }
    public String getNomtransmission() {
        return nomtransmission;
    }
    public void setNomtransmission(String nomtransmission) {
        this.nomtransmission = nomtransmission;
    }   
    public double getVitesse(){
        return this.vitesse;
    }
    public void setVitesse(double vitesse){
        this.vitesse=vitesse;
    }
    public int getIduser(){
        return this.iduser;
    }
    public void setIduser(int iduser){
        this.iduser=iduser;
    }
    public String getNomuser(){
        return this.nomuser;
    }
    public void setNomuser(String nomuser){
        this.nomuser=nomuser;
    }
    public String getPrenomuser(){
        return this.prenomuser;
    }
    public void setPrenomuser(String prenomuser){
        this.prenomuser=prenomuser;
    }
    public int getIdcarburant(){
        return this.idcarburant;
    }
    public void setIdcarburant(int idcarburant){
        this.idcarburant=idcarburant;
    }
    public String getNomcarburant(){
        return this.nomcarburant;
    }
    public void setNomcarburant(String nomcarburant){
        this.nomcarburant=nomcarburant;
    }
    public int getIdmarque(){
        return this.idmarque;
    }
    public void setIdmarque(int idmarque){
        this.idmarque=idmarque;
    }
    public String getNommarque(){
        return this.nommarque;
    }
    public void setNommarque(String nommarque){
        this.nommarque=nommarque;
    }
    public int getIdmodel(){
        return this.idmodel;
    }
    public void setIdmodel(int idmodel){
        this.idmodel=idmodel;
    }
    public String getNommodel(){
        return this.nommodel;
    }
    public void setNommodel(String nommodel){
        this.nommodel=nommodel;
    }
    public double getNbfavoris() {
        return nbfavoris;
    }
    public void setNbfavoris(double nbfavoris) {
        this.nbfavoris = nbfavoris;
    }
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }
    public String getNomcategorie(){
        return this.nomcategorie;
    }
    public void setNomcategorie(String nomcategorie){
        this.nomcategorie=nomcategorie;
    }
    public int getAnneefab() {
        return anneefab;
    }
    public void setAnneefab(int anneefab) {
        this.anneefab = anneefab;
    }
    public Date getDatevente(){
        return this.datevente;
    }
    public void setDatevente(Date datevente){
        this.datevente=datevente;
    }
    public Date getDatemodifstatus(){
        return this.datemodifstatus;
    }
    public void setDatemodifstatus(Date datemodifstatus){
        this.datemodifstatus=datemodifstatus;
    }
    public int getIdannoncefavoris() {
        return idannoncefavoris;
    }
    public void setIdannoncefavoris(int idannoncefavoris) {
        this.idannoncefavoris = idannoncefavoris;
    }   
    public int getIdannoncephoto() {
        return idannoncephoto;
    }
    public void setIdannoncephoto(int idannoncephoto) {
        this.idannoncephoto = idannoncephoto;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public boolean estfavoris(){
        if(idannoncefavoris<=0){ return false; }
        else{ return true; }
    }

    public String formatTimestamp() {
        Instant instant = this.dateannonce.toInstant();
        Instant now = Instant.now();
        Duration duration = Duration.between(instant, now);

        long seconds = duration.getSeconds();
        long minutes = duration.toMinutes();
        long hours = duration.toHours();
        long days = duration.toDays();

        if (seconds < 60) {
            return seconds + " seconde(s)";
        } else if (minutes < 60) {
            return minutes + " minute(s)";
        } else if (hours < 24) {
            return hours + " heure(s)";
        } else if (days < 31){
            return days + " jour(s)";
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(new Date(this.dateannonce.getTime()));
        }
    }
    public String formatTimestamp2() {
        long now = System.currentTimeMillis();
        long diff = now - this.dateannonce.getTime();
        // Si la durée est inférieure à 1 minute, afficher en secondes
        if (diff < 60000) {
            return diff / 1000 + " secondes";
        }// Si la durée est inférieure à 1 heure, afficher en minutes
        if (diff < 3600000) {
            return diff / 60000 + " minutes";
        }// Si la durée est inférieure à 1 mois, afficher en jours
        if (diff < 2592000000L) { // 1 mois = 30 jours * 24 heures * 60 minutes * 60 secondes * 1000 millisecondes
            return diff / (24 * 3600000) + " jours";
        }// Si la durée est supérieure ou égale à 1 mois, afficher la date au format "yyyy-mm-dd hh:mm:ss"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(this.dateannonce.getTime()));
    }


    
}
