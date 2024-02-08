-- insertion de transmission
insert into transmission(nomtransmission) values('Automatique');
insert into transmission(nomtransmission) values('Manuelle');

-- insertion carburant
insert into carburant(nomcarburant) values('Gasoil');
insert into carburant(nomcarburant) values('Essence');

-- insertion de marque 
insert into marque(nommarque) values ('Honda');
insert into marque(nommarque) values ('Subaru');
insert into marque(nommarque) values ('Ford');

-- insertion de models 
-- marque HONDA
insert into models(datesortie,nommodel,idmarque,idtransmission,vitesse,idcarburant) values('2001-12-01','Civic',1,1,6,2);
insert into models(datesortie,nommodel,idmarque,idtransmission,vitesse,idcarburant) values('1995-06-01','CR-V',1,2,6,2);
insert into models(datesortie,nommodel,idmarque,idtransmission,vitesse,idcarburant) values('1995-06-01','Accord',1,2,7,1);
-- marque Subaru
insert into models(datesortie,nommodel,idmarque,idtransmission,vitesse,idcarburant) values('2001-12-01','Impreza',2,2,6,2);
insert into models(datesortie,nommodel,idmarque,idtransmission,vitesse,idcarburant) values('1996-06-01','Luxe',2,1,10,1);
insert into models(datesortie,nommodel,idmarque,idtransmission,vitesse,idcarburant) values('1992-06-01','Rally2000',2,2,6,1);
-- categorie  idcategorie | nomcategorie
insert into categorie(nomcategorie) values
('course'),
('sport'),
('familiale'),
('tous terrain'),
('transporteur'),
('voyage');

--modelcategorie  idmodelcategorie | idmodel | idcategorie
insert into modelcategorie(idmodel,idcategorie) values
(1,1),
(1,2),
(2,2),
(2,3),
(3,6),
(3,1),
(3,2),
(4,3),
(4,1),
(5,2),
(5,3),
(5,4),
(6,2),
(6,3),
(6,5),
(6,6);

-----Admin  idadmins | nomadmin | prenomadmin | mail | nee | pwd
insert into admins(nomadmin,prenomadmin,mail,nee,pwd) values
('Mirado','Ifa','mirado@gmail.com','2002-02-02','1234');
------USER  iduser | nomuser | prenomuser | mail | nee | pwd | role
insert into users(nomuser,prenomuser,mail,nee,pwd) values
('Andy','Ains','andy@gmail.com','2005-05-05','1234'),
('Tafita','Eal','tafita@gmail.com','2003-08-05','1234'),
('Miaro','Mot','miaro@gmail.com','2002-07-05','1234');
---------LIEU
insert into lieu (nomlieu) values
('ANTANANARIVO'),('TOAMASINA'),('ANTSIRABE'),('DIEGO'),('AMBOSITRA');

--VOITURE INFO
insert into voitureinfo(nomvoiture,nombreplace,kilometrage,iduser,idmodel) values
('01 Honda-Civic',4,69000,1,1),
('02 Honda-Civic',6,59000,1,1),
('03 Honda-CR-V',7,79000,1,2),
('04 Honda-CR-V',5,89000,1,2),
('01 Subaru-Impreza',4,39000,2,4),
('02 Subaru-Impreza',4,49000,2,4),
('03 Subaru-Luxe',5,19000,2,5),
('04 Subaru-Luxe',5,39000,2,5),
('01 Honda-Accord',6,38000,3,3),
('02 Honda-Accord',6,47000,3,3),
('03 Subaru-Rally2000',4,20000,3,6),
('04 Subaru-Rally2000',8,48000,3,6),
('06 Honda-Civic',4,89000,1,1),
('07 Honda-Civic',8,88000,2,1),
('08 Honda-CR-V',4,77000,3,2),
('09 Honda-CR-V',6,85000,1,2)
;
--ANNONCE
insert into annonce(prixvente,descriptions,statusvente,etat,dateannonce,idlieu,idvoitureinfo) values
(15000000,'sans defaut et impecable',10,0,'2024-02-01 19:50:00',1,1),
(19000000,'sans defaut et impecable',10,0,'2024-02-01 20:00:00',1,2),
(20000000,'sans problem et impecable',10,0,'2024-02-02 20:50:00',1,3),
(25000000,'sans problem et impecable',10,0,'2024-02-02 21:50:00',1,4),
(25000000,'etat 9/10 ',10,0,'2024-02-01 17:50:00',2,5),
(29000000,'etat 9/10 ',10,0,'2024-02-01 22:00:00',2,6),
(30000000,'etat 8.9/10 tout ok',10,0,'2024-02-04 10:50:00',2,7),
(35000000,'etat 8.9/10 tout ok',10,0,'2024-02-04 11:50:00',2,8),
(25000000,'quelque petite reparation,mais tous est ok  ',10,0,'2024-02-01 17:30:00',3,9),
(29000000,'quelque petite reparation,mais tous est ok  ',10,0,'2024-02-01 22:10:00',3,10),
(19000000,'jamais eu des degas majeur',10,0,'2024-02-04 10:20:00',3,11),
(17000000,'jamais eu des degas majeur',10,0,'2024-02-04 11:23:00',3,12),
(23000000,'quelque petite reparation,mais tous est ok  ',10,0,'2024-02-04 17:36:00',3,13),
(21000000,'quelque petite reparation,mais tous est ok  ',10,0,'2024-02-04 19:23:00',3,14),
(40000000,'jamais eu des degas majeur',10,0,'2024-02-05 10:20:00',3,15),
(32000000,'jamais eu des degas majeur',10,0,'2024-02-05 11:23:00',3,16);

