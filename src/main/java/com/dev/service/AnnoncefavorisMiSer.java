package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.exception.ExceptionCar;
import com.dev.models.AnnoncefavorisMi;
import com.dev.repository.AnnoncefavorisMiRep;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class AnnoncefavorisMiSer {

    @Autowired
    private AnnoncefavorisMiRep annonceRepository;
    
    public AnnoncefavorisMi save(AnnoncefavorisMi Annonce) {
        return annonceRepository.save(Annonce);
    }
    public AnnoncefavorisMi verifeInsert(int iduser, int idannonce) throws Exception{
        AnnoncefavorisMi annoncefavorisMi=new AnnoncefavorisMi(0,iduser,idannonce);
        List<AnnoncefavorisMi> la=getListByIduserByIdannonce(iduser, idannonce);
        if(la.isEmpty()==true){ return annonceRepository.save(annoncefavorisMi); }
        else { 
            annonceRepository.deleteById(la.get(0).getIdannoncefavoris());
            return null;
         }
         //fafana raha efa misy
    }
    // private File convertMultiPartToFile(MultipartFile file) {
    //     File convertedFile = new File(file.getOriginalFilename());
    //     try {
    //         file.transferTo(convertedFile);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     return convertedFile;
    // }
    public void enregistrer( MultipartFile file,String pathForSave)throws Exception{
        // Vérifiez si le fichier est vide
        if (file.isEmpty()) {
           throw new ExceptionCar("Le fichier est vide.");
        }
        try {
            // Obtenez le chemin du répertoire où vous souhaitez enregistrer le fichier
            String uploadDir =pathForSave;
            String fileName = file.getOriginalFilename();
            String filePath = uploadDir + File.separator + fileName;
            // Créez le fichier dans le répertoire local
            File dest = new File(filePath);
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionCar("Erreur lors de l'enregistrement du fichier.");
        }catch(Exception e){
            throw e;
        }
    }
    public List<AnnoncefavorisMi> getAll() {
        return annonceRepository.findAll();
    }
    public List<AnnoncefavorisMi> getListByIduserByIdannonce(int iduser, int idannonce){
        return annonceRepository.getListByIduserByIdannonce(iduser, idannonce);
    }
    public AnnoncefavorisMi[] getTabAll(){
        List<AnnoncefavorisMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        AnnoncefavorisMi[] Annonces=new AnnoncefavorisMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            Annonces[i]=lst.get(i);
        }
        return Annonces;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<AnnoncefavorisMi> getById(int id) {
        return annonceRepository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        annonceRepository.deleteById(id);
    }
}
