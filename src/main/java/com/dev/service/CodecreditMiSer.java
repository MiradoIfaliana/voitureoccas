package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.CodecreditMi;
import com.dev.repository.CodecreditMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class CodecreditMiSer {

    @Autowired
    private CodecreditMiRep repository;
    
    public CodecreditMi save(CodecreditMi Creditersoldesite) {
        return repository.save(Creditersoldesite);
    }
    public List<CodecreditMi> getAll() {
        return repository.findAll();
    }
    public CodecreditMi[] getTabAll(){
        List<CodecreditMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        CodecreditMi[] tabs=new CodecreditMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }
    public CodecreditMi getByCode(int code){
        List<CodecreditMi> lc=repository.getByCode(code);
        if(lc.isEmpty()==true){ return null; }
        else{ return lc.get(0); }
    }
    
    // Méthode pour récupérer un  par son ID
    public Optional<CodecreditMi> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
