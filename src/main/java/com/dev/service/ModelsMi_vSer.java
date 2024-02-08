package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.MarqueModelsMi;
import com.dev.models.ModelsMi_v;
import com.dev.repository.ModelsMi_vRep;

import java.util.ArrayList;
import java.util.List;
@Service
public class ModelsMi_vSer {

    @Autowired
    private ModelsMi_vRep modelsMi_vRep;
    
    public List<MarqueModelsMi> getAllMarqueModelsMiByListModelsMi_v(List<ModelsMi_v> lstMd){
        List<MarqueModelsMi> lstmq=new ArrayList<>();
        MarqueModelsMi mmtemp=null;
        int idmq=0;
        for(int i=0;i<lstMd.size();i++){
            if(i==0){ 
                idmq=lstMd.get(i).getIdmarque();
                mmtemp=new MarqueModelsMi(lstMd.get(i).getIdmarque(), lstMd.get(i).getNommarque(), null);
            }
            if(idmq==lstMd.get(i).getIdmarque()){
                mmtemp.addModels(lstMd.get(i));
            }
            else if(idmq!=lstMd.get(i).getIdmarque()){
                idmq=lstMd.get(i).getIdmarque();//idmarque vaovao
                lstmq.add(mmtemp); //apidirina amin'izay le teo aloha
                mmtemp=new MarqueModelsMi(lstMd.get(i).getIdmarque(), lstMd.get(i).getNommarque(), null); //foronona le vaovao
                mmtemp.addModels(lstMd.get(i));
            }    
        }
        if(mmtemp!=null){
            lstmq.add(mmtemp); //apidirina amin'izay le teo aloha
        }
        return lstmq;
    }
    public MarqueModelsMi getAllModelsOfAllMarque(){
        List<ModelsMi_v> lstMd=modelsMi_vRep.getAllOrderByIdmarque();
        MarqueModelsMi mmtemp=null;
        // idmarque | nommarque | idmodel | nommodel  | datesortie | vitesse | idtransmission | nomtransmission | idcarburant | nomcarburant
        for(int i=0;i<lstMd.size();i++){
            if(i==0){
                mmtemp=new MarqueModelsMi(0, "tous marque", null);
            }
                mmtemp.addModels(lstMd.get(i));
        }
        return mmtemp;
    }
    public List<MarqueModelsMi> getAllMarqueModelsMi(){
        List<ModelsMi_v> lstMd=modelsMi_vRep.getAllOrderByIdmarque();
        return getAllMarqueModelsMiByListModelsMi_v(lstMd);
    }
    public MarqueModelsMi getMarqueModelsMiByIdMarque(int idmarque){
        if(idmarque==0){
            return getAllModelsOfAllMarque();
        }
        List<ModelsMi_v> lstMd=modelsMi_vRep.getAllByIdmarqueOrderByIdmarque(idmarque);
        List<MarqueModelsMi>  mqmd= getAllMarqueModelsMiByListModelsMi_v(lstMd);
        if(mqmd.isEmpty()){return null;}
        return mqmd.get(0);
    }


}