-----ANNONCE PHOTO
insert into annoncephoto (photo,idannonce) values
('https:////i.ibb.co//p0RRDGz//dodgered1.jpg',1),
('https:////i.ibb.co//Ttt6dbV//dodgered2.jpg',1),
('https:////i.ibb.co//HVHFmtv//Dodge-Argente.png',2),
('https:////i.ibb.co//WBsnPkb//dodge-Original.jpg',2),
('https:////i.ibb.co//CJpv52x//citadin1.png',3),
('https:////i.ibb.co//Sdtx7M4//citadin2.png',3),
('https:////i.ibb.co//4RgyJsD//frg1.png',4),
('https:////i.ibb.co//VMnMW94//frg2.png',4),
('https:////i.ibb.co//7KhRy1y//jp1.png',5),
('https:////i.ibb.co//V3nQYJt//jp2.png',5),
('https:////i.ibb.co//WyDVhwK//voy1.png',6),
('https:////i.ibb.co//QFLq5NQ//voy2.png',6),
('https:////i.ibb.co//0CGKwnC//rdrv2.png',7),
('https:////i.ibb.co//2FjpJGr//rdrv3.png',7),
('https:////i.ibb.co//4RY72kr//car111.jpg',8),
('https:////i.ibb.co//8sRrpt7//car3333.jpg',8),
('https:////i.ibb.co//ZGx6Nqh//touster1.jpg',9),
('https:////i.ibb.co//bdhFZfG//touster2.jpg',9),
('https:////i.ibb.co//60CvP3j//touster3.jpg',9),
('https:////i.ibb.co//nfZBSjf//touster4.jpg',9),
('https:////i.ibb.co//SxT6nVG//touster5.jpg',9),
('https:////i.ibb.co//zh0YT9Y//frg1.png',10),
('https:////i.ibb.co//XjC99bF//frg2.png',10),
('https:////i.ibb.co//fddgDd7//Nissan-Patrol.jpg',11),
('https:////i.ibb.co//fddgDd7//Nissan-Patrol.jpg',11),
('https:////i.ibb.co//khdK421//voiture1.jpg',12),
('https:////i.ibb.co//khdK421//voiture1.jpg',12),
('https:////i.ibb.co//CJpv52x//citadin1.png',13),
('https:////i.ibb.co//Sdtx7M4//citadin2.png',13),
('https:////i.ibb.co//fMC6J86//Capture-d-cran-2024-01-29-130415.png',14),
('https:////i.ibb.co//QbywyL1//Capture-d-cran-2024-01-29-130439.png',14),
('https:////i.ibb.co//3CNJMKR//bmw1.jpg',15),
('https:////i.ibb.co//SVcxSj7//bmw4.jpg',15),
('https:////i.ibb.co//hVLC4BD//bmw2.jpg',15),
('https:////i.ibb.co//3cLMrPZ//bmw3.jpg',15),
('https:////i.ibb.co//nfZBSjf//touster4.jpg',16),
('https:////i.ibb.co//ZGx6Nqh//touster1.jpg',16),
('https:////i.ibb.co//SxT6nVG//touster5.jpg',16);

 idannoncevalidation | datevalide | idadmins | idannonce

insert into annoncevalidation(datevalide,idadmins,idannonce) values
('2024-02-05',1,1),
('2024-02-05',1,2),
('2024-02-05',1,3),
('2024-02-05',1,4),
('2024-02-05',1,5),
('2024-02-05',1,6),
('2024-02-05',1,7),
('2024-02-05',1,8),
('2024-02-05',1,9),
('2024-02-05',1,10),
('2024-02-05',1,11),
('2024-02-05',1,12),
('2024-02-05',1,13),
('2024-02-05',1,14),
('2024-02-05',1,15),
('2024-02-05',1,16);
update annonce set etat=10 where idannonce between 1 and 16;
 


