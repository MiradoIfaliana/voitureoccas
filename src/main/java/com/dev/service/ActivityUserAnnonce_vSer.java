package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.ActivityUserAnnonce_v;
import com.dev.repository.ActivityUserAnnonce_vRep;

@Service
public class ActivityUserAnnonce_vSer {
    @Autowired
    private ActivityUserAnnonce_vRep activityUserAnnonce_vRep;
    

    public ActivityUserAnnonce_v getByIduser(int iduser){
        List<ActivityUserAnnonce_v> lst= activityUserAnnonce_vRep.getByIduser(iduser);
        if(lst.isEmpty()==true){ return null; }
        else { return lst.get(0); }
    }

}
