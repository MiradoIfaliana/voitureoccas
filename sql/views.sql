
create or replace view nbfavoris_v as
      select idannonce,count(annoncefavoris) as nbfavoris from annoncefavoris group by idannonce;

create or replace view annoncedetail_v as
   select a.idannonce,
         a.prixvente,a.descriptions,a.statusvente,a.etat,a.dateannonce,
         a.idlieu,l.nomlieu,
         a.idvoitureinfo,vi.nomvoiture,vi.nombreplace,vi.kilometrage,md.idtransmission,t.nomtransmission,md.vitesse,
         vi.iduser,u.nomuser,u.prenomuser,
         md.idcarburant,cb.nomcarburant,
         md.idmarque,mq.nommarque,
         vi.idmodel,md.nommodel,
         COALESCE(nbfavoris,0) as nbfavoris,
         ct.idcategorie,ct.nomcategorie,
         COALESCE(EXTRACT(YEAR FROM md.datesortie)::int,0) as anneefab,
         v.datevente,
         v.datemodifstatus,
         COALESCE(aph.idannoncephoto,0) as idannoncephoto,
         aph.photo
         from annonce as a
         join lieu as l on l.idlieu=a.idlieu
         join voitureinfo as vi on a.idvoitureinfo=vi.idvoitureinfo
         join users as u on u.iduser=vi.iduser
         join models as md on md.idmodel=vi.idmodel
         join carburant as cb on cb.idcarburant=md.idcarburant
         join marque as mq on mq.idmarque=md.idmarque
         join transmission as t on t.idtransmission=md.idtransmission
         join modelcategorie as mc on mc.idmodel=vi.idmodel
         join categorie as ct on ct.idcategorie=mc.idcategorie
         left join annoncephoto as aph on aph.idannonce=a.idannonce
         left join vendu as v on v.idannonce=a.idannonce
         left join nbfavoris_v as nb_v on nb_v.idannonce=a.idannonce;

create or replace view annoncenbrepeat_v as
      select idannonce,iduser,statusvente,etat,count(idannonce) as nbrepeat from annoncedetail_v
      group by idannonce,iduser,statusvente,etat;
create or replace view codecredit_v as
      select c.*,v.valeur from codecredit as c 
            join valeurcredit as v 
            on c.idvaleurcredit=v.idvaleurcredit;

create or replace view activityuserannonce_v as
      select 
            u.iduser,
            count(a) as nbannonce,
            count(av) as nbvendu,
            count(af) as nbfavoris
            from users as u
            left join voitureinfo as v on v.iduser=u.iduser
            left join annonce as a on (a.idvoitureinfo=v.idvoitureinfo and a.etat=10)
            left join annonce as av on (av.idvoitureinfo=v.idvoitureinfo and av.etat=10 and av.statusvente=0)
            left join annoncefavoris as af on (af.iduser=u.iduser)
            group by u.iduser;

---statusvente : 0 : vendu /10 : non vendu
---etat : 0:encour demande / 10 :accepter / 20: refuser

--pub a part mes pubs, non vendu , deja accepter
--LIMIT 6 OFFSET 5; --->le 5e ligne tsy asehony , de manomboka eo @ ]5, ...6 ligne ambony]

-- -- Pour changer le type d'une colonne dans une table
-- ALTER TABLE annoncephoto
-- ALTER COLUMN photo TYPE text;


-- select ad_v.*, af.idannoncefavoris from annoncedetail_v as ad_v 
-- left join annoncefavoris as af 
--       on (ad_v.idannonce=af.idannonce and af.iduser='iduserconnect') 
-- where ad_v.iduser!=1 
--       and ad_v.statusvente=10 
--       and ad_v.etat=10 
-- order by ad_v.idannonce ASC,
--       ad_v.idcategorie ASC,
--       ad_v.dateannonce ASC 
-- LIMIT 6 OFFSET 6;


--  select
--         ad_v.iduser,
--         ad_v.idannonce as a0,
--         af.idannonce as a1,
--         COALESCE(af.idannoncefavoris, 0) as idannoncefavoris
--     from
--         annoncedetail_v as ad_v
--     left join
--         annoncefavoris as af
--             on (ad_v.idannonce=af.idannonce
--             and af.iduser= 6)
--     join
--         (select
--             *
--         from
--             annoncenbrepeat_v
--         where
--             iduser!= 6
--             and statusvente=10
--             and etat=10
--         LIMIT
--             8
--         OFFSET
--             0) as ar_v
--             on ad_v.idannonce=ar_v.idannonce
--     order by
--         ad_v.idannonce ASC,
--         ad_v.idcategorie ASC,
--         ad_v.idannoncephoto ASC,
--         ad_v.dateannonce ASC