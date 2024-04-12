/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.DomainObject;
import domain.TipKlijenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class UcitajListuTipovaKlijenata extends AbstractSO{

    public UcitajListuTipovaKlijenata() throws Exception {
        super();
    }

    List<TipKlijenta> tipovi=new ArrayList<>();

    public List<TipKlijenta> getTipovi() {
        return tipovi;
    }
    
    
    @Override
    protected void validate(Object argument) throws Exception {
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        //result = dbbr.popuniListuTipovaKlijenata();
        TipKlijenta tipKlijenta = new TipKlijenta();
        List<DomainObject> result = dbbr.getAll(tipKlijenta);
        for(DomainObject domObj:result){
            TipKlijenta tip = (TipKlijenta)domObj;
            tipovi.add(tip);
        }
        
    }
    
    
}
