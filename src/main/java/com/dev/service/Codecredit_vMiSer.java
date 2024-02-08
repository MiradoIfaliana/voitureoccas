package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.Codecredit_vMi;
import com.dev.repository.Codecredit_vMiRep;
import java.util.List;
@Service
public class Codecredit_vMiSer {

    @Autowired
    private Codecredit_vMiRep repository;
    public Codecredit_vMi getByCodeCredit(int code){
        List<Codecredit_vMi> lc=repository.getByCodeCredit(code);
        if(lc.isEmpty()==true){ return null; }
        else{ return lc.get(0); }
    }

}
